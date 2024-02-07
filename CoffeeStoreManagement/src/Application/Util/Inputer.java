/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Util;

import java.util.Scanner;

/**
 *
 * @author andymai
 */
public class Inputer {
    private static Scanner sc;
    public static int getPositiveInt(String mess){
        sc = new Scanner(System.in);
        int num;
        while(true){
            try {
                System.out.printf(mess);
                num = sc.nextInt();
                if(num >= 0) {
                    break;
                }else{
                    System.out.println("Please enter a positive number...");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number...");
                sc.nextLine();
            }
        }  
        return num;
    }
    public static int getInt(String mess){
        sc = new Scanner(System.in);
        int num;
        while(true){
            try {
                System.out.printf(mess);
                num = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please enter a number...");
                sc.nextLine();
            }
        }  
        return num;
    }
    public static double getPositiveDouble(String mess){
        sc = new Scanner(System.in);
        double num;
        while(true){
            try {
                System.out.printf(mess);
                num = sc.nextDouble();
                if(num >= 0) {
                    break;
                }else{
                    System.out.println("Please enter a positive number...");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number...");
                sc.nextLine();
            }
        }  
        return num;
    }
    public static double getDouble(String mess){
        sc = new Scanner(System.in);
        double num;
        while(true){
            try {
                System.out.printf(mess);
                num = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Please enter a number...");
                sc.nextLine();
            }
        }  
        return num;
    }
    public static String getString(String mess){
        sc = new Scanner(System.in);
        String s;
        while(true){
            try {
                System.out.printf(mess);
                s = sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Please enter a number...");
                sc.nextLine();
            }
        }  
        return s;
    }
    
    public static String getID(String mess){
        String id;
        do{
            id = getString(mess);
        }while(!ValidationData.validateID(id));
        return id.toUpperCase();
    }
    
    public static boolean confirmOption(String mess){
        String option = getString(mess);
        if(option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }
    
}
