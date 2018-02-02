package model;

public class Table {
    private String nom;
    public Table(String nom)
    {
        this.nom = nom;
    }
    @Override
    public String toString()
    {
        return this.nom;
    }
}
