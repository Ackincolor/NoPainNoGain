/**
 * 
 */
package vue;

import Utils.PolygonMy;
import model.Info_Boutique_Model;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import model.Article;
/**
 * @author loisg
 * 
 *	Class qui permet d'afficher les information d'une boutque
 *
 */
public class Info_Boutique extends JFrame implements Runnable{
	private JList list;
	private int counter = 15;
	private Info_Boutique_Model info_boutique_model;
	private ObjectMapper objectMapper;
	/**
	 * @throws HeadlessException
	 */
	public Info_Boutique(Connection con,PolygonMy poly) throws HeadlessException {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		this.setSize(400,500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		//this.list = new JList<Article>();
		this.info_boutique_model = new Info_Boutique_Model(con,poly);
		//this.info_boutique_model.populate_list(con);
		DefaultListModel model = this.info_boutique_model.getArticles();
	    list = new JList<DefaultListModel>(model);
	    
	    JScrollPane pane = new JScrollPane(list);
	    JButton addButton = new JButton("Export to JSon");
	    JButton addProduct = new JButton("Add Product");
	    JPanel panel1 = new JPanel();
	    JPanel panel2 = new JPanel();
	    panel1.add(addButton);
	    /*for (int i = 0; i < 15; i++)
	      model.addElement("Element " + i);
		*/
	    addButton.addActionListener(event -> {
	  		try {
	  			String s = new String();
	  			Object[] article = model.toArray();
	  			objectMapper.writeValue(new File("articles.json") , article);
	  			/*for(int i = 0;i<model.size();i++)
	  			{
	  				s+=objectMapper.writeValueAsString(model.getElementAt(i));
	  				s+="\n";
	  			}
	  			BufferedWriter writer = new BufferedWriter(new FileWriter("articles.json"));
	  		    writer.write(s);
	  		    writer.close();*/
			} catch (JsonGenerationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	    });
	    panel2.add(addProduct);
	    add(pane, BorderLayout.CENTER);
	    add(panel1, BorderLayout.WEST);
	    add(panel2,BorderLayout.EAST);
	}

	/**
	 * @param arg0 premier argument
	 */
	public Info_Boutique(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0 premier argument
	 * @throws HeadlessException
	 */
	public Info_Boutique(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0 premier argument
	 * @param arg1 deuxieme argument
	 */
	public Info_Boutique(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}

}
