package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	// Nom du pilote (driver). Dans ce cas, MySQL
	private static final String DRIVER_NAME ="org.mariadb.jdbc.Driver";
	private String url;
	private String user;
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	static {
	// Chargement du pilote
	// N'aura lieu qu'une seule fois
	try {

	Class.forName(DRIVER_NAME).newInstance();
	//DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
	System.out.println("*** Driver loaded.");
	}
	catch(ClassNotFoundException | InstantiationException | IllegalAccessException e)
	{
		e.printStackTrace();
	}
	
	}
	public static Connection getConnection(String URL, String USER, String PASSWORD) throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	public Connection connect() throws SQLException
	{
		return DriverManager.getConnection(this.url, this.user, this.password);
	}
	//pour un select
	public static ResultSet executeRequete(String requete, Connection con) {
		ResultSet results = null;
		try {
		Statement stmt = con.createStatement();
		results = stmt.executeQuery(requete);
		}
		catch (SQLException e) {
		System.out.println("Erreur requ�te : " + e.getMessage());
		}
		return results;
	}
	
	
	
}
