/**
 * 
 */
package model;

/**
 * @author Predator-Lois
 *
 */
import Utils.PolygonMy;
import vue.RightPanelVue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
public class RightPanel {
	private int id_emplacement=-1;
	private PolygonMy polygon;
	private RightPanelVue rpv = null;
	private String nom_boutique = "";
	private String surface = "0 m²";
	private Connection con=null;
	public RightPanel(Connection con)
	{
		this.con = con;
	}
	public void setVue(RightPanelVue rpv)
	{
		this.rpv = rpv;
	}
	public RightPanelVue getVue()
	{
		return this.rpv;
	}
	public void send(PolygonMy poly)
	{
		this.polygon = poly;
		String requete = "SELECT B.nom_boutique FROM Boutique B "
				+ "JOIN emplacement_boutique eb ON B.idBoutique = eb.id_boutique "
				+ "WHERE eb.id_emplacement ='"+poly.getIdEmplacement()+"';";
		System.out.println(requete);
		boolean is_res = false;
		try {
			Statement stmt = this.con.createStatement();
			ResultSet res = stmt.executeQuery(requete);
			while(res.next())
			{
				this.nom_boutique = res.getString(1);
				is_res = true;
			}
			if(!is_res)
			{
				this.nom_boutique = "";
			}
			stmt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		this.calcul_surface();
		this.refresh();
	}
	/*
	 * methode qui calcule l'aire de la surface selectionnée
	 */
	private void calcul_surface()
	{
		int[] res = {0,0};
		//System.out.println(arrayof_X.length);
		int[] arrayof_X = Arrays.copyOf(this.polygon.xpoints, this.polygon.npoints+1);
		int[] arrayof_Y = Arrays.copyOf(this.polygon.ypoints, this.polygon.npoints+1);
		//System.out.println(arrayof_X.length);
		//ajout du dernier point
		arrayof_X[this.polygon.npoints] = arrayof_X[0]; 
		arrayof_Y[this.polygon.npoints] = arrayof_Y[0]; 
		//debut du calcul
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<this.polygon.npoints;j++)
			{
				if(i==0)
					res[i] += arrayof_X[j]*arrayof_Y[j+1];
				else
					res[i] += arrayof_X[j+1]*arrayof_Y[j];
			}
		}
		float surface = (res[0] - res[1]) /2; 
		//System.out.print(surface+"m²");
		//il y a donc "surface" pixel sur l'emplacement;
		this.surface = Float.toString(surface)+" m²";
	}
	private void refresh()
	{
		this.rpv.setNomBoutique(this.nom_boutique);
		this.rpv.setSurface(this.surface);
		this.rpv.repaint();
	}
}
