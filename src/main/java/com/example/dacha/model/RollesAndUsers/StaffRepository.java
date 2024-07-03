package com.example.dacha.model.RollesAndUsers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    public List<Staff> findStaffByPhoneAndPass(String phone, String pass);

}