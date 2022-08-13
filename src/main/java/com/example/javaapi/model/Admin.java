package com.example.javaapi.model;

import com.example.javaapi.model.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name = "admin", uniqueConstraints = {
//        @UniqueConstraint(columnNames = {
//                "admin_name"
//        })
//})
@Table
public class Admin extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer id;
    @NotBlank
    @Size(max = 40)
    private String adminName;
    @NotBlank
    @Size(max = 100)
    private String adminPassWord;
    private Integer adminType;
    private String roleId;

    @Size(max = 100)
    private String preGuid;
    private String Sort;
    private String Sort1;
    private String Sort2;


//        @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "`admin_phone_numbers`", joinColumns = @JoinColumn(name = "admin_id"))
//    @Column(name = "phone_number")
//    private Set<String> phoneNumbers = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "user_phone_numbers", joinColumns = @JoinColumn(name = "admin_id"))
    @Column(name = "phone_number")
    private Set<String> phoneNumbers = new HashSet<>();


    public String getSort2() {
        return Sort2;
    }

    public void setSort2(String sort2) {
        Sort2 = sort2;
    }

    @NotNull
    private Instant createDateTime;

    public String getSort() {
        return Sort;
    }

    public void setSort(String sort) {
        Sort = sort;
    }

    public String getSort1() {
        return Sort1;
    }

    public void setSort1(String sort1) {
        Sort1 = sort1;
    }

    public Instant getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Instant createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Admin(Integer id,Set<String> phoneNumbers, String adminName, String adminPassWord, Integer adminType, String roleId, String preGuid, String sort, String sort1,String sort2, Instant createDateTime, Set<AdminRole> roles) {
        this.id = id;
        this.adminName = adminName;
        this.adminPassWord = adminPassWord;
        this.adminType = adminType;
        this.roleId = roleId;
        this.preGuid = preGuid;
        Sort = sort;
        Sort1 = sort1;
        Sort2= sort2;
        this.createDateTime = createDateTime;
        this.roles = roles;
        this.phoneNumbers = phoneNumbers;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "admin_roles",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "admin_roles_id"))


    private Set<AdminRole> roles = new HashSet<>();






//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "admin_test",
//            joinColumns = @JoinColumn(name = "admin_id"),
//            inverseJoinColumns = @JoinColumn(name = "admin_roles_id"))


    public Set<AdminRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AdminRole> roles) {
        this.roles = roles;
    }

    public Admin() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassWord() {
        return adminPassWord;
    }

    public void setAdminPassWord(String adminPassWord) {
        this.adminPassWord = adminPassWord;
    }

    public Integer getAdminType() {
        return adminType;
    }

    public void setAdminType(Integer adminType) {
        this.adminType = adminType;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPreGuid() {
        return preGuid;
    }

    public void setPreGuid(String preGuid) {
        this.preGuid = preGuid;
    }


}
