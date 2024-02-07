/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Data;

import Application.Entity.Ingredient;
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
public class IngredientFile extends File implements ManageFile<Ingredient>{

    public IngredientFile(String fileName, String path) {
        super(fileName, path);
    }

    @Override
    public void importFile(ArrayList<Ingredient> list) {
        try {
            FileReader fileReader = new FileReader(path + "/" + fileName);
            BufferedReader br = new BufferedReader(fileReader);
            
            String line;
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                if(values.length == 4){
                    String idIngre = values[0];
                    String nameIngre = values[1];
                    double quantityIngre = Double.parseDouble(values[2]);
                    String unitIngre = values[3];
                    Ingredient tmp = new Ingredient(idIngre, nameIngre, quantityIngre, unitIngre);
                    list.add(tmp);
                }
            }
            System.out.println("Loaded Ingredient List Successfully!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void exportFile(ArrayList<Ingredient> list) {
        try {
            FileWriter fileWriter = new FileWriter(path + "/" + fileName);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            for (Ingredient ingredient : list) {
                bufferWriter.write(ingredient.getIngrID() + ",");
                bufferWriter.write(ingredient.getIngrName() + ",");
                bufferWriter.write(ingredient.getIngrQuantity() + ",");
                bufferWriter.write(ingredient.getIngrUnit() + "\n");
            }
            
            bufferWriter.close();
            fileWriter.close();
            System.out.println("Saved Ingredient Sucessfully!");
            System.out.println("Path: " + path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
