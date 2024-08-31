package model;

import java.io.Serializable;

public class User implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private int id;
    private String name;
    private String mobile;

    public User() {

    }

    public User(int id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

}
