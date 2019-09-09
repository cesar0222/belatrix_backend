package com.belatrix.jobLogger.Repository;

import com.belatrix.jobLogger.model.LogEntity;
import com.belatrix.jobLogger.repository.LogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LogRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LogRepository logRepository;

    @Test
    public void whenFindByLogMessage_thenReturnLog() {
        // given
        LogEntity prueba = new LogEntity("prueba de log",3);
        entityManager.persist(prueba);
        entityManager.flush();

        // when
        LogEntity found = logRepository.findByLogMessage(prueba.getLogMessage());

        // then
        assertThat(found.getLogMessage())
                .isEqualTo(prueba.getLogMessage());
    }
}
