package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.Interface;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.MedieDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.PercentualiDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.ValorisingoliDTO;
;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MedieDTO.class, name = "medie" ),
        @JsonSubTypes.Type(value = ValorisingoliDTO.class, name ="valorisingoli"),
        @JsonSubTypes.Type(value = PercentualiDTO.class, name = "percentuali")
})
public interface INumericFormat {

}
