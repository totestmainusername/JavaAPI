package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller;


import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.Interface.INumericFormat;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Factory.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ApiController {


    @Autowired
    public ServiceFactory serviceFactory;

    @PostMapping("/api/post")
    public ResponseEntity<INumericFormat> receiveMessage(@RequestBody INumericFormat numericFormat ){
        return serviceFactory.SelectFactory(numericFormat).Add(numericFormat);
    }


}
