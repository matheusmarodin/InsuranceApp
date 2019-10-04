package com.mathmaro.healthinsurance.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleServiceTest {

    GoogleService googleService;

    @BeforeEach
    public void setUp() {
        googleService = new GoogleService();
    }

    @Test
    public void findDistanceBetweenCoordinates() throws Exception{
        String[] origins = { "-23.955354,-46.4104784" };
        String[] destinations = { "-25.3036111,-50.0902778" };
        List<Double> distances = googleService.findDistanceBetweenCoordinates(origins, destinations);

        assertEquals(1, distances.size());
        assertEquals(new Double(513.189), distances.get(0));

    }


}
