/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day4_lab1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import joinery.DataFrame;
import joinery.DataFrame.JoinType;
import tech.tablesaw.api.BooleanColumn;
import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.joining.DataFrameJoiner;

/**
 *
 * @author nader
 */

public class Main {
    
    // load csv by joinery
    public static DataFrame loadDataFromCSVByJoinery(String path) throws IOException{
        DataFrame<Object> df = DataFrame.readCsv(path);
        return df;
    }
    
    // load csv by tablesaw
    public static Table loadDataFromCSVByTablesaw(String path) throws IOException{
        Table dt = Table.read().csv(path);
        return dt;
    }
    
    
    public static void main(String [] args) {
        
        /********************************************* using joinery ********************************************/
        System.out.println("******************************************************* < Using Joinery > *******************************************************");
        System.out.println();
        try {
            // printing data
            System.out.println(">> --------------------------------------------------------Printing All Data-------------------------------------------------------- <<");
            System.out.println();
            DataFrame df = loadDataFromCSVByJoinery("D:\\AI_PRO\\Content\\8-JavaUML\\titanic.csv");
            System.out.println(df);
            System.out.println();
            
            // describing data (applied for numeric values)
            System.out.println(">> --------------------------------------------------------Describing Numeric Data----------------------------------------------- <<");
            System.out.println();
            DataFrame describe = df.describe();
            System.out.println(describe.toString());
            System.out.println();
            
            // choosing specific columns
            System.out.println(">> --------------------------------------------------------Describing Specific Data------------------------------------------------ <<");
            System.out.println();
            DataFrame<Object> describeSpecific = df.retain("pclass","survived","age").describe();
            System.out.println(describeSpecific);
            System.out.println();
            
            
            
            // creating data frame1
            DataFrame<Object> df1 = new DataFrame<>();

            String [] labels1 = {"name","age","salary"};
            
            df1.add(labels1);
            
            df1.append(29604, Arrays.asList("ahmed", 26, 5000));
            df1.append(29857, Arrays.asList("mona", 28, 10000));
            df1.append(24468, Arrays.asList("marawan", 28, 10000));
            
            System.out.println("=========================================================  Data Frame1  =========================================================");
            System.out.println();
            System.out.println(df1);
            System.out.println();
            
            // creating data frame2
            DataFrame<Object> df2 = new DataFrame<>();

            String [] labels2 = {"manager","department"};
            
            df2.add(labels2);
            
            df2.append(29604, Arrays.asList("rovan", "dp5"));
            df2.append(29857, Arrays.asList("mostafa", "dp8"));
            
            System.out.println("=========================================================  Data Frame2  =========================================================");
            System.out.println();
            System.out.println(df2);
            System.out.println();
            
            // joining data frames
            DataFrame<Object> joined = df1.join(df2,JoinType.LEFT);
            
            System.out.println("=========================================================  Joined Data Frame  =========================================================");
            System.out.println();
            System.out.println(joined);
            System.out.println();
            
            
            // creating data frame3
            DataFrame<Object> df3 = new DataFrame<>();

            String [] labels3 = {"name","gender"};
            
            df3.add(labels3);
            
            df3.append(26694, Arrays.asList("ahmed", "male"));
            df3.append(14857, Arrays.asList("mona", "female"));
            df3.append(77468, Arrays.asList("marawan", "male"));
            
            // merging data frames
            DataFrame<Object> merged = df1.merge(df3);
            
            System.out.println("=========================================================  Merged Data Frame  =========================================================");
            System.out.println();
            System.out.println(merged);
            System.out.println();
            
            
            
        } catch (IOException e) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        
        
        
        System.out.println();
        System.out.println();
        
        
        /********************************************* using Tablesaw ********************************************/
        System.out.println();
        System.out.println("******************************************************* < Using Tablesaw > *******************************************************");
        System.out.println();
        System.out.println();
        
        try {
            // printing data
            System.out.println();
            System.out.println();
            System.out.println(">> --------------------------------------------------------Printing All Data-------------------------------------------------------- <<");
            System.out.println();
            Table dt = loadDataFromCSVByTablesaw("D:\\AI_PRO\\Content\\8-JavaUML\\titanic.csv");
            System.out.println(dt);
            System.out.println();
            
            
            // printing specific columns
            System.out.println(">> --------------------------------------------------------Printing Specific Columns----------------------------------------------- <<");
            System.out.println();
            Table retainColumns = dt.retainColumns("pclass", "name", "age");
            System.out.println(retainColumns);
            System.out.println();
            
            // data structure
            System.out.println(">> --------------------------------------------------------Structure of Data----------------------------------------------- <<");
            System.out.println();
            Table dtStructure = dt.structure();
            System.out.println(dtStructure);
            System.out.println();
            
            
            // data summary
            System.out.println(">> --------------------------------------------------------Summary of Data----------------------------------------------- <<");
            System.out.println();
            Table dtSummary = dt.summary();
            System.out.println(dtSummary);
            System.out.println();
            
            // creating table1
            Table table1 = Table.create();
            
            String [] tableNames = {"Mamdoh", "Amany", "Kareem"};
            StringColumn namesCol = StringColumn.create("name",tableNames);
            
            double [] tableAmounts = {5000, 7500, 8000};
            DoubleColumn amountsCol = DoubleColumn.create("amount",tableAmounts);
            
            table1.addColumns(namesCol);
            table1.addColumns(amountsCol);
            
            System.out.println("=========================================================  Table1  =========================================================");
            System.out.println();
            System.out.println(table1);
            System.out.println();
            
            
            // creating table2
            Table table2 = Table.create();
            
            table2.addColumns(namesCol);
            
            int rowCount=table1.rowCount();
            List<LocalDate> dateList = new ArrayList<LocalDate>();
            for(int i=0;i<rowCount;i++) {
                dateList.add(LocalDate.of(2021, 5, i%31 == 0 ? 1 : i%31));
            }
            DateColumn dateColumn = DateColumn.create("date",dateList);
            table2.insertColumn(table2.columnCount(),dateColumn);
            
            boolean [] tableBuyFirstTime = {true, false, true};
            BooleanColumn firstTimeBuyCol = BooleanColumn.create("first time here",tableBuyFirstTime);
            table2.addColumns(firstTimeBuyCol);
            
            System.out.println("=========================================================  Table2  =========================================================");
            System.out.println();
            System.out.println(table2);
            System.out.println();
            
            // joining tables
            DataFrameJoiner joinOn = table1.joinOn("name");
            
            System.out.println("=========================================================  Joined Table  =========================================================");
            System.out.println();
            System.out.println(joinOn.inner(table2));
            System.out.println();
            
            // removing column to be able to merge or concatenate
            table2.removeColumns("name");
            
            // concatenating tables
            table1.concat(table2);
            
            System.out.println("=========================================================  Concatenated Table  =========================================================");
            System.out.println();
            System.out.println(table1);
            System.out.println();
            
        }
        
        catch (IOException e) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }
}
