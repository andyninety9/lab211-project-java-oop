/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Datalayer;

import Application.Model.Hotel;
import Application.Service.ManageHotel;
import Application.UI.Menu;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author andymai
 */
public class DatFile extends File implements FileManagement{

    public DatFile(String fileName, String path) {
        super(fileName, path);
    }
    
    
    @Override
    public void exportData(ManageHotel listHotel) {
        try {
            FileWriter fileWriter = new FileWriter( path + "/" +  fileName );
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            for(Hotel hotel : listHotel.handleGetList()){
                bufferedWriter.write(hotel.getHotelID() + ",");
                bufferedWriter.write(hotel.getHotelName()+ ",");
                bufferedWriter.write(hotel.getIsAvailable()+ ",");
                bufferedWriter.write(hotel.getHotelAddress()+ ",");
                bufferedWriter.write(hotel.getHotelPhone()+ ",");
                bufferedWriter.write(hotel.getHotelRating() + "\n");
            }
            
            bufferedWriter.close();
            fileWriter.close();
            Menu.displaySuccess("Saved Successfully!");
            System.out.println("Path: " + path);
        } catch (IOException e) {
            Menu.displayFailed(e.getMessage());
        }
    }
    
    @Override
    public void importData(ManageHotel listHotel) {
        try {
            FileReader fileReader = new FileReader(path + "/" + fileName);
            BufferedReader br = new BufferedReader(fileReader);
            
            String line;
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                if(values.length == 6){
                    String hotelID = values[0];
                    String hotelName = values[1];
                    int hotelStatus = Integer.parseInt(values[2]);
                    String hotelAddress = values[3];
                    String hotelPhone = values[4];
                    double hotelRating = Double.parseDouble(values[5]);
                    Hotel tempHotel = new Hotel(hotelID, hotelName, hotelStatus, hotelAddress, hotelPhone, hotelRating);
                    listHotel.handleGetList().add(tempHotel);
                }    
            }
            Menu.displaySuccess("Loaded Successfully!");
            br.close();
            fileReader.close();
            Menu.displaySuccess("Load data successfully!");
        } catch(IOException e){
            Menu.displayFailed(e.getMessage());
        }
    }
    
}
