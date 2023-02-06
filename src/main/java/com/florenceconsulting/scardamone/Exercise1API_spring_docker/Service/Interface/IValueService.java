package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Interface;


import org.springframework.http.ResponseEntity;

public interface IValueService <T>{
    ResponseEntity<T> Add(T numericFormat);
}
