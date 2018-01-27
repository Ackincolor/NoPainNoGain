/**
 * 
 */
package model;

/**
 * @author loisg
 *
 */
public class Article {
	private int id;
	private String nom;
	private int qty;
	/**
	 * 
	 */
	public Article() {
		// TODO Auto-generated constructor stub
	}
	public Article(int id,String nom, int qty)
	{
		this.id=id;
		this.nom = nom;
		this.qty = qty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String toString() {
	    return this.nom+";"+Integer.toString(this.qty);
	}

}
