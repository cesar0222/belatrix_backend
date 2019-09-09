package com.belatrix.jobLogger.service;

import com.belatrix.jobLogger.exception.RecordNotFoundException;
import com.belatrix.jobLogger.model.LogEntity;
import com.belatrix.jobLogger.repository.LogRepository;
import com.belatrix.jobLogger.service.LogService;
import com.belatrix.jobLogger.service.LogServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LogServiceImplIntegrationTest {

    @TestConfiguration
    static class LogServiceImplTestContextConfiguration {

        @Bean
        public LogService logService() {
            return new LogServiceImpl();
        }
    }

    @Autowired
    private LogService logService;

    @MockBean
    private LogRepository logRepository;

    @Before
    public void setUp() {
        LogEntity prueba = new LogEntity("prueba de log",3);

        Mockito.when(logRepository.findByLogMessage(prueba.getLogMessage()))
                .thenReturn(prueba);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() throws RecordNotFoundException {
        String message = "prueba de log";
        LogEntity found = logService.getLogByMessage(message);

        Assertions.assertThat(found.getLogMessage())
                .isEqualTo(message);
    }
}
