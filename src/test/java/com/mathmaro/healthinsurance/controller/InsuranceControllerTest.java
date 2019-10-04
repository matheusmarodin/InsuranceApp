package com.mathmaro.healthinsurance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathmaro.healthinsurance.model.ProviderResponse;
import com.mathmaro.healthinsurance.service.InsuranceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class InsuranceControllerTest {

    @Mock
    InsuranceService insuranceService;

    @InjectMocks
    InsuranceController insuranceController;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(insuranceController).build();
    }

    @Test
    public void listHealthProviders() throws Exception {
        List<ProviderResponse> response = new ArrayList<>();
        ProviderResponse p1 = ProviderResponse.builder()
                .nome("Dino Cardim")
                .endereco("Rua Comendador Assad Abdalla")
                .latitude(-25.9)
                .longitute(-52.65)
                .distanciaEmKm(828.393)
                .build();
        response.add(p1);

        when(insuranceService.findProvidersByDistanceAndSpecialty(any(),any(),any())).thenReturn(response);

        MvcResult result = mockMvc.perform(get("/obterPrestadoresSaude?latitude=-23.955354&longitude=-46.4104784&especialidade=Radioterapia"))
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        assertEquals(mapper.writeValueAsString(response), result.getResponse().getContentAsString());
    }
}
