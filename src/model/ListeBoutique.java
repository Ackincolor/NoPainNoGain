package model;

import utils.Constants;
import utils.MyListModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListeBoutique extends Table{
    private ArrayList<Boutique> liste;
    private MyListModel<Boutique> model;
    public ListeBoutique(String s)
    {
        super(s);
        this.liste = new ArrayList<>();
    }
    public void setInfo(ResultSet resultSet)
    {
        try
        {
            int index=0;
            while(resultSet.next())
            {
                liste.add(new Boutique(resultSet.getString("nom_boutique"),resultSet.getInt("idBoutique"),resultSet.getInt("idBoutique")));
                index++;
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        this.model = new MyListModel<>(this.liste);
    }
    public MyListModel getModel()
    {
        return this.model;
    }
}
