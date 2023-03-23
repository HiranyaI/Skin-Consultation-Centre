public class Patient extends Person{ //Create patient list class
    private String patient_id;

    public Patient(String name, String surname, String date_of_birth, String mobile_number,int patient_id) {
        super(name, surname, date_of_birth, mobile_number);
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }
}
