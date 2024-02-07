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
public class IngredientMenu implements Menu{
    ArrayList<String> ingrMenu = new ArrayList();
    private void createIngrMenu(){
        ingrMenu.add("1. Add an ingredient");
        ingrMenu.add("2. Update ingredient information");
        ingrMenu.add("3. Delete ingredient");
        ingrMenu.add("4. Show all ingredients");
        ingrMenu.add("5. Exit");
    }
    
    @Override
    public void display(){
        createIngrMenu();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("|%-20s%-40s%20s|\n","","     MANAGE INGREDIENTS","©SE182823 ");
        System.out.println("----------------------------------------------------------------------------------");
        for (String option : ingrMenu) {
            System.out.printf("|%-20s%-40s%-20s|\n","",option,"");
        }
        System.out.printf("|%20s%-40s%-20s|\n","=>  ","(CHOOSE OPTIONS FROM 1-4)","");
        System.out.println("----------------------------------------------------------------------------------");
    }
}
