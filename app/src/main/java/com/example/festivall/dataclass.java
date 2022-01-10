package com.example.festivall;

import android.media.audiofx.AudioEffect;

public class dataclass {
    String id;
    String nom;
    String lieu;
    String datedebut;
    String Description;
    String photo;

    public dataclass( String nom, String lieu, String datedebut, String description,String photo) {

        this.nom = nom;
        this.lieu = lieu;
        this.datedebut = datedebut;
        this.Description = description;
        this.photo= photo;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
