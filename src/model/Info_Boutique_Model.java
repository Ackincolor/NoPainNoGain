package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Utils.Database;
import Utils.PolygonMy;

public class Info_Boutique_Model {
	private int id_boutique;
	private int id_emplacement;
	private float surface;
	private DefaultListModel<Article> model;
	
	public Info_Boutique_Model(Connection con,PolygonMy poly)
	{
		this.model = new DefaultListModel<Article>();
		this.id_boutique = poly.getIdEmplacement();
		this.id_emplacement = poly.getIdEmplacement();
		this.surface = poly.getSurface();
		this.populate_list(con);
	}
	public void populate_list(Connection con)
	{
		String requete = "SELECT es.id_produit,produit.nom, (select sum(quantité) from entrée_stock es2 where es2.id_produit = es.id_produit)-(select sum(quantité) from sortie_stock ss where ss.id_produit = es.id_produit) as quantité "
				+ "FROM entrée_stock es "
				+ "JOIN produit ON es.id_produit = produit.iDProduit "
				+ "JOIN sortie_stock ss ON es.id_produit = ss.id_produit "
				+ "WHERE es.id_boutique ="+this.id_boutique+" GROUP BY es.id_produit "
				+ "UNION SELECT es.id_produit,produit.nom, es.quantité "
				+ "FROM entrée_stock es "
				+ "JOIN produit ON es.id_produit = produit.iDProduit "
				+ "WHERE es.id_boutique = "+this.id_boutique+" "
				+ "AND es.id_produit not in ("
				+ "		SELECT id_produit from sortie_stock"
				+ "		);";
		/*
		 * il manque le fait quil peut y avoir plusieur ajouts et sorites
		 * SELECT es.id_produit,produit.nom, es.quantité - ss.quantité AS quantité 
FROM entrée_stock es 
JOIN produit ON es.id_produit=produit.iDProduit 
JOIN sortie_stock ss ON es.id_produit = ss.id_produit 
WHERE es.id_boutique = 1
UNION SELECT es.id_produit,produit.nom, es.quantité 
FROM entrée_stock es 
JOIN produit ON es.id_produit=produit.iDProduit 
WHERE es.id_boutique = 1
AND es.id_produit not in (select id_produit from sortie_stock)
		 */
		//System.out.println(requete);
		try
		{
			ResultSet res = Database.executeRequete(requete, con);
			while(res.next())
			{
				this.model.addElement(new Article(res.getInt(1),res.getString(2),res.getInt(3)));
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public DefaultListModel<Article> getArticles()
	{
		return this.model;
	}
}
