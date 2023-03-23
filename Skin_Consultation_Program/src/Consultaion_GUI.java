//Importing packages
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Consultaion_GUI extends JFrame{ //Creating Consultaion_GUI JFrame class

    //Get consultation details
    public static ArrayList<Consultation> final_consultation_details;

    public static void finalConsultationListDataTransfer(ArrayList<Consultation> final_consultation_details2) {
        final_consultation_details = final_consultation_details2;
    }

    public Consultaion_GUI() {{
        //Create two panels
        JPanel first_panel = new JPanel(new GridLayout(2, 1));

        JPanel second_panel = new JPanel(new GridBagLayout());

        // creates a constraints object
        GridBagConstraints grid_bag_constraints = new GridBagConstraints();

        // insets for all components
        grid_bag_constraints.insets = new Insets(5, 5, 5, 5);
        grid_bag_constraints.fill = GridBagConstraints.VERTICAL;
        grid_bag_constraints.gridx = 0;
        grid_bag_constraints.gridy = 0;


        // Initializing the JTable
        DefaultTableModel table_model = new DefaultTableModel();
        JTable table = new JTable(table_model);
        table.setBounds(30, 40, 200, 300);

        //Add column Names
        table_model.addColumn("Doctor ID");
        table_model.addColumn("Name");
        table_model.addColumn("Surname");
        table_model.addColumn("Patient ID");
        table_model.addColumn("Date of birth");
        table_model.addColumn("Mobile No.");
        table_model.addColumn("Cost");
        table_model.addColumn("Consultation date");
        table_model.addColumn("Consultation time");
        table_model.addColumn("Note");

        //Add row data
        int i = 0;
        for (Consultation value : final_consultation_details) {
            table_model.insertRow(i, new String[]{Integer.toString(value.getDoctor_ID()), value.getPatient_name(), value.getPatient_surname(), Integer.toString(value.getPatient_ID()), String.valueOf(value.getDate_of_birth()), String.valueOf(value.getPatient_mobile_number()), String.valueOf(value.getCost()), String.valueOf(value.getDate_of_consultation()), String.valueOf(value.getTime()), String.valueOf(value.getNote())});
            i++;

        }

        //Adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        first_panel.add(sp);  // Add scroll pane to mainPanel


        //Sort table button
        JButton sort_button = new JButton("Menu");
        grid_bag_constraints.gridx = 1;
        grid_bag_constraints.gridy = 0;
        second_panel.add(sort_button, grid_bag_constraints); // Add sort_button to second_panel

        //Create Book consultation button
        JButton book_button = new JButton("Exit");
        grid_bag_constraints.gridx = 1;
        grid_bag_constraints.gridy = 1;
        second_panel.add(book_button, grid_bag_constraints); // Add book_button to second_panel

        first_panel.add(second_panel); // Add second_panel to first_panel

        //Frame details
        JFrame frame1 = new JFrame(); // Frame initialization
        frame1.setTitle("Consultation List"); // Frame Title
        frame1.setVisible(true); // Frame Visible = true
        frame1.setSize(800, 400); // Frame Size
        //frame1.setResizable(false); // Not resizable
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application

        //Add panel to frame
        frame1.add(first_panel);

        //Exit button Actionlistener
        book_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();

            }
        });

        //Back to main menu button Actionlistener
        sort_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false); // Frame Visible = false
                new GUI_One();
                frame1.dispose();
            }
        });
    }

    }
}
