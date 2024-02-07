/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Data;

import Application.Entity.Dispensing;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author andymai
 */
public class DispensingFile extends File implements ManageFile<Dispensing>{

    public DispensingFile(String fileName, String path) {
        super(fileName, path);
    }

    @Override
    public void importFile(ArrayList<Dispensing> list) {
        try {
            FileReader fileReader = new FileReader(path + "/" + fileName);
            BufferedReader br = new BufferedReader(fileReader);
            
            String line;
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                if(values.length == 4){
                    String idOrder = values[0];
                    String idBeverage = values[1];
                    String custumer = values[2];
                    int quantity = Integer.parseInt(values[3]);
                    
                    list.add(new Dispensing(idOrder, idBeverage, custumer, quantity));
                }
            }
            br.close();
            fileReader.close();
            
            System.out.println("Loaded Order Successfully!");
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void exportFile(ArrayList<Dispensing> list) {
        try {
            FileWriter fileWriter = new FileWriter(path + "/" + fileName);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Dispensing dispensing : list) {
                bw.write(dispensing.getDispensingID() + ",");
                bw.write(dispensing.getBeverageID() + ",");
                bw.write(dispensing.getCustumerName() + ",");
                bw.write(dispensing.getQuantity() + "\n");
            }
            bw.close();
            fileWriter.close();
            
            System.out.println("Saved Order Successfully!");
            System.out.println("Path: " + path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
