/**
 * 
 */
package vue;

import javax.swing.JLabel;
/**
 * @author Predator-Lois
 *
 */
import javax.swing.JPanel;
public class RightPanelVue extends JPanel{
	private int idEmplacement = -1;
	private String nomBoutique = "";
	private int surface = 0;
	private JLabel label_boutique;
	public RightPanelVue()
	{
		super();
		this.label_boutique = new JLabel("");
		this.add(this.label_boutique);
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
	public int getSurface() {
		return surface;
	}
	public void setSurface(int surface) {
		this.surface = surface;
	}
	
	
}
