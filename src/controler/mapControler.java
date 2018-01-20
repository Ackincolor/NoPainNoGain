package controler;

import java.awt.event.MouseAdapter;
import vue.Map;
import java.awt.event.MouseEvent;;

public class mapControler extends MouseAdapter {

	private Map map;
	public mapControler(Map map) {
		// TODO Auto-generated constructor stub
		this.map = map;
	}
	public void mouseCLicked(MouseEvent e)
	{
		this.map.setCLicked(e.getSource());
	}
	public void mouseMoved(MouseEvent e)
	{
		this.map.setMousePos(e.getX(), e.getY());
		this.map.repaint();
	}

}
