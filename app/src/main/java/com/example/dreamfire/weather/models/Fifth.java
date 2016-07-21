package com.example.dreamfire.weather.models;

import java.util.List;

/**
 * Created by dreamfire on 10.06.16.
 */
public class Fifth {
    private City city;
    private String cod;
    private float message;
    private int count;
    private List<Current> list;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Current> getList() {
        return list;
    }

    public void setList(List<Current> list) {
        this.list = list;
    }
}
