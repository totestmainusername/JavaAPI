package com.florenceconsulting.scardamone.Exercise1API_spring_docker.Controller;



import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.Interface.INumericFormat;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.AverageDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.PercentageDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Common.DTO.SingleValueDTO;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation.AvarageService;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation.PercentageService;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Factory.ServiceFactory;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Implementation.SingleValueService;
import com.florenceconsulting.scardamone.Exercise1API_spring_docker.Service.Interface.IValueService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ApiController.class)
@ActiveProfiles("test")
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceFactory serviceFactory;

    @Mock
    private AvarageService avarageService;
    @Mock
    private PercentageService percentageService;
    @Mock
    private SingleValueService singleValueService;
    @Mock
    private IValueService valueService;
    @Test
    public void Return201WhenCreateNewAverage() throws Exception{

        INumericFormat Average = new AverageDTO("1",1);
        INumericFormat percentuali = new PercentageDTO("1",1);
        INumericFormat valorisingoli = new SingleValueDTO("1",1);


         when(serviceFactory.SelectFactory(any(AverageDTO.class))).thenReturn(avarageService);
         when(serviceFactory.SelectFactory(any(PercentageDTO.class))).thenReturn(percentageService);
         when(serviceFactory.SelectFactory(any(SingleValueDTO.class))).thenReturn(singleValueService);

         when(avarageService.Add(any(AverageDTO.class))).thenReturn(new ResponseEntity<AverageDTO>(new AverageDTO("1",1), HttpStatus.CREATED));
         when(percentageService.Add(any(PercentageDTO.class))).thenReturn(new ResponseEntity<PercentageDTO> (new PercentageDTO("1",1), HttpStatus.CREATED));
        when(singleValueService.Add(any(SingleValueDTO.class))).thenReturn(new ResponseEntity<SingleValueDTO>(new SingleValueDTO("1",1),HttpStatus.CREATED));

        String requestBodyAverage = "{\"id\":\"1\",\"value\":\"1\",\"type\":\"Average\"}";
        mockMvc.perform(post("/api/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBodyAverage))
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"type\":\"Average\",\"id\":\"1\",\"value\":1}"));

        String requestBodyPercentuali = "{\"id\":\"1\",\"value\":\"1\",\"type\":\"percentuali\"}";
        mockMvc.perform(post("/api/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBodyPercentuali))
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"type\":\"percentuali\",\"id\":\"1\",\"value\":1}"));

        String requestBodyValorisingoli = "{\"id\":\"1\",\"value\":\"1\",\"type\":\"valorisingoli\"}";
        mockMvc.perform(post("/api/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBodyValorisingoli))
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"type\":\"valorisingoli\",\"id\":\"1\",\"value\":1}"));

    }

}
