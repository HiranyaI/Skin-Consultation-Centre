//This class is for Patient details GUI part

//Import packages
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Patientlist_GUI extends JFrame { //Create Patientlist_GUI
    private JButton jButton1;
    private JTextField patient_name;
    private JTextField patient_surname;
    private JTextField day_of_birth;
    private JTextField month_of_birth;
    private JTextField year_of_birth;
    private JTextField patient_mobile_number;
    private JTextField patient_ID;
    private JFrame frame;
    private JTextField doctor_id;

    public static ArrayList<Doctor_ids> doctor_id_list;

    public static void doctorIDDataTransfer(ArrayList<Doctor_ids> doctor_id_list2) {
        doctor_id_list = doctor_id_list2;
    }

    //Get Consultation class as an Arraylist
    public static ArrayList<Consultation> consultation_list;

    public static void consultationListDataTransfer(ArrayList<Consultation> consultation_list2) {
        consultation_list = consultation_list2;
    }


    public Patientlist_GUI() {
        //Create a new frame
        JFrame frame = new JFrame();

        //Create a new panel
        JPanel panel = new JPanel();

        //Create JTextField
        JTextField patient_name = new JTextField();
        JTextField patient_surname = new JTextField();
        JTextField day_of_birth = new JTextField();
        JTextField month_of_birth = new JTextField();
        JTextField year_of_birth = new JTextField();
        JTextField patient_mobile_number = new JTextField();
        JTextField patient_ID = new JTextField();
        JTextField newt=new JTextField();
        JTextField day_of_consultation=new JTextField();
        JTextField month_of_consultation=new JTextField();
        JTextField year_of_consultation=new JTextField();
        JTextField time_of_consultation=new JTextField();
        JTextField cost_for_consultation=new JTextField();
        JTextField note_for_consultation=new JTextField();

        //Create JLabel
        JLabel empty=new JLabel();
        JLabel empty_two=new JLabel();
        JLabel message_d_id=new JLabel();
        JLabel message=new JLabel();
        JLabel message_two=new JLabel();
        //JLabel doctor_id=new JLabel();

        //doctor_id.setText(String.valueOf(doctor_id_list.get(doctor_id_list.size()).getDoctor_id()));

        //Create a JButton
        JButton button1 = new JButton("Book");

        //message details
        message_d_id.setFont(new Font("Segoe UI", 1, 15));
        message_d_id.setText("Please enter doctor id, ");

        //message details
        message.setFont(new Font("Segoe UI", 1, 15));
        message.setText("Please enter patient details,");

        //message details
        message_two.setFont(new Font("Segoe UI", 1, 15));
        message_two.setText("Please enter consultation details,");

        panel.setBackground(Color.lightGray);

        //Frame details
        frame.setSize(481, 410);
        frame.setBackground(new Color(0,0,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Patient Details");
        frame.setResizable(false);


        //Add action listener to button
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                //Get JTextField user inputs as Strings and int
                String name = patient_name.getText();
                String surname = patient_surname.getText();
                String day = day_of_birth.getText();
                String month = month_of_birth.getText();
                String year = year_of_birth.getText();
                String date_of_birth = day.concat("/" + month + "/" + year);
                int p_id = Integer.parseInt(patient_ID.getText());
                int d_id = Integer.parseInt(newt.getText());
                String mobile_number = patient_mobile_number.getText();
                String doc = day_of_consultation.getText();
                String moc = month_of_consultation.getText();
                String yoc = year_of_consultation.getText();
                String consultation_date = doc.concat("/" + moc + "/" + yoc);
                String cost = String.valueOf(Integer.valueOf(cost_for_consultation.getText())*25);
                String notes = note_for_consultation.getText();
                String time = time_of_consultation.getText();

                Consultation consultation_one = new Consultation(d_id, p_id, name, surname, mobile_number, date_of_birth, consultation_date, time, cost, notes);
                consultation_list.add(consultation_one);

                Consultaion_GUI.finalConsultationListDataTransfer(consultation_list);

                new Consultaion_GUI();
                frame.dispose();
            }
        });

        //Creating the panel using GridLayout
        panel.setLayout(new GridLayout(18, 2));
        panel.add(message_d_id);
        panel.add(new JLabel());
        panel.add(new JLabel("1. Doctor id : "));
        panel.add(newt);
        panel.add(message);
        panel.add(new JLabel());
        panel.add(new JLabel("1. Patient Name : "));
        panel.add(patient_name);
        panel.add(new JLabel("2. Patient Surname : "));
        panel.add(patient_surname);
        panel.add(new JLabel("3. Day of Birth : "));
        panel.add(day_of_birth);
        panel.add(new JLabel("4. Month of Birth : "));
        panel.add(month_of_birth);
        panel.add(new JLabel("5. Year of Birth : "));
        panel.add(year_of_birth);
        panel.add(new JLabel("5. Mobile number : "));
        panel.add(patient_mobile_number);
        panel.add(new JLabel("6. Patient ID : "));
        panel.add(patient_ID);
        panel.add(message_two);
        panel.add(empty);
        panel.add(new JLabel("1. Day of Consultation : "));
        panel.add(day_of_consultation);
        panel.add(new JLabel("2. Month of Consultation : "));
        panel.add(month_of_consultation);
        panel.add(new JLabel("3. Year of Consultation : "));
        panel.add(year_of_consultation);
        panel.add(new JLabel("4. Time of Consultation : "));
        panel.add(time_of_consultation);
        panel.add(new JLabel("5. Cost for Consultation : "));
        panel.add(cost_for_consultation);
        panel.add(new JLabel("6. Note for Consultation : "));
        panel.add(note_for_consultation);
        panel.add(empty_two);
        panel.add(button1);

        //Add panel to frame
        frame.add(panel);
    }
}
