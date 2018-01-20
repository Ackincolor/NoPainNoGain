package Utils;

import java.awt.Polygon;

public class PolygonMy extends Polygon {
	private boolean selected;
	private int id_emplacement;
	public PolygonMy() {
		// TODO Auto-generated constructor stub
		this.selected = false;
		this.id_emplacement = -1;
	}
	public PolygonMy(int[] x,int[] y, int n)
	{
		super(x,y,n);
		this.selected = false;
	}
	public void setEmplacement(int id)
	{
		this.id_emplacement = id;
	}
	public int getIdEmplacement()
	{
		return this.id_emplacement;
	}
	public void setSelected(boolean b)
	{
		this.selected = b;
	}
	public boolean isSelected()
	{
		return this.selected;
	}
	public void translate_x(int dist)
	{
		for(int i=0;i<this.npoints;i++)
		{
			this.xpoints[i]=this.xpoints[i]+dist;
		}
	}
	public void translate_y(int dist)
	{
		for(int i=0;i<this.npoints;i++)
		{
			this.ypoints[i]=this.ypoints[i]+dist;
		}
	}
}
