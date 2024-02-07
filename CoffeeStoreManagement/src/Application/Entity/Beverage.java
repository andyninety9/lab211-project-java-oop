/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Entity;

import Application.Services.ManageIngredient;

/**
 *
 * @author andymai
 */
public class Beverage {
    private String beverageID;
    private String beverageName;
    private ManageIngredient listOfIngr;

    public Beverage(String beverageID, String beverageName, ManageIngredient listOfIngr) {
        this.beverageID = beverageID;
        this.beverageName = beverageName;
        this.listOfIngr = listOfIngr;
    }

    public Beverage() {
        this.beverageID = null;
        this.beverageName = null;
        this.listOfIngr = new ManageIngredient();
    }

    public String getBeverageID() {
        return beverageID;
    }

    public void setBeverageID(String beverageID) {
        this.beverageID = beverageID;
    }

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public ManageIngredient getListOfIngr() {
        return listOfIngr;
    }

    public void setListOfIngr(ManageIngredient listOfIngr) {
        this.listOfIngr = listOfIngr;
    }

   

    @Override
    public String toString() {
        return "Beverage{" + "beverageID=" + beverageID + ", beverageName=" + beverageName + ", listOfIngr=" + listOfIngr + '}';
    }
    
    
   
    public void showBeverage(){
        System.out.printf("|%15s|%50s|\n", this.beverageID, this.beverageName);
        System.out.println("|------------------------------------------------------------------|");
    }
    
    public static void createTemplateBeverage(){
        System.out.println("|__________________________________________________________________|");
        System.out.printf("|%15s%-51s|\n", "", "BEVERGAE");
        System.out.println("|__________________________________________________________________|");
        System.out.printf("|%15s|%50s|\n", "Bever.ID", "NAME");
        System.out.println("|__________________________________________________________________|");
    }
    public static void createTemplateBeverage(String title){
        System.out.println("|__________________________________________________________________|");
        System.out.printf("|%15s%50s|\n", "", title);
        System.out.println("|__________________________________________________________________|");
        System.out.printf("|%15s|%50s|\n", "Bever.ID", "NAME");
        System.out.println("|__________________________________________________________________|");
    }
    
    
}
