package view;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Table;
import utils.Constants;
import utils.MyListModel;

import javax.swing.*;

public class Fenetre extends JFrame implements Runnable{
    private JPanel panelgauche;
    private JButton listTable;
    private JPanel panelCentre;
    private ArrayList<Table> listeTable;
    public Fenetre()
    {
        super();
        this.setTitle("Proto_IHM");
        this.setSize(new Dimension(Constants.WIDTH,Constants.HEIGHT));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.ajouterBouton();
        this.listeTable = new ArrayList<>();
        this.populatePanelCentre();
    }
    private void ajouterBouton()
    {
        this.panelgauche = new JPanel();
        this.listTable = new JButton("liste des tables");
        this.panelgauche.add(this.listTable);
        this.getContentPane().add(this.panelgauche);
    }
    private void populatePanelCentre()
    {
        this.panelCentre = new JPanel();

        ResultSet res = Constants.DB.getListeTable();
        try
        {
            while(res.next())
            {
                this.listeTable.add(new Table(res.getString(1)));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        //creation du model
        MyListModel<Table> listeModel = new MyListModel<>(this.listeTable);
        JList jlist = new JList(listeModel);
        this.panelCentre.add(jlist);
        this.add(this.panelCentre);

    }
    @Override
    public void run() {
        this.setVisible(true);
    }
}
