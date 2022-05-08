package org.libraryConsoleApp.models.getModels;

public class Clients {

    public Clients(String firstName, String lastName, String patherName, String passportSeria, String passportNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patherName = patherName;
        this.passportSeria = passportSeria;
        this.passportNum = passportNum;
    }

    private String firstName;

    private String lastName;

    private String patherName;

    private String passportSeria;

    private String passportNum;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatherName() {
        return patherName;
    }

    public void setPatherName(String patherName) {
        this.patherName = patherName;
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }
}
