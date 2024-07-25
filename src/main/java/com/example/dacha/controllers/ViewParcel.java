package com.example.dacha.controllers;

import com.example.dacha.CrudService;
import com.example.dacha.model.ParcelRepository;
import com.example.dacha.model.PaysAndJobs.AnnualPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewParcel {

    @Autowired
    private CrudService crudService;
    private ParcelRepository parcelRepository;
    public ViewParcel(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }
    @RequestMapping("/viewparcel")
    public String viewParcel() {


        return "viewparcel";
    }

}
