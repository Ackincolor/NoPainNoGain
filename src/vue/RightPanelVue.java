/**
 * 
 */
package vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
/**
 * @author Predator-Lois
 *
 */
import javax.swing.JPanel;

import Utils.Constants;
import Utils.PolygonMy;
public class RightPanelVue extends JPanel{
	private int idEmplacement = -1;
	private String nomBoutique = "";
	private String surface = "";
	private JLabel label_boutique;
	private JLabel label_surface;
	private JButton voir_plus;
	private PolygonMy polygon;
	public RightPanelVue(Connection con)
	{
		super();
		this.setLayout(new GridLayout(8,1));
		this.setSize(150, Constants.WINDOW_HEIGHT);
		this.label_boutique = new JLabel("");
		this.label_surface = new JLabel("");
		this.voir_plus = new JButton("Voir plus");
		this.add(this.label_boutique);
		this.add(this.label_surface);
		this.add(this.voir_plus);
		this.voir_plus.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(polygon!=null)
						javax.swing.SwingUtilities.invokeLater(new Info_Boutique(con,polygon));
					}	
				});
	}
	public void setPolygon(PolygonMy poly)
	{
		this.polygon=poly;
	}
	public int getIdEmplacement() {
		return idEmplacement;
	}
	public void setIdEmplacement(int idEmplacement) {
		this.idEmplacement = idEmplacement;
	}
	public String getNomBoutique() {
		return nomBoutique;
	}
	public void setNomBoutique(String nomBoutique) {
		this.nomBoutique = nomBoutique;
		this.label_boutique.setText(this.nomBoutique);
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
		this.label_surface.setText(this.surface);
	}
	
	
}
