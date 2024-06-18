package com.example.dacha.controllers;

import com.example.dacha.CrudService;
import com.example.dacha.model.Parcel;
import com.example.dacha.model.RollesAndUsers.Rolles;
import com.example.dacha.model.RollesAndUsers.RollesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RolesController {
    @Autowired
    private CrudService crudService;

    private RollesRepository rollesRepository;
    public RolesController (RollesRepository rollesRepository) {
        this.rollesRepository = rollesRepository;
    }

   /*
    @RequestMapping("/owner")

    public String roles() {
        return "owner";
    }
*/

    @GetMapping("/rolesList")
    public ResponseEntity<List<Rolles>> getRolesList() {
        //System.out.println("hihi");
        var listb = crudService.getRollesList();
        System.out.println("hih");
        System.out.println(listb);

        return new ResponseEntity<List<Rolles>>(crudService.getRollesList(), HttpStatus.OK);
    }

    @PostMapping("roles/save")
    public ResponseEntity<Void> saveOrUpdateCompany(@RequestBody Rolles roles) {
        crudService.saveOrUpdateRoles(roles);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
