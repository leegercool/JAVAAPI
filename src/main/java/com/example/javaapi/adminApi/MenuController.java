package com.example.javaapi.adminApi;

import com.example.javaapi.common.CommonResult;
import com.example.javaapi.common.GetListParameter;
import com.example.javaapi.dao.AdminRepository;
import com.example.javaapi.model.Admin;
import com.example.javaapi.security.AdminPrincipal;
import com.example.javaapi.security.CurrentUser;
import com.example.javaapi.service.AdminRoleService;
import com.example.javaapi.service.MenuService;
import com.example.javaapi.util.AppConstants;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MenuController {



    @Autowired
    MenuService menuService;



    @GetMapping(path = "/GetMenu" )
//    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    public ResponseEntity<?> getMenu(@CurrentUser   AdminPrincipal currentUser){


        try {

            return menuService.getMenu(currentUser);

        } catch (Exception e) {
//            e.printStackTrace();
            return CommonResult.failed(e.getMessage());

        }


    }

}
