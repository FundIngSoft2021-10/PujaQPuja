package pujaQpuja.controller.pantallas;
/*
import Entidades.Binario;
import Entidades.TarjetaRed;
import Entidades.TarjetasRed;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import jpcap.packet.EthernetPacket;


public class EjemploControladorFXMLDocumentController implements Initializable
{

    private String stringAuxMacDestino;

    @FXML
    private Label label;
    @FXML
    private ComboBox<TarjetaRed> comboBoxT;
    @FXML
    private TextField tTipo;
    @FXML
    private TextField tMacOrigen;
    @FXML
    private TextField tMacDestino;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //ComboBox de Libros
        comboBoxT.setPromptText("Seleccione la Tarjeta Red a usar");
        TarjetasRed tr = new TarjetasRed();
        List<TarjetaRed> array = tr.getTarjetasRed();
        ObservableList<TarjetaRed> observableArrayList = FXCollections.observableArrayList(array);
        comboBoxT.setItems(observableArrayList);
    }

    public void pressButton(ActionEvent event) throws Exception
    {
        String[] scannerString;
        byte[] macOrigen, macDestino;
        byte[] ipOrigen, ipDestino;
        EthernetPacket tramaEthernetII = new EthernetPacket();

        short tipoTrama = Short.decode(tTipo.getText()); // Porque se recibe en Hexa

        scannerString = tMacOrigen.getText().split(":");
        macOrigen = Binario.macHexaStringAByte(scannerString);

        scannerString = tMacDestino.getText().split(":");
        if (scannerString.length <= 1)
        {
            macDestino = Binario.macFF;
        }
        else
        {
            macDestino = Binario.macHexaStringAByte(scannerString);
        }

        //Creación de la trama Ethernet II
        tramaEthernetII.frametype = tipoTrama;
        tramaEthernetII.src_mac = macOrigen;
        tramaEthernetII.dst_mac = macDestino; //esto tiene que ser FF

        FXMLLoader fxmlLoader = null;
        switch (tipoTrama)
        {
            case 2054://llamamos a ARP
                fxmlLoader = new FXMLLoader(getClass().getResource("ARP.fxml"));
                fxmlLoader.load();
                ARPController arpController = fxmlLoader.getController();
                arpController.enviarDatosNecesarios(tramaEthernetII, comboBoxT.getValue());
                break;

            case 2048://llamamos a ICMP
                fxmlLoader = new FXMLLoader(getClass().getResource("ICMP.fxml"));
                fxmlLoader.load();
                ICMPController icmpController = fxmlLoader.getController();
                icmpController.enviarDatosNecesarios(tramaEthernetII, comboBoxT.getValue());
                break;
        }
        Parent p = fxmlLoader.getRoot();
        Stage s = new Stage();
        s.setScene(new Scene(p));
        s.show();
    }

    public void cambioDeTarjetaRed(ActionEvent event) throws Exception
    {
        tMacOrigen.setText(Binario.arregloBytesAHexa(comboBoxT.getValue().getNetworkInterface().mac_address, ":"));
    }

    public void alPonerArpEnType(KeyEvent event) throws Exception
    {
        if (tTipo.getText().length() > 2 && tTipo.getText().length() <= 6)
        {

            short tipoTrama = Short.decode(tTipo.getText()); // Porque se recibe en Hexa
            if (tipoTrama == 2054)
            {;
                tMacDestino.setText("ff:ff:ff:ff:ff:ff");
                tMacDestino.setEditable(false);
            }
            else
            {
                tMacDestino.setText(stringAuxMacDestino);
                tMacDestino.setEditable(true);
            }
        }
    }

    public void alPonerMacDestino(KeyEvent event) throws Exception
    {
        stringAuxMacDestino = tMacDestino.getText();

    }
}
*/