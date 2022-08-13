package com.example.javaapi.adminApi;

import com.example.javaapi.common.CommonResult;
import com.example.javaapi.common.GetListParameter;
import com.example.javaapi.dao.AdminRepository;
import com.example.javaapi.dao.AdminRoleRepository;
import com.example.javaapi.model.AdminRole;
import com.example.javaapi.payload.JwtAuthenticationResponse;
import com.example.javaapi.payload.LoginRequest;
import com.example.javaapi.security.AdminPrincipal;
import com.example.javaapi.security.CurrentUser;
import com.example.javaapi.security.JwtTokenProvider;
import com.example.javaapi.service.AdminRoleService;
import com.example.javaapi.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AdminRoleRepository adminRoleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;


    @Autowired
    private AdminRoleService adminRoleService;

    @PostMapping("/AdminLogin")
    public ResponseEntity<?>  authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//    public CommonResult<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtTokenProvider.generateToken(authentication);

           AdminPrincipal adminPrincipal = (AdminPrincipal) authentication.getPrincipal();

            //return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
            var  authenticationResponse = new  JwtAuthenticationResponse(jwt);
            authenticationResponse.setSort(adminPrincipal.getSort());
            authenticationResponse.setSort1(adminPrincipal.getSort1());
            authenticationResponse.setSort2(adminPrincipal.getSort2());
            authenticationResponse.setRole(adminPrincipal.getRole());
            authenticationResponse.setAdminname(adminPrincipal.getUsername());

//            return CommonResult.success(authenticationResponse,"success signin");

            return CommonResult.success(authenticationResponse,"success signin");

        } catch (Exception e) {
//            return CommonResult.failed(e.getMessage());

            return new ResponseEntity(CommonResult.failed(e.getMessage()),HttpStatus.NOT_FOUND);

        }
    }



//    @GetMapping(path = "/GetList" )
//    @ResponseBody
//    public
//
//    CommonResult<AdminRole> getAllAdminRole(@Valid @RequestBody GetListParameter getListParameter, @CurrentUser AdminPrincipal currentUser,   @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
//                                            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){
//
//
//        try {
////            var getId=currentUser.getId();
//            var pageNum=page;
//
//            return adminRoleService.getAdminRole(getListParameter);
//        } catch (Exception e) {
////            e.printStackTrace();
//            return CommonResult.failed(e.getMessage());
//
//        }
//
//
//    }



}
