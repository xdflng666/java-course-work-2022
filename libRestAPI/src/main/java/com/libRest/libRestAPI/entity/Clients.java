package com.libRest.libRestAPI.entity;

import com.libRest.libRestAPI.model.idModels.ClientsIdModel;

import javax.persistence.*;

@Entity
public class Clients {

    public Clients(){}

    public Clients(String first_name, String last_name, String pather_name, String passport_seria, String passport_num){
        this.firstName = first_name;
        this.lastName = last_name;
        this.patherName = pather_name;
        this.passportSeria = passport_seria;
        this.passportNum = passport_num;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "pather_name")
    private String patherName;

    @Column(name = "passport_seria", nullable = false)
    private String passportSeria;

    @Column(name = "passport_num", nullable = false, unique = true)
    private String passportNum;

    public ClientsIdModel toIdModel(){
        return new ClientsIdModel(
                this.id,
                this.firstName,
                this.lastName,
                this.patherName
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getPatherName() {
        return patherName;
    }

    public void setPatherName(String pather_name) {
        this.patherName = pather_name;
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passport_seria) {
        this.passportSeria = passport_seria;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passport_num) {
        this.passportNum = passport_num;
    }
}
