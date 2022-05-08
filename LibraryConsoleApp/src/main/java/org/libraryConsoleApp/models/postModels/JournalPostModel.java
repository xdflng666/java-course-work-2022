package org.libraryConsoleApp.models.postModels;

import java.sql.Date;

public class JournalPostModel {

    public JournalPostModel(Long date_beg, Long date_ret) {
        this.date_beg = date_beg;
        this.date_ret = date_ret;
    }

    private Long date_beg;

    private Long date_ret;

    public Long getDate_beg() {
        return date_beg;
    }

    public void setDate_beg(Long date_beg) {
        this.date_beg = date_beg;
    }

    public Long getDate_ret() {
        return date_ret;
    }

    public void setDate_ret(Long date_ret) {
        this.date_ret = date_ret;
    }
}
