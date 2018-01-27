package vue;

import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Color;

import Utils.PolygonMy;
import model.RightPanel;
public class Map extends JPanel {

	private ArrayList<PolygonMy> emplacements;
	private PolygonMy clicked = null;
	private RightPanel rightPanel= null;
	private Image img1;
	//private Point mouse_position;
	public Map() {
		// TODO Auto-generated constructor stub
		this.emplacements = new ArrayList<PolygonMy>();
		this.img1 = Toolkit.getDefaultToolkit().getImage("src/res/PlanCentreCo.png");
	}
	public void add_polygon(int[] poly_x,int[] poly_y)
	{
		this.emplacements.add(new PolygonMy(poly_x,poly_y,poly_x.length));
	}
	public void add_polygon(PolygonMy poly)
	{
		this.emplacements.add(poly);
	}
	public void refresh()
	{
		for(PolygonMy poly : this.emplacements)
		{
			poly.refresh(this.getSize());
		}
	}
	public void set_rightPanel(RightPanel rp)
	{
		this.rightPanel = rp;
	}
	public void send_data()
	{
		if(this.rightPanel != null)
		{
			if(this.clicked!=null)
			this.rightPanel.send(this.clicked);
			this.rightPanel.getVue().repaint();
		}
		else
		{
			
		}
	}
	public void setClicked()
	{
		for(PolygonMy poly: this.emplacements)
		{
			if(poly.isSelected())
			{
				this.clicked = poly;
				return;
			}
			this.clicked=null;
		}
	}
	public void setMousePos(int x,int y)
	{
		//System.out.println(x+";"+y);
		for(PolygonMy poly: this.emplacements)
		{
			if(poly.contains(x, y))
			{
				poly.setSelected(true);
				//System.out.println("IN");
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
		//g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2.setColor(Color.BLACK);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); 
		g2.drawImage(this.img1, 0 , 0,this.getWidth(), this.getHeight(), this);
		for(PolygonMy poly: this.emplacements)
		{
			//System.out.println("dessin d'un poly");
			int polyId = poly.getIdEmplacement();
			if(!poly.isSelected())
				g2.drawPolygon(poly);
			else if(poly==this.clicked)
			{
				g2.setColor(Color.BLUE);
				g2.fillPolygon(poly);
				g2.drawPolygon(poly);
				g2.setColor(Color.BLACK);
			}
			else
			{
				g2.fillPolygon(poly);
				g2.drawPolygon(poly);
				g2.setColor(Color.BLACK);
			}
		}
	}
	
}
