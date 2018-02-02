package controler;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import utils.Constants;
import utils.Database;
import view.Fenetre;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //
        try{
            ObjectMapper objectMapper = new ObjectMapper();

            Constants.DB = objectMapper.readValue(new File("settings.cfg"),Database.class);
            Fenetre fen = new Fenetre();
            javax.swing.SwingUtilities.invokeLater(fen);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
