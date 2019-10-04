package com.mathmaro.healthinsurance.bootstrap;

import com.mathmaro.healthinsurance.domain.Provider;
import com.mathmaro.healthinsurance.domain.Specialty;
import com.mathmaro.healthinsurance.repository.ProviderRepository;
import com.mathmaro.healthinsurance.repository.SpecialtyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    SpecialtyRepository specialtyRepository;

    @Override
    public void run(String... args) {
        loadData();
    }

    private void loadData() {
        Specialty s1 = Specialty.builder().description("Psiquiatria").build();
        Specialty s2 = Specialty.builder().description("Alergia").build();
        Specialty s3 = Specialty.builder().description("Endoscopia").build();
        Specialty s4 = Specialty.builder().description("Homeopatia").build();
        Specialty s5 = Specialty.builder().description("Cardiologia").build();
        Specialty s6 = Specialty.builder().description("Cirurgia").build();
        Specialty s7 = Specialty.builder().description("Neurologia").build();
        Specialty s8 = Specialty.builder().description("Ortopedia").build();
        Specialty s9 = Specialty.builder().description("Urologia").build();
        Specialty s10 = Specialty.builder().description("Radioterapia").build();

        specialtyRepository.saveAll(Arrays.asList(s1,s2,s3,s4,s5,s6,s6,s7,s8,s9,s10));
        log.info("Loaded specialties");

        Provider p1 = Provider.builder()
                .name("Anselmo Lage")
                .address("Rua Glucínio")
                .latitude(-25.2838889)
                .longitude(-50.1130556)
                .specialties(Arrays.asList(s1,s3,s5))
                .build();

        Provider p2 = Provider.builder()
                .name("Benedita Castanho")
                .address("Rua Nelson Ferreira")
                .latitude(-25.2838889)
                .longitude(-50.1130556)
                .specialties(Arrays.asList(s4,s5,s6))
                .build();

        Provider p3 = Provider.builder()
                .name("Capitolino Areosa")
                .address("Rua Clodomiro Pinheiro")
                .latitude(-25.3036111)
                .longitude(-50.0902778)
                .specialties(Arrays.asList(s1,s3,s5))
                .build();

        Provider p4 = Provider.builder()
                .name("Carla Belchiorinho")
                .address("Rua Emí\u00ADlio Retrosi")
                .latitude(-16.6833333)
                .longitude(-56.0166667)
                .specialties(Collections.singletonList(s8))
                .build();

        Provider p5 = Provider.builder()
                .name("Cauê Valido")
                .address("Praça Antônio Pereira Martins")
                .latitude(-6.8000000)
                .longitude(-42.2833333)
                .specialties(Arrays.asList(s1,s3,s5))
                .build();

        Provider p6 = Provider.builder()
                .name("Dino Cardim")
                .address("Rua Comendador Assad Abdalla")
                .latitude(-25.9000000)
                .longitude(-52.6500000)
                .specialties(Collections.singletonList(s10))
                .build();

        Provider p7 = Provider.builder()
                .name("Ernesto Casado")
                .address("Rua Ouro Verde")
                .latitude(-25.9000000)
                .longitude(-52.6500000)
                .specialties(Arrays.asList(s4,s5,s6))
                .build();

        Provider p8 = Provider.builder()
                .name("Ernesto Castilhos")
                .address("Rua Casa da Boavista")
                .latitude(-28.4666667)
                .longitude(-48.8666667)
                .specialties(Arrays.asList(s1,s3,s5))
                .build();

        Provider p9 = Provider.builder()
                .name("Zenaide Lousã")
                .address("Praça João Paulo Meira")
                .latitude(-27.9333333)
                .longitude(-52.9166667)
                .specialties(Collections.singletonList(s7))
                .build();

        Provider p10 = Provider.builder()
                .name("Frederica Sobreira")
                .address("Rua John Redford")
                .latitude(-30.7000000)
                .longitude(-52.1166667)
                .specialties(Arrays.asList(s8,s9))
                .build();

        Provider p11 = Provider.builder()
                .name("Godo Homem")
                .address("Avenida Nazaré")
                .latitude(-19.9000000)
                .longitude(-45.9833333)
                .specialties(Arrays.asList(s1,s3,s5))
                .build();

        Provider p12 = Provider.builder()
                .name("Sancha Monteiro")
                .address("Avenida João Barreto de Menezes")
                .latitude(-24.8833333)
                .longitude(-53.2666667)
                .specialties(Collections.singletonList(s2))
                .build();

        Provider p13 = Provider.builder()
                .name("Iara Canejo")
                .address("Avenida Adelino Jorge Montenegro")
                .latitude(-24.9500000)
                .longitude(-53.2333333)
                .specialties(Collections.singletonList(s1))
                .build();

        Provider p14 = Provider.builder()
                .name("Ingrit Bethancout")
                .address("Rua Rynaldo Borgianni")
                .latitude(-25.5666667)
                .longitude(-54.4666667)
                .build();

        Provider p15 = Provider.builder()
                .name("Iolanda Arantes")
                .address("Rua Acioli Monteiro")
                .latitude(-25.5091667)
                .longitude(-50.5913889)
                .specialties(Arrays.asList(s1,s3,s5))
                .build();

        Provider p16 = Provider.builder()
                .name("Judas Pêcego")
                .address("Rua Acioli Monteiro")
                .latitude(-25.5091667)
                .longitude(-50.5913889)
                .specialties(Collections.singletonList(s1))
                .build();

        Provider p17 = Provider.builder()
                .name("Levindo Guaraná")
                .address("Rua Manuel Teles Vitancos")
                .latitude(-25.4922222)
                .longitude(-50.5780556)
                .specialties(Arrays.asList(s4,s5,s6))
                .build();

        Provider p18 = Provider.builder()
                .name("Maiara Dorneles")
                .address("Rua Antônio Mariani")
                .latitude(-29.4166667)
                .longitude(-53.1333333)
                .specialties(Collections.singletonList(s1))
                .build();

        Provider p19 = Provider.builder()
                .name("Rafael Quirós")
                .address("Rua Tiburno")
                .latitude(-24.9333333)
                .longitude(-53.1833333)
                .specialties(Arrays.asList(s1,s3,s5))
                .build();

        Provider p20 = Provider.builder()
                .name("Rebeca Campello")
                .address("Rua Venceslau José Bernardes")
                .latitude(-25.0333333)
                .longitude(-52.9166667)
                .specialties(Collections.singletonList(s4))
                .build();

        providerRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20));
        log.info("Loaded providers");
    }

}
