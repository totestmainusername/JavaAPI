package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.Converter;



import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.AverageDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.PercentageDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.SingleValueDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Entity.*;
import org.springframework.context.annotation.Bean;


public class DTOtoEntity {

    @Bean
    public static Medie cast(AverageDTO AverageDTO){
        Medie entity = new Medie();
        entity.setId(AverageDTO.getId());
        entity.setValue(AverageDTO.getValue());
        return entity;
    }

    @Bean
    public static Valorisingoli cast(SingleValueDTO singleValueDTO){
        Valorisingoli entity = new Valorisingoli();
        entity.setId(singleValueDTO.getId());
        entity.setValue(singleValueDTO.getValue());
        return entity;
    }

    @Bean
    public static  Percentuali cast(PercentageDTO percentageDTO){
        Percentuali entity = new Percentuali();
        entity.setId(percentageDTO.getId());
        entity.setValue(percentageDTO.getValue());
        return entity;
    }

    @Bean
    public static AverageDTO cast (Medie Average){
        AverageDTO dto = new AverageDTO();
        dto.setId(Average.getId());
        dto.setValue(Average.getValue());
        return dto;
    }

    @Bean
    public static PercentageDTO cast (Percentuali percentuali){
        PercentageDTO dto = new PercentageDTO();
        dto.setId(percentuali.getId());
        dto.setValue(percentuali.getValue());
        return dto;
    }
    @Bean
    public static SingleValueDTO cast (Valorisingoli valorisingoli){
        SingleValueDTO dto = new SingleValueDTO();
        dto.setId(valorisingoli.getId());
        dto.setValue(valorisingoli.getValue());
        return dto;
    }



}
