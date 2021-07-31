/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2_lab1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author nader
 */
public class Main {
    public static void main(String [ ] args) throws IOException {
        try {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String name;
        BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
        do {
        System.out.println("Enter your name");
        name = br.readLine();
        if ("stop".equals(name.toLowerCase())){
            break;
        }
        System.out.println("Welcome " + name);
        output.write(name);
        output.newLine();
        } while (true);
        output.close();
        r.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
