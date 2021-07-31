/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3_lab1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nader
 */
public class Country {
    private int cid;
    private String name, continent;
    //private List<City> city;
    
    public Country(int cid, String name, String continent) {
        this.cid = cid;
        this.name = name;
        this.continent = continent;
        //this.city = new ArrayList<City>();
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    /*public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }*/
    
    @Override
    public String toString(){
        return "{" + cid + ", " + name + ", " + continent + "}";
    }
}
