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
public class BeverageMenu implements Menu{
    ArrayList<String> beverageMenu = new ArrayList();
    private void createBeverMenu(){
        beverageMenu.add("1. Add the drink to menu");
        beverageMenu.add("2. Update the drink information");
        beverageMenu.add("3. Delete the drink from menu");
        beverageMenu.add("4. Show menu");
        beverageMenu.add("5. Exit");
    }
    
    @Override
    public void display(){
        createBeverMenu();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("|%-20s%-40s%20s|\n","","     Manage beverage recipes".toUpperCase(),"©SE182823 ");
        System.out.println("----------------------------------------------------------------------------------");
        for (String option : beverageMenu) {
            System.out.printf("|%-20s%-40s%-20s|\n","",option,"");
        }
        System.out.printf("|%20s%-40s%-20s|\n","=>  ","(CHOOSE OPTIONS FROM 1-4)","");
        System.out.println("----------------------------------------------------------------------------------");
    }
}
