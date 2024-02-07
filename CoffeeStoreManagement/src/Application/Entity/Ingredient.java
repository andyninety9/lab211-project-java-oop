/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Entity;

/**
 *
 * @author andymai
 */
public class Ingredient {
    private String ingrID;
    private String ingrName;
    private double ingrQuantity;
    private String ingrUnit;

    public Ingredient(String ingrID, String ingrName, double ingrQuantity, String ingrUnit) {
        this.ingrID = ingrID;
        this.ingrName = ingrName;
        this.ingrQuantity = ingrQuantity;
        this.ingrUnit = ingrUnit;
    }

    public Ingredient() {
        this.ingrID = null;
        this.ingrName = null;
        this.ingrQuantity = 0;
        this.ingrUnit = "gram";
    }

    public String getIngrID() {
        return ingrID;
    }

    public void setIngrID(String ingrID) {
        this.ingrID = ingrID;
    }

    public String getIngrName() {
        return ingrName;
    }

    public void setIngrName(String ingrName) {
        this.ingrName = ingrName;
    }

    public double getIngrQuantity() {
        return ingrQuantity;
    }

    public void setIngrQuantity(double ingrQuantity) {
        this.ingrQuantity = ingrQuantity;
    }

    public String getIngrUnit() {
        return ingrUnit;
    }

    public void setIngrUnit(String ingrUnit) {
        this.ingrUnit = ingrUnit;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "ingrID=" + ingrID + ", ingrName=" + ingrName + ", ingrQuantity=" + ingrQuantity + ", ingrUnit=" + ingrUnit + '}';
    }
    
    public void showIngredient(){
        System.out.printf("|%15s|%50s|%15.1f|%10s|\n", this.ingrID, this.ingrName, this.ingrQuantity, this.ingrUnit);
        System.out.println("|---------------------------------------------------------------------------------------------|");
    }
    
    public static void createTemplate(){
        System.out.println("|---------------------------------------------------------------------------------------------|");
        System.out.printf("|%15s%-50s%15s%13s|\n", "", "      LIST OF INGREDIENTS   ", "", "");
        System.out.println("|---------------------------------------------------------------------------------------------|");
        System.out.printf("|%15s|%50s|%15s|%10s|\n", "Ingr.ID", "NAME", "Quantity".toUpperCase(), "Unit".toUpperCase());
        System.out.println("|---------------------------------------------------------------------------------------------|");
    }
    public static void createTemplate(String title){
        System.out.println("|---------------------------------------------------------------------------------------------|");
        System.out.printf("|%15s%-50s%15s%13s|\n", "", title, "", "");
        System.out.println("|---------------------------------------------------------------------------------------------|");
        System.out.printf("|%15s|%50s|%15s|%10s|\n", "Ingr.ID", "NAME", "Quantity".toUpperCase(), "Unit".toUpperCase());
        System.out.println("|---------------------------------------------------------------------------------------------|");
    }
    
    
}
