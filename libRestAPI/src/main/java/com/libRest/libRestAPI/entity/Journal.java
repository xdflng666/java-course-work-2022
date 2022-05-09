package com.libRest.libRestAPI.entity;

import com.libRest.libRestAPI.model.JournalModel;
import com.libRest.libRestAPI.model.idModels.JournalIdModel;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class Journal {

    public Journal(){}

    public Journal(Date date_beg, Date date_end, Date date_ret){
        this.date_beg = date_beg;
        this.date_end = date_end;
        this.date_ret = date_ret;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Clients clientId;

    @ManyToOne(optional = false)
    private Books books_id;

    @Column(name = "date_beg", nullable = false)
    private Date date_beg;

    @Column(name = "date_end")
    private Date date_end;

    @Column(name = "date_ret")
    private Date date_ret;

    public JournalModel toModel(){
        return new JournalModel(this.clientId.getFirstName(),
                                this.clientId.getLastName(),
                                this.clientId.getPatherName(),
                                this.books_id.getName(),
                                this.books_id.getCnt(),
                                this.date_beg.toString(),
                                this.date_end.toString(),
                                this.date_ret.toString());
    }

    public JournalIdModel toIdModel(){
        return new JournalIdModel(
                this.id,
                this.clientId.getFirstName(),
                this.clientId.getLastName(),
                this.clientId.getPatherName(),
                this.books_id.getName(),
                this.date_beg.toString(),
                this.date_end.toString(),
                this.date_ret.toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clients getClientId() {
        return clientId;
    }

    public void setClientId(Clients client_id) {
        this.clientId = client_id;
    }

    public Date getDate_beg() {
        return date_beg;
    }

    public void setDate_beg(Date date_beg) {
        this.date_beg = date_beg;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public Date getDate_ret() {
        return date_ret;
    }

    public void setDate_ret(Date date_ret) {
        this.date_ret = date_ret;
    }

    public Books getBooks_id() {
        return books_id;
    }

    public void setBooks_id(Books books_id) {
        this.books_id = books_id;
    }
}
