package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Factory;

import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.Interface.INumericFormat;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.AverageDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.PercentageDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation.AvarageService;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation.PercentageService;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation.SingleValueService;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Interface.IValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFactory {

    private final AvarageService avarageService;
    private final PercentageService percentageService;
    private final SingleValueService singleValueService;

    @Autowired
    public ServiceFactory(AvarageService avarageService, PercentageService percentageService, SingleValueService singleValueService) {
        this.avarageService = avarageService;
        this.percentageService = percentageService;
        this.singleValueService = singleValueService;
    }

    public IValueService SelectFactory(INumericFormat numericFormat){
        if(numericFormat instanceof AverageDTO){
            return avarageService;
        }
        else if (numericFormat instanceof PercentageDTO){
            return percentageService;
        }
        else{
            return singleValueService;
        }
    }


}
