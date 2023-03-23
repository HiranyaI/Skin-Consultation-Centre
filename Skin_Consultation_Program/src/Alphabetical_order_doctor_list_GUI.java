//Importing packages
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Alphabetical_order_doctor_list_GUI extends JFrame { //Creating Alphabetical_order_doctor_list_GUI JFrame class

    //Get doctor list details
    public static ArrayList<Doctor> doctorArrayList;

    public static void doctorListDataTransfer(ArrayList<Doctor> doctorList2) {
        doctorArrayList = doctorList2;

    }
    Alphabetical_order_doctor_list_GUI() {

        //Create a frame
        JFrame frame1 = new JFrame();

        Collections.sort(doctorArrayList, new Comparator<Doctor>() {
            public int compare(Doctor o1, Doctor o2) {
                return Integer.valueOf(o1.getName().compareTo(o2.getName()));
            }
        });

        //Create two panels
        JPanel first_panel = new JPanel(new GridLayout(2, 1)); //Main panel

        JPanel second_panel = new JPanel(new GridBagLayout()); //Sub panel

        // Create GridBagConstraints
        GridBagConstraints grid_bag_constraints = new GridBagConstraints();

        // Add insets for components
        grid_bag_constraints.insets = new Insets(5, 5, 5, 5);
        grid_bag_constraints.fill = GridBagConstraints.VERTICAL;
        grid_bag_constraints.gridx = 0;
        grid_bag_constraints.gridy = 0;


        //Initializing the JTable
        DefaultTableModel table_model = new DefaultTableModel();
        JTable table = new JTable(table_model);
        table.setBounds(30, 40, 200, 300);

        //Add column Names
        table_model.addColumn("Name");
        table_model.addColumn("Surname");
        table_model.addColumn("Date of birth");
        table_model.addColumn("Mobile No.");
        table_model.addColumn("Licence No.");
        table_model.addColumn("Specialization");

        //Add row data
        int i = 0;
        for (Doctor value : doctorArrayList) {
            table_model.insertRow(i, new String[]{value.getName(), value.getSurname(), String.valueOf(value.getDate_of_birth()), String.valueOf(value.getMobile_number()), Integer.toString(value.getMedical_license_number()), value.getSpecialisation()});
            i++;
        }

        //Adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        first_panel.add(sp);  // Add scroll pane to mainPanel


        //Create Menu
        JButton menu_button = new JButton("Menu");
        grid_bag_constraints.gridx = 1;
        grid_bag_constraints.gridy = 0;
        second_panel.add(menu_button, grid_bag_constraints); // Add menu_button to second_panel

        //Create Exit button
        JButton exit_button = new JButton("Exit");
        grid_bag_constraints.gridx = 1;
        grid_bag_constraints.gridy = 1;
        second_panel.add(exit_button, grid_bag_constraints); // Add exit_button to second_panel

        first_panel.add(second_panel); // Add second_panel to first_panel

        //Frame details
        frame1.setTitle("Doctor List Alphabetically"); // Frame Title
        frame1.setVisible(true); // Frame Visible = true
        frame1.setSize(500, 200); // Frame Size
        frame1.setResizable(false); // Not resizable
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application

        //Add panel to frame
        frame1.add(first_panel);

        // Exit button
        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
            }
        });

        // Menu button
        menu_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI_One();
                frame1.dispose();

            }
        });
    }

}







