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
public class RightPanel {
	private int id_emplacement=-1;
	private PolygonMy polygon;
	private RightPanelVue rpv = null;
	private String nom_boutique = "";
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
		this.refresh();
		String requete = "SELECT nom_boutique FROM Boutique "
				+ "Joir";
	}
	private void refresh()
	{
		this.rpv.setNomBoutique(this.nom_boutique);
		this.rpv.repaint();
	}
}
