package com.libRest.libRestAPI.entity;

import com.libRest.libRestAPI.model.idModels.BookTypesIdModel;

import javax.persistence.*;

@Entity
public class BookTypes {

    public BookTypes(){}

    public BookTypes(String name, Integer cnt, Integer fine, Integer day_count){
        this.name = name;
        this.cnt = cnt;
        this.fine = fine;
        this.day_count = day_count;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cnt", nullable = false)
    private Integer cnt;

    @Column(name = "fine", nullable = false)
    private Integer fine;

    @Column(name = "day_count", nullable = false)
    private Integer day_count;

    public BookTypesIdModel toIdModel(){return new BookTypesIdModel(this.id, this.name);}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Integer getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }

    public Integer getDay_count() {
        return day_count;
    }

    public void setDay_count(Integer day_count) {
        this.day_count = day_count;
    }
}
