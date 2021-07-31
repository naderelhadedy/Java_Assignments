/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3_lab1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;


/**
 *
 * @author nader
 */
public class Main {
    
    // lab3.1
    public static void highestPopCity (int cid, List<City> cities) {
        Stream<City> cityPerCo = cities.stream().filter(c -> c.getCid() == cid);
        List<Integer> cityPops = cityPerCo.map(City::getPopulation).collect(toList());
        String highestPopCity = cities.stream().filter(c -> c.getCid() == cid).filter(c -> c.getPopulation() == Collections.max(cityPops)).map(City::getName).collect(toList()).toString();
        System.out.println(highestPopCity);
    }
    
    // lab3.2
    public static void highestPopCityCon (String con, List<Country> countries,List<City> cities) {
        Stream<Country> countryPerCon = countries.stream().filter(c -> c.getContinent().equals(con));
        List<Integer> cityCids = countryPerCon.map(Country::getCid).collect(toList());
        Stream<City> cityPerCon = cities.stream().filter(c -> cityCids.contains(c.getCid()));
        List<Integer> cityPops = cityPerCon.map(City::getPopulation).collect(toList());
        String highestPopCon = cities.stream().filter(c -> cityCids.contains(c.getCid())).filter(c -> c.getPopulation() == Collections.max(cityPops)).map(City::getName).collect(toList()).toString();
        System.out.println(highestPopCon);
    }
    
    // lab3.3
    public static void highestPopCityCapital (int cid, List<City> cities) {
        Stream<City> cityPerCo = cities.stream().filter(c -> c.getCid() == cid);
        List<Integer> cityPops = cityPerCo.map(City::getPopulation).collect(toList());
        String highestPopCity = cities.stream().filter(c -> c.getCid() == cid).filter(c -> c.getPopulation() == Collections.max(cityPops) && c.getCapital().equals("yes")).map(City::getName).collect(toList()).toString();
        System.out.println(highestPopCity);
    }
    
    public static void main(String [] args) {
        // read countries
        CountryDAO coDAO = new CountryDAO();
        List<Country> countries = null;
        try {
            countries = coDAO.readCountries("D:\\AI_PRO\\Content\\8-JavaUML\\country.csv");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        System.out.println(countries.toString());
        
        
        // read cities
        CityDAO ciDAO = new CityDAO();
        List<City> cities = null;
        try {
            cities = ciDAO.readCities("D:\\AI_PRO\\Content\\8-JavaUML\\city.csv");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        System.out.println(cities.toString());
        
        
        // create map
        Map<Integer, List<City>> combination = new HashMap<>();
        //combination.put(5,cities.get(0));
        //combination.put(6,cities.get(1));
        for (City c: cities) {
            if (combination.get(c.getCid()) == null) {
                List<City> a = new ArrayList<City>();
                combination.put(c.getCid(), a);
                combination.get(c.getCid()).add(c);
            } else {
                combination.get(c.getCid()).add(c);
            }
        }
        
        
        // print combination of countryID and corresponding cities
        System.out.println(combination);
        
        System.out.println("-------------------------------------------------------------");
        
        // sort cities by population
        int targetCountryID = 1;
        List<City> resultedList = combination.get(targetCountryID);
        
        // list cities before sorting
        System.out.println("List of cities respectively 'before' sorting with country id of " + targetCountryID + " >> " + resultedList);
        
        // sorting code
        Collections.sort(resultedList, new Comparator<City>() {
            @Override
            public int compare(City c1, City c2) {
                if (c1.getPopulation()> c2.getPopulation())
                    return 1;
                if (c1.getPopulation() < c2.getPopulation())
                    return -1;
                return 0;
            }
        });
        
        // list cities after sorting ascending
        System.out.println("List of cities ascendingly 'after' sorting with country id of " + targetCountryID + " >> " + resultedList);
        // list cities after sorting descending
        Collections.reverse(resultedList);
        System.out.println("List of cities descendingly 'after' sorting with country id of " + targetCountryID + " >> " + resultedList);
        
        System.out.println("-------------------------------------------------------------");
        
        // lab3.1
        int [] Cids = {1,2,3,4,5};
        for (int cid: Cids) {
            System.out.print("Highest Population City(s) in country " + cid + ": ");
            highestPopCity(cid,cities);
        }
        
        System.out.println("-------------------------------------------------------------");
        
        // lab3.2
        String [] Continents = {"Africa", "Asia"};
        for (String con: Continents) {
            System.out.print("Highest Population City in " + con + ": ");
            highestPopCityCon(con, countries, cities);
        }
        
        System.out.println("-------------------------------------------------------------");
        
        // lab3.3
        /*Cids = {1,2,3,4,5};*/
        for (int cid: Cids) {
            System.out.print("Highest Population Capital in country " + cid + ": ");
            highestPopCityCapital(cid,cities);
        }
        
        
    }
       
}
