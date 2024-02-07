/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Entity;



/**
 *
 * @author andymai
 */
public class Dispensing {
    private String dispensingID;
    private String beverageID; 
    private String custumerName;
    private int quantity;

    public Dispensing(String dispensingID, String beverageID, String custumerName, int quantity) {
        this.dispensingID = dispensingID;
        this.beverageID = beverageID;
        this.custumerName = custumerName;
        this.quantity = quantity;
    }

    
    public String getDispensingID() {
        return dispensingID;
    }

    public void setDispensingID(String dispensingID) {
        this.dispensingID = dispensingID;
    }

    public String getCustumerName() {
        return custumerName;
    }

    public void setCustumerName(String custumerName) {
        this.custumerName = custumerName;
    }

    public String getBeverageID() {
        return beverageID;
    }

    public void setBeverageID(String beverageID) {
        this.beverageID = beverageID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Dispesnsing{" + "dispensingID=" + dispensingID + ", custumerName=" + custumerName + ", beverageID=" + beverageID + ", quantity=" + quantity + '}';
    }
    
    public void showDispensing(){
        System.out.printf("|%15s|%50s|%15d|%15s|\n", this.dispensingID, this.beverageID, this.quantity, this.custumerName);
        System.out.println("|--------------------------------------------------------------------------------------------------|");
    }
    
    public static void createTemplateDispens(){
        System.out.println("|--------------------------------------------------------------------------------------------------|");
        System.out.printf("|%15s%-50s%15s%15s|\n", "", "      LIST OF DISPENSING", "", "");
        System.out.println("|--------------------------------------------------------------------------------------------------|");
        System.out.printf("|%15s|%50s|%15s|%15s|\n", "Disp.ID", "Bvr.ID", "Quantity", "CUSTUMER".toUpperCase());
        System.out.println("|--------------------------------------------------------------------------------------------------|");
    }
    
}
