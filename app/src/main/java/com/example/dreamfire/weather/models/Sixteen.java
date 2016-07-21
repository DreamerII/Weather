package com.example.dreamfire.weather.models;


import java.io.Serializable;
import java.util.List;

/**
 * Created by dreamfire on 11.06.16.
 */
public class Sixteen implements Serializable{
    int id;
    private String cod;
    private float message;
    private City city;
    private int cnt;
    private List<SixteenItem> list;


    public String getCod() {
        return cod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<SixteenItem> getList() {
        return list;
    }

    public void setList(List<SixteenItem> list) {
        this.list = list;
    }
}
