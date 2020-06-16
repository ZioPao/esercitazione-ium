//Alessandro Picchetti 65524

package com.example.esercitazioneBonus.model;

public class User {

    String username;
    String password;
    String city;
    String date;

    public User(String username, String password, String city, String date){

        this.username = username;
        this.password = password;
        this.city = city;
        this.date = date;
    }


    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
    public String getCity(){
        return city;
    }

    public String getDate(){
        return date;
    }


    public void setPassword(String password){this.password = password;}

}
