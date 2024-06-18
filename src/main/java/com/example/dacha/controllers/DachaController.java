package com.example.dacha.controllers;

import com.example.dacha.CrudService;
import com.example.dacha.model.Parcel;
import com.example.dacha.model.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DachaController {

    private ParcelRepository parcelRepository;

    // Рекомендуемый вариант внедрения зависимости:
    // внедрение зависимости в класс через конструктор
    public DachaController(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

 //   @GetMapping("/parcels/")
/*
    @GetMapping("/companyList")
    public ResponseEntity<List<Company>> getCompanyList() {
        return new ResponseEntity<List<Company>>(crudService.getCompanyList(), HttpStatus.OK);
    }

    public List<Parcel> list() {
        Iterable<Parcel> parcelIterable = parcelRepository.findAll();

        List<Parcel> parcels = new ArrayList<>();
        for (Parcel parcel : parcelIterable) {
            parcels.add(parcel);
        }
        return parcels;
    }
*/

    @Autowired
    private CrudService crudService;
    @GetMapping("/parcels")
    public ResponseEntity<List<Parcel>> getCompanyList() {
        return new ResponseEntity<List<Parcel>>(crudService.getCompanyList(), HttpStatus.OK);
    }
@PostMapping("/parcel/save")
public ResponseEntity<Void> saveOrUpdateCompany(@RequestBody Parcel parcel) {
    crudService.saveOrUpdateCompany(parcel);
    return new ResponseEntity<Void>(HttpStatus.OK);
}


/*
    @DeleteMapping("/parcel/delete/{id}")
    public ResponseEntity<Long> deleteParcel(@PathVariable Long id) {
        Long idDel = crudService.deleteParcel(id);
        return new ResponseEntity <Long> (HttpStatus.OK);
    }

 */

    @DeleteMapping("/parcel/delete/{id}")
    public ResponseEntity<Void> deleteParcel(@PathVariable Long id){
        try {
        //    Parcel parsel = crudService.findById(id);
            crudService.deleteParcel(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}