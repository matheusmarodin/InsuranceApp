package com.mathmaro.healthinsurance.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathmaro.healthinsurance.domain.Provider;
import com.mathmaro.healthinsurance.domain.Specialty;
import com.mathmaro.healthinsurance.model.ProviderResponse;
import com.mathmaro.healthinsurance.repository.ProviderRepository;
import com.mathmaro.healthinsurance.repository.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InsuranceServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @Mock
    ProviderRepository providerRepository;

    @Mock
    GoogleService googleService;

    @InjectMocks
    InsuranceService insuranceService;

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void findProvidersByDistanceAndSpecialty() throws Exception {

        String content = "{\"nome\":\"Dino Cardim\",\"endereco\":\"Rua Comendador Assad Abdalla\",\"latitude\":-25.9,\"longitute\":-52.65,\"distanciaEmKm\":828.393}";

        List<ProviderResponse> response;

        Specialty speciality = Specialty.builder().description("Radioterapia").build();

        when(specialtyRepository.findByDescription(any())).thenReturn(speciality);

        Provider provider = Provider.builder().name("Dino Cardim")
                .address("Rua Comendador Assad Abdalla")
                .latitude(-25.9000000)
                .longitude(-52.6500000)
                .build();
        List<Provider> providerList = new ArrayList<>();
        providerList.add(provider);

        when(providerRepository.findProviderBySpecialtiesIn(any())).thenReturn(providerList);

        List<Double> distances = new ArrayList<>();
        distances.add(828.393d);

        when(googleService.findDistanceBetweenCoordinates(any(),any())).thenReturn(distances);

        response = insuranceService.findProvidersByDistanceAndSpecialty(
                -23.955354,
                -46.4104784,
                "Radioterapia"
        );

        assertNotNull(response);
        assertEquals(1, response.size());

        ObjectMapper mapper = new ObjectMapper();
        assertEquals(content, mapper.writeValueAsString(response.get(0)));
    }
}
