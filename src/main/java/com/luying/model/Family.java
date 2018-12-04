package com.luying.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2018-11-11
 **/
public class Family {
    private int id;
    private String name;
    private int order;
    private List<Person> ps=new ArrayList<>();

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPs() {
        return ps;
    }

    public void setPs(List<Person> ps) {
        this.ps = ps;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ps=" + ps +
                '}';
    }
}
