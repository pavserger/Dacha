package com.example.dacha.controllers;

import com.example.dacha.CrudService;
import com.example.dacha.model.ParcelRepository;
import com.example.dacha.model.PaysAndJobs.AnnualPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.apache.commons.compress.utils.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
    /*
    @GetMapping(value = "/image")
    public @ResponseBody byte[] getImage() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/com/baeldung/produceimage/image.jpg").;
    //    ByteArrayOutputStream IOUtils = null;
     //   return IOUtils.toByteArray(in);
        return in;

    }

     */
    @GetMapping("/get-image-dynamic-type")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getImageDynamicType(@RequestParam("jpg") boolean jpg) {
        MediaType contentType = jpg ? MediaType.IMAGE_JPEG : MediaType.IMAGE_PNG;
        InputStream in = jpg ?
                getClass().getResourceAsStream("/com/baeldung/produceimage/image.jpg") :
                getClass().getResourceAsStream("/com/baeldung/produceimage/image.png");
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(new InputStreamResource(in));
    }





}
