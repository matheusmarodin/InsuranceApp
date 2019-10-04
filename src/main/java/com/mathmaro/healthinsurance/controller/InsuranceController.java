package com.mathmaro.healthinsurance.controller;

import com.mathmaro.healthinsurance.model.ProviderResponse;
import com.mathmaro.healthinsurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping( method = RequestMethod.GET, path = "/obterPrestadoresSaude", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ProviderResponse> listHealthProviders(@RequestParam("latitude") Double latitude,
                                                      @RequestParam("longitude") Double longitude,
                                                      @RequestParam("especialidade") String specialty){
        return insuranceService.findProvidersByDistanceAndSpecialty(latitude, longitude, specialty);
    }
}
