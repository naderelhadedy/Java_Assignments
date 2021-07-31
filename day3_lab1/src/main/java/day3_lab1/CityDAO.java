/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3_lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nader
 */
public class CityDAO {
    List<City> cities;
    public CityDAO() {}
    public List<City> readCities(String fileName) throws IOException {
        
        cities = new ArrayList<City>();
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        
        String line = b.readLine();

        do {
            line = b.readLine();
            if (line != null) {
                String [] attributes = line.split(",");
                City c = new City(0,0,null,null,0,0);
                c.setId(Integer.parseInt(attributes[0]));
                c.setCid(Integer.parseInt(attributes[1]));
                c.setName(attributes[2]);
                c.setCapital(attributes[3]);
                c.setSurfaceArea(Integer.parseInt(attributes[4]));
                c.setPopulation(Integer.parseInt(attributes[5]));

                cities.add(c);
            }

        } while (line != null);
            
            
        
        return cities;
    }
}
