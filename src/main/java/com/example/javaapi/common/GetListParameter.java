package com.example.javaapi.common;

public class GetListParameter {
    private Integer page;
    private Integer pageSize;
    private String keyWord;
    private String order;
    private Integer type;
    private String stime;
    private String etime;

    public GetListParameter(Integer page, Integer pageSize, String keyWord, String order, Integer type, String stime, String etime) {
        this.page = page;
        this.pageSize = pageSize;
        this.keyWord = keyWord;
        this.order = order;
        this.type = type;
        this.stime = stime;
        this.etime = etime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }
}
