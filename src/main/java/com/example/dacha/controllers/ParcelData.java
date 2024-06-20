package com.example.dacha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParcelData {

    @RequestMapping("/parcel")
    public String roles() {
        return "parcel";
    }

}
