package pujaQpuja.utilities;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pujaQpuja.MainApp;
import pujaQpuja.controller.pantallas.PantallaRealizarSubastaController;

public class PantallasMenu {

    public static void abrirPantalla(Event event, String nombrePantalla) {
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource("/view/" + nombrePantalla + ".fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.toFront();
            window.show();
        } catch (Exception e) {
            System.err.println("Error abriendo pantalla: " + e);
        }
    }

    public static void abrirVentana(ActionEvent event, String nombrePantalla) {
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource("/view/" + nombrePantalla + ".fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            System.err.println("Error abriendo pantalla: " + e);
        }
    }

    public static void abrirPerfil(MouseEvent event) {
        abrirPantalla(event, "PantallaPerfil");
    }

    public static void abrirAjustes(MouseEvent event) {
        // TODO hacer pantalla ajustes
        abrirPantalla(event, "PantallaAjustes");
    }

    public static void abrirCategorias(MouseEvent event) {
        abrirPantalla(event, "PantallaSeleccionarCategoria");
    }

    public static void abrirRealizarSubasta(MouseEvent event) {
        abrirPantalla(event, "PantallaRealizarSubasta");
    }

    public static void abrirHistorialVentas(MouseEvent event) {
        abrirPantalla(event, "HistorialVentas");
    }

    public static void abrirHistorialCompras(MouseEvent event) {
        abrirPantalla(event, "HistorialCompras");
    }

    public static void abrirNotificaciones(MouseEvent event) {
        // TODO hacer pantalla notificaciones
        abrirPantalla(event, "PantallaNotificaciones");
    }

    public static void abririMetodoPago(MouseEvent event) {
        // TODO hacer pantalla método pago
        abrirPantalla(event, "PantallaMetodoPago");
    }


}
