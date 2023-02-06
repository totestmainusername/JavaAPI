package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service;

import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.PercentageDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Entity.Percentuali;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Repository.PercentualiRepository;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation.PercentageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
@DisplayName("Percentage Service Test")
public class PercentageServiceTest {

    @InjectMocks
    private PercentageService service;
    @Mock
    private PercentualiRepository repository;

    @Test
    void save(){
        final Percentuali expected =new Percentuali();
        expected.setId("13");
        expected.setValue(1);

        final PercentageDTO dtoToSave = new PercentageDTO();
        dtoToSave.setId("13");
        dtoToSave.setValue(1);
        when(repository.save(any(Percentuali.class))).thenReturn(expected);

        var actual = service.Add(dtoToSave);

        assertThat(actual.getBody().getId()).isEqualTo(expected.getId());
        verify(repository, times(1)).save(any(Percentuali.class));
        verifyNoMoreInteractions(repository);
    }
    @Test
    void outOfRangeValue(){
        final PercentageDTO upperValue= new PercentageDTO();
        upperValue.setId("1");
        upperValue.setValue(101);
        final PercentageDTO lowerValue = new PercentageDTO();
        lowerValue.setId("2");
        lowerValue.setValue(-1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.Add(upperValue);
        });
        assertThrows(IllegalArgumentException.class, () ->{
           service.Add(lowerValue);
        });
    }
}
