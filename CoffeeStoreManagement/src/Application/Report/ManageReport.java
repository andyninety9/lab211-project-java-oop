/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Application.Report;

import Application.Services.ManageBeverage;
import Application.Services.ManageDispensing;
import Application.Services.ManageIngredient;



/**
 *
 * @author andymai
 */
public interface ManageReport {
    public void makeReport(ManageIngredient listIngredient, ManageDispensing listDispensing, ManageBeverage listBeverage);
}
