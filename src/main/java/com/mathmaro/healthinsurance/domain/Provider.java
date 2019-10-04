package com.mathmaro.healthinsurance.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "provider")
@AllArgsConstructor
@NoArgsConstructor
public class Provider {
    @Id
    @GeneratedValue
    Long id;

    String name;

    String address;

    Double latitude;

    Double longitude;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "providers_specialities", joinColumns = @JoinColumn(name = "provider_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    List<Specialty> specialties;
}
