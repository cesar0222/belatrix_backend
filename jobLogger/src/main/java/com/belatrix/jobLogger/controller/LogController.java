package com.belatrix.jobLogger.controller;

import com.belatrix.jobLogger.exception.RecordNotFoundException;
import com.belatrix.jobLogger.model.LogEntity;
import com.belatrix.jobLogger.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    LogService service;

    public LogController(LogService logService) {
        this.service = logService;
    }

    @GetMapping("/all")
    public List<LogEntity> getAllLogs() {
        return service.getAllLogs();
    }

    @GetMapping("/{id}")
    public LogEntity getLogById(@PathVariable("id") Long id)  throws RecordNotFoundException {
        return service.getLogById(id);
    }

    @PostMapping
    public ResponseEntity<LogEntity> createOrUpdateLog(LogEntity employee) throws RecordNotFoundException {
        LogEntity updated = service.createOrUpdateLog(employee);
        return new ResponseEntity<LogEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteLogById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteLogById(id);
        return HttpStatus.FORBIDDEN;
    }

}
