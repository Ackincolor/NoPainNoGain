package controler;
/**
 * 
 */

/**
 * @author loisg
 *
 */
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import Utils.Fenetre;
import Utils.Database;
import Utils.Constants;
import controler.mapControler;
import vue.Map;
import Utils.PolygonMy;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		String url = "jdbc:mariadb://localhost";
		String user = "root";
		String password = "npng";
		try {
			con = Database.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Fenetre fen = new Fenetre("Prototype");
		fen.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gbl = new GridBagLayout();
		fen.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		//fen.setLayout(new FlowLayout());
		
		Map map = new Map();
		JMenuBar mb = new JMenuBar();
		populate_map(con,map);
		//map.add_polygon(poly3_x, poly3_y);
		//gbc pour le menu
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		//
		//fen.add(mb,gbc);
		//gbc pour la map
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 4;
		gbc.gridheight = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		map.setBackground(Color.BLUE);
		fen.add(map,gbc);
		map.addMouseMotionListener(new mapControler(map));
		fen.setVisible(true);	
	}
	public static void populate_menu(JMenuBar mb)
	{
		mb.add(new JMenu("test"));
	}
	public static void populate_map(Connection con,Map map)
	{
		//les donnée ici serons recuperé depuis la base
		int[] poly1_x = {20,50,50,10,2};
		int[] poly1_y = {10,10,50,50,45};
		
		int[] poly2_x = {50,80,80,50};
		int[] poly2_y = {10,10,50,50};
		
		int[] poly3_x = {30,50,45,30};
		int[] poly3_y = {20,20,80,80};
		
		int[] poly4_x = {30,45,45,30};
		int[] poly4_y = {20,20,80,80};
		//boucle pour recuperer les points contenus dans la BD 
		
		
		PolygonMy poly1 = new PolygonMy(poly3_x,poly3_y,poly3_x.length);
		
		map.add_polygon(poly1_x, poly1_y);
		map.add_polygon(poly2_x, poly2_y);
		map.add_polygon(poly1);
		PolygonMy poly2 = new PolygonMy(poly3_x,poly3_y,poly3_x.length );
		poly2.translate_x(50);
		poly2.translate_y(20);
		map.add_polygon(poly2);
	}

}

