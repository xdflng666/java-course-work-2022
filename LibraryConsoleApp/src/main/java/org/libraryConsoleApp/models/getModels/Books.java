package org.libraryConsoleApp.models.getModels;

public class Books {

    public Books(String name, Integer cnt, String typeName) {
        this.name = name;
        this.cnt = cnt;
        this.typeName = typeName;
    }

    private String name;

    private Integer cnt;

    private String typeName;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
