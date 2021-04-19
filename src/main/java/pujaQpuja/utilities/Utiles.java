package pujaQpuja.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Utiles {

    public static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    
    public static Image cargarImagen(Event event, String rutaImagen)
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
        File imgFile = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
        if (imgFile != null) {
            Image image = new Image("file:" + imgFile.getAbsolutePath());
            rutaImagen = imgFile.getAbsolutePath();
            return image;
            //imagenProducto.setImage(image);
        }
        return null;
    }

    public static Image cargarImagenConRuta(String rutaImagen)
    {
        return new Image("file:" + rutaImagen, 200, 200, true, false);
    }

    /*
    public static Blob convertirImagenABlob ( Image imagen ) {

        Blob imagenBlob = null;
        BufferedImage bi = new BufferedImage ( imagen.getWidth ( null ), imagen.getHeight ( null ), BufferedImage.TYPE_INT_ARGB );
        Graphics bg = bi.getGraphics ();
        bg.drawImage ( imagen, 0, 0, null );
        bg.dispose ();
  
        ByteArrayOutputStream baos = new ByteArrayOutputStream ();
        try {
           ImageIO.write (
                 bi,
                 imagen.getDescription ().substring (
                       imagen.getDescription ().length () - 3 ), baos );
           baos.flush ();
           baos.close ();
        } catch ( IOException e ) {
           e.printStackTrace ();
        }
  
        byte [] imagenByte = baos.toByteArray ();
  
        try {
           imagenBlob = new SerialBlob ( imagenByte );
        } catch ( SerialException se ) {
           se.printStackTrace ();
        } catch ( SQLException sqle ) {
           sqle.printStackTrace ();
        }
        return imagenBlob;
     }*/

}
