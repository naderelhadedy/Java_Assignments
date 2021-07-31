/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2_lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nader
 */
public class PyramidCSVDAO {
    
    List<Pyramid> pyramids;
    public PyramidCSVDAO() {}
    public List<Pyramid> readPyramidsFromCSV(String fileName) throws IOException {
        
        pyramids = new ArrayList<Pyramid>();
        FileReader f = new FileReader(fileName);
        
        BufferedReader b = new BufferedReader(f);
        
        String line = b.readLine();

        do {
            line = b.readLine();
            if (line != null) {
                String [] attributes = line.split(",");
                Pyramid p = new Pyramid(null,null,null,0);
                p.setPharaoh(attributes[0]);
                p.setModern_name(attributes[2]);
                p.setSite(attributes[4]);
                if (!attributes[7].isEmpty()){
                p.setHeight(Double.parseDouble(attributes[7]));
                }

                pyramids.add(p);
            }

        } while (line != null);
            
            
        
        return pyramids;
    }

}
