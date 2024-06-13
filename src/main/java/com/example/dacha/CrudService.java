package com.example.dacha;

import com.example.dacha.model.Parcel;
import com.example.dacha.model.ParcelRepository;
import com.example.dacha.model.RollesAndUsers.Rolles;
import com.example.dacha.model.RollesAndUsers.RollesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {

    @Autowired
    private ParcelRepository crudRepository;
    private RollesRepository rollesRepository;

    public CrudService(ParcelRepository crudRepository, RollesRepository rollesRepository) {
        this.crudRepository = crudRepository;
        this.rollesRepository = rollesRepository;
    }

    public List<Parcel> getCompanyList() {
        return crudRepository.findAll();
    }


    public List<Rolles> getRollesList() {
        return rollesRepository.findAll();
    }


    public Parcel getCompanyById(Long id) {
        return crudRepository.findById(id).get();
    }

    public void saveOrUpdateCompany(Parcel parcel) {
        crudRepository.save(parcel);
    }
    public void saveOrUpdateRoles(Rolles rolles) { rollesRepository.save(rolles);
    }
    public void deleteParcel(Long id) {
        crudRepository.deleteById(id);
    }


    public void deleteCompany(Long id) {
        crudRepository.deleteById(id);
    }

}
