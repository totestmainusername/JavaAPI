package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation;



import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTOtoEntity;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.ValorisingoliDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository.ValorisingoliRepository;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Interface.IValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SingleValueService implements IValueService<ValorisingoliDTO> {

    private ValorisingoliRepository valorisingoliRepository;

    @Autowired
    public SingleValueService(ValorisingoliRepository valorisingoliRepository) {
        this.valorisingoliRepository = valorisingoliRepository;
    }

    @Override
    public void Add(ValorisingoliDTO valorisingoliDTO){
        valorisingoliRepository.save(DTOtoEntity.cast(valorisingoliDTO));
    }

}
