package utils;

public class Database {
    private String url,usr,password;
    /*
    * Chargement du driver de connexion a la base de données.
    * ceci ne s'execute qu'une seul fois
     */
    static
    {
        try {

            Class.forName(Constants.DRIVER_NAME).newInstance();
            //DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
            System.out.println("*** Driver loaded.");
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
    /*
    * Construteur de la class database
     */
    public Database()
    {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
