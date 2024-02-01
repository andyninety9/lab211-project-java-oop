/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Util;

/**
 *
 * @author andymai
 */
public class DataValidate {
    public static void idValidation(String id) throws Exception{
        String prefix = id.substring(0,2);
        if(id.length() > 10) throw new Exception("ID must less than 10 characters");
        else if(!prefix.matches("[a-zA-Z]+")) throw new Exception("First 2 characters must be character");
    }
    
    public static void phoneValidation(String phone) throws Exception{
        if(!phone.matches("^(\\+\\d{1,3})?[-.\\s]?\\(?\\d{1,3}\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}$")){
            throw new Exception("Invalid phone number...09xx.xxx.xxx");
        }
    }
    
    public static void ratingValidation(double rating) throws Exception{
        if(rating < 0 || rating > 5){
            throw new Exception("Rating between 0 and 5...");
        }
    }
}
