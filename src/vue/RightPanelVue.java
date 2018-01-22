/**
 * 
 */
package vue;

import java.awt.GridLayout;

import javax.swing.JLabel;
/**
 * @author Predator-Lois
 *
 */
import javax.swing.JPanel;

import Utils.Constants;
public class RightPanelVue extends JPanel{
	private int idEmplacement = -1;
	private String nomBoutique = "";
	private String surface = "";
	private JLabel label_boutique;
	private JLabel label_surface;
	public RightPanelVue()
	{
		super();
		this.setLayout(new GridLayout(8,1));
		this.setSize(150, Constants.WINDOW_HEIGHT);
		this.label_boutique = new JLabel("");
		this.label_surface = new JLabel("");
		this.add(this.label_boutique);
		this.add(this.label_surface);
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
