public class Doctor extends Person { //Create "Doctor" class

    //medical license number and specialisation are unique for Doctor class
    private int medical_license_number;
    private String specialisation;

    //Constructor class
    public Doctor(String name, String surname, String date_of_birth, String mobile_number, int medical_license_number, String specialisation) {
        super(name, surname, date_of_birth, mobile_number);
        this.medical_license_number = medical_license_number;
        this.specialisation = specialisation;

    }

    //Create getters and setters
    public int getMedical_license_number() {
        return medical_license_number;
    }

    public void setMedical_license_number(int medical_license_number) {
        this.medical_license_number = medical_license_number;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    //Return these as a string value
    @Override
    public String toString()
    {
        return "Name of the doctor : "+getName() + "\n\tSurname of the doctor : " + getSurname() + "\n\tDate of birth of the doctor : " + getDate_of_birth() + "\n\tMobile number of the doctor : "
                + getMobile_number() + "\n\tMedical license ID  of the doctor : " + this.medical_license_number+ "\n\tSpecialisation  of the doctor : " + this.specialisation;
    }
}

