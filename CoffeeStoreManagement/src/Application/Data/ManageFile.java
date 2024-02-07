/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Application.Data;

import Application.Services.ManageBeverage;
import Application.Services.ManageDispensing;
import Application.Services.ManageIngredient;
import java.util.ArrayList;

/**
 *
 * @author andymai
 * @param <T>
 */
public interface ManageFile<T> {
    public void importFile(ArrayList<T> list);
    public void exportFile(ArrayList<T> list);
}
