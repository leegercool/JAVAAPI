package com.example.javaapi.dao;

import com.example.javaapi.model.AdminRole;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface AdminRoleRepository extends CrudRepository<AdminRole,Integer> {
}
