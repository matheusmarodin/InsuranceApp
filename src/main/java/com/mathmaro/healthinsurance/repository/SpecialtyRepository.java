package com.mathmaro.healthinsurance.repository;

import com.mathmaro.healthinsurance.domain.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {

    Specialty findByDescription(String description);
}
