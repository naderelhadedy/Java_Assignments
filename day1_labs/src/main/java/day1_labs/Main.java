/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1_labs;
import java.util.Scanner;
import static day1_labs.Complex.addComplex;
import static day1_labs.Complex.subtractComplex;
import static day1_labs.Calculator.Calc;
/**
 *
 * @author nader
 */

public class Main {
    public static void main (String [] args) {
        // pro2.1
        /*
        System.out.println("Hello Java");
        Scanner inpt = new Scanner(System.in);
        String name = inpt.nextLine();
        System.out.println("Hello " + name);
        */
        
        // pro2.2
        /*
        Complex one = new Complex(2,3);
        Complex two = new Complex(-2,4);
        
        addComplex(one,two);
        subtractComplex(one,two);
        */
        
        // pro6.1
        /*
        Calc(5,4,"+");
        Calc(5,4,"-");
        Calc(5,4,"*");
        Calc(5,4,"/");
        */
        
        // pro6.2
        /*
        System.out.println("Enter your IP: ");
        Scanner inpt2 = new Scanner(System.in);
        String IP = inpt2.nextLine();
        String [] cuts = IP.split("\\.");
        
        for (String i: cuts) {
            System.out.println(i);
        }
        */
        
        // pro6.3.1
        /*
        int n = 6;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        */
        
        // pro6.3.2
        /*
        int n = 6;
        for (int i = 1; i <= n; i++) {
            for (int k = n-i; k > 0; k--){
                System.out.print(" ");
        }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        */
    }
}

