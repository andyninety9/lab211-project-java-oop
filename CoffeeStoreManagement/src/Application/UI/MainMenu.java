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
public class MainMenu implements Menu{
    ArrayList<String> mainMenu = new ArrayList();

    
    
    
    
    private void createMainMenu(){
        mainMenu.add("1. Manage ingredients");
        mainMenu.add("2. Manage beverage recipes");
        mainMenu.add("3. Dispensing beverages");
        mainMenu.add("4. Report");
        mainMenu.add("5. Store data to files");
        mainMenu.add("6. Load data form files");
        mainMenu.add("7. Exit");
    }
    
    @Override
    public void display(){
        createMainMenu();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("|%-20s%-40s%20s|\n","","     COFFEE MANAGEMENT APPLICATION","©SE182823 ");
        System.out.println("----------------------------------------------------------------------------------");
        for (String option : mainMenu) {
            System.out.printf("|%-20s%-40s%-20s|\n","",option,"");
        }
        System.out.printf("|%20s%-40s%-20s|\n","=>  ","(CHOOSE OPTIONS FROM 1-6)","");
        System.out.println("----------------------------------------------------------------------------------");
    }
}
