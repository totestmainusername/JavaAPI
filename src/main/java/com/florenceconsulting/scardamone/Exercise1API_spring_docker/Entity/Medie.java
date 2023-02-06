package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MEDIE")
public class Medie {
    @Id
    @Column(name = "Id", nullable = false, length = 100)
    private String id;

    @Column(name = "value")
    private Integer value;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}