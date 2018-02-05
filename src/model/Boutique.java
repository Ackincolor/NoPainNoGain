package model;

public class Boutique {
    private String nom;
    private int id, idEmplacement;
    public Boutique(String nom,int id, int idEmplacement)
    {
        this.id = id;
        this.idEmplacement = idEmplacement;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmplacement() {
        return idEmplacement;
    }

    public void setIdEmplacement(int idEmplacement) {
        this.idEmplacement = idEmplacement;
    }
    public String toString()
    {
        return this.nom+";"+this.id+";";
    }
}
