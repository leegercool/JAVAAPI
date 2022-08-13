package com.example.javaapi.payload;

import java.util.List;

public class JwtAuthenticationResponse {
    private String token;
    private String tokenType = "Bearer";
    private String adminname;
    private String[] sort;
    private String[]  sort1;
    private String[]  sort2;
    private Integer role;

    private List<Boolean> rules;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String[] getSort() {
        return sort;
    }

    public void setSort(String[] sort) {
        this.sort = sort;
    }

    public String[] getSort1() {
        return sort1;
    }

    public void setSort1(String[] sort1) {
        this.sort1 = sort1;
    }

    public String[] getSort2() {
        return sort2;
    }

    public void setSort2(String[] sort2) {
        this.sort2 = sort2;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public List<Boolean> getRules() {
        return rules;
    }

    public void setRules(List<Boolean> rules) {
        this.rules = rules;
    }

    public JwtAuthenticationResponse(String accessToken) {
        this.token = accessToken;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
