package com.example.dacha;

import com.example.dacha.model.Parcel;
import com.example.dacha.model.ParcelRepository;
import com.example.dacha.model.PaysAndJobs.AnnualPayment;
import com.example.dacha.model.PaysAndJobs.AnnualPaymentRepository;
import com.example.dacha.model.RollesAndUsers.Landowner;
import com.example.dacha.model.RollesAndUsers.LandownerRepository;
import com.example.dacha.model.RollesAndUsers.Staff;
import com.example.dacha.model.RollesAndUsers.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {

//    @Autowired
    private ParcelRepository crudRepository;
    private StaffRepository rollesRepository;
    private LandownerRepository landownerRepository;
    private AnnualPaymentRepository annualPaymentRepository;
    private StaffRepository staffRepository;


    private Landowner currentLandowner;
    private Staff currentStaff;

    public CrudService(ParcelRepository crudRepository,
                       StaffRepository rollesRepository,
                       LandownerRepository landownerRepository,
                       StaffRepository staffRepository,
                       AnnualPaymentRepository annualPaymentRepository
    ) {
        this.crudRepository = crudRepository;
        this.rollesRepository = rollesRepository;
        this.landownerRepository = landownerRepository;
        this.staffRepository = staffRepository;
        this.annualPaymentRepository = annualPaymentRepository;

    }

    public List<Parcel> getCompanyList() {
        return crudRepository.findAll();
    }


    public List<Staff> getRollesList() {
        return rollesRepository.findAll();
    }


    public Parcel getParcelById(Long id) {
        return crudRepository.findById(id).get();
    }

    public String findOwnerAndParcel(Login login) {

         List<Landowner> listOwners =
        landownerRepository.findLandOwnersByPhoneAndPass(login.getPhone(), login.getPass());
         List <Staff> staffList = staffRepository.findStaffByPhoneAndPass(login.getPhone(), login.getPass());
            if (listOwners.size() == 1)  {
                currentLandowner = listOwners.get(0);
             //   return "OK";
            };
            if (staffList.size()==1) {currentStaff = staffList.get(0);};

            if ((currentLandowner != null) || (staffList!=null)) {return "OK";}
            return "NOT_FOUND";
    }
  //      if (listOwners.size() == 1) {
  //          currentLandowner = listOwners.get(0);
  //      };


    public void saveOrUpdateCompany(Parcel parcel) {
        crudRepository.save(parcel);
    }
    public void saveOrUpdateRoles(Staff rolles) { rollesRepository.save(rolles);
    }
    public void deleteParcel(Long id) {
        crudRepository.deleteById(id);
    }


    public void saveOrUpdateOwners(Landowner landowner) {
        landownerRepository.save(landowner);

    }
    public List<Landowner> getOwnersList() {
        var list = landownerRepository.findAll();
        if (currentStaff == null) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setPass("???");
            };
        };
        return list;
    }

    public void deleteOwner(Long id) {
        landownerRepository.deleteById(id);
    }
//     -------------  AnnualPayment --------------------------

    public List<AnnualPayment> getAnnualPaymentList() {
        return annualPaymentRepository.findAll();
    }

    public void saveOrUpdateAnnualPayment(AnnualPayment annualPayment) {
        annualPaymentRepository.save(annualPayment);
    }

    public void deleteAnnualPayment(Long id) {
        annualPaymentRepository.deleteById(id);
    }
    //     -------------  ParcelPayment --------------------------
    public List<AnnualPayment> getParcelPaymentList() {
        return annualPaymentRepository.findAnnualPaymentByParcel (currentLandowner.getParcel());
    }

    //     -------------  Staff --------------------------
    public List<Staff> getStaffList() {
        return staffRepository.findAll();
    }

    public void saveOrUpdateStaff(Staff staff) {
        staffRepository.save(staff);
    }

}
