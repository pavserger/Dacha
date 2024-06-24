package com.example.dacha;

import com.example.dacha.model.Parcel;
import com.example.dacha.model.ParcelRepository;
import com.example.dacha.model.PaysAndJobs.AnnualPayment;
import com.example.dacha.model.PaysAndJobs.AnnualPaymentRepository;
import com.example.dacha.model.RollesAndUsers.Landowner;
import com.example.dacha.model.RollesAndUsers.LandownerRepository;
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
    private LandownerRepository landownerRepository;
    private AnnualPaymentRepository annualPaymentRepository;


    public CrudService(ParcelRepository crudRepository,
                       RollesRepository rollesRepository,
                       LandownerRepository landownerRepository,
                       AnnualPaymentRepository annualPaymentRepository
    ) {
        this.crudRepository = crudRepository;
        this.rollesRepository = rollesRepository;
        this.landownerRepository = landownerRepository;
        this.annualPaymentRepository = annualPaymentRepository;

    }

    public List<Parcel> getCompanyList() {
        return crudRepository.findAll();
    }


    public List<Rolles> getRollesList() {
        return rollesRepository.findAll();
    }


    public Parcel getParcelById(Long id) {
        return crudRepository.findById(id).get();
    }

    public void findOwnerAndParcel(Login login) {
         List<Landowner> listOwners =
        landownerRepository.findLandOwnersByPhoneAndPass(login.getPhone(), login.getPass());
        listOwners.size();
    }

    public void saveOrUpdateCompany(Parcel parcel) {
        crudRepository.save(parcel);
    }
    public void saveOrUpdateRoles(Rolles rolles) { rollesRepository.save(rolles);
    }
    public void deleteParcel(Long id) {
        crudRepository.deleteById(id);
    }


   // public void deleteCompany(Long id) {
   //     crudRepository.deleteById(id);
  //  }

    public void saveOrUpdateOwners(Landowner landowner) {
        landownerRepository.save(landowner);

    }
    public List<Landowner> getOwnersList() {
        var list = landownerRepository.findAll();
        return landownerRepository.findAll();
    }

    public void deleteOwner(Long id) {
        landownerRepository.deleteById(id);
    }

    // Annual Paayment

    public List<AnnualPayment> getAnnualPaymentList() {
        return annualPaymentRepository.findAll();
    }

    public void saveOrUpdateAnnualPayment(AnnualPayment annualPayment) {
        annualPaymentRepository.save(annualPayment);
    }

    public void deleteAnnualPayment(Long id) {
        annualPaymentRepository.deleteById(id);
    }



}
