package org.libraryConsoleApp.models.dialogModels;

public class ClientsIdModel {

    public ClientsIdModel(Long id, String firstName, String lastName, String patherName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patherName = patherName;
    }

    private Long id;

    private String firstName;

    private String lastName;

    private String patherName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

}
