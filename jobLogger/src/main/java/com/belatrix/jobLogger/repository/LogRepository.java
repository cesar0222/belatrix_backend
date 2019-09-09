package com.belatrix.jobLogger.repository;

import com.belatrix.jobLogger.model.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Long> {

    public LogEntity findByLogMessage(String name);
}
