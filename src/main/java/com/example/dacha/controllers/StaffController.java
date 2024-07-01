package com.example.dacha.controllers;

import com.example.dacha.CrudService;
import com.example.dacha.model.Parcel;
import com.example.dacha.model.PaysAndJobs.AnnualPayment;
import com.example.dacha.model.PaysAndJobs.AnnualPaymentRepository;
import com.example.dacha.model.RollesAndUsers.Staff;
import com.example.dacha.model.RollesAndUsers.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StaffController {
    @Autowired
    private CrudService crudService;
    private StaffRepository staffRepository;
    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
    //    Annual Payment
    @RequestMapping("/staff")
    public String roles() {
        return "staff";
    }

    @GetMapping("/staff/list")
    public ResponseEntity<List<Staff>> getStaffList() {
        return new ResponseEntity<List<Staff>>(crudService.getStaffList(), HttpStatus.OK);
    }

    @PostMapping("/staff/save")
    public ResponseEntity<Void> saveOrUpdaStaff (@RequestBody Staff staff) {
      //  Staff parcel = crudService.getParcelById(staff.getLparcel());
     //   staff.setParcel(parcel);
        crudService.saveOrUpdateStaff(staff);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/staff/delete/{id}")
    public ResponseEntity<Void> deleteStaff (@PathVariable Long id) {
     //   try {
     //       crudService.deleteAnnualPayment(id);
     //       return new ResponseEntity<Void>(HttpStatus.OK);
     //   } catch (Exception e){
     //       return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
     //   }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
