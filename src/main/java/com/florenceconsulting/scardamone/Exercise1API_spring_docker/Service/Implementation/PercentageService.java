package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation;



import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTOtoEntity;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller.DTO.PercentualiDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository.PercentualiRepository;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Interface.IValueService;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PercentageService implements IValueService<PercentualiDTO> {

    private PercentualiRepository percentualiRepository;

    @Autowired
    public PercentageService(PercentualiRepository percentualiRepository) {
        this.percentualiRepository = percentualiRepository;
    }

    public void Add(PercentualiDTO percentualiDTO){
        if(percentualiDTO.getValue()<0 || percentualiDTO.getValue()>100)
            throw new IllegalArgumentException("Percent value out of range");
        percentualiRepository.save(DTOtoEntity.cast(percentualiDTO));
    }
}
