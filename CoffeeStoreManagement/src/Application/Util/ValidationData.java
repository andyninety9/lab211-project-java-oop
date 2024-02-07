/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Util;

/**
 *
 * @author andymai
 */
public class ValidationData {
    public static boolean validateID(String id){
        if(id.isEmpty()) {
            System.out.println("ID Required...");
            return false;
        }else if(id.length() > 15){
            System.out.println("ID less than 10 characters...");
            return false;
        }
        return true;
    }
    
    public static boolean validateName(String name){
        if(name.isEmpty()){
            System.out.println("Name Required...");
            return false;
        }else if(name.length() > 20){
            System.out.println("Name less than 20 characters...");
            return false;
        }
        return true;
    }
    
    
}
