package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service;


import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.SingleValueDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Entity.Valorisingoli;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository.ValorisingoliRepository;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation.SingleValueService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
@DisplayName("SingleValue Service Test")
public class SingleValueServiceTest {

    @InjectMocks
    private SingleValueService service;
    @Mock
    private ValorisingoliRepository repository;

    @Test
    void save(){
        final Valorisingoli singlevalueToSave =new Valorisingoli();
        singlevalueToSave.setId("13");
        singlevalueToSave.setValue(1);
        when(repository.save(any(Valorisingoli.class))).thenReturn(singlevalueToSave);

        var actual = service.Add(new SingleValueDTO());

        assertThat(actual.getBody().getId()).isEqualTo(singlevalueToSave.getId());
        verify(repository, times(1)).save(any(Valorisingoli.class));
        verifyNoMoreInteractions(repository);
    }

}

