package com.belatrix.jobLogger.service;

import com.belatrix.jobLogger.exception.RecordNotFoundException;
import com.belatrix.jobLogger.model.LogEntity;
import java.util.List;

public interface LogService {
    List<LogEntity> getAllLogs();
    LogEntity getLogById(Long id) throws RecordNotFoundException;
    LogEntity getLogByMessage(String message) throws RecordNotFoundException;
    LogEntity createOrUpdateLog(LogEntity entity);
    void deleteLogById(Long id) throws RecordNotFoundException;

}
