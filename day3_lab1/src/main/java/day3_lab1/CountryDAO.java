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
public class CountryDAO {
    List<Country> countries;
    public CountryDAO() {}
    public List<Country> readCountries(String fileName) throws IOException {
        
        countries = new ArrayList<Country>();
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        
        String line = b.readLine();

        do {
            line = b.readLine();
            if (line != null) {
                String [] attributes = line.split(",");
                Country c = new Country(0,null,null);
                c.setCid(Integer.parseInt(attributes[0]));
                c.setName(attributes[1]);
                c.setContinent(attributes[2]);

                countries.add(c);
            }

        } while (line != null);
            
            
        
        return countries;
    }
}
