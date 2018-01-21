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
		String url = "jdbc:mariadb://localhost/pdstest";
		String user = "root";
		String password = "";
		try {
			con = Database.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Fenetre fen = new Fenetre("Prototype",con);
		javax.swing.SwingUtilities.invokeLater(fen);
		fen.populate_map(con);
	}
}

