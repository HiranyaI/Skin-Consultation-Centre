//Import packages
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    //Create Scanner for user inputs
    static Scanner user_input = new Scanner(System.in);

    //Access Doctor class using "Arraylist"
    static ArrayList<Doctor> doctor_list = new ArrayList<Doctor>();

    //Access consultation class using "Arraylist"
    static ArrayList<Consultation> consultation_list_main = new ArrayList<Consultation>();

    //Access Doctor_ids class using "Arraylist"
    static ArrayList<Doctor_ids> doctor_id_inputs = new ArrayList<Doctor_ids>();

    //Access Doctor for list
    static ArrayList<Doctor> new_array=new ArrayList<Doctor>();


    //Main
    public static void main(String[] args) {

        System.out.println("\n ----Welcome to Skin Consultation Centre ! ---- \n"); //Menu welcome message

        Menu(); //User will direct to the Menu which will show the user options

    }

    //Menu
    private static void Menu() {

        System.out.println("""
                Your options are below
                1  or AD   : Add a doctor
                2  or DD   : Delete a doctor
                3  or VDL  : View the list of doctors
                4  or DSIF : Save doctors list in a file
                5  or DRTF : Read the doctor text file
                6 or CD    : User interface
                9 or EXT   : Exit the program
                """);
        validate(); //User will direct to Validate method
    }

    //Validate
    private static void validate() {
        /*
            In this system will get user input and redirect to whichever user selects.
            If user enters invalid inputs it'll prompt an error.
        */

        System.out.print("Choose Your Option: ");

        //Getting user inputs
        String user_input = WestminsterSkinConsultationManager.user_input.nextLine();
        user_input = user_input.toUpperCase();
        System.out.println("\n");

        while (true) {
            switch (user_input) {
                case "1":
                case "AD":
                    get_doctor_details();
                    break;
                case "2":
                case "DD":
                    delete_a_doctor();
                    break;
                case "3":
                case "VDL":
                    view_doctor_list();
                    break;
                case "4":
                case "DSIF":
                    save_doctor_list_in_a_file();
                    break;
                case "5":
                case "DRTF":
                    read_the_saved_file();
                    break;
                case "6":
                case "UI":
                    user_interface();
                    break;
                case "9":
                case "EXT":
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("\nError please try again with a valid input! \n");

            }

            /*Try again

                If user select "yes" then the program will run again,
                but if he select "no" program will show a thank you message and end the program.
             */

            System.out.print("Would you like to continue? answer(Y/y[yes] or N/n[no]): ");
            String answer = WestminsterSkinConsultationManager.user_input.next();

            /*
              If user enters a capital letter it'll convert into a simple letter.
              For an example,
                     if user enters "Y" , then it'll convert to "y".
                     if user enters "y", then it'll remain "y"
            */

            answer = answer.toLowerCase();
            if (answer.equals("y")) {
                WestminsterSkinConsultationManager.user_input.nextLine();
                Menu();
            }
            if (answer.equals("n")) {
                System.out.println("\n-----Thank you!-----\n");
                break;
            }
            break;
        }
    }

    //Get doctor details
    private static void get_doctor_details() {

        if (doctor_list.size() == 10) {
            System.out.println("Sorry the doctor list is full! \nPlease try again later"); //If doctor list size is equal or more than 10 an error will appear
        } else {
            System.out.print("1. Please enter the name of doctor : "); //Get doctor's name from user
            String doctor_name = user_input.next();
            doctor_name=capitalize(doctor_name); //Capitalize the first letter

            if (isNumeric(doctor_name) == false) {
                System.out.print("2. Please enter the surname of doctor : "); //Get doctor's surname from user
                String doctor_surname = user_input.next();
                doctor_surname=capitalize(doctor_surname); //Capitalize the first letter

                if (isNumeric(doctor_surname) == false) {
                    System.out.print("3. Please enter the specialisation of doctor : "); //Get doctor's specialization from user
                    String doctor_specialisation = user_input.next();
                    doctor_specialisation=capitalize(doctor_specialisation); //Capitalize the first letter

                    if (isNumeric(doctor_specialisation) == false) {
                        System.out.println("4. Please enter the date of birth of doctor, "); //Get doctor's date of birth from user
                        System.out.print("\tDay : "); //Get doctor's day of birth from user
                        String date = user_input.next();
                        if (isNumeric(date) == true && Integer.valueOf(date)<=31) {
                            System.out.print("\tMonth : "); //Get doctor's month of birth from user
                            String month = user_input.next();
                            if (isNumeric(month) == true && Integer.valueOf(month)<=12) {
                                System.out.print("\tYear : "); //Get doctor's year of birth from user
                                String year = user_input.next();
                                System.out.println("\n");
                                if (isNumeric(year) == true) {
                                    String doctor_date_of_birth = date.concat("/" + month + "/" + year); //Connect day, month, year using concat
                                    System.out.print("5. Please enter the mobile number of doctor : "); //Get doctor's mobile number from user
                                    String doctor_mobile_number = user_input.next();

                                    if (isNumeric(doctor_mobile_number) == true) {
                                        System.out.print("6. Please enter the medical license number of doctor : "); //Get doctor's medical license number from user
                                        int doctor_medical_license_number = user_input.nextInt();
                                        System.out.println("\n");
                                        if (isNumeric(String.valueOf(doctor_medical_license_number)) == true) {
                                            //Save user entered data to "Doctor" class
                                            Doctor doctor_one = new Doctor(doctor_name, doctor_surname, doctor_date_of_birth, doctor_mobile_number, doctor_medical_license_number, doctor_specialisation);
                                            doctor_list.add(doctor_one);
                                            new_array.add(doctor_one);
                                        } else {
                                            System.out.println("Error, Please enter a  valid integer for doctor medical license number.");
                                            System.out.println("\n");
                                        }
                                    } else {
                                        System.out.println("Error, Please enter a valid input as mobile number of doctor.");
                                        System.out.println("\n");
                                    }
                                } else {
                                    System.out.println("Error, Please enter a valid input as year of birth.");
                                    System.out.println("\n");
                                }
                            } else {
                                System.out.println("Error, Please enter a valid input as month of birth.");
                                System.out.println("\n");
                            }
                        } else {
                            System.out.println("Error, Please enter a valid input as day of birth.");
                            System.out.println("\n");
                        }
                    } else {
                        System.out.println("Error, Please enter a valid input as specialisation of doctor.");
                        System.out.println("\n");
                    }
                } else {
                    System.out.println("Error, Please enter a valid input as surname of doctor.");
                    System.out.println("\n");
                }
            } else {
                System.out.println("Sorry, Please enter a valid input as name of doctor.");
                System.out.println("\n");
            }
        }
    }

    //To view all the names of doctors I'm using this function
    private static void view_doctor_list() {
        //If the quantity is more than or equal to ten it will prompt an error
        if (doctor_list.size() == 0) {
            System.out.println("The doctor list is empty!");
        } //If quantity is less than til the program will continue
        else {
            //Sort ou in alphabetical order
            Collections.sort(new_array, new Comparator<Doctor>() {
                public int compare(Doctor o1, Doctor o2) {
                    return Integer.valueOf(o1.getSurname().compareTo(o2.getSurname()));
                }
            });
            System.out.println("------------------------------- List of Doctors -------------------------------");
            System.out.println("\n");
            for (Doctor doctor_print : new_array) { //Get data through arraylist and view the doctor details
                for (int i = 1; i <= 1; i++) {
                    System.out.println(doctor_print);
                    System.out.println("\n");
                    System.out.println("---------------------------------------------------------------------------------");
                }
            }
        }
    }

    //Delete a doctor from the list
    private static void delete_a_doctor() {
        //If doctor list is not empty program will continue
        if (doctor_list.size() != 0) {
            //Getting user inputs for doctor medical ID to delete a doctor
            System.out.print("Please select doctor's medical ID to delete from list : ");
            String delete_a_doctor = user_input.next();
            System.out.println("\n");
            if (isNumeric(String.valueOf(delete_a_doctor)) == true) {
                for (int i=0;i<=doctor_list.size();i++) {
                    if (doctor_list.get(i).getMedical_license_number()==Integer.valueOf(delete_a_doctor)) {
                        for (Doctor value : doctor_list) {
                            if (value.getMedical_license_number() == Integer.parseInt(delete_a_doctor)) {
                                System.out.println(value);
                                System.out.println("Total number of doctors in the list = " + doctor_list.size());
                                int index = doctor_list.indexOf(value);
                                doctor_list.remove(index);
                                System.out.println("\n");
                                System.out.println("Successfully removed a doctor"); //After removing a doctor successfully this message will appear
                                System.out.println("\n");
                                break;
                            }
                            break;
                        }for (Doctor value : new_array) {
                            if (value.getMedical_license_number() == Integer.parseInt(delete_a_doctor)) {
                                int index = new_array.indexOf(value);
                                new_array.remove(index);
                                break;
                            }
                            break;
                        }
                        break;
                    }else if(doctor_list.get(i).getMedical_license_number()!=Integer.valueOf(delete_a_doctor)){
                        System.out.println("Error,Please enter a valid input.");
                        break;
                    }
                }
            } else {
                System.out.println("Error, Please enter a valid input."); //If user input is a string it will prompt an error
                System.out.println("\n");
            }
        } else {
            System.out.println("The doctor list is empty"); //If the list is empty it will prompt an error
            System.out.println("\n");
        }
    }

    //Save doctor details to a text file
    private static void save_doctor_list_in_a_file() {
        try {
            FileWriter filewriter = new FileWriter("Output.txt"); //new FileWriter
            filewriter.write("------------------------------- List of Doctors -------------------------------" + "\n");
            filewriter.write("\n");

            //Print doctor details in the file
            for (int i = 0; i < doctor_list.size(); i++) {
                filewriter.write((i + 1) + ". " + "Dr." + doctor_list.get(i).getName() + " " + doctor_list.get(i).getSurname() + "\n");
                filewriter.write("\t Date of birth : " + doctor_list.get(i).getDate_of_birth() + "\n");
                filewriter.write("\t Mobile number : " + doctor_list.get(i).getMobile_number() + "\n");
                filewriter.write("\t Medical license number : " + doctor_list.get(i).getMedical_license_number() + "\n");
                filewriter.write("\t Specialisation : " + doctor_list.get(i).getSpecialisation());
                filewriter.write("\n");
                filewriter.write("------------------------------------------------------------");
                filewriter.write("\n");
            }
            filewriter.close(); //Close the FileWriter
            System.out.println("Data has been successfully Stored in a file.");
        } catch (IOException e) {
            System.out.println("Sorry an error occurred.");
            e.printStackTrace();
        }
    }

    //Read the saved text file
    private static void read_the_saved_file() {
        try {
            File object = new File("Output.txt"); //Open the file
            Scanner reader = new Scanner(object);
            while (reader.hasNextLine()) {
                String info = reader.nextLine();
                System.out.println(info);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    private static String capitalize(String word){
        String first_letter_of_the_word=word.substring(0,1);
        String capitalized_word=first_letter_of_the_word.toUpperCase()+word.substring(1);
        return capitalized_word;
    }

    //User Interface
    private static void user_interface() {
        Doctorlist_GUI.doctorListDataTransfer(doctor_list); //Transfer "doctor_list" data to GUI
        Patientlist_GUI.consultationListDataTransfer(consultation_list_main);
        GUI_One.finalConsultationGUIListDataTransfer(consultation_list_main);
        Doctor_id.checkDoctorListDataTransfer(consultation_list_main);
        Doctor_id.doctor_id_check(doctor_id_inputs);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_One();
            }
        });
    }

    //Checking user inputs
    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }
}



