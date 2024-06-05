package com.example.dacha.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  LandownerRepository extends JpaRepository <Landowner, Long> {
}
