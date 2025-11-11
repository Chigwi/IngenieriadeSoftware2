package co.edu.poli.actividad1.Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Servicios.AdaptadorPais;
import co.edu.poli.actividad1.Servicios.Cancilleria;
import co.edu.poli.actividad1.Servicios.ConcreteMediador;
import co.edu.poli.actividad1.Servicios.Migracion;
import co.edu.poli.actividad1.Servicios.Policia;
import co.edu.poli.actividad1.vista.App;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ControladorNotificaciones implements Initializable {
	
	private ConcreteMediador con;
	
	private Cancilleria can;
	
	private Migracion mig;
	
	private Policia pol;
	
    @FXML
    private Button bttCancilleria;

    @FXML
    private Button bttMigracion;

    @FXML
    private Button bttPolicia;

    @FXML
    private Button bttSwitch;

    @FXML
    private TextArea inText;
    
    @FXML
    private Button clear;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		con = new ConcreteMediador();
		can = new Cancilleria();
		mig = new Migracion();
		pol = new Policia();	
	}
	
    @FXML
    void cleanText(ActionEvent event) {
    	inText.clear();
    }

    @FXML
    void notificarCancilleria(ActionEvent event) {
    	String message = con.notificar(can) + "\n del mensaje \n" + inText.getText();
    	inText.setText(message);

    }

    @FXML
    void notificarMigracion(ActionEvent event) {
    	String message = con.notificar(mig) + "\n del mensaje \n" + inText.getText();
    	inText.setText(message);
    }

    @FXML
    void notificarPolicia(ActionEvent event) {
    	String message = con.notificar(pol) + "\n del mensaje \n" + inText.getText();
    	inText.setText(message);
    }

    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");

    }

}
