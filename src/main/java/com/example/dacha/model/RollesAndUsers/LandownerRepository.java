package com.example.dacha.model.RollesAndUsers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  LandownerRepository extends JpaRepository <Landowner, Long> {
    public List<Landowner> findLandOwnersByPhoneAndPass(String phone, String pass);
}