/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Util;

import static Application.Util.DataValidate.idValidation;
import static Application.Util.DataValidate.phoneValidation;
import static Application.Util.DataValidate.ratingValidation;
import java.util.Scanner;

/**
 *
 * @author andymai
 */
public class DataInput {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static int inputPositiveNumber(String mess) throws Exception{
        sc = new Scanner(System.in);
        int num;
        try {
            System.out.printf(mess);
            num = sc.nextInt();
        } catch (Exception e) {
            throw new Exception("Please enter a number...");
        }
        if (num < 0) throw new Exception("Please enter positive number...");
        return num;
    }
    
    public static double inputPositiveDouble(String mess) throws Exception{
        sc = new Scanner(System.in);
        double d;
        try {
            System.out.printf(mess);
            d = sc.nextDouble();
        } catch (Exception e) {
            throw new Exception("Please enter real number...");
        }
        if (d < 0) throw new Exception("Number must be bigger than 0...");
        return d;
    }
    
    public static boolean inputStatus(String mess) throws Exception{
        sc = new Scanner(System.in);
        boolean isAvailable;
        try {
            System.out.printf(mess);
            isAvailable = sc.nextBoolean();
        } catch (Exception e) {
            throw new Exception("Only True or False");
        }
        
        return isAvailable;
    }
    
    public static String inputString(String mess) throws Exception{
        sc = new Scanner(System.in);
        String s;
        try {
            System.out.printf(mess);
            s = sc.nextLine();
        } catch (Exception e) {
            throw new Exception("Please enter a string...");
        }
        if(s.isEmpty()) throw new Exception("Please enter this field...");
        
        return s;
    }
    public static String inputID(String mess) throws Exception{
        sc = new Scanner(System.in);
        String s;
        s = inputString(mess);
        idValidation(s);
        return s.toUpperCase();
    }
    public static String inputPhone(String mess) throws Exception{
        sc = new Scanner(System.in);
        String s;
        s = inputString(mess);
        phoneValidation(s);
        return s;
    }
    public static double inputRating(String mess) throws Exception{
        sc = new Scanner(System.in);
        double num;
        num = inputPositiveDouble(mess);
        ratingValidation(num);
        return num;
    }
    
    public static boolean optional(String mess){
        sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.printf(mess);
        String option = sc.nextLine();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        
        if(option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes")){
            return true;
        }
        return false;
    }
    
   
}
