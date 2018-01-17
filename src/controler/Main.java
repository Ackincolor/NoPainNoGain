package controler;

/**
 * 
 */

/**
 * @author loisg
 *
 */
import java.sql.*;
import Utils.Fenetre;
import Utils.Database;
import Utils.Constants;

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
		fen.setVisible(true);
		
	}

}

