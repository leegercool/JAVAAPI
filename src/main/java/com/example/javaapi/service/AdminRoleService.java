package com.example.javaapi.service;


import com.example.javaapi.common.CommonResult;
import com.example.javaapi.common.GetListParameter;
import com.example.javaapi.common.PagedResponse;
import com.example.javaapi.dao.AdminRoleRepository;
import com.example.javaapi.enums.ResultStatusEnum;
import com.example.javaapi.model.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleService {
    @Autowired
    private AdminRoleRepository adminRoleRepository;



    public ResponseEntity<?> getAdminRole(GetListParameter getListParameter) {

//        Iterable<AdminRole> adminRoles=adminRoleRepository.findAll();

//        List<AdminRole> adminRoles = (List<AdminRole>) adminRoleRepository.findAll();



        return CommonResult.success(adminRoleRepository.findAll());
        //return adminRoleRepository.findAll();




    }
}
