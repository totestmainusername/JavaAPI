package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation;



import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.Converter.DTOtoEntity;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.AverageDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository.AverageRepository;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Interface.IValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AvarageService implements IValueService<AverageDTO> {

    private final AverageRepository AverageRepository;

    @Autowired
    public AvarageService(AverageRepository AverageRepository) {
        this.AverageRepository = AverageRepository;
    }

    @Override
    public ResponseEntity<AverageDTO> Add (AverageDTO AverageDTO){
        return new ResponseEntity<>(DTOtoEntity.cast(AverageRepository.save(DTOtoEntity.cast(AverageDTO))), HttpStatus.CREATED);
    }
}
