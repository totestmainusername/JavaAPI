package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller;


import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.Interface.INumericFormat;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation.ServiceFactory;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Interface.IValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ExcerciseController {


    @Autowired
    public ServiceFactory serviceFactory;

    @PostMapping("/api/post")
    public void reciveMessage(@RequestBody INumericFormat numericFormat ){
        serviceFactory.SelectFactory(numericFormat).Add(numericFormat);
    }


}
