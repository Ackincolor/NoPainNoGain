package model;

import utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
