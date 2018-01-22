package Utils;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controler.mapControler;
import model.RightPanel;
import vue.Map;
import vue.RightPanelVue;

public class Fenetre extends JFrame implements Runnable{
	private Map map;
	private JMenuBar mb;
	public Fenetre(String name,Connection con)
	{
		super(name);
		this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.map = new Map();
		JMenuBar mb = new JMenuBar();
		
		//map.add_polygon(poly3_x, poly3_y);
		//gbc pour le menu
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 6.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 6;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		//pour la bar de menu
		this.mb = new JMenuBar();
		populate_menu();
		this.add(this.mb);
		//gbc pour la map
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.gridwidth = 5;
		gbc.gridheight = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		map.setBackground(Color.BLUE);
		this.add(map,gbc);
		gbc.gridx = 5;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.5;
		gbc.gridwidth = 1;
		gbc.gridheight = 5;
		gbc.anchor = GridBagConstraints.LINE_END;
		RightPanelVue rpv = new RightPanelVue();
		this.add(rpv,gbc);
		RightPanel rp = new RightPanel(con);
		rp.setVue(rpv);
		map.set_rightPanel(rp);
		mapControler mpc = new mapControler(map);
		map.addMouseMotionListener(mpc);	
		map.addMouseListener(mpc);
	}
	public void populate_menu()
	{
		JMenu filemenu = new JMenu("File");
        JMenuItem open = new JMenuItem("Ouvrir");
        JMenuItem save = new JMenuItem("Sauvegarder");
        filemenu.add(open);
        filemenu.add(save);
        
        this.mb.add(filemenu);
        
        JMenu editmenu = new JMenu("Edit");
        this.mb.add(editmenu);

        
        JMenu viewmenu = new JMenu("View");

        JMenuItem piano = new JMenuItem("Ouvrir Piano");
        viewmenu.add(piano);
         JMenuItem rythme = new JMenuItem("Ouvrir rythme");
        JMenuItem accueil = new JMenuItem("Accueil");
        viewmenu.add(accueil);
        viewmenu.add(rythme);
        viewmenu.addSeparator();
        //viewmenu.add(color);
        this.mb.add(viewmenu);
	}
	public void populate_map(Connection con)
	{
		//les donnée ici serons recuperé depuis la base
		String requete = "SELECT coord_X, coord_Y, id_emplacement FROM Emplacement_points";
		ArrayList<PolygonMy> polyTab = new ArrayList<PolygonMy>();
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(requete);
			int curID = 0;
			PolygonMy poly = null;
			
			int index =0;
			while(res.next())
			{
				int x = res.getInt(1);
				int y = res.getInt(2);
				
				int id = res.getInt(3);
				if(id!=curID)
				{
					curID = id;
					polyTab.add(index,new PolygonMy());
					polyTab.get(index).setEmplacement(id);
					polyTab.get(index).addPoint(x, y);
					index++;
				}
				else
				{
					polyTab.get(index-1).addPoint(x, y);
				}
				//System.out.println("x:"+x+";y:"+y+";id:"+id);
			}
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(PolygonMy poly : polyTab)
		{
			poly.setnew();
			this.map.add_polygon(poly);
		}
		this.repaint();
		//boucle pour recuperer les points contenus dans la BD 
		
		/*
		PolygonMy poly1 = new PolygonMy(poly3_x,poly3_y,poly3_x.length);
		
		this.map.add_polygon(poly1_x, poly1_y);
		this.map.add_polygon(poly2_x, poly2_y);
		this.map.add_polygon(poly1);
		PolygonMy poly2 = new PolygonMy(poly3_x,poly3_y,poly3_x.length );
		poly2.translate_x(50);
		poly2.translate_y(20);
		this.map.add_polygon(poly2);*/
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		this.map.refresh();
		this.repaint();
	}
}
