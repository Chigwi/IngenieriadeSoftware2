package co.edu.poli.actividad1.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ControlPantallaPasaporte {

    @FXML
    private Button bttInsertar;

    @FXML
    private Button bttShow;

    @FXML
    private Button bttactualizar;

    @FXML
    private Button bttdelete;

    @FXML
    private Button bttselect;

    @FXML
    private RadioButton inDiplomatico;

    @FXML
    private TextArea inExtra;

    @FXML
    private TextField inIdPasaporte;

    @FXML
    private RadioButton inOrdinario;

    @FXML
    private ComboBox<?> selectCiudad;

    @FXML
    private DatePicker selectFecha;

    @FXML
    private ComboBox<?> selectPais;

    @FXML
    private ComboBox<?> selectUsuarios;

    @FXML
    private ToggleGroup tipoPasaporte;

    @FXML
    void DeletePasaporte(ActionEvent event) {
    	
    	inIdPasaporte.setDisable(true);
    	inIdPasaporte.setVisible(false);
    	
    	bttselect.setDisable(true);
    	bttselect.setVisible(false);
    
    	
    	
    	Alert a = new Alert (AlertType.INFORMATION);
    	a.setContentText("alerta pendiente");
    	a.show();

    }

    @FXML
    void actualizarPasaporte(ActionEvent event) {
    	
    	inIdPasaporte.setDisable(false);
    	inIdPasaporte.setVisible(true);
    	
    	bttselect.setDisable(true);
    	bttselect.setVisible(false);
    
    	
    	Alert a = new Alert (AlertType.INFORMATION);
    	a.setContentText("alerta pendiente");
    	a.show();

    }

    @FXML
    void insertarPasaporte(ActionEvent event) {
    	
    	inIdPasaporte.setDisable(true);
    	inIdPasaporte.setVisible(false);
    	
    	bttselect.setDisable(true);
    	bttselect.setVisible(false);
    	
    	Alert a = new Alert (AlertType.INFORMATION);
    	a.setContentText("alerta pendiente");
    	a.show();


    }

    @FXML
    void selectPasaporte(ActionEvent event) {
    	
    	Alert a = new Alert (AlertType.INFORMATION);
    	a.setContentText("alerta pendiente");
    	a.show();


    }

    @FXML
    void showSelect(ActionEvent event) {
    	inIdPasaporte.setDisable(false);
    	inIdPasaporte.setVisible(true);
    	
    	bttselect.setDisable(false);
    	bttselect.setVisible(true);
    }

    @FXML
    void textDiplomatico(ActionEvent event) {
    	
    	inExtra.setPromptText("ingrese mision diplomatica");

    }

    @FXML
    void textOrdinario(ActionEvent event) {
    	
    	inExtra.setPromptText("ingrese mision de viaje");

    }

}
