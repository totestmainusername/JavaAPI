package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO;

import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.Interface.INumericFormat;


public class AverageDTO implements INumericFormat {
    private String id;
    private Integer value;

    public AverageDTO(){}
    public AverageDTO(String id, Integer value) {
        this.id = id;
        this.value = value;
    }

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
