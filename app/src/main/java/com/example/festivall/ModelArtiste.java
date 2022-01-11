package com.example.festivall;

public class ModelArtiste {

    private String nom;
    private String prenom;
    private String nomArtiste;
    private String age;
    private String sexe;
    private String style;
    private String photo;
    public ModelArtiste(){};
    public ModelArtiste(String nom, String prenom, String nomArtiste, String age, String sexe, String style, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.nomArtiste = nomArtiste;
        this.age = age;
        this.sexe = sexe;
        this.style = style;
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomArtiste() {
        return nomArtiste;
    }

    public void setNomArtiste(String nomArtiste) {
        this.nomArtiste = nomArtiste;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
