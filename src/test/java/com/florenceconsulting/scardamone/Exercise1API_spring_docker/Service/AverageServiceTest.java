package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service;

import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.AverageDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Entity.Medie;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository.AverageRepository;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation.AvarageService;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@DisplayName("Avarage Service Test")
public class AverageServiceTest {

    @InjectMocks
    private AvarageService service;
    @Mock
    private AverageRepository repository;

    @Test
    void save(){
        final Medie avarageToSave =new Medie();
        avarageToSave.setId("13");
        avarageToSave.setValue(1);
        when(repository.save(any(Medie.class))).thenReturn(avarageToSave);

        var actual = service.Add(new AverageDTO());

        assertThat(actual.getBody().getId()).isEqualTo(avarageToSave.getId());
        verify(repository, times(1)).save(any(Medie.class));
        verifyNoMoreInteractions(repository);
    }
}
