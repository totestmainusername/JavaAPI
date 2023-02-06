package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.Interface;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.AverageDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.PercentageDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.SingleValueDTO;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AverageDTO.class, name = "medie" ),
        @JsonSubTypes.Type(value = SingleValueDTO.class, name ="valorisingoli"),
        @JsonSubTypes.Type(value = PercentageDTO.class, name = "percentuali")
})
public interface INumericFormat {

}
