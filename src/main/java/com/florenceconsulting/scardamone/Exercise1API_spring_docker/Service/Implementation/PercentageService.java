package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation;



import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.Converter.DTOtoEntity;

import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.PercentageDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository.PercentualiRepository;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Interface.IValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class PercentageService implements IValueService<PercentageDTO> {

    private final PercentualiRepository percentualiRepository;

    @Autowired
    public PercentageService(PercentualiRepository percentualiRepository) {
        this.percentualiRepository = percentualiRepository;
    }

    public ResponseEntity<PercentageDTO> Add (PercentageDTO percentualiDTO){
        if(percentualiDTO.getValue()<0 || percentualiDTO.getValue()>100)
            throw new IllegalArgumentException("Percent value out of range");
        return new ResponseEntity<>(DTOtoEntity.cast(percentualiRepository.save(DTOtoEntity.cast(percentualiDTO))), HttpStatus.CREATED);
    }
}
