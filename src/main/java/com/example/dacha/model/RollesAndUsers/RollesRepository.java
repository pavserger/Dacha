package com.example.dacha.model.RollesAndUsers;

import com.example.dacha.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RollesRepository  extends JpaRepository<Rolles, Long> {

}