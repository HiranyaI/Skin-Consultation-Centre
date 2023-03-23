//This is the main menu console of GUI

//Import packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JFrame;


public class GUI_One extends JFrame  { //GUI_One class extends JFrame

    private JRadioButton view_doctor_button;
    private JRadioButton consultation_list_button;
    private JRadioButton exit_button;
    private ButtonGroup button_group;

    private JFrame frame;

    private JLabel welcome_message;

    private JLabel option_message;

    public static ArrayList<Consultation> final_consultation_details_GUI_main;

    public static void finalConsultationGUIListDataTransfer(ArrayList<Consultation> final_consultation_details_GUI_main2) {
        final_consultation_details_GUI_main = final_consultation_details_GUI_main2;
    }


    public GUI_One() {
        JFrame frame = new JFrame(); //Create a new frame
        JLabel welcome_message = new JLabel(); //Create a new label
        JLabel option_message = new JLabel(); // Create another label
        JPanel panel_radio_button=new JPanel();
        JPanel panel_one=new JPanel();
        JPanel panel_two=new JPanel();
        JPanel panel_three=new JPanel();
        //JPanel panel_four=new JPanel();

        view_doctor_button = new JRadioButton("View doctor list"); //Create a radio button to view Doctor list
        consultation_list_button = new JRadioButton("Consultation list"); //Create a radio button to view Consultation list
        exit_button = new JRadioButton("Exit"); //Create a radio button for exit

        button_group = new ButtonGroup();  //Create a new button group
        button_group.add(view_doctor_button);  //Add view doctor list radio button to button_group
        button_group.add(consultation_list_button); //Add consultation radio button to button_group
        button_group.add(exit_button); //Add exit radio button to button_group

        //Add action listener to radio buttons
        view_doctor_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                new Doctorlist_GUI(); //Open Doctorlist_GUI and run
                frame.dispose(); //Close frame
            }
        });
        consultation_list_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                if (final_consultation_details_GUI_main.isEmpty()==true){
                    JOptionPane.showMessageDialog(null,"Consultation list is empty ! ");
                } else if(final_consultation_details_GUI_main.isEmpty()==false){
                    new Consultaion_GUI();
                    frame.dispose(); //Close frame
                }
            }
        });
        exit_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                frame.dispose(); //Close frame
            }
        });

        //Welcome message details
        welcome_message.setFont(new Font("Segoe UI", 1, 18));
        welcome_message.setText("   Welcome! ");

        //Option message details
        option_message.setFont(new Font("Segoe UI", 0, 14));
        option_message.setText("Please select your desired mode : ");

        //Radio button sub panel
        panel_radio_button.setLayout(new GridLayout(3,1));
        panel_radio_button.add(view_doctor_button);
        panel_radio_button.add(consultation_list_button);
        panel_radio_button.add(exit_button);

        //Welcome message sub panel
        panel_two.setLayout(new GridLayout(1,3));
        panel_two.add(new JLabel());
        panel_two.add(welcome_message);
        panel_two.add(new JLabel());

        //Last panel
        panel_three.setLayout(new GridLayout(1,3));
        panel_three.add(new JLabel());
        panel_three.add(panel_radio_button);
        panel_three.add(new JLabel());

        //Big panel
        panel_one.setLayout(new GridLayout(3,1));
        panel_one.add(panel_two);
        panel_one.add(panel_three);
        panel_one.add(new JLabel());

        //Frame details
        frame.setSize(481, 410);
        frame.setBackground(new Color(102, 255, 102));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Westminster Skin Consultation Manager");

        //Add panel to the frame
        frame.add(panel_one);
    }
}