package Utils;

import java.awt.Dimension;
import java.awt.Polygon;
import java.util.Arrays;

public class PolygonMy extends Polygon {
	private boolean selected;
	private int id_emplacement;
	public int[] new_x;
	public int[] new_y;
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
	public void setnew()
	{
		//System.out.println("setnew");
		this.new_x = Arrays.copyOf(this.xpoints,this.npoints);
		this.new_y = Arrays.copyOf(this.ypoints,this.npoints);
	}
	public void refresh(Dimension mapSize)
	{
		//System.out.println(mapSize);
		this.reset();
		this.npoints = this.new_x.length;
		for(int i=0;i<this.npoints;i++)
		{
			this.xpoints[i]=(int) ((this.new_x[i]*mapSize.getWidth())/Constants.IMAGE_WIDTH);
			this.ypoints[i]=(int) ((this.new_y[i]*mapSize.getHeight())/Constants.IMAGE_HEIGHT);
			//System.out.println(this.new_x[i] + ";" + this.new_y[i]);
		}
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
