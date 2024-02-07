/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coffeestoremanagement;

import Application.Data.DispensingFile;
import Application.Data.IngredientFile;
import Application.Data.ManageFile;
import Application.Data.MenuFile;
import Application.Report.AvailableIngredientReport;
import Application.Report.ManageReport;
import Application.Report.UnavailableDrinkReport;
import Application.Services.ManageBeverage;
import Application.Services.ManageDispensing;
import Application.Services.ManageIngredient;
import Application.UI.BeverageMenu;
import Application.UI.DispensingMenu;
import Application.UI.IngredientMenu;
import Application.UI.MainMenu;
import Application.UI.Menu;
import Application.UI.ReportMenu;
import Application.Util.Inputer;
import static Application.Util.Inputer.confirmOption;

/**
 *
 * @author andymai
 */
public class CoffeeStoreManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ManageIngredient ingredients = new ManageIngredient();
            ManageBeverage beverage = new ManageBeverage();
            ManageDispensing dispensing = new ManageDispensing();
            int choice;
            do{
                Menu mainMenu = new MainMenu();
                mainMenu.display();
                choice = Inputer.getPositiveInt("YOUR OPTION: ");
                switch(choice){
                    case 1: {
                        while(true){
                            int option1;
                            Menu ingrMenu = new IngredientMenu();
                            ingrMenu.display();
                            option1 = Inputer.getPositiveInt("YOUR OPTION: ");
                            switch(option1){
                                case 1: {
                                    do{
                                        ingredients.handleAddIngredient();
                                    }while(confirmOption("Do you want to continue[YES/NO]: "));
                                    break;
                                }
                                case 2: {
                                    ingredients.handleUpdateIngredient();
                                    break;
                                }
                                case 3: {
                                    ingredients.handleRemoveIngredient();
                                    break;
                                }
                                case 4: {
                                    ingredients.handleDisplayAllByName();
                                    break;
                                }
                                default:{
                                    break;
                                }
                            }
                            if(option1 > 4) break;
                        }
                        break;
                    }
                    case 2: {
                        while(true){
                        int option2;
                        Menu beverMenu = new BeverageMenu();
                        beverMenu.display();
                        option2 = Inputer.getPositiveInt("YOUR OPTION: ");
                        switch(option2){
                            case 1: {
                                beverage.handleAddDrinkToMenu(ingredients);
                                break;
                            }
                            case 2: {
                                beverage.handleUpdateDrink();
                                break;
                            }
                            case 3: {
                                beverage.handleDeleteBeverage();
                                break;
                            }
                            case 4: {
                                beverage.handleDisplayMenu();
                                break;
                            }
                        }
                        if(option2 > 4) break;
                        }
                        break;
                    }
                    case 3: {
                        while(true){
                            int option3;
                            Menu dispensingMenu = new DispensingMenu();
                            dispensingMenu.display();
                            option3 = Inputer.getPositiveInt("YOUR OPTION: ");
                            switch(option3){
                                case 1: {
                                    dispensing.handleAddDispensing(beverage, ingredients);
                                    break;
                                }
                                case 2: {
                                    dispensing.handleUpdateDispensing(beverage, ingredients);
                                    break;
                                }
                                default:{
                                    break;
                                }
                            }
                            if(option3 > 2) break;
                        }
                        break;
                    }
                    case 4: {
                        while(true){
                            int option4;
                            Menu reportMenu = new ReportMenu();
                            reportMenu.display();
                            option4 = Inputer.getPositiveInt("YOUR OPTION: ");
                            switch(option4){
                                case 1: {
                                    ManageReport availbleRp = new AvailableIngredientReport();
                                    availbleRp.makeReport(ingredients, dispensing, beverage);
                                    break;
                                }
                                case 2: {
                                    ManageReport unavailableRp = new UnavailableDrinkReport();
                                    unavailableRp.makeReport(ingredients, dispensing, beverage);
                                    break;
                                }
                                case 3: {
                                    dispensing.handleDisplayDispensing();
                                    break;
                                }
                                default:{
                                    break;
                                }
                            }
                            if(option4 > 3) break;
                        }
                        break;
                    }
                    case 5: {
                        ManageFile ingredientFile = new IngredientFile("Ingredient.dat", "/Users/andymai/Documents/lab211-project-java-oop/Data/CoffeeShop");
                        ingredientFile.exportFile(ingredients.getListIngr());
                        ManageFile menuFile = new MenuFile("Menu.dat", "/Users/andymai/Documents/lab211-project-java-oop/Data/CoffeeShop");
                        menuFile.exportFile(beverage.getListBeverage());
                        ManageFile orderFile = new DispensingFile("Order.dat", "/Users/andymai/Documents/lab211-project-java-oop/Data/CoffeeShop");
                        orderFile.exportFile(dispensing.getListDispens());
                        break;
                    }
                    case 6: {
                        ManageFile loadIngredient = new IngredientFile("Ingredient.dat", "/Users/andymai/Documents/lab211-project-java-oop/Data/CoffeeShop");
                        loadIngredient.importFile(ingredients.getListIngr());
                        ManageFile loadMenu = new MenuFile("Menu.dat", "/Users/andymai/Documents/lab211-project-java-oop/Data/CoffeeShop");
                        loadMenu.importFile(beverage.getListBeverage());
                        ManageFile loadOrder = new DispensingFile("Order.dat", "/Users/andymai/Documents/lab211-project-java-oop/Data/CoffeeShop");
                        loadOrder.importFile(dispensing.getListDispens());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }while(choice >= 1 && choice < 7);
        } catch (Exception e) {
            System.out.println("Somthing wrong...");
        }
    }
    
}



    