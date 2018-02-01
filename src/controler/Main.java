package controler;
/**
 * 
 */

/**
 * @author loisg
 *
 */
import java.io.File;
import java.io.IOException;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import Utils.Fenetre;
import Utils.Database;
import Utils.Constants;
import controler.mapControler;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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
		ObjectMapper objM = new ObjectMapper();
		try {
			Database db = objM.readValue(new File("settings.cfg"), Database.class);
			con = db.connect();
			Fenetre fen = new Fenetre("Prototype",con);
			javax.swing.SwingUtilities.invokeLater(fen);
			fen.populate_map(con);
		}catch(SQLException e)
		{
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

