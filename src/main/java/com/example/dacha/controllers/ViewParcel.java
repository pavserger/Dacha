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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.List;

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
    @GetMapping("viewparcel/img")
   // @ResponseBody
    /*
    public ResponseEntity<InputStreamResource> getImageDynamicType(@RequestParam("jpg") boolean jpg) {
        //public ResponseEntity<InputStreamResource> getImageDynamicType(@RequestParam("jpg") boolean jpg) {
        MediaType contentType = jpg ? MediaType.IMAGE_JPEG : MediaType.IMAGE_PNG;
        InputStream in = jpg ?
                getClass().getResourceAsStream("dacha2.png") :
                getClass().getResourceAsStream("dacha2.jpg");
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(new InputStreamResource(in));
    }




     */
/*
    public ResponseEntity<InputStreamResource> getImageDynamicType() {
        //public ResponseEntity<InputStreamResource> getImageDynamicType(@RequestParam("jpg") boolean jpg) {
      //  MediaType contentType = jpg ? MediaType.IMAGE_JPEG : MediaType.IMAGE_PNG;
        InputStream in = getClass().getResourceAsStream("dacha2.png");
        return new ResponseEntity<InputStreamResource>((MultiValueMap<String, String>) in, HttpStatus.OK);

    }
*/

    public @ResponseBody byte[] getImage() throws IOException {

        //  OutputStream os = new FileOutputStream("../image/output.txt");
      //  os.write(65);

      //  System.out.println("Working Directory = " + System.getProperty("user.dir"));
     //   InputStream in = getClass()
       //         .getResourceAsStream("dacha2.PNG");

        InputStream fileSystemStream = new FileInputStream(System.getProperty("user.dir")+"/image/dacha2.PNG");
        return IOUtils.toByteArray(fileSystemStream);
    }


}
