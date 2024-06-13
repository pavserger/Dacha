package com.example.dacha.controllers;

import com.example.dacha.CrudService;
import com.example.dacha.model.Parcel;
import com.example.dacha.model.RollesAndUsers.Rolles;
import com.example.dacha.model.RollesAndUsers.RollesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RolesController {
    @Autowired
    private CrudService crudService;

    private RollesRepository rollesRepository;
    public RolesController (RollesRepository rollesRepository) {
        this.rollesRepository = rollesRepository;
    }
    @GetMapping("/roleslist")
    public ResponseEntity<List<Rolles>> getRolesList() {
        return new ResponseEntity<List<Rolles>>(crudService.getRolesList(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveOrUpdateCompany(@RequestBody Rolles roles) {
        crudService.saveOrUpdateRoles(roles);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
