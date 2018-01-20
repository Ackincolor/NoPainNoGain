package vue;

import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import Utils.PolygonMy;
public class Map extends JPanel {

	private ArrayList<PolygonMy> emplacements;
	private 
	//private Point mouse_position;
	public Map() {
		// TODO Auto-generated constructor stub
		this.emplacements = new ArrayList<PolygonMy>();
	}
	public void add_polygon(int[] poly_x,int[] poly_y)
	{
		this.emplacements.add(new PolygonMy(poly_x,poly_y,poly_x.length));
	}
	public void add_polygon(PolygonMy poly)
	{
		this.emplacements.add(poly);
	}
	public void setMousePos(int x,int y)
	{
		for(PolygonMy poly: this.emplacements)
		{
			if(poly.contains(x, y))
			{
				poly.setSelected(true);
				//System.out.println("in");
			}
			else
			{
				poly.setSelected(false);
			}
		}
	}
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2.setColor(Color.BLACK);
		for(PolygonMy poly: this.emplacements)
		{
			if(!poly.isSelected())
				g2.drawPolygon(poly);
			else
			{
				g2.fillPolygon(poly);
				g2.drawPolygon(poly);
			}
		}
	}
	
}
