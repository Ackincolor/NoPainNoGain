package controler;

import java.awt.event.MouseAdapter;
import vue.Map;
import Utils.PolygonMy;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;;

public class mapControler extends MouseAdapter{

	private Map map;
	public mapControler(Map map) {
		// TODO Auto-generated constructor stub
		this.map = map;
	}
	public void mouseClicked(MouseEvent e)
	{
		this.map.setClicked();
		this.map.send_data();
		this.map.repaint();
	}
	public void mouseMoved(MouseEvent e)
	{
		this.map.setMousePos(e.getX(), e.getY());
		//System.out.println("x:"+e.getX()+"y:"+e.getY());
		this.map.refresh();
		this.map.repaint();
	}

}
