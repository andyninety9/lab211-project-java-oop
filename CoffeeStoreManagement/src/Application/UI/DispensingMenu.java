/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.UI;

import java.util.ArrayList;

/**
 *
 * @author andymai
 */
public class DispensingMenu implements Menu{
    ArrayList<String> dispensingMenu = new ArrayList();
    private void createDispensingMenu(){
        dispensingMenu.add("1. Dispensing the drink");
        dispensingMenu.add("2. Update the dispensing drink");
        dispensingMenu.add("3. Exit");
        
    }
    
    @Override
    public void display(){
        createDispensingMenu();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("|%-20s%-40s%20s|\n","","     Dispensing beverages".toUpperCase(),"©SE182823 ");
        System.out.println("----------------------------------------------------------------------------------");
        for (String option : dispensingMenu) {
            System.out.printf("|%-20s%-40s%-20s|\n","",option,"");
        }
        System.out.printf("|%20s%-40s%-20s|\n","=>  ","(CHOOSE OPTIONS FROM 1-2)","");
        System.out.println("----------------------------------------------------------------------------------");
    }
}
