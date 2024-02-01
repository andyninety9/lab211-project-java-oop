/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Model;

/**
 *
 * @author andymai
 */
public class Hotel {
    private String hotelID;
    private String hotelName;
    private int isAvailable;
    private String hotelAddress;
    private String hotelPhone;
    private double hotelRating;

    public Hotel(String hotelID, String hotelName, int isAvailable, String hotelAddress, String hotelPhone, double hotelRating) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.isAvailable = isAvailable;
        this.hotelAddress = hotelAddress;
        this.hotelPhone = hotelPhone;
        this.hotelRating = hotelRating;
    }

    public Hotel() {
        this.hotelID = null;
        this.hotelName = null;
        this.isAvailable = 0;
        this.hotelAddress = null;
        this.hotelPhone = null;
        this.hotelRating = 0.0;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public double getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(double hotelRating) {
        this.hotelRating = hotelRating;
    }
    
    

    @Override
    public String toString() {
        return "Hotel{" + "hotelID=" + hotelID + ", hotelName=" + hotelName + ", isAvailable=" + isAvailable + ", hotelAddress=" + hotelAddress + ", hotelPhone=" + hotelPhone + ", hotelRating=" + hotelRating + '}';
    }
    
    public void displayHotel(){
        System.out.printf("|%10s|%50s|%35s|%15s|%5.1f star|%10d|\n",this.hotelID, this.hotelName, this.hotelAddress, this.hotelPhone, this.hotelRating , this.isAvailable);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    }
    
}
