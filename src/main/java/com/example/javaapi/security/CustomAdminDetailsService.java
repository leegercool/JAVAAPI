package com.example.javaapi.security;


import com.example.javaapi.dao.AdminRepository;
import com.example.javaapi.model.Admin;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomAdminDetailsService implements UserDetailsService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;




    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDetails userDetails= User.builder().username("admin").password(passwordEncoder.encode("password")).roles("test").build();
//        return userDetails;
        Admin admin=adminRepository.findByAdminName(username).orElseThrow(()->
                new UsernameNotFoundException("找不到用户名："+username));

        return com.example.javaapi.security.AdminPrincipal.create(admin);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Integer id) {
        Admin admin = adminRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return com.example.javaapi.security.AdminPrincipal.create(admin);
    }
}
