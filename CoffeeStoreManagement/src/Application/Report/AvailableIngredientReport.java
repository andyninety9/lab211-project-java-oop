/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Report;

import Application.Entity.Ingredient;
import Application.Services.ManageBeverage;
import Application.Services.ManageDispensing;
import Application.Services.ManageIngredient;
import java.util.Date;

/**
 *
 * @author andymai
 */
public class AvailableIngredientReport extends Report implements ManageReport{

    public AvailableIngredientReport(String reportID, Date dateReport) {
        super(reportID, dateReport);
    }

    public AvailableIngredientReport() {
        super();
    }

    @Override
    public void makeReport(ManageIngredient listIngredient, ManageDispensing listDispensing, ManageBeverage listBeverage) {
        Ingredient.createTemplate();
        for (Ingredient ingr : listIngredient.getListIngr()) {
            if(ingr.getIngrQuantity() > 0){
                ingr.showIngredient();
            }
        }        
    }
    
    


}
