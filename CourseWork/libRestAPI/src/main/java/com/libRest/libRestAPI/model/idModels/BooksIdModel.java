package com.libRest.libRestAPI.model.idModels;

public class BooksIdModel {

    public BooksIdModel(Long id, String name, String typeName) {
        this.id = id;
        this.name = name;
        this.typeName = typeName;
    }

    private Long id;

    private String name;

    private String typeName;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
