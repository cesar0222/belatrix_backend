package com.belatrix.jobLogger.controller;

import com.belatrix.jobLogger.model.LogEntity;
import com.belatrix.jobLogger.service.LogService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static java.util.Collections.singleton;
import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LogController.class)
public class LogControllerTest {
    @Autowired
    private MockMvc mockMVc;

    @MockBean
    private LogController logController;

    @Before
    public void setUp() {
        mockMVc = MockMvcBuilders.standaloneSetup(logController).build();
    }

    @Test
    public void getAllLogs() throws Exception {
        LogEntity testLog = new LogEntity("prueba de log",3);

        List<LogEntity> allLogs = singletonList(testLog);

        given(logController.getAllLogs()).willReturn(allLogs);

        mockMVc.perform(get("/api/logs/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].logMessage",is(testLog.getLogMessage())));
    }

    @Test
    public void getLogById() throws Exception {
        LogEntity log = new LogEntity();
        log.setLogMessage("Prueba");

        given(logController.getLogById(1L)).willReturn(log);

        mockMVc.perform(get("/api/logs/" + 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("logMessage", is(log.getLogMessage())));
    }

}
