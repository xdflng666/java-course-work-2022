package org.libraryConsoleApp.models.getModels;

public class BookTypes {

    public BookTypes(String name, Integer cnt, Integer fine, Integer day_count) {
        this.name = name;
        this.cnt = cnt;
        this.fine = fine;
        this.day_count = day_count;
    }

    private String name;

    private Integer cnt;

    private Integer fine;

    private Integer day_count;

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
