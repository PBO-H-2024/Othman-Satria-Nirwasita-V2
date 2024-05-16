/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Othman Satria
 */
public class ViewData {
    //Input Data
    class InputData extends JFrame{
    
        JFrame window = new JFrame("Student Input");

        JLabel lNim = new JLabel("NIM");
        JTextField fNim = new JTextField();

        JLabel lName = new JLabel("NAME");
        JTextField fName = new JTextField();

        JLabel lAge = new JLabel("AGE");
        JTextField fAge = new JTextField();

        JButton btnAdd = new JButton("ADD");

        //Parameter controller untuk menghubungkan ke model
        public InputData(Controller C){
            window.setLayout(null);
            window.setSize(500, 200);
            window.setVisible(true);
            window.setLocationRelativeTo(null);

            window.add(lNim);
            window.add(lName);
            window.add(lAge);
            window.add(fNim);
            window.add(fName);
            window.add(fAge);
            window.add(btnAdd);

             //LABEL
            lNim.setBounds(5, 35, 120, 20);
            lName.setBounds(5, 60, 120, 20);
            lAge.setBounds(5, 85, 120, 20);

            //TEXTFIELD
            fNim.setBounds(150, 35, 120, 20);
            fName.setBounds(150, 60, 120, 20);
            fAge.setBounds(150, 85, 120, 20);

            //BUTTONPANEL
            btnAdd.setBounds(300, 110, 90, 20);

            btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    C.insertData(Integer.parseInt(fNim.getText()), fName.getText(), Integer.parseInt(fAge.getText()));
                }
            });
        }
    }
    
    //Read Data public untuk dapat dibaca diluar package
    public class ReadData extends JFrame {
        public int id, nim, age;
        public String name;
        int totalData;
        String data[][] = new String[100][4];

        JFrame window = new JFrame("Read Data Student");
        JTable tabel;
        DefaultTableModel tableModel;
        JScrollPane scrollPane;
        Object columnName[] = {
            "ID", "NIM", "Name", "Age"
        };

        JButton btnAdd = new JButton("Add");
        JButton btnRefresh = new JButton("Refresh");

        //Parameter controller untuk menghubungkan ke model
        public ReadData(Controller C){
            tableModel = new DefaultTableModel(columnName, 0);
            tabel = new JTable(tableModel);
            scrollPane = new JScrollPane(tabel);

            window.setLayout(null);
            window.setSize(550, 600);
    //        window.setDefaultCloseOperation(3);
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setResizable(false);

            window.add(scrollPane);
            window.add(btnAdd);
            window.add(btnRefresh);
            scrollPane.setBounds(20, 35, 500, 300);
            btnAdd.setBounds(150, 350, 90, 20);
            btnRefresh.setBounds(250, 350, 120, 20);

            data = C.readData();

            tabel.setModel((new JTable(data, columnName)).getModel());

            tabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    super.mouseClicked(e);
                    int row = tabel.getSelectedRow();
                    int column = tabel.getSelectedColumn();

                    int id = Integer.parseInt(tabel.getValueAt(row,0).toString());
                    String name = tabel.getValueAt(row,2).toString();

                    int input = JOptionPane.showConfirmDialog(null,
                                "do you want to delete " + name + "?",
                                "Option...",
                                JOptionPane.YES_NO_OPTION);

                    if(input == 0){
                        C.deleteData(id);
                    }else{
                        input = JOptionPane.showConfirmDialog(null,
                                "do you want to update " + name + "?",
                                "Option...",
                                JOptionPane.YES_NO_OPTION);
                        if(input == 0){
                            new UpdateData(C, id);
                        }
                    }
                }
            });

            btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InputData(C);
             }
            });

            btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 data = C.readData();

                tabel.setModel((new JTable(data, columnName)).getModel());
             }
            });
        }
    }
    
    //Update Data
    class UpdateData extends JFrame {
        int id;

        JFrame window = new JFrame("Update Data Student");

        JLabel lNim = new JLabel("NIM");
        JTextField fNim = new JTextField();

        JLabel lName = new JLabel("NAME");
        JTextField fName = new JTextField();

        JLabel lAge = new JLabel("AGE");
        JTextField fAge = new JTextField();

        JButton btnUpd = new JButton("UPDATE");

        //Parameter controller untuk menghubungkan ke model
        public UpdateData(Controller C, int id){
            this.id = id;
            window.setLayout(null);
            window.setSize(500, 200);
            window.setVisible(true);
            window.setLocationRelativeTo(null);

            window.add(lNim);
            window.add(lName);
            window.add(lAge);
            window.add(fNim);
            window.add(fName);
            window.add(fAge);
            window.add(btnUpd);

             //LABEL
            lNim.setBounds(5, 35, 120, 20);
            lName.setBounds(5, 60, 120, 20);
            lAge.setBounds(5, 85, 120, 20);

            //TEXTFIELD
            fNim.setBounds(150, 35, 120, 20);
            fName.setBounds(150, 60, 120, 20);
            fAge.setBounds(150, 85, 120, 20);

            //BUTTONPANEL
            btnUpd.setBounds(300, 35, 90, 20);

            btnUpd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    C.updateData(id,Integer.parseInt(fNim.getText()), fName.getText(), Integer.parseInt(fAge.getText()));
                }
            });
        }
    }
}
