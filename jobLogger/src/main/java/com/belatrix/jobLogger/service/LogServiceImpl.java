package com.belatrix.jobLogger.service;

import com.belatrix.jobLogger.exception.RecordNotFoundException;
import com.belatrix.jobLogger.model.LogEntity;
import com.belatrix.jobLogger.repository.LogRepository;
import com.belatrix.jobLogger.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogRepository repository;

    public List<LogEntity> getAllLogs()
    {
        List<LogEntity> logList = repository.findAll();

        if(logList.size() > 0) {
            return logList;
        } else {
            return new ArrayList<LogEntity>();
        }
    }

    public LogEntity getLogById(Long id) throws RecordNotFoundException
    {
        Optional<LogEntity> log = repository.findById(id);

        if(log.isPresent()) {
            return log.get();
        } else {
            throw new RecordNotFoundException(Constants.RECORD_NOT_FOUND);
        }
    }

    public LogEntity getLogByMessage(String message) throws RecordNotFoundException
    {
        LogEntity log = repository.findByLogMessage(message);

        System.out.println(log);

        if (log.getId() != null) {
            return log;
        } else {
            throw new RecordNotFoundException(Constants.RECORD_NOT_FOUND);
        }
    }

    public LogEntity createOrUpdateLog(LogEntity entity)
    {
        if(entity.getId()!=null)
        {
            Optional<LogEntity> log = repository.findById(entity.getId());
            LogEntity newEntity = log.get();
            System.out.println(newEntity);
            newEntity.setLogMessage(entity.getLogMessage());
            newEntity.setLogType(entity.getLogType());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteLogById(Long id) throws RecordNotFoundException
    {
        Optional<LogEntity> log = repository.findById(id);

        if(log.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException(Constants.RECORD_NOT_FOUND);
        }
    }
}
