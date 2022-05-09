package com.libRest.libRestAPI.entity;

import com.libRest.libRestAPI.model.BooksModel;
import com.libRest.libRestAPI.model.idModels.BooksIdModel;

import javax.persistence.*;

@Entity
public class Books {

    public Books(){}

    public Books(String name, Integer cnt){
        this.name = name;
        this.cnt = cnt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cnt", nullable = false)
    private Integer cnt;

    @ManyToOne(optional = false)
    private BookTypes typeId;

    public BooksModel toModel(){
        return new BooksModel(this.getName(), this.getCnt(), this.getTypeId().getName());
    }

    public BooksIdModel toIdModel(){
        return new BooksIdModel(this.id, this.name, this.getTypeId().getName());
    }

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

    public BookTypes getTypeId() {
        return typeId;
    }
    public void setTypeId(BookTypes type_id) {
        this.typeId = type_id;
    }

}
