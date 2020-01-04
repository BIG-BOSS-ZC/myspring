package com.myspring.day2.myioc.constractor;

import java.util.List;
import java.util.Map;

public class BeanInfo {
    private String id;
    private String cls;
    private Map<String,String> value;

    public BeanInfo(String id, String cls, Map<String,String> value) {
        this.id = id;
        this.cls = cls;
        this.value = value;
    }

    public BeanInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public Map<String,String> getValue() {
        return value;
    }

    public void setValue(Map<String,String> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanInfo{" +
                "id='" + id + '\'' +
                ", cls='" + cls + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
