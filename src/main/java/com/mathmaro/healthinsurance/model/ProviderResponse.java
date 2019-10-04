package com.mathmaro.healthinsurance.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProviderResponse {
    String nome;
    String endereco;
    Double latitude;
    Double longitute;
    Double distanciaEmKm;
}
