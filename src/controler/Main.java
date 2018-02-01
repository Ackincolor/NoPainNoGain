package controler;

import utils.Constants;
import utils.Database;
import view.Fenetre;

public class Main {
    public static void main(String[] args) {
        //
        Constants.DB = new Database();
        Fenetre fen = new Fenetre();
        javax.swing.SwingUtilities.invokeLater(fen);
    }
}
