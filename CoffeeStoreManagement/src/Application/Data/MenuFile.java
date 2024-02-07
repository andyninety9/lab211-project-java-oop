/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Data;

import Application.Entity.Beverage;
import Application.Entity.Ingredient;
import Application.Services.ManageIngredient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;



/**
 *
 * @author andymai
 */
public class MenuFile extends File implements ManageFile<Beverage>{

    public MenuFile(String fileName, String path) {
        super(fileName, path);
    }

    @Override
    public void importFile(ArrayList<Beverage> list) {
        try {
            FileReader fileReader = new FileReader(path + "/" + fileName);
            BufferedReader br = new BufferedReader(fileReader);
            
            String line;
            while((line = br.readLine()) != null){
                JSONObject beverageJson = new JSONObject(line);
                String beverageID = beverageJson.getString("beverageID");
                String beverageName = beverageJson.getString("beverageName");
                
                JSONArray ingredientJson = beverageJson.getJSONArray("ingredients");
                ManageIngredient listIngre = new ManageIngredient();
                for (int i = 0; i < ingredientJson.length(); i++) {
                    JSONObject ingreTmp = ingredientJson.getJSONObject(i);
                    String ingrID = ingreTmp.getString("ingrID");
                    String ingrName = ingreTmp.getString("ingrName");
                    double ingrQuantity = ingreTmp.getDouble("ingrQuantity");
                    String ingrUnit = ingreTmp.getString("ingrUnit");
                    listIngre.getListIngr().add(new Ingredient(ingrID, ingrName, ingrQuantity, ingrUnit));
                }
                list.add(new Beverage(beverageID, beverageName, listIngre));
            }
        
            System.out.println("Loaded Beverage List Successfully!");
            br.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void exportFile(ArrayList<Beverage> list) {
        try {
            FileWriter fileWriter = new FileWriter(path + "/" + fileName);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

        for (Beverage beverage : list) {
            JSONObject beverageJson = new JSONObject();
            beverageJson.put("beverageID", beverage.getBeverageID());
            beverageJson.put("beverageName", beverage.getBeverageName());

            JSONArray ingredientsJson = new JSONArray();
            for (Ingredient ingr : beverage.getListOfIngr().getListIngr()) {
                JSONObject ingredientJson = new JSONObject();
                ingredientJson.put("ingrID", ingr.getIngrID());
                ingredientJson.put("ingrName", ingr.getIngrName());
                ingredientJson.put("ingrQuantity", ingr.getIngrQuantity());
                ingredientJson.put("ingrUnit", ingr.getIngrUnit());
                ingredientsJson.put(ingredientJson);
            }

            beverageJson.put("ingredients", ingredientsJson);
            bufferWriter.write(beverageJson.toString());
            bufferWriter.write("\n");
        }

            bufferWriter.close();
            fileWriter.close();
            System.out.println("Saved Menu Successfully!");
            System.out.println("Path: " + path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
