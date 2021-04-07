package pujaQpuja;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class MainApp extends Application {
    /*
    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Realice las inicializaciones necesarias aquí.");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/java/pujaQpuja/FXMLDocument.fxml"));

        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Label etiqueta = new Label("Hola Mundo");
        etiqueta.setAlignment(Pos.CENTER);
        Scene scene = new Scene(etiqueta, 500, 350);
        primaryStage.setTitle("Aplicación Hola Mundo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Destruye los recursos. Realice limpieza.");
    }
    public static void main(String[] args) {
        launch(args);
    }
    */
    /*
    private static Stage stage;
    
    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        stage=s;
        setRoot("primary","");
    }
    
    static void setRoot(String fxml) throws IOException {
        setRoot(fxml,stage.getTitle());
    }
    
    static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/"+ fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    */

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Inicio"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}