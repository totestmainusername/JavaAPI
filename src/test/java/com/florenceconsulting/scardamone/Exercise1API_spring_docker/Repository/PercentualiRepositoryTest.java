package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository;

import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Entity.Percentuali;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PercentualiRepositoryTest {

    @Autowired
    private PercentualiRepository percentualiRepository;

    @Test
    @DisplayName("Percentuali save in to the database")
    void save() {
        Percentuali percentuali = new Percentuali();
        percentuali.setValue(10);
        percentuali.setId("1");
        Percentuali createdPercentuali= percentualiRepository.save(percentuali);
        assertNotNull(createdPercentuali);
        assertThat(createdPercentuali.getId()).isEqualTo(percentuali.getId());
    }


}
