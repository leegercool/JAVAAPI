package com.example.javaapi.payload;

import java.util.List;

public class MasterMenu {

    private Integer subActive;
    private String icon;
    private  String name;
    private List<SunMenu> sunMenus;
    private  String pathName;

    public MasterMenu() {
    }

    public Integer getSubActive() {
        return subActive;
    }

    public void setSubActive(Integer subActive) {
        this.subActive = subActive;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SunMenu> getSunMenus() {
        return sunMenus;
    }

    public void setSunMenus(List<SunMenu> sunMenus) {
        this.sunMenus = sunMenus;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public MasterMenu(Integer subActive, String icon, String name, List<SunMenu> sunMenus, String pathName) {
        this.subActive = subActive;
        this.icon = icon;
        this.name = name;
        this.sunMenus = sunMenus;
        this.pathName = pathName;
    }
}
