package com.libRest.libRestAPI.model.idModels;

public class JournalIdModel {

    public JournalIdModel(Long id, String firstName, String lastName, String patherName, String bookName, String dateBeg, String dateEnd, String dateRet) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patherName = patherName;
        this.bookName = bookName;
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.dateRet = dateRet;
    }

    private Long id;

    private String firstName;

    private String lastName;

    private String patherName;

    private String bookName;

    private String dateBeg;

    private String dateEnd;

    private String dateRet;

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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDateBeg() {
        return dateBeg;
    }

    public void setDateBeg(String dateBeg) {
        this.dateBeg = dateBeg;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDateRet() {
        return dateRet;
    }

    public void setDateRet(String dateRet) {
        this.dateRet = dateRet;
    }
}
