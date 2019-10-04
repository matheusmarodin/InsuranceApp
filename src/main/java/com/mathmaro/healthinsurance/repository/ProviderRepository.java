package com.mathmaro.healthinsurance.repository;

import com.mathmaro.healthinsurance.domain.Provider;
import com.mathmaro.healthinsurance.domain.Specialty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProviderRepository extends CrudRepository<Provider, Long> {

    List<Provider> findProviderBySpecialtiesIn(Specialty specialty);
}
