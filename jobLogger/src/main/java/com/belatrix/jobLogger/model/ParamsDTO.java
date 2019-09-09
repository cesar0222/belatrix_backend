package com.belatrix.jobLogger.model;

public class ParamsDTO {

    private String dbUserName;
    private String dbPassword;
    private String dbServerName;
    private String dbPortNumber;
    private String dbDbms;
    private String logFileFolder;
    private Boolean logToConsole;
    private Boolean logToFile;
    private Boolean logToDatabase;
    private Boolean logTypeError;
    private Boolean logTypeWarning;
    private Boolean logTypeMessage;

    public String getDbUserName() {
        return dbUserName;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbServerName() {
        return dbServerName;
    }

    public void setDbServerName(String dbServerName) {
        this.dbServerName = dbServerName;
    }

    public String getDbPortNumber() {
        return dbPortNumber;
    }

    public void setDbPortNumber(String dbPortNumber) {
        this.dbPortNumber = dbPortNumber;
    }

    public String getDbDbms() {
        return dbDbms;
    }

    public void setDbDbms(String dbDbms) {
        this.dbDbms = dbDbms;
    }

    public String getLogFileFolder() {
        return logFileFolder;
    }

    public void setLogFileFolder(String logFileFolder) {
        this.logFileFolder = logFileFolder;
    }

    public Boolean getLogToConsole() {
        return logToConsole;
    }

    public void setLogToConsole(Boolean logToConsole) {
        this.logToConsole = logToConsole;
    }

    public Boolean getLogToFile() {
        return logToFile;
    }

    public void setLogToFile(Boolean logToFile) {
        this.logToFile = logToFile;
    }

    public Boolean getLogToDatabase() {
        return logToDatabase;
    }

    public void setLogToDatabase(Boolean logToDatabase) {
        this.logToDatabase = logToDatabase;
    }

    public Boolean getLogTypeError() {
        return logTypeError;
    }

    public void setLogTypeError(Boolean logTypeError) {
        this.logTypeError = logTypeError;
    }

    public Boolean getLogTypeWarning() {
        return logTypeWarning;
    }

    public void setLogTypeWarning(Boolean logTypeWarning) {
        this.logTypeWarning = logTypeWarning;
    }

    public Boolean getLogTypeMessage() {
        return logTypeMessage;
    }

    public void setLogTypeMessage(Boolean logTypeMessage) {
        this.logTypeMessage = logTypeMessage;
    }

    @Override
    public String toString() {
        return "Params{" +
                "dbUserName='" + dbUserName + '\'' +
                ", dbPassword='" + dbPassword + '\'' +
                ", dbServerName='" + dbServerName + '\'' +
                ", dbPortNumber='" + dbPortNumber + '\'' +
                ", dbDbms='" + dbDbms + '\'' +
                ", logFileFolder='" + logFileFolder + '\'' +
                ", logToConsole=" + logToConsole +
                ", logToFile=" + logToFile +
                ", logToDatabase=" + logToDatabase +
                ", logTypeError=" + logTypeError +
                ", logTypeWarning=" + logTypeWarning +
                ", logTypeMessage=" + logTypeMessage +
                '}';
    }
}
