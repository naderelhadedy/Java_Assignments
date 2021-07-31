/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1_labs;

import static java.lang.Math.abs;

/**
 *
 * @author nader
 */
public class Complex {
    
    // pro2.2
    double real, img;
    
    Complex(double real, double img) {
        this.real = real;
        this.img = img;
    }
    
    public static void handleOutput(double realRes, double imgRes) {
        if ((realRes > 0 && imgRes > 0) || (realRes < 0 && imgRes > 0)) {
            System.out.println(realRes+"+"+imgRes+"i");
        }
        else if ((realRes > 0 && imgRes < 0) || (realRes < 0 && imgRes < 0)) {
            System.out.println(realRes+"-"+abs(imgRes)+"i");
        }
        else if (realRes > 0 && imgRes < 0) {
            System.out.println(realRes+"-"+abs(imgRes)+"i");
        }
        else if (realRes == 0) {
            System.out.println(imgRes+"i");
        }
        else if (imgRes == 0) {
            System.out.println(realRes);
        }
        else {
            System.out.println(0);
        }
    }
    
    public static void addComplex(Complex a, Complex b) {
        double realRes = a.real + b.real;
        double imgRes = a.img + b.img;
        System.out.println("Result of Sum:");
        handleOutput(realRes, imgRes);
    }
    
    public static void subtractComplex(Complex a, Complex b) {
        double realRes = a.real - b.real;
        double imgRes = a.img - b.img;
        System.out.println("Result of Subtract:");
        handleOutput(realRes, imgRes);
    }
    
}
