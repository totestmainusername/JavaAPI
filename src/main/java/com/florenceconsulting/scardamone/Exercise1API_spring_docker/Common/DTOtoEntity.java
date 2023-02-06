package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common;



import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.*;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Entity.*;
import org.springframework.context.annotation.Bean;


public class DTOtoEntity {

    @Bean
    public static Medie cast(MedieDTO medieDTO){
        Medie entity = new Medie();
        entity.setId(medieDTO.getId());
        entity.setValue(medieDTO.getValue());
        return entity;
    }

    @Bean
    public static Valorisingoli cast(ValorisingoliDTO valorisingoliDTO){
        Valorisingoli entity = new Valorisingoli();
        entity.setId(valorisingoliDTO.getId());
        entity.setValue(valorisingoliDTO.getValue());
        return entity;
    }

    @Bean
    public static  Percentuali cast(PercentualiDTO percentualiDTO){
        Percentuali entity = new Percentuali();
        entity.setId(percentualiDTO.getId());
        entity.setValue(percentualiDTO.getValue());
        return entity;
    }





}
