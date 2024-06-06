package com.example.dacha.controllers;

import com.example.dacha.CrudService;
import com.example.dacha.model.Parcel;
import com.example.dacha.model.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
/*
    @PostMapping("/company/save")
    public ResponseEntity<Void> saveOrUpdateCompany(@RequestBody Company company) {
        crudService.saveOrUpdateCompany(company);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/parcel/save")
    public void add(Parcel parcel) {
        Parcel newParcel = parcelRepository.save(parcel);
        //return newParcel.getId();
    }
 */
@PostMapping("/parcel/save")
public ResponseEntity<Void> saveOrUpdateCompany(@RequestBody Parcel parcel) {
    crudService.saveOrUpdateCompany(parcel);
    return new ResponseEntity<Void>(HttpStatus.OK);
}



/*
    @GetMapping("/books/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Parcel> optionalBook = parcelRepository.findById(id);

        if (!optionalBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
    }

 */
}