package com.mathmaro.healthinsurance.service;

import com.google.maps.*;
import com.google.maps.model.DistanceMatrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GoogleService {

    public List<Double> findDistanceBetweenCoordinates(String[] origins, String[] destinations) throws Exception {

        log.info("Google API");
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDW3TeIt4chzzH3e0-I0OzlYL88siWygiw")
                .build();

        DistanceMatrixApiRequest request = DistanceMatrixApi.getDistanceMatrix(context,
                origins,
                destinations);

        DistanceMatrix result = request.await();

        List<Double> distances = new ArrayList<>();
        for (int line = 0; line < destinations.length; line++) {
            if (result.rows[0].elements[line].distance != null)
                distances.add(result.rows[0].elements[line].distance.inMeters / 1000d);
            else
                distances.add(-1d);
        }
        return distances;

    }

}
