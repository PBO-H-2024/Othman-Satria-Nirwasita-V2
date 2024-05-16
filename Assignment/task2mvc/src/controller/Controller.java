/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.Model;

/**
 *
 * @author Othman Satria
 */
public class Controller {
    Model model;

    public Controller() {
        this.model = new Model(this);
    }
    
    public void insertData(int nim, String name, int age){
        model.insertData(nim, name, age);
        JOptionPane.showMessageDialog(null, "Insert Data Process is Success", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public String[][] readData(){
        return model.readData();
    }
    
    public void updateData(int id, int nim, String name, int age){
        model.updateData(id, nim, name, age);
        JOptionPane.showMessageDialog(null, "Update Data Process is Success", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void deleteData(int id){
        model.deleteData(id);
        JOptionPane.showMessageDialog(null, "Delete Data Process is Success", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
