package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO;

import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.Interface.INumericFormat;


public class ValorisingoliDTO implements INumericFormat {
    private String id;
    private Integer value;
    private String type;

    public ValorisingoliDTO(){}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
