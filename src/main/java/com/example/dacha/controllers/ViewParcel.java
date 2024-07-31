package com.example.dacha.controllers;

import com.example.dacha.CrudService;
import com.example.dacha.model.ParcelRepository;
import com.example.dacha.model.PaysAndJobs.AnnualPaymentRepository;
import com.example.dacha.model.RollesAndUsers.Landowner;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
//import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.List;

@Controller
public class ViewParcel {

    @Autowired
    private CrudService crudService;
    private ParcelRepository parcelRepository;

    public long idParcel = 1;
    public ViewParcel(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }
    @RequestMapping("/viewparcel")
    public String viewParcel() {


        return "viewparcel";
    }
    @PostMapping("/viewparcel/img/{id}")

    public  ResponseEntity<Void> postNumImage(@PathVariable Long id) throws IOException {
        idParcel = id;
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("viewparcel/img")

    public @ResponseBody byte[] getImage() throws IOException {
        String dacha = "/image/dacha"+ idParcel+".PNG";
        String p = System.getProperty("user.dir");
        String p2 = p + dacha;

        InputStream fileSystemStream = new FileInputStream(System.getProperty("user.dir")+dacha);
        return IOUtils.toByteArray(fileSystemStream);
    }


}
