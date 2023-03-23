//Importing packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Doctor_id extends JFrame { //Creating Doctor_id class

    private JFrame frame;

    //Import doctor_id details
    public static ArrayList<Doctor_ids> doctor_id;

    public static void doctor_id_check(ArrayList<Doctor_ids> doctor_id2) {
        doctor_id = doctor_id2;
    }

    //Import consultation details
    public static ArrayList<Consultation> cList;

    public static void checkDoctorListDataTransfer(ArrayList<Consultation> doctorList2) {
        cList = doctorList2;
    }

    Doctor_id(){ //Doctor id JFrame class
        JFrame frame=new JFrame("Doctor Medical ID"); //New frame
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JTextField textField=new JTextField(); //New JTextfield
        JButton button=new JButton("Next"); //New button
        JPanel panel_one=new JPanel(); //New panel
        JPanel panel_two=new JPanel(); //New panel
        JPanel panel_three=new JPanel(); //New panel

        panel_two.setLayout(new GridLayout(3,2));
        panel_two.add(new JLabel());
        panel_two.add(new JLabel());
        panel_two.add(new JLabel("Doctor ID : "));
        panel_two.add(textField);
        panel_two.add(new JLabel());
        panel_two.add(new JLabel());

        panel_three.setLayout(new GridLayout(3,3));
        panel_three.add(new Label());
        panel_three.add(new Label());
        panel_three.add(new Label());
        panel_three.add(new Label());
        panel_three.add(button);
        panel_three.add(new Label());
        panel_three.add(new Label());
        panel_three.add(new Label());
        panel_three.add(new Label());


        panel_one.setLayout(new GridLayout(2,1));
        panel_one.add(panel_two);
        panel_one.add(panel_three);

        // Add panel to frame
        frame.add(panel_one);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = textField.getText();
                if(cList.isEmpty()==true) {
                    int text_field_input=Integer.parseInt(textField.getText());
                    new Patientlist_GUI();
                    frame.dispose();
                }else if (cList.isEmpty()==false){
                    for (int i=0;i<=cList.size();i++) {
                        if (cList.get(i).getDoctor_ID() == Integer.valueOf(s)) {
                            JOptionPane.showMessageDialog(null, "This doctor is booked!");

                        } else {
                            int text_field_input=Integer.parseInt(textField.getText());
                            new Patientlist_GUI();
                            frame.dispose();
                        }
                    }
                }
            }
        });
    }
}
