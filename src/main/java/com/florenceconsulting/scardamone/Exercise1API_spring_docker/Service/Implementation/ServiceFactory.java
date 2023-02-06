package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation;

import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.Interface.INumericFormat;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.MedieDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.PercentualiDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Entity.Medie;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository.MedieRepository;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Interface.IValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFactory {

    private  AvarageService avarageService;
    private  PercentageService percentageService;
    private SingleValueService singleValueService;

    @Autowired
    public ServiceFactory(AvarageService avarageService, PercentageService percentageService, SingleValueService singleValueService) {
        this.avarageService = avarageService;
        this.percentageService = percentageService;
        this.singleValueService = singleValueService;
    }

    public IValueService SelectFactory(INumericFormat numericFormat){
        if(numericFormat instanceof MedieDTO){
            return avarageService;
        }
        else if (numericFormat instanceof PercentualiDTO){
            return percentageService;
        }
        else{
            return singleValueService;
        }
    }


}
