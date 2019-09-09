package com.belatrix.jobLogger.model;

import javax.persistence.*;

@Entity
@Table(name="TBL_LOG_VALUES")
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="LOGMESSAGE")
    private String logMessage;

    @Column(name="LOGTYPE")
    private Integer logType;

    public LogEntity(){}

    public LogEntity(String logMessage, Integer logType) {
        this.logMessage = logMessage;
        this.logType = logType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "id=" + id +
                ", logMessage='" + logMessage + '\'' +
                ", logType=" + logType +
                '}';
    }
}
