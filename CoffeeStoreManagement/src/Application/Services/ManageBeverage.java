/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Services;

import Application.Entity.Beverage;
import Application.Entity.Ingredient;
import Application.Util.Inputer;
import java.util.ArrayList;

/**
 *
 * @author andymai
 */
public class ManageBeverage {
    ArrayList<Beverage> listBeverage = new ArrayList();
    
    public ArrayList<Beverage> getListBeverage(){
        return listBeverage;
    }
    
    public void handleAddDrinkToMenu(ManageIngredient refListIngredient){
        String idBeverage, nameBeverage;
        idBeverage = Inputer.getID("Enter ID's Beverage: ");
        int positionBever = handleSearchDrinkByID(idBeverage); 
        if(positionBever != -1){
            System.out.println("ID Beverage Duplicated!");
            return;
        }
        nameBeverage = Inputer.getString("Enter Name Drink: ");
        Beverage temp = new Beverage(idBeverage, nameBeverage, new ManageIngredient());
        do{
            String createIdIngre = Inputer.getID("Create an ID Ingredient: ");
            int isExitIDIngre = refListIngredient.handleSearchIngredientByID(createIdIngre);
            if(isExitIDIngre == -1){
                String nameIngredient = Inputer.getString("Enter Name Ingredient: ");
                System.out.println("You have to add total quantity of ".toUpperCase() + nameIngredient + " FIRST ");
                double totalQuantity = Inputer.getPositiveDouble("Enter total quantity: ");
                double quantityIngre = Inputer.getPositiveDouble("Enter Quantity Of Ingreedient: ");
                String unitIngre = Inputer.getString("Enter Unit of Ingredient: ");
                refListIngredient.handleAddIngredient(createIdIngre, nameIngredient, totalQuantity, unitIngre);
                temp.getListOfIngr().handleAddIngredient(createIdIngre, nameIngredient, quantityIngre, unitIngre);
                
            }else{
                Ingredient tmp = refListIngredient.listIngredient.get(isExitIDIngre);
                temp.getListOfIngr().listIngredient.add(new Ingredient(tmp.getIngrID(), tmp.getIngrName(), Inputer.getPositiveInt("Enter quantity: "), tmp.getIngrUnit()));
            }
            System.out.println("Added ingredient successfully!");
        }while(Inputer.confirmOption("Do you want to add more ingredients?[YES/NO]: ") != false);
        listBeverage.add(temp);
        temp.getListOfIngr().handleDisplayAllByName();
        System.out.println("Add Drink To Menu Successfully!");
    }

    
    public void handleUpdateDrink(){
        String idUpdate = Inputer.getID("Enter ID Beverage to update: ");
        int position =handleSearchDrinkByID(idUpdate);
        if( position == -1){
            System.out.println("The drink does not exist...");
            return;
        }
        
        String updateBerverageName = Inputer.getString("Update Berverage Name: ");
        if(!updateBerverageName.isEmpty()){
            listBeverage.get(position).setBeverageName(updateBerverageName);
        }
        listBeverage.get(position).getListOfIngr().handleDisplayAllByName();
        do{
            String idIngrUpdate = Inputer.getID("Enter Ingredient ID to update: ");
            listBeverage.get(position).getListOfIngr().handleUpdateIngredient(idIngrUpdate);
        }while(Inputer.confirmOption("Do you want to continue update ingredients[YES/NO]: ") != false);
        Beverage.createTemplateBeverage();
        listBeverage.get(position).showBeverage();
    }
    
    public void handleDeleteBeverage(){
        String idUpdate = Inputer.getID("Enter ID Beverage to delete: ");
        int position =handleSearchDrinkByID(idUpdate);
        if( position == -1){
            System.out.println("The drink does not exist...");
            return;
        }
        
        if(Inputer.confirmOption("Do you want to delete[YES/NO]: ")){
            listBeverage.remove(position);
            System.out.println("Deleted Successfully!");
        }
    }
    
    public int handleSearchDrinkByID(String idSearch){
        if(listBeverage.isEmpty()){
            return -1;
        }
        for (int i = 0; i < listBeverage.size(); i++) {
            if(listBeverage.get(i).getBeverageID().equalsIgnoreCase(idSearch)){
                return i;
            }
        }
        return -1;
    }
    
    public void handleDisplayMenu(){
        if(listBeverage.isEmpty()){
            System.out.println("There are nothing to display...try again...");
            return;
        }
        Beverage.createTemplateBeverage();
        for (Beverage beverage : listBeverage) {
            beverage.showBeverage();
        }
    }
}
