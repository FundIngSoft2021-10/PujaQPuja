package pujaQpuja.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pujaQpuja.MainApp;

public class PantallasMenu {

    static public void abrirPerfil(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource("/view/" + "PantallaPerfil.fxml"));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();

        } catch (Exception e) {
            System.err.println("Error abriendo pantalla: " + e);
        }
    }

    static public void abrirAjustes(MouseEvent event) {
        // TODO hacer pantalla ajustes
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource("/view/" + "PantallaAjustes.fxml"));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();

        } catch (Exception e) {
            System.err.println("Error abriendo pantalla: " + e);
        }
    }

    static public void abrirCategorias(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource("/view/" + "PantallaSeleccionarCategoria.fxml"));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();

        } catch (Exception e) {
            System.err.println("Error abriendo pantalla: " + e);
        }
    }

    static public void abrirRealizarSubasta(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource("/view/" + "PantallaRealizarSubasta.fxml"));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();

        } catch (Exception e) {
            System.err.println("Error abriendo pantalla: " + e);
        }
    }

    static public void abrirHistorialVentas(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource("/view/" + "HistorialVentas.fxml"));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();

        } catch (Exception e) {
            System.err.println("Error abriendo pantalla: " + e);
        }
    }

    static public void abrirHistorialCompras(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource("/view/" + "HistorialCompras.fxml"));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();

        } catch (Exception e) {
            System.err.println("Error abriendo pantalla: " + e);
        }
    }

    static public void abrirNotificaciones(MouseEvent event) {
        // TODO hacer pantalla notificaciones
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource("/view/" + "PantallaNotificaciones.fxml"));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();

        } catch (Exception e) {
            System.err.println("Error abriendo pantalla: " + e);
        }
    }

    static public void abririMetodoPago(MouseEvent event) {
        // TODO hacer pantalla método pago
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource("/view/" + "PantallaMetodoPago.fxml"));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();

        } catch (Exception e) {
            System.err.println("Error abriendo pantalla: " + e);
        }
    }
}
