package com.example.dacha.model.PaysAndJobs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectrisitiTarifRepository extends JpaRepository<ElectrisityTariff, Long> {
}
