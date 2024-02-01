/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Application.UI;

import Application.Datalayer.DatFile;
import Application.Datalayer.FileManagement;
import Application.Service.ManageHotel;
import static Application.UI.Menu.displayFailed;
import static Application.UI.Menu.displayMainMenu;
import static Application.UI.Menu.displayQuitProgram;
import static Application.UI.Menu.displaySearchMenu;
import static Application.UI.Menu.pressAnything;
import static Application.Util.DataInput.inputPositiveNumber;
import static Application.Util.DataInput.optional;


/**
 *
 * @author andymai
 */
public class TheHotelManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        ManageHotel hotelSystem = new ManageHotel();
//        FileManagement file = new DatFile("test.dat", "/Users/andymai/Documents/lab211-project-java-oop/Data");
        FileManagement file;
        try {
            do{
                displayMainMenu();
                choice = inputPositiveNumber("YOUR CHOICE: ");
                switch(choice){
                    case 1: {
                        file = new DatFile("test.dat", "/Users/andymai/Documents/lab211-project-java-oop/Data");
                        file.importData(hotelSystem);
                        break;
                    }
                    case 2: {
                        boolean isContinue = true;
                        while(isContinue){
                            hotelSystem.handleAddHotel();
                            isContinue = optional("Do you want to continue? [YES/NO]: ");
                        }
                        break;
                    }
                    case 3: {
                        boolean isContinue = true;
                        while(isContinue){
                            hotelSystem.handleCheckingExitsHotel();
                            isContinue = optional("Do you want to continue? [YES/NO]: ");
                        }
                        break;
                    }
                    case 4: {
                        hotelSystem.handleEditHotel();
                        break;
                    }
                    case 5: {
                        hotelSystem.handleRemoveHotel();
                        break;
                    }
                    case 6: {
                        int secondChoice;
                        do{
                            displaySearchMenu();
                            secondChoice = inputPositiveNumber("YOUR CHOICE: ");
                            switch(secondChoice){
                                case 1: {
                                    hotelSystem.handleSearchHotelByID();
                                    pressAnything();
                                    break;
                                }
                                case 2: {
                                    hotelSystem.handleGetHotelByAddress();
                                    pressAnything();
                                    break;
                                }
                                default: {
                                    displayFailed("Cancel");
                                    break;
                                }
                            }
                        }while(secondChoice >= 1 && secondChoice <= 2);
                        break;
                    }
                    case 7: {
                        hotelSystem.handleDisplayListHotel();
                        pressAnything();
                        break;
                    }
                    case 8: {
                        file = new DatFile("export_test.dat", "/Users/andymai/Documents/lab211-project-java-oop/Data");
                        file.exportData(hotelSystem);
                        break;
                    }
                    default: {
                        displayQuitProgram();
                        return;
                    }
                }
            }while(choice >= 1 && choice <= 9);
        } catch (Exception e) {
            displayFailed(e.getMessage());
        }
    }
    
}
