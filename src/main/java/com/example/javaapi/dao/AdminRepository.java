package com.example.javaapi.dao;

import com.example.javaapi.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

//    Optional<Admin> findByName(String name);

    List<Admin> findByIdIn(List<Long> userIds);


    Optional<Admin> findByAdminName(String adminName);

    Boolean existsByAdminName(String adminName);


}
