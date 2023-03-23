
public class Person { //Create the "Person" class

    //Create variables for the Person class
    private String name;
    private String surname;
    private String date_of_birth;
    private String mobile_number;

    //Create constructor
    public Person(String name, String surname, String date_of_birth, String mobile_number) {
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.mobile_number = mobile_number;
    }

    //Create getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }


}


