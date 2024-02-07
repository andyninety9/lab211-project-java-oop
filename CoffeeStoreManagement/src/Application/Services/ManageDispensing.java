/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Services;

import Application.Entity.Dispensing;
import Application.Entity.Ingredient;
import Application.Util.Inputer;
import java.util.ArrayList;

/**
 *
 * @author andymai
 */
public class ManageDispensing {
    ArrayList<Dispensing> listDispensing = new ArrayList();
    
    public ArrayList<Dispensing> getListDispens(){
        return listDispensing;
    }
    
    public void handleAddDispensing(ManageBeverage refBeverage, ManageIngredient refIngredient){
        String idDispensing = Inputer.getID("Create ID Dispensing: ");
        if(handleSearchDispensingByID(idDispensing) != -1){
            System.out.println("ID Duplicated...");
            return;
        }
        String idBeverage_forSearching = Inputer.getID("Enter id of drink which you want to dispens: ");
        int beveragePosition = refBeverage.handleSearchDrinkByID(idBeverage_forSearching);
        if(beveragePosition == -1){
            System.out.println("The drink does not exist...");
            return;
        }
        String custumerName = Inputer.getString("Enter custumer's name: ");
        int quantity = Inputer.getPositiveInt("Enter quantity: ");
        if(handleCheckIngredient(refBeverage, refIngredient, beveragePosition, quantity) == 1){
            listDispensing.add(new Dispensing(idDispensing, idBeverage_forSearching, custumerName, quantity));
            System.out.println("Dispensing Successfully!");
        }else{
            listDispensing.add(new Dispensing(idDispensing, idBeverage_forSearching, custumerName, quantity));
            System.out.println("Do not have enough ingredient...");
        }
        
    }
    
    public int handleCheckIngredient(ManageBeverage refBeverage, ManageIngredient refIngredient, int beveragePosition, int quantityOfDispen){
        ManageIngredient listIngredientNeeded = refBeverage.listBeverage.get(beveragePosition).getListOfIngr();
        for (Ingredient ingredient : listIngredientNeeded.listIngredient) {
            String idIngre = ingredient.getIngrID();
            String nameIngre = ingredient.getIngrName();
            double quantityIngreNeeded = ingredient.getIngrQuantity() * quantityOfDispen;
            String unit = ingredient.getIngrUnit();
            
            int refPosition = refIngredient.handleSearchIngredientByID(idIngre);
            while(refIngredient.listIngredient.get(refPosition).getIngrQuantity() < quantityIngreNeeded){
                Ingredient.createTemplate();
                refIngredient.listIngredient.get(refPosition).showIngredient();
                System.out.println("Does not enough " + nameIngre + " needed...");
                if(Inputer.confirmOption("Do you want to update the quantity of " + nameIngre + " (Need " + (quantityIngreNeeded - refIngredient.listIngredient.get(refPosition).getIngrQuantity()) + " " + unit + " more[YES/NO]? ")){
                    refIngredient.handleUpdateIngredient(idIngre);
                }else{
                    return -1;
                }
            }
        }
        return 1;
    }
    
    public void handleUpdateDispensing(ManageBeverage refBeverage, ManageIngredient refIngredient){
        String idDispensUpdate = Inputer.getID("Enter ID Dispensing To Update: ");
        int positionDispens = handleSearchDispensingByID(idDispensUpdate);
        if(positionDispens == -1){
            System.out.println("The dispensing does not exist...");
            return;
        }
        String newIDBeverage = Inputer.getID("Change beverage: ");
        while(refBeverage.handleSearchDrinkByID(newIDBeverage) == -1 && !newIDBeverage.isEmpty()){
            System.out.println("The drink does not exist...");
            if(Inputer.confirmOption("Do you want to re-enter ID[YES/NO]? ")){
                newIDBeverage = Inputer.getID("Re-enter ID Beverage: ");
            }else{
                System.out.println("Cannot update dispensing...");
                return;
            }
        }
        
        int newQuantity = Inputer.getPositiveInt("Change quantity: ");
        if(newQuantity != listDispensing.get(positionDispens).getQuantity()){
            int beveragePosition = refBeverage.handleSearchDrinkByID(newIDBeverage);
            if(handleCheckIngredient(refBeverage, refIngredient, beveragePosition, newQuantity) == 1){
                listDispensing.get(positionDispens).setBeverageID(newIDBeverage);
                listDispensing.get(positionDispens).setQuantity(newQuantity);
                System.out.println("Update " + idDispensUpdate + " Successfully!");
            }else{
                System.out.println("Do not have enough ingredient...");
                listDispensing.get(positionDispens).setBeverageID(newIDBeverage);
                listDispensing.get(positionDispens).setQuantity(newQuantity);
            }
        }

    }
    
    public int handleSearchDispensingByID(String idCheck){
        if(listDispensing.isEmpty()){
            return -1;
        }
        for (int i = 0; i < listDispensing.size(); i++) {
            if(listDispensing.get(i).getDispensingID().equalsIgnoreCase(idCheck)){
                return i;
            }
        }
        return -1;
    }
    
    public void handleDisplayDispensing(){
        if(listDispensing.isEmpty()){
            System.out.println("There are nothing to display...try again...");
            return;
        }
        
        Dispensing.createTemplateDispens();
        for (Dispensing dispesnsing : listDispensing) {
            dispesnsing.showDispensing();
        }
        
    }
}
