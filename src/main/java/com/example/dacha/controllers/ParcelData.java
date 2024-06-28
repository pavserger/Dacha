package com.example.dacha.controllers;

import com.example.dacha.CrudService;
import com.example.dacha.model.PaysAndJobs.AnnualPayment;
import com.example.dacha.model.PaysAndJobs.AnnualPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ParcelData {
    @Autowired
    private CrudService crudService;
    private AnnualPaymentRepository annualPaymentRepository;
    public ParcelData(AnnualPaymentRepository annualPaymentRepository) {
        this.annualPaymentRepository = annualPaymentRepository;
    }
    @RequestMapping("/parcel")
    public String roles() {
        return "parcel";
    }


    @GetMapping("/parcel/list")
    public ResponseEntity<List<AnnualPayment>> geAnnualPaymentList() {
        return new ResponseEntity<List<AnnualPayment>>(crudService.getParcelPaymentList(), HttpStatus.OK);
    }


}
