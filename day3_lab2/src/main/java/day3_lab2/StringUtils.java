/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3_lab2;

import static java.lang.Character.isLetter;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 *
 * @author nader
 */
public class StringUtils {
    // example 1
    public static String betterString(String s1, String s2, BiPredicate<String, String> p) {
        if (p.test(s1,s2)) {
            return s1;
        } else {
            return s2;
        }
    }
    
    // example 2
    public static String alphaString(String s, Predicate<String> p) {
        if (p.test(s)) {
            return "contains alphabets only";
        } else {
            return "contains not only alphabets";
        }
    }
    
    
    public static void main(String [] args) {
        // example 1
        String string1 = "Hello";
        String string2 = "Heeeeeeeeey";
        String longer = StringUtils.betterString(string1, string2, (s1,s2) -> s1.length() > s2.length());
        String first = StringUtils.betterString(string1, string2, (s1,s2) -> true);
        
        System.out.println("'" + longer + "'" + " is longer");
        System.out.println("'" + first + "'" + " is first");
        
        
        // example 2
        String str = "very 5happy";
        String checked = StringUtils.alphaString(str, (s) -> {
            char[] ch = new char[s.length()];
            boolean b = false;
            for (int i = 0; i < s.length(); i++) {
                ch[i] = s.charAt(i);
            }
            for(char c: ch) {
                if(isLetter(c)) {
                    b = true;
                } else {
                    b = false;
                    break;
                }
            }
            return b;
        }
        );
        
        System.out.println("'" + str + "' " + checked);
    }
}
