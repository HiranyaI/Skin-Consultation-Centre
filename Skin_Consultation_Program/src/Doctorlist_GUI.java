//This class is for the doctor details part

//Import packages
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Doctorlist_GUI extends JFrame { //Create Doctorlist_GUI

    //Get doctor list details
    public static ArrayList<Doctor> doctorList;

    public static void doctorListDataTransfer(ArrayList<Doctor> doctorList2) {
        doctorList = doctorList2;
    }

    Doctorlist_GUI() {
        //Create two panels
        JPanel first_panel = new JPanel(new GridLayout(2, 1));

        JPanel second_panel = new JPanel(new GridBagLayout());

        //Create GridBagConstraints
        GridBagConstraints grid_bag_constraints = new GridBagConstraints();

        //Add insets for components
        grid_bag_constraints.insets = new Insets(5, 5, 5, 5);
        grid_bag_constraints.fill = GridBagConstraints.VERTICAL;
        grid_bag_constraints.gridx = 0;
        grid_bag_constraints.gridy = 0;


        // Initializing the JTable
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
        for (Doctor value : doctorList) {
            table_model.insertRow(i, new String[]{value.getName(), value.getSurname(), String.valueOf(value.getDate_of_birth()), String.valueOf(value.getMobile_number()), Integer.toString(value.getMedical_license_number()), value.getSpecialisation()});
            i++;
        }

        //Add JScrollPane
        JScrollPane sp = new JScrollPane(table);
        first_panel.add(sp);  // Add scroll pane to mainPanel


        //Sort table button
        JButton sort_button = new JButton("Sort Table");
        grid_bag_constraints.gridx = 1;
        grid_bag_constraints.gridy = 0;
        second_panel.add(sort_button, grid_bag_constraints); // Add sort_button to second_panel

        //Create Book consultation button
        JButton book_button = new JButton("Book Doctor");
        grid_bag_constraints.gridx = 1;
        grid_bag_constraints.gridy = 1;
        second_panel.add(book_button, grid_bag_constraints); // Add book_button to second_panel

        first_panel.add(second_panel); // Add second_panel to first_panel

        //Frame details
        JFrame frame = new JFrame(); // Frame initialization
        frame.setTitle("Doctor List"); // Frame Title
        frame.setVisible(true); // Frame Visible = true
        frame.setSize(500, 200); // Frame Size
        frame.setResizable(false); // Not resizable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application

        frame.add(first_panel);

        //book_button button
        book_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (doctorList.isEmpty()==true){
                    JOptionPane.showMessageDialog(null,"Doctor list is empty!");
                }else if(doctorList.isEmpty()==false) {
                    frame.setVisible(false); // Frame Visible = false
                    new Doctor_id();
                }
            }
        });

        //Sort_button button
        sort_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(doctorList.isEmpty()==true){
                    JOptionPane.showMessageDialog(null,"Doctor list is empty!");
                } else if(doctorList.isEmpty()==false) {
                    Alphabetical_order_doctor_list_GUI.doctorListDataTransfer(doctorList);
                    frame.setVisible(false); // Frame Visible = false
                    new Alphabetical_order_doctor_list_GUI();
                    frame.dispose();
                }
            }
        });
    }
}







