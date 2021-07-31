/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3_lab1;

/**
 *
 * @author nader
 */
public class City {
    private int id, cid, surfaceArea, population;
    private String name, capital;
    
    public City(int id, int cid, String name, String capital, int surfaceArea, int population) {
        this.id = id;
        this.cid = cid;
        this.name = name;
        this.capital = capital;
        this.surfaceArea = surfaceArea;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(int surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    
    @Override
    public String toString(){
        return "{" + id + ", " + cid + ", " + name + "}";
    }
}
