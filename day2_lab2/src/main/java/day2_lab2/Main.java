/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2_lab2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import static java.util.stream.Collectors.toList;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author nader
 */
public class Main {
    /*
    public static String[] getSliceOfArray(String[] arr, int start, int end)
    {
  
        // Get the slice of the Array
        String[] slice = new String[end - start];
  
        // Copy elements of arr to slice
        for (int i = 0; i < slice.length; i++) {
            slice[i] = arr[start + i];
        }
  
        // return the slice
        return slice;
    }
    */
    /*
    public static void highestPopCity (int cid, List<Pyramid> cities) {
        Stream<Pyramid> cityPerCo = pyramids.stream().filter(p -> p. == cid);
        List<Integer> cityPops = cityPerCo.map(City::getPopulation).collect(toList());
        String highestPopCity = cities.stream().filter(c -> c.getCid() == cid).filter(c -> c.getPopulation() == Collections.max(cityPops)).map(City::getName).collect(toList()).toString();
        System.out.println(highestPopCity);
    }
    */
    
    // day3_lab4
    public static void heightsPyramidsAverage(List<Pyramid> pyramids) {
            DoubleStream validPyramids = pyramids.stream().filter(p -> p.getHeight() != 0.0).mapToDouble(Pyramid::getHeight);
            double heightsAverage = validPyramids.average().orElse(-1);
            System.out.println("Average for Heights of Pyramids: " + heightsAverage);
    }
    
    // day3_lab4
    public static void heightsPyramidsMedian(List<Pyramid> pyramids) {
        DoubleStream validPyramids2 = pyramids.stream().filter(p -> p.getHeight() != 0.0).mapToDouble(Pyramid::getHeight);
        int count = (int)validPyramids2.count();
        int index = 0;
        double heightsMedian = 0;
        DoubleStream validPyramids3 = pyramids.stream().filter(p -> p.getHeight() != 0.0).mapToDouble(Pyramid::getHeight);
        double[] sortedPyramids = validPyramids3.sorted().toArray();
        if (count % 2 == 0) {
            index = (count/2)-1;
            double [] medianEven = {sortedPyramids[index],sortedPyramids[index+1]};
            heightsMedian = DoubleStream.of(medianEven).average().orElse(-1);
        } else {
            index = ((count+1)/2)-1;
            heightsMedian = sortedPyramids[index];
        }
        System.out.println("Median for Heights of Pyramids: " + heightsMedian);
    }
    
    // day3_lab4
    public static void CalculateQuartile(List<Pyramid> pyramids, String type) {
        DoubleStream validPyramids2 = pyramids.stream().filter(p -> p.getHeight() != 0.0).mapToDouble(Pyramid::getHeight);
        int count = (int)validPyramids2.count();
        int index = 0;
        int middle = 0;
        DoubleStream validPyramids3 = pyramids.stream().filter(p -> p.getHeight() != 0.0).mapToDouble(Pyramid::getHeight);
        double[] sortedPyramids = validPyramids3.sorted().toArray();
        if (count % 2 == 0) {
            index = count/2;
            middle = index+2;
        } else {
            index = (count+1)/2;
            middle = index+1;
        }
        double[] newArray = null;
        if (type.equals("lower")) {
            newArray = Arrays.copyOfRange(sortedPyramids, 0, index);
        } else if (type.equals("upper")) {
            newArray = Arrays.copyOfRange(sortedPyramids, middle, sortedPyramids.length);
        }
        double quartile = median(newArray);
        System.out.println(quartile);
    }
    
    /* day3_lab4 */
    // median function
    public static double median(double[] m) {
        int middle = m.length/2;
        if (m.length%2 == 1) {
            return m[middle];
        } else {
            return (m[middle-1] + m[middle]) / 2.0;
        }
    }
    
    
    public static void main(String [] args) {
        /*
        try {
            FileReader f = new FileReader("D:\\AI_PRO\\Content\\8-JavaUML\\pyramids.csv");
            BufferedReader b = new BufferedReader(f);
            String line = b.readLine();
            int count = 0;
            int start = 0;
            int end = 5;
            if (line != null) {
                System.out.println(Arrays.toString(getSliceOfArray(line.split(","), start, end)));
            }
            do {
                line = b.readLine();
                count += 1;
                
                if (line != null) {
                    String [] lineData = line.split(",");
                    for (String data: getSliceOfArray(lineData, start, end)){
                        System.out.print(data + " / ");
                    }
                    System.out.println();
                }
                
                if (count == 3) {
                    break;
                }
            } while (line != null);
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        */
        
        
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = null;
        try {
            pyramids = pDAO.readPyramidsFromCSV("D:\\AI_PRO\\Content\\8-JavaUML\\pyramids.csv");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        int i = 0;
        for (Pyramid p: pyramids) {
            System.out.println("#" + (i++) + p);
        }
        
        System.out.println("-------------------------------------------------------------");
        
        /* day3_lab4 */
        
        // calculate average
        heightsPyramidsAverage(pyramids);
        System.out.println("-------------------------------------------------------------");
        
        // calculate median
        heightsPyramidsMedian(pyramids);
        System.out.println("-------------------------------------------------------------");
        
        // calculate lower quartile
        System.out.print("Lower Quartile for Heights of Pyramids: ");
        CalculateQuartile(pyramids, "lower");
        
        
        // calculate lower quartile
        System.out.print("Upper Quartile for Heights of Pyramids: ");
        CalculateQuartile(pyramids, "upper");
        
    }
}
