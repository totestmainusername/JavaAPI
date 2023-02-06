package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation;



import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTOtoEntity;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.MedieDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository.MedieRepository;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Interface.IValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AvarageService implements IValueService<MedieDTO> {

    private MedieRepository medieRepository;

    @Autowired
    public AvarageService(MedieRepository medieRepository) {
        this.medieRepository = medieRepository;
    }

    @Override
    public void Add (MedieDTO medieDTO){
        medieRepository.save(DTOtoEntity.cast(medieDTO));
    }
}
