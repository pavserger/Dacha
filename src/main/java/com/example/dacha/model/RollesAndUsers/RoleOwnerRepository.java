package com.example.dacha.model.RollesAndUsers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleOwnerRepository extends JpaRepository<RoleOwner, Long> {
}
