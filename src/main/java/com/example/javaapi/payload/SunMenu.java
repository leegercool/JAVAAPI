package com.example.javaapi.payload;

public class SunMenu {
    private String icon;
    private String name;
    private  String pathName;

    public SunMenu(String icon, String name, String pathName) {
        this.icon = icon;
        this.name = name;
        this.pathName = pathName;
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

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }
}
