/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Controller;
import java.sql.*;

/**
 *
 * @author Othman Satria
 */
public class Model {
    private Model model;
    ConnectorDB ConnDB = new ConnectorDB();
    
    public Model(Controller C){
        
    }
    
    class ConnectorDB {
        String DBurl = "jdbc:mysql://localhost/student_db";
        String DBusername = "root";
        String DBpassword = "";

        Connection conn;
        Statement statement;

        public ConnectorDB(){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
                System.out.println("Connection Success");
            }catch(Exception ex){
                System.out.println("Connection Failed " + ex.getMessage());
            }
        }
    }
    
    //Input Data Process
    public void insertData(int nim, String name, int age){
        try{
            String query = "INSERT INTO `student`(`nim`,`name`,`age`) VALUES ('" + nim + "','" + name + "','" + age + "')";
            
            ConnDB.statement = ConnDB.conn.createStatement();
            ConnDB.statement.executeUpdate(query);
            
            System.out.println("Input Success");
        }catch(Exception ex){
            System.out.println("Input Failed " + ex.getMessage());
        }
    }
    
    //Read Data Process
    public String[][] readData(){
        String data[][] = new String[10][4]; 
        try{
            int totalData = 0;
            String query = "SELECT * FROM student";
                      
            ConnDB.statement = ConnDB.conn.createStatement();
            ResultSet resultSet = ConnDB.statement.executeQuery(query);
            while(resultSet.next()){
                data[totalData][0] = resultSet.getString("id");
                data[totalData][1] = resultSet.getString("nim");
                data[totalData][2] = resultSet.getString("name");
                data[totalData][3] = resultSet.getString("age");
                totalData++;
            }
            ConnDB.statement.close();
        }catch(SQLException e){
            System.out.println("SQL Error" + e.getMessage());
        }finally{
            return data;
        }
    }
    
    //Update Data Process
    public void updateData(int id, int nim, String name, int age){
        try{     
            String query = "UPDATE `student` SET nim= '" + nim+ "',"
                    + " name= '" + name+ "',"
                    + " age= '" + age+ "' WHERE id = '" + id + "'";
            
            ConnDB.statement = ConnDB.conn.createStatement();
            ConnDB.statement.executeUpdate(query);
            
            System.out.println("Update Success");
        }catch(Exception ex){
            System.out.println("Update Failed : " + ex.getMessage());
        }
    }
    
    //Delete Data Process
    public void deleteData(int id){
        try{
            String query = "DELETE FROM `student` WHERE id='" + id + "'";
            
            ConnDB.statement = ConnDB.conn.createStatement();
            ConnDB.statement.executeUpdate(query);
            
            System.out.println("Delete Success");
        }catch(Exception ex){
            System.out.println("Delete Failed : " + ex.getMessage());
        }
    }
}
