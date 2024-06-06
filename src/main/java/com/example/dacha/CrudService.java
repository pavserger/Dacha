package com.example.dacha;

import com.example.dacha.model.Parcel;
import com.example.dacha.model.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {

    @Autowired
    private ParcelRepository crudRepository;

    public List<Parcel> getCompanyList() {
        return crudRepository.findAll();
    }

    public Parcel getCompanyById(Long id) {
        return crudRepository.findById(id).get();
    }

    public void saveOrUpdateCompany(Parcel company) {
        crudRepository.save(company);
    }

    public void deleteCompany(Long id) {
        crudRepository.deleteById(id);
    }

}
