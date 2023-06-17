package com.example.project_equipment;

public class booking_information {

    String name;
    String EmaiL;
    String phonenumber;
    String Equnam;
    String Date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmaiL() {
        return EmaiL;
    }

    public void setEmaiL(String emaiL) {
        EmaiL = emaiL;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }



    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEqunam() {
        return Equnam;
    }

    public void setEqunam(String equnam) {
        Equnam = equnam;
    }

    public booking_information(String name, String Email, String phonenumber, String Equnam , String Date) {
        this.name = name;
        this.EmaiL=Email;
        this.phonenumber=phonenumber;
        this.Equnam = Equnam;
        this.Date=Date;
    }

    public booking_information() {
    }
}
