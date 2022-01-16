package nus.edu.workshop14.model;

import java.io.Serializable;

//remember to implement serializable
public class Contacts implements Serializable {
    private String name;
    private String email;
    private int phoneNumber;
    private String id;


    public Contacts() {
        this.id = randomHex();
    }

    public Contacts(String name, String email, int phoneNumber, String id) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    //Use syncro?
    public String randomHex() {
        int minValue = 0;
        //max interger value use for the upper bound to generate the hex number
        int maxValue = Integer.MAX_VALUE;
        int ranNum = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
        String hexValue = Integer.toHexString(ranNum);
        return hexValue;
    }
}