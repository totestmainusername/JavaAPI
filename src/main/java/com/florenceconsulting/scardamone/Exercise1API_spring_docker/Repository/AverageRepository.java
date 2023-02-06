package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository;


import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Entity.Medie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AverageRepository extends JpaRepository<Medie, String> {
}
