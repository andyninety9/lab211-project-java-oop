/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.UI;

import java.util.Scanner;


/**
 *
 * @author andymai
 */
public class Menu {

    public static void displayMainMenu(){
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("|%-20s%-40s%20s|\n","","      HOTEL MANAGEMENT APPLICATION","©SE182823 ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("|%-20s%-40s%-20s|\n","","1. Load Data From File To Program.","");
        System.out.printf("|%-20s%-40s%-20s|\n","","","");
        System.out.printf("|%-20s%-40s%-20s|\n","","2. Adding New Hotel.","");
        System.out.printf("|%-20s%-40s%-20s|\n","","","");
        System.out.printf("|%-20s%-40s%-20s|\n","","3. Checking Exits Hotels.","");
        System.out.printf("|%-20s%-40s%-20s|\n","","","");
        System.out.printf("|%-20s%-40s%-20s|\n","","4. Updating Hotel Information.","");
        System.out.printf("|%-20s%-40s%-20s|\n","","","");
        System.out.printf("|%-20s%-40s%-20s|\n","","5. Deleting Hotel.","");
        System.out.printf("|%-20s%-40s%-20s|\n","","","");
        System.out.printf("|%-20s%-40s%-20s|\n","","6. Searching Hotel.","");
        System.out.printf("|%-20s%-40s%-20s|\n","","","");
        System.out.printf("|%-20s%-40s%-6s|\n","","7. Displaying A Hotel List (Descending By Hotel_Name).","");
        System.out.printf("|%-20s%-40s%-20s|\n","","","");
        System.out.printf("|%-20s%-40s%-20s|\n","","8. Save Data To File.","");
        System.out.printf("|%-20s%-40s%-20s|\n","","","");
        System.out.printf("|%-20s%-40s%-20s|\n","","9. Others Quit.","");
        System.out.printf("|%-20s%-40s%-20s|\n","","","");
        System.out.printf("|%20s%-40s%-20s|\n","=>  ","(CHOOSE OPTIONS FROM 1-9)","");
        System.out.println("----------------------------------------------------------------------------------");
    }
    
    public static void displaySearchMenu(){
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("|%-20s%-40s%20s|\n","","      SEARCHING OPTIONS","©SE182823");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("|%-20s%-40s%-20s|\n","","1. Searching By Hotel_ID.","");
        System.out.printf("|%-20s%-40s%-20s|\n","","","");
        System.out.printf("|%-20s%-40s%-20s|\n","","2. Searching By Hotel_Address.","");
        System.out.printf("|%-20s%-40s%-20s|\n","","","");
        System.out.printf("|%-20s%-40s%-20s|\n","","3. Cancel","");
        System.out.println("----------------------------------------------------------------------------------");
    }
    
    public static void displayQuitProgram(){
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("|%15s%-40s%20s|\n","","COPYRIGHTS BY SE182823 - ALL RIGHTS RESERVED.","");
        System.out.printf("|%20s%-40s%20s|\n","","","");
        System.out.printf("|%20s%-40s%20s|\n","","        ...GOODBYE...","");
        System.out.println("----------------------------------------------------------------------------------");
    }
    
    public static void displayFrameHotel(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-30s%-75s%30s|\n","","         HOTEL INFORMATION","");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|%10s|%50s|%35s|%15s|%10s|%10s|\n","HOTEL ID", "HOTEL NAME", "HOTEL ADDRESS", "HOTLINE", "RATING", "AVAILABLE");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public static void pressAnything(){
        System.out.println("Press anything to continue...");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
    }
    
    public static void displayFailed(String errorMess){
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-30s%-45s%30s|\n","FAILED","=> " + errorMess.toUpperCase(),"Try again");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }
    public static void displaySuccess(String successMess){
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-30s%-45s%30s|\n","SUCCESS","=> " + successMess.toUpperCase(),"Congrats");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }
    
   
}
