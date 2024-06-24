package com.example.dacha.controllers;

import com.example.dacha.CrudService;
import com.example.dacha.model.Parcel;
import com.example.dacha.model.ParcelRepository;
import com.example.dacha.model.PaysAndJobs.AnnualPayment;
import com.example.dacha.model.PaysAndJobs.AnnualPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookKeeper {
    @Autowired
    private CrudService crudService;
    private AnnualPaymentRepository annualPaymentRepository;
    public BookKeeper(AnnualPaymentRepository annualPaymentRepository) {
        this.annualPaymentRepository = annualPaymentRepository;
    }
   //    Annual Payment
    @RequestMapping("/bookkeeper")
    public String roles() {
        return "bookkeeper";
    }

    @GetMapping("/bookkeeper/list")
    public ResponseEntity<List<AnnualPayment>> geAnnualPaymentList() {
        return new ResponseEntity<List<AnnualPayment>>(crudService.getAnnualPaymentList(), HttpStatus.OK);
    }

    @PostMapping("/bookkeeper/save")
    public ResponseEntity<Void> saveOrUpdaAnnualPayment (@RequestBody AnnualPayment annualPayment) {
        Parcel parcel = crudService.getParcelById(annualPayment.getLparcel());
        annualPayment.setParcel(parcel);
        crudService.saveOrUpdateAnnualPayment(annualPayment);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/bookkeeper/delete/{id}")
    public ResponseEntity<Void> deleteAnnualPayment (@PathVariable Long id) {
        try {
            crudService.deleteAnnualPayment(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
