package com.example.dacha.controllers;

import com.example.dacha.CrudService;
import com.example.dacha.model.Parcel;
import com.example.dacha.model.ParcelRepository;
import com.example.dacha.model.RollesAndUsers.Landowner;
import com.example.dacha.model.RollesAndUsers.LandownerRepository;
import com.example.dacha.model.RollesAndUsers.Rolles;
import com.example.dacha.model.RollesAndUsers.RollesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OwnerController {

    @Autowired
    private CrudService crudService;
    private LandownerRepository landownerRepository;
    public OwnerController (LandownerRepository landownerRepository) {
        this.landownerRepository = landownerRepository;
    }
    @RequestMapping("/owner")
    public String roles() {
        return "owner";
    }

    @GetMapping("/ownersList")
    public ResponseEntity<List <Landowner>> getOwnersList() {
        //System.out.println("hihi");
        var listb = crudService.getOwnersList();

        return new ResponseEntity<List<Landowner>>(crudService.getOwnersList(), HttpStatus.OK);
    }

    @PostMapping("owner/save")
    public ResponseEntity<Void> saveOrUpdateOwners(@RequestBody Landowner landowner) {
      //  crudService.saveOrUpdateOwners(landowner);
        Parcel parcel = crudService.getParcelById(landowner.getNumparcel());
        landowner.setParcel(parcel);
        crudService.saveOrUpdateOwners(landowner);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/owner/delete/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        crudService.deleteOwner(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
