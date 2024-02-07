/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.UI;

import java.util.ArrayList;

/**
 *
 * @author andymai
 */
public class ReportMenu implements Menu{
    ArrayList<String> reportMenu = new ArrayList();
    private void createReportMenu(){
        reportMenu.add("1. The ingredients are available");
        reportMenu.add("2. The drinks for which the store is out of ingredients");
        reportMenu.add("3. Show all the dispensing drink");
        reportMenu.add("4. Exit");
    }
    
    @Override
    public void display(){
        createReportMenu();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-20s%-70s%20s|\n","","             REPORT MENU","©SE182823 ");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        for (String option : reportMenu) {
            System.out.printf("|%-20s%-70s%-20s|\n","",option,"");
        }
        System.out.printf("|%20s%-70s%-20s|\n","=>  ","(CHOOSE OPTIONS FROM 1-3)","");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }
}
