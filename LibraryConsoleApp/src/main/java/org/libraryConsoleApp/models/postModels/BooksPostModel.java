package org.libraryConsoleApp.models.postModels;

public class BooksPostModel {

    public BooksPostModel(String name, Integer cnt) {
        this.name = name;
        this.cnt = cnt;
    }

    private String name;

    private Integer cnt;

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
}
