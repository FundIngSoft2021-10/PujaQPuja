package pujaQpuja.utilities;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pujaQpuja.MainApp;
import pujaQpuja.controller.pantallas.PantallaRealizarSubastaController;

import java.io.IOException;

public class PantallasMenu {

    public static void abrirPantalla(Event event, String nombrePantalla) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/view/" + nombrePantalla + ".fxml"));
            Parent root = fxmlLoader.load();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(new Scene(root));
            window.toFront();
            window.showAndWait();
        } catch (Exception e) {
            System.err.println("Error abriendo pantalla: " + e);
        }
    }

    public static void abrirVentana(String nombrePantalla) {

            ////////////////////////////////////////////////////////////////////////////
                                Text text = new Text("¡Aguarda!  Estamos cargando las subastas mas interesantes para ti");
                                text.setX(150);
                                text.setY(150);
                                text.setStroke(Color.BLUE);
                                //text.setStrokeWidth(3);
                                StackPane loadingRoot = new StackPane();
                                ProgressIndicator pin =new ProgressIndicator();
                                loadingRoot.getChildren().setAll(pin);
                                loadingRoot.getChildren().add(text);
                                final Scene scene = new Scene(loadingRoot);
                                Stage stage = new Stage();
                                stage.initModality(Modality.WINDOW_MODAL);
                                stage.setWidth(1280);
                                stage.setHeight(760);
                                stage.setScene(scene);
                                stage.show();
                                new Thread(() -> {
                              //  root = FXMLLoader.load(Main.class.getResource("FXMLDocument.fxml"));

                                    // we need to wrap UI code in Platform
                                    Platform.runLater(() -> {
                                             Parent root;
                                              try{

                                      FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/view/" + nombrePantalla + ".fxml"));

                                        root = fxmlLoader.load();

                                         Stage window = new Stage();
                                            window.setScene(new Scene(root));
                                            window.show();

                                            stage.close();
                                         //scene.setRoot(root);
                                 }catch(IOException ex)
                                 {
                                     System.err.println("Error abriendo pantalla: " + ex);
                                 }

                                    });
                                }).start();

            //////////////////////////////////////////////////////////////////////////////
           /* FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/view/" + nombrePantalla + ".fxml"));
            Parent root = fxmlLoader.load();
            Stage window = new Stage();
            window.setScene(new Scene(root));
            window.show();
        } catch (Exception e) {
            System.err.println("Error abriendo pantalla: " + e);
        }*/

    }

    public static void cerrarPantalla(Event event){
        Stage escena = (Stage) ((Node) event.getSource()).getScene().getWindow();
        escena.close();
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

    public static void abrirQA(MouseEvent event) {
        abrirPantalla(event, "PantallaPreguntas");
    }

    public static void abrirNotificaciones(MouseEvent event) {
        // TODO hacer pantalla notificaciones
        abrirPantalla(event, "PantallaNotificaciones");
    }

    public static void abririMetodoPago(MouseEvent event) {
        abrirPantalla(event, "PantallaMetodoPago");
    }

    public static void abrirChat(ActionEvent event) {
        abrirPantalla(event, "PantallaChat");
    }

    public static void abrirPreguntasPuja(ActionEvent event) {
        abrirPantalla(event, "PreguntasPuja");
    }
}
