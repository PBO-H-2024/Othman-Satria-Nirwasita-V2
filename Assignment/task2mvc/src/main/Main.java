/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.Controller;
import view.ViewData;

/**
 *
 * @author Othman Satria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ViewData vs = new ViewData();
        ViewData.ReadData rd = vs.new ReadData(new Controller());
    }
    
}
