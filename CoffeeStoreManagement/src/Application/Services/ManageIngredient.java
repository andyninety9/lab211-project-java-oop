/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Services;

import Application.Entity.Ingredient;
import Application.Util.Inputer;
import static Application.Util.Inputer.confirmOption;
import static Application.Util.Inputer.getPositiveDouble;
import static Application.Util.Inputer.getString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author andymai
 */
public class ManageIngredient {
    ArrayList<Ingredient> listIngredient = new ArrayList();
    
    public ArrayList<Ingredient> getListIngr(){
        return listIngredient;
    }
    
    public void handleAddIngredient(){
        String id, name, unit;
        double quantity;
        
        id = Inputer.getID("Enter Ingredient's ID: ");
        if(handleSearchIngredientByID(id) != -1) {
            System.out.println("ID Duplicated!");
            return;
        }
        name = Inputer.getString("Enter Ingredient's Name: ");
        quantity = Inputer.getPositiveDouble("Enter Quantity: ");
        unit = Inputer.getString("Unit: ");
        Ingredient temp = new Ingredient(id, name, quantity, unit);
        listIngredient.add(temp);
        System.out.println("Added " + id + " Sucessfully!");
        
    }
    public void handleAddIngredient(String id, String name, double quantity, String unit){
       
        if(handleSearchIngredientByID(id) != -1) {
            System.out.println("ID Duplicated!");
            return;
        }
        Ingredient temp = new Ingredient(id, name, quantity, unit);
        listIngredient.add(temp);
    }
    
    public int handleSearchIngredientByID(String idCheck){
        if(listIngredient.isEmpty()){
            return -1;
        }
        for (int i = 0; i < listIngredient.size(); i++) {
            if(listIngredient.get(i).getIngrID().equalsIgnoreCase(idCheck)){
                return i;
            }
        }
        return -1;
    }
    
    public void handleUpdateIngredient(){
        String idUpdate = getString("Enter ID To Update: ");
        int isExit = handleSearchIngredientByID(idUpdate);
        if(isExit == -1){
            System.out.println("ID does not exits");
            return;
        }
        String newName, newUnit;
        double newQuantity;
        
        newName = getString("Rename Ingredient: ");
        if(!newName.equals(listIngredient.get(isExit).getIngrName()) && !newName.isEmpty()){
            listIngredient.get(isExit).setIngrName(newName);
        }
        newQuantity = getPositiveDouble("Change quantity: ");
        if(newQuantity != listIngredient.get(isExit).getIngrQuantity()){
            listIngredient.get(isExit).setIngrQuantity(newQuantity);
        }
        newUnit = getString("Change unit: ");
        if(!newUnit.equals(listIngredient.get(isExit).getIngrUnit()) && !newUnit.isEmpty()){
            listIngredient.get(isExit).setIngrUnit(newUnit);
        }
        System.out.println(listIngredient.get(isExit).getIngrID() + " updated");
    }
    public void handleUpdateIngredient(String idUpdate){
        int isExit = handleSearchIngredientByID(idUpdate);
        if(isExit == -1){
            System.out.println("ID does not exits");
            if(confirmOption("Do you want to add new ingredient[YES/NO]: ") == true){
                handleAddIngredient();
            }
            return;
        }
        String newUnit;
        double newQuantity;
        
        newQuantity = getPositiveDouble("Change quantity: ");
        if(newQuantity != listIngredient.get(isExit).getIngrQuantity()){
            listIngredient.get(isExit).setIngrQuantity(newQuantity);
        }
        newUnit = getString("Change unit: ");
        if(!newUnit.equals(listIngredient.get(isExit).getIngrUnit()) && !newUnit.isEmpty()){
            listIngredient.get(isExit).setIngrUnit(newUnit);
        }
        System.out.println(listIngredient.get(isExit).getIngrID() + " updated");
    }
    
    public void handleRemoveIngredient(){
        String idRemove = getString("Enter ID To Remove: ");
        int position;
        if(handleSearchIngredientByID(idRemove) == -1){
            System.out.println("ID does not exits");
            return;
        }else{
            position = handleSearchIngredientByID(idRemove);
        }
        if(confirmOption("Are you sure? Delete " + listIngredient.get(position).getIngrID() + "?")){
            listIngredient.remove(position);
            System.out.println("Remove Successfully!");
        }else{
            System.out.println("Cancel...");
        }
    }
    
    
    
    public void handleDisplayAllByName(){
        if(listIngredient.isEmpty()){
            System.out.println("There are nothing to display...try again...");
            return;
        }
        Comparator nameBalance = (Comparator<Ingredient>) (Ingredient o1, Ingredient o2) -> o1.getIngrName().compareToIgnoreCase(o2.getIngrName());
        Collections.sort(listIngredient.subList(0, 0), nameBalance);
        Ingredient.createTemplate();
        for (Ingredient ingredient : listIngredient) {
            ingredient.showIngredient();
        }
    }
    
    public void displayInline(){
        for (Ingredient ingredient : listIngredient) {
            System.out.printf(ingredient.getIngrName() + "|");
        }
        System.out.printf("%60s", "");
    }
}
