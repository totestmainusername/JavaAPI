package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation;



import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.Converter.DTOtoEntity;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.SingleValueDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository.ValorisingoliRepository;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Interface.IValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class SingleValueService implements IValueService<SingleValueDTO> {

    private final ValorisingoliRepository valorisingoliRepository;

    @Autowired
    public SingleValueService(ValorisingoliRepository valorisingoliRepository) {
        this.valorisingoliRepository = valorisingoliRepository;
    }

    @Override
    public ResponseEntity<SingleValueDTO> Add(SingleValueDTO valorisingoliDTO){
        return new ResponseEntity<>(DTOtoEntity.cast(valorisingoliRepository.save(DTOtoEntity.cast(valorisingoliDTO))), HttpStatus.CREATED);
    }

}
