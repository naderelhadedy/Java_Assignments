package day4_lab2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.SeriesMarkers;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main( String[] args )
    {
        App loadJson = new App();
        
        // load json data from file
        List<TitanicPassenger> allPassengers = loadJson.readFromJSONFile("D:\\AI_PRO\\Content\\8-JavaUML\\titanic_csv.json");
        System.out.println(allPassengers);
        
        // generate graph for survive percentage
        loadJson.graphPassengerSurvival(allPassengers);
        
        // generate graph for ages and fares
        loadJson.graphPassengerAgesVsFares(allPassengers);
    }
    
    // read json file
    public List<TitanicPassenger> readFromJSONFile(String path) {
        
        List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        try(InputStream input = new FileInputStream (path)) {
            allPassengers = objectMapper.readValue(input, new TypeReference<List<TitanicPassenger>> () { });
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
        return allPassengers;
    }
    
    
    // graph percentage of survivals
    public void graphPassengerSurvival(List<TitanicPassenger> passengerList) {
        // get survived vs count
        Map<String, Long> result;
        result = passengerList.stream ().collect (
                Collectors.groupingBy (
                        TitanicPassenger::getSurvived, Collectors.counting()
                )
        );
        // create pie chart
        PieChart chart = new PieChartBuilder().width(800).height(600).title("Survived vs Died").build();
        // create suitable colors
        Color[] sliceColors = new Color[]{new Color (255, 190, 106), new Color (64, 176, 166)};
        chart.getStyler().setSeriesColors(sliceColors);
        // append categories
        chart.addSeries("Died", result.get("0"));
        chart.addSeries("Survived", result.get("1"));
        // display chart
        new SwingWrapper(chart).displayChart();
    }
    
    // graph different ages versus fares
    public void graphPassengerAgesVsFares(List<TitanicPassenger> passengerList) {
        //filter to get an array of passengers ages
        List<Float> pAges = passengerList.stream().map(TitanicPassenger::getAge).limit(6).collect(Collectors.toList());
        //filter to get an array of passengers fares
        List<Float> pFares = passengerList.stream().map(TitanicPassenger::getFare).limit(6).collect(Collectors.toList());
        
        Float ages[] = new Float[pAges.size()];
        Float fares[] = new Float[pFares.size()];

        ages = pAges.toArray(ages);
        fares = pFares.toArray(fares);
        
        // create bubble chart
        BubbleChart chart = new BubbleChartBuilder().width(800).height(600).title("Ages & Fares").xAxisTitle("Order").yAxisTitle("Age").build();
        
        
        // handle bubble data
        double[] xData = new double[] {1,2,3,4,5,6};
        double[] yData = convertFloatsToDoubles(ages);
        double[] bubbleData = convertFloatsToDoubles(fares);
        
        // append axes
        chart.addSeries("Six Samples", xData, yData, bubbleData);
        
        // display chart
        new SwingWrapper<BubbleChart>(chart).displayChart();
        
    }
    
    // convert array of floats to array of doubles
    public static double[] convertFloatsToDoubles(Float[] input) {
        if (input == null)
        {
            return null; // Or throw an exception - your choice
        }
        double[] output = new double[input.length];
        for (int i = 0; i < input.length; i++)
        {
            output[i] = input[i];
        }
        return output;
    }
    
}
