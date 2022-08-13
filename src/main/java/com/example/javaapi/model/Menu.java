package com.example.javaapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Menu {
    @Id
    private Integer id;
    private Integer pId;

    @Size(max = 40)
    private String name;
    private String value;
    private String valueType;
    private Boolean isUse;
    private String value1;
    private String pathName;

    public Menu(Integer id, Integer pId, String name, String value, String valueType, Boolean isUse, String value1, String pathName, String icon) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.value = value;
        this.valueType = valueType;
        this.isUse = isUse;
        this.value1 = value1;
        this.pathName = pathName;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    private String icon;

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }



    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }



    public Menu() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public Boolean getUse() {
        return isUse;
    }

    public void setUse(Boolean use) {
        isUse = use;
    }
}
