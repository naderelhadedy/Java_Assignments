/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1_labs;

/**
 *
 * @author nader
 */
public class Calculator {
    public static void Calc(double a, double b, String k) {
        switch (k){
            case "+":
                System.out.println("Result of summation: "+(a+b));
                break;
            case "-":
                System.out.println("Result of subtraction: "+(a-b));
                break;
            case "*":
                System.out.println("Result of multiplication: "+(a*b));
                break;
            case "/":
                System.out.println("Result of division: "+(a/b));
                break;
            default:
                System.out.println("Can't do operation");
        }
    }
}
