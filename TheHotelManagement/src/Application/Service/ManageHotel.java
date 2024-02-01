/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Application.Service;

import Application.Model.Hotel;
import static Application.UI.Menu.displayFailed;
import static Application.UI.Menu.displayFrameHotel;
import static Application.UI.Menu.displaySuccess;
import static Application.Util.DataInput.inputID;
import static Application.Util.DataInput.inputPhone;
import static Application.Util.DataInput.inputPositiveDouble;
import static Application.Util.DataInput.inputPositiveNumber;
import static Application.Util.DataInput.inputString;
import static Application.Util.DataInput.optional;
import java.util.*;

/**
 *
 * @author andymai
 */
public class ManageHotel {
    private ArrayList<Hotel> listHotel = new ArrayList();
    
    public void handleAddHotel(){
        String id_hotel, name_hotel, address_hotel, phone_hotel;
        int status_hotel;
        double rating_hotel;
        int isValid = 0;
        //check dữ liệu người dùng nhập vào
        do{
            try {
                id_hotel = inputID("Enter ID's Hotel: ");
                name_hotel = inputString("Enter Name's Hotel: ");
                address_hotel = inputString("Enter Hotel's address: ");
                phone_hotel = inputPhone("Enter Hotel's phone: ");
                rating_hotel = inputPositiveDouble("Rating from 0 to 5: ");
                status_hotel = inputPositiveNumber("Enter hotel's status: ");
                //Kiểm tra xem id đã có hay chưa
                if(handleSearchHotelByID(id_hotel) != -1){
                    displayFailed("Hotel ID already exits...");
                    break;
                }else{
                    listHotel.add(new Hotel(id_hotel, name_hotel, status_hotel, address_hotel, phone_hotel, rating_hotel));
                    displaySuccess("Added Successfully!");
                    isValid = 1;
                } 
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(isValid == 0);
    }
    
    public void handleRemoveHotel(){
        try {
            String idRemove = inputID("Enter ID To Remove: ");
            int pos = handleSearchHotelByID(idRemove);
            if(pos == -1){
                displayFailed("Cannot found");
            }else{
                if(optional("Do you ready want to delete this hotel [YES/NO]: ")){
                    listHotel.remove(pos);
                    displaySuccess("Removed Successfully!");
                }else{
                    displayFailed("Cancel");
                }

            }
        } catch (Exception e) {
            displayFailed(e.getMessage());
        }
        
    }
    
    public void handleCheckingExitsHotel(){
        int isFound = 0;
        try {
            String checkID = inputString("Enter ID to check exist: ");
            for(int i = 0; i < listHotel.size(); i++){
                if(listHotel.get(i).getHotelID().equalsIgnoreCase(checkID)){
                    isFound = 1;
                    break;
                }
            }
        if(isFound == 0){
            displayFailed("No Hotel Found!");
        }else{
            displaySuccess("Exist Hotel");
        }
        } catch (Exception e) {
            displayFailed(e.getMessage());
        }
    }
    
    public void handleEditHotel(){
        try {
            String idEdit = inputID("Enter ID To Edit: ");
            int pos = handleSearchHotelByID(idEdit);
            if(pos == -1){
                displayFailed("Cannot found");
            }else{
                listHotel.get(pos).setHotelName(inputString("Rename Hotel: "));
                listHotel.get(pos).setHotelPhone(inputPhone("Change phone number: "));
                listHotel.get(pos).setHotelAddress(inputString("Change hotel address: "));
                displaySuccess("Updated Successfully!");
            }
        } catch (Exception e) {
            displayFailed(e.getMessage());
        }
        
    }
    
    public int handleSearchHotelByID(String id){
        if(listHotel.isEmpty()){
            return -1;
        }
        for(int i = 0; i < listHotel.size(); i++){
            if(listHotel.get(i).getHotelID().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }
    
    public void handleDisplayListHotel(){
        if(listHotel.isEmpty()){
            displayFailed("Do not have any hotel...please try again!");
        }else{
            Comparator nameBalance = (Comparator<Hotel>) (Hotel o1, Hotel o2) -> o1.getHotelName().compareToIgnoreCase(o2.getHotelName());
            Collections.sort(listHotel, nameBalance);
            displayFrameHotel();
            for(Hotel x : listHotel){
                x.displayHotel();
            }
        }
    }
    
    public void handleSearchHotelByID(){
        try {
            String idSearch = inputID("Enter ID's Hotel To Search: ");
            int pos = handleSearchHotelByID(idSearch);
            if(pos == -1){
                displayFailed("Cannot Found");
            }else{
                displayFrameHotel();
                listHotel.get(pos).displayHotel();
            }
        } catch (Exception e) {
            displayFailed(e.getMessage());
        }
    }
    
    public void handleGetHotelByAddress(){
        int isFound = 0;
        try {
            String addressSearch = inputString("Enter Address To Search: ");
            displayFrameHotel();
            for(int i = 0; i < listHotel.size(); i++){
                if(listHotel.get(i).getHotelAddress().contains(addressSearch)){
                    listHotel.get(i).displayHotel();
                    isFound = 1;
                }
            }
            if(isFound == 0){
                displayFailed("Cannot found");
            }
        } catch (Exception e) {
            displayFailed(e.getMessage());
        }
    }
    
    public ArrayList<Hotel> handleGetList(){
        return listHotel;
    }
}
