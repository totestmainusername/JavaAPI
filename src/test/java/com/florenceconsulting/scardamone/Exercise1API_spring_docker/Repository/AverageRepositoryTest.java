package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository;


import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Entity.Medie;
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
public class AverageRepositoryTest {

        private AverageRepository AverageRepository;
        @Autowired
        public AverageRepositoryTest(AverageRepository AverageRepository) {
            this.AverageRepository = AverageRepository;
        }

    @Test
        @DisplayName("Average save in to the database")
        void save() {
            Medie average = new Medie();
            average.setValue(10);
            average.setId("1");
            Medie createdAverage= AverageRepository.save(average);
            assertNotNull(createdAverage);
            assertThat(createdAverage.getId()).isEqualTo(average.getId());
        }
}
