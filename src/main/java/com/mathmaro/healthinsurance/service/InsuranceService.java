package com.mathmaro.healthinsurance.service;

import com.mathmaro.healthinsurance.domain.Provider;
import com.mathmaro.healthinsurance.domain.Specialty;
import com.mathmaro.healthinsurance.model.ProviderResponse;
import com.mathmaro.healthinsurance.repository.ProviderRepository;
import com.mathmaro.healthinsurance.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class InsuranceService {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private GoogleService googleService;

    public List<ProviderResponse> findProvidersByDistanceAndSpecialty(Double latitude, Double longitude, String specialty){

        String[] origins = {String.format("%s,%s", latitude, longitude)};
        List<ProviderResponse> responseList = new ArrayList<>();
        List<String> destinations = new ArrayList<>();

        Specialty spec = specialtyRepository.findByDescription(specialty);

        if (spec != null) {

            //Generate list of destinations coordinates
            List<Provider> providers = providerRepository.findProviderBySpecialtiesIn(spec);

            providers.forEach(
                    provider -> destinations.add(String.format("%s,%s", provider.getLatitude(), provider.getLongitude()))
            );

            //Create Response with distance from google api
            List<Double> distances;
            try {
                distances = googleService.findDistanceBetweenCoordinates(origins, destinations.toArray(new String[destinations.size()]));
            } catch(Exception e){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao buscar dados Google Api", e);
            }

            int index = 0;
            for (Provider provider : providers) {
                ProviderResponse response = ProviderResponse
                        .builder()
                        .nome(provider.getName())
                        .endereco(provider.getAddress())
                        .latitude(provider.getLatitude())
                        .longitute(provider.getLongitude())
                        .distanciaEmKm(distances.get(index))
                        .build();

                responseList.add(response);
                index++;
            }

            //Order by getDistanciaEmKM

            Comparator<ProviderResponse> compareByDistance = Comparator.comparing(ProviderResponse::getDistanciaEmKm);

            responseList.sort(compareByDistance);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Especialidade invalida");
        }

        return responseList;
    }
}
