package com.example.javaapi.security;


import com.example.javaapi.model.Admin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AdminPrincipal implements UserDetails {
    private Integer id;
//    private String name;
    private  String username;
    @JsonIgnore
    private  String password;
    private Collection<? extends GrantedAuthority> authorities;

    private String[] sort;
    private String[]sort1;
    private String[] sort2;
    private Integer role;




    public AdminPrincipal(Integer id, String adminName, String passWord, Collection<? extends GrantedAuthority> authorities,String[] sort, String[]sort1, String[] sort2, Integer role) {
        this.id = id;
//        this.name = name;
        this.username = adminName;
        this.password = passWord;
        this.authorities = authorities;
        this.sort = sort;
        this.sort1 = sort1;
        this.sort2 = sort2;
        this.role = role;
    }

    public String[] getSort() {
        return sort;
    }

    public String[] getSort1() {
        return sort1;
    }

    public String[] getSort2() {
        return sort2;
    }

    public Integer getRole() {
        return role;
    }

    public static AdminPrincipal create(Admin admin){
        List<GrantedAuthority> authorities=admin.getRoles().stream()
                .map(role->new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
        String[]ids = (admin.getSort()==null?"":admin.getSort()) .split(",");
        String[]ids1 = (admin.getSort1()==null?"":admin.getSort1()).split(",");
        String[]ids2 = (admin.getSort2()==null?"":admin.getSort2()).split(",");


        return  new AdminPrincipal(
                admin.getId(),
                admin.getAdminName(),
                admin.getAdminPassWord(),
                authorities,
                ids,
                ids1,
                ids2,
                admin.getAdminType()
        );

    }

    public Integer getId() {
        return id;
    }





    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminPrincipal that = (AdminPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
