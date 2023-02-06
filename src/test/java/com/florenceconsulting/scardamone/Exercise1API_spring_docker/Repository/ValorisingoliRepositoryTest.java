package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository;

import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Entity.Valorisingoli;
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
public class ValorisingoliRepositoryTest {

    @Autowired
    private ValorisingoliRepository valorisingoliRepository;

    @Test
    @DisplayName("ValoriSingoli save in to the database")
    void save() {
        Valorisingoli valorisingoli = new Valorisingoli();
        valorisingoli.setValue(10);
        valorisingoli.setId("1");
        Valorisingoli createdValorisingoli = valorisingoliRepository.save(valorisingoli);
        assertNotNull(createdValorisingoli);
        assertThat(createdValorisingoli.getId()).isEqualTo(valorisingoli.getId());
    }
}
