/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Report;

import Application.Entity.Beverage;
import Application.Entity.Dispensing;
import Application.Entity.Ingredient;
import Application.Services.ManageBeverage;
import Application.Services.ManageDispensing;
import Application.Services.ManageIngredient;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author andymai
 */
public class UnavailableDrinkReport extends Report implements ManageReport{

    public UnavailableDrinkReport(String reportID, Date dateReport) {
        super(reportID, dateReport);
    }

    public UnavailableDrinkReport() {
        super();
    }

    @Override
    public void makeReport(ManageIngredient listIngredient, ManageDispensing listDispensing, ManageBeverage listBeverage) {
        Beverage.createTemplateBeverage("UNAVAIALABLE BEVERAGE");
        for (Beverage bvr : listBeverage.getListBeverage()) {
            boolean flag = true;
            ArrayList<Ingredient> listIngreCheck = bvr.getListOfIngr().getListIngr();
            for (Ingredient ingredient : listIngreCheck) {
                String idCheck = ingredient.getIngrID();
                double quantityNeeded = ingredient.getIngrQuantity();
                for (Ingredient refIngredient : listIngredient.getListIngr()) {
                    if(idCheck.equalsIgnoreCase(refIngredient.getIngrID()) && quantityNeeded > refIngredient.getIngrQuantity()){
                        bvr.showBeverage();
                        flag = false;
                        break;
                    }
                }
                if(flag == false) break;
            }
        }
    }
}
