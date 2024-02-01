/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Application.Datalayer;

import Application.Service.ManageHotel;

/**
 *
 * @author andymai
 */
public interface FileManagement {
    public void exportData(ManageHotel listHotel);
    public void importData(ManageHotel listHotel);
}
