package com.belatrix.jobLogger.db;

import com.belatrix.jobLogger.model.ParamsDTO;
import com.belatrix.jobLogger.util.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbConnection {

    Connection connection = null;

    public void DbConnection(ParamsDTO paramsDTO) {
        Properties connectionProps = new Properties();
        connectionProps.put("user", paramsDTO.getDbUserName());
        connectionProps.put("password", paramsDTO.getDbPassword());

        StringBuilder url = new StringBuilder();
        url.append(Constants.JDBC_IDENTIFIER);
        url.append(paramsDTO.getDbDbms());
        url.append(Constants.CONNECTOR_WITH_DOBLE_SLASH);
        url.append(paramsDTO.getDbServerName());
        url.append(Constants.CONNECTOR);
        url.append(paramsDTO.getDbPortNumber());
        url.append(Constants.CONNECTOR_SLASH);

        try {
            connection = DriverManager.getConnection(url.toString(), connectionProps);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public int insertDB(String message, int type) {
        int responseDB = -1;
        try {
            Statement stmt = connection.createStatement();
            responseDB = stmt.executeUpdate("insert into Log_Values('" + message + "', " + type + ")");
        } catch (SQLException sqlException) {

        }
        return responseDB;
    }
}
