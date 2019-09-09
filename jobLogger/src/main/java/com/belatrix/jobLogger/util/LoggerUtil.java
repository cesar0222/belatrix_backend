package com.belatrix.jobLogger.util;

import com.belatrix.jobLogger.model.ParamsDTO;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {

    private void validateFields(String messageText, ParamsDTO params) throws Exception {
        if (messageText == null || messageText.length() == 0) {
            return;
        }
        if (!params.getLogToConsole() && !params.getLogToFile() && !params.getLogToDatabase()) {
            throw new Exception("Invalid configuration");
        }
        if (!params.getLogTypeMessage() && !params.getLogTypeWarning() && !params.getLogTypeError()) {
            throw new Exception("Error or Warning or Message must be specified");
        }
    }

    private int returnLoggerType(boolean message, boolean warning, boolean error) {
        int logType = 0;

        if (message ) {
            logType = 1;
        }

        if (error) {
            logType = 2;
        }

        if (warning) {
            logType = 3;
        }
        return logType;
    }

    private String formatLoggerMessage(String messageText, ParamsDTO params ) {
        DateUtil dateUtil = new DateUtil();
        String formatDate = dateUtil.formatDate(new Date(),DateFormat.LONG);
        StringBuilder message = new StringBuilder();

        if (params.getLogTypeError()) {
            message.append("error:");
        }

        if (params.getLogTypeWarning()) {
            message.append("warning:");
        }

        if (params.getLogTypeMessage()) {
            message.append("message:");
        }

        message.append(formatDate);
        message.append(Constants.BLANK_SEPARATOR);
        message.append(messageText);

        return message.toString();
    }

    private void showLogger(String messageText, ParamsDTO params) {
        Logger logger = Logger.getLogger(Constants.LOGGER_NAME);
        logger.setUseParentHandlers(false);
        //Level logLevel = returnLogLevel(params);

        if(params.getLogToFile()) {
            StringBuilder fileBuilder = new StringBuilder();
            fileBuilder.append(params.getLogFileFolder());
            fileBuilder.append(Constants.CONNECTOR_SLASH);
            fileBuilder.append(Constants.LOG_FILE);

            File logFile = new File(fileBuilder.toString());
            FileHandler fileHandler = null;
            try {
                fileHandler = new FileHandler(fileBuilder.toString());
                if (!logFile.exists()) {
                    logFile.createNewFile();
                }
            } catch (IOException ioException) {

            }
            logger.addHandler(fileHandler);
            logger.log(Level.INFO, formatLoggerMessage(messageText,params));
        }

        if(params.getLogToConsole()) {
            logger.addHandler(new ConsoleHandler());
            logger.log(Level.INFO, formatLoggerMessage(messageText,params));
        }

        /*if(params.getLogToDatabase()) {
            DbConnection dbConnection = new DbConnection();
            dbConnection.insertDB(messageText,returnLoggerType(this.logMessage,this.logWarning,this.logError));
        }*/
    }

    public void logMessage(String messageToLog, ParamsDTO params) throws Exception {
        messageToLog.trim();
        this.validateFields(messageToLog, params);
        this.showLogger(messageToLog, params);
    }

    public Level returnLogLevel(ParamsDTO params) {
        Integer logType = returnLoggerType(params.getLogTypeMessage(),params.getLogTypeWarning(),params.getLogTypeError());
        switch (logType) {
            case 1:
                return Level.INFO;
            case 2:
                return Level.SEVERE;
            case 3:
                return Level.WARNING;
        }

        return null;
    }
}
