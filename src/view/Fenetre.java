package view;

import java.awt.*;
import java.sql.SQLException;

import utils.Constants;

import javax.swing.*;

public class Fenetre extends JFrame implements Runnable{
    private JPanel panelgauche;
    private JButton listTable;
    public Fenetre()
    {
        super();
        this.setTitle("Proto_IHM");
        this.setSize(new Dimension(Constants.WIDTH,Constants.HEIGHT));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.ajouterBouton();

    }
    private void ajouterBouton()
    {
        this.panelgauche = new JPanel();
        this.listTable = new JButton("liste des tables");
        this.panelgauche.add(this.listTable);
        this.getContentPane().add(this.panelgauche);
    }
    @Override
    public void run() {
        this.setVisible(true);
    }
}
