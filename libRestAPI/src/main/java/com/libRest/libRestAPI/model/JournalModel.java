package com.libRest.libRestAPI.model;

public class JournalModel {

    public JournalModel(String first_name, String last_name, String pather_name, String book_name, Integer book_cnt, String date_beg, String date_end, String date_ret) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.pather_name = pather_name;
        this.book_name = book_name;
        this.book_cnt = book_cnt;
        this.date_beg = date_beg;
        this.date_end = date_end;
        this.date_ret = date_ret;
    }

    private String first_name;

    private String last_name;

    private String pather_name;

    private String book_name;

    private Integer book_cnt;

    private String date_beg;

    private String date_end;

    private String date_ret;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPather_name() {
        return pather_name;
    }

    public void setPather_name(String pather_name) {
        this.pather_name = pather_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getBook_cnt() {
        return book_cnt;
    }

    public void setBook_cnt(Integer book_cnt) {
        this.book_cnt = book_cnt;
    }

    public String getDate_beg() {
        return date_beg;
    }

    public void setDate_beg(String date_beg) {
        this.date_beg = date_beg;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getDate_ret() {
        return date_ret;
    }

    public void setDate_ret(String date_ret) {
        this.date_ret = date_ret;
    }
}
