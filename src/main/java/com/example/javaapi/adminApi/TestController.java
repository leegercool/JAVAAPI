package com.example.javaapi.adminApi;


import com.example.javaapi.common.CommonResult;
import com.example.javaapi.common.GetListParameter;
import com.example.javaapi.dao.AdminRepository;
import com.example.javaapi.model.AdminRole;
import com.example.javaapi.security.AdminPrincipal;
import com.example.javaapi.security.CurrentUser;
import com.example.javaapi.service.AdminRoleService;
import com.example.javaapi.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    private AdminRoleService adminRoleService;

    @GetMapping(path = "/GetList" )
//    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    public ResponseEntity<?> getAllAdminRole(@Valid @RequestBody GetListParameter getListParameter, @CurrentUser AdminPrincipal currentUser, @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                     @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){


        try {
            var getId=currentUser.getId();
            var pageNum=page;

            return adminRoleService.getAdminRole(getListParameter);
        } catch (Exception e) {
//            e.printStackTrace();
            return CommonResult.failed(e.getMessage());

        }


    }


}
