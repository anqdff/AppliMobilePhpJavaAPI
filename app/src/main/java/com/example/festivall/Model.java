package com.example.festivall;

public class Model {
     private String nom,lieu,datedebut,description,image;

     public Model(){

     }
    public Model(String nom, String lieu, String datedebut, String description,String image) {
        this.nom = nom;
        this.lieu = lieu;
        this.datedebut = datedebut;
        this.description = description;
        this.image=image;
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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
