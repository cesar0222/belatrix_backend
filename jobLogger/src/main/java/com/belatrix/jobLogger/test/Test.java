package com.belatrix.jobLogger.test;

import com.belatrix.jobLogger.model.ParamsDTO;
import com.belatrix.jobLogger.util.LoggerUtil;

public class Test {

    public static void main(String[] args) {
        ParamsDTO params = new ParamsDTO();
        params.setLogFileFolder("C://Apps//jobLogger");
        params.setLogToFile(true);
        params.setLogToConsole(true);
        params.setLogToDatabase(false);
        params.setLogTypeMessage(false);
        params.setLogTypeError(false);
        params.setLogTypeWarning(true);

        try {
            LoggerUtil loggerUtil = new LoggerUtil();
            loggerUtil.logMessage("Esto es  una prueba",params);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
