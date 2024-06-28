package com.example.dacha.model.PaysAndJobs;

import com.example.dacha.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnualPaymentRepository extends JpaRepository<AnnualPayment, Long> {
    List<AnnualPayment> findAnnualPaymentByParcel(Parcel parcel);
}
