public class Consultation { //Creating the consultation class

    /*In this class program get patient's info and consultation details.
      Program use this class to do all consultation methods.*/

    //Generating variables for Consultation class
    private int doctor_ID;
    private int patient_ID;
    private String patient_name;
    private String patient_surname;
    private String patient_mobile_number;
    private String date_of_birth;
    private String date_of_consultation;
    private String time;
    private String cost;
    private  String note;

    //Create constructor
    public Consultation(int doctor_ID, int patient_ID, String patient_name, String patient_surname, String patient_mobile_number, String date_of_birth, String date_of_consultation, String time, String cost, String note) {
        this.doctor_ID = doctor_ID;
        this.patient_ID = patient_ID;
        this.patient_name = patient_name;
        this.patient_surname = patient_surname;
        this.patient_mobile_number = patient_mobile_number;
        this.date_of_birth = date_of_birth;
        this.date_of_consultation = date_of_consultation;
        this.time = time;
        this.cost = cost;
        this.note = note;
    }

    //Create getters and setters
    public int getDoctor_ID() {
        return doctor_ID;
    }

    public void setDoctor_ID(int doctor_ID) {
        this.doctor_ID = doctor_ID;
    }

    public int getPatient_ID() {
        return patient_ID;
    }

    public void setPatient_ID(int patient_ID) {
        this.patient_ID = patient_ID;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_surname() {
        return patient_surname;
    }

    public void setPatient_surname(String patient_surname) {
        this.patient_surname = patient_surname;
    }

    public String getPatient_mobile_number() {
        return patient_mobile_number;
    }

    public void setPatient_mobile_number(String patient_mobile_number) {
        this.patient_mobile_number = patient_mobile_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getDate_of_consultation() {
        return date_of_consultation;
    }

    public void setDate_of_consultation(String date_of_consultation) {
        this.date_of_consultation = date_of_consultation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
