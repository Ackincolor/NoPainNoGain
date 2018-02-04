package view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Table;
import utils.Constants;
import utils.MyListModel;

import javax.swing.*;

public class Fenetre extends JFrame implements Runnable{
    private JPanel panelDroit;
    private JButton listTable;
    private JPanel panelGauche;
    private ArrayList<Table> listeTable;
    private String selectedTable;
    public Fenetre()
    {
        super();
        this.setTitle("Proto_IHM");
        this.setSize(new Dimension(Constants.WIDTH,Constants.HEIGHT));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.ajouterBouton();
        this.listeTable = new ArrayList<>();
        this.populatepanelGauche();
    }
    private void ajouterBouton()
    {
        this.panelDroit = new JPanel();
        this.listTable = new JButton("liste des tables");
        this.panelDroit.add(this.listTable);
        this.getContentPane().add(this.panelDroit,BorderLayout.WEST);
    }
    private void afficherTable() {

        ResultSet res = Constants.DB.getValueTable(this.selectedTable);
        try {
            ResultSetMetaData rsMetaData = res.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();
            //recuperation des info
            Array[] values = new Array[numberOfColumns];
            for(int i=0;i<numberOfColumns;i++) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void populatepanelGauche()
    {
            this.panelGauche = new JPanel();

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
        jlist.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedTable = ((Table)jlist.getSelectedValue()).toString();
                afficherTable();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.panelGauche.add(jlist);
        this.add(this.panelGauche,BorderLayout.CENTER);

    }
    @Override
    public void run() {
        this.setVisible(true);
    }
}
