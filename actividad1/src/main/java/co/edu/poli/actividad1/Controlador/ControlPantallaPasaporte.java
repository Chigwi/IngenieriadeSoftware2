package co.edu.poli.actividad1.Controlador;

import java.util.ArrayList;

import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Titular;
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
	
	private ArrayList <Ciudad> ciudades = new ArrayList <Ciudad>();
	private ArrayList <Ciudad> ciudadesKorea = new ArrayList <Ciudad>();
	private ArrayList <Ciudad> ciudadesMexico = new ArrayList <Ciudad>();
	private ArrayList <Ciudad> gringos = new ArrayList <Ciudad>();
	
	//paises
	private Pais colombia = new Pais ("1","colombia","espaniol", ciudades);
	
	private Pais KoreadelNorte = new Pais ("148","Korea del Norte","koreano", ciudadesKorea);
	
	private Pais Mexico = new Pais ("49","Mexico","Espannol", ciudadesMexico);
	
	private Pais EstadosUnidos = new Pais ("104", "EstadosUnidos", "ingles",gringos);
	
	//estados unidos
	private Ciudad Washington = new Ciudad ("0001", "washington", true,"104");
	
	private Ciudad Miami = new Ciudad ("0002", "Miami", false, "104");
	
	private Ciudad newYork = new Ciudad ("0003", "New York", false, "104");
	
	//mexico
	private Ciudad CiudadDeMexico = new Ciudad ("0521", "Ciudad De mexico", true,"49");
	
	private Ciudad Cancun = new Ciudad ("0522", "Cancun", false,"49");
	
	private Ciudad Monterrey = new Ciudad ("0523", "Monterrey", false,"49");
	
	//colombia
	private Ciudad Tunja = new Ciudad("0573", "Tunja", false, "1");
	
	private Ciudad medellin = new Ciudad ("0572", "Medellin", false , "1");
	
	private Ciudad Bogotá = new Ciudad("0571", "Bogotá", true, "1");
	
	//korea del norte
	
	private Ciudad Pionyang = new Ciudad ("8501", "Pionyang", true,"148");
	
	private Ciudad Sinuiju = new Ciudad ("8502", "Sinuiju", false,"148");
	
	private Ciudad Haeju = new Ciudad ("8503", "Haeju", false,"148");
	
	//titulares
	private Titular SalomeDorado = new Titular ("1023530646", "17/03/04", "SalomeDorado");
	
	private Titular Allyson = new Titular ("1000034908","14/04/2002", "Allyson Velandia");
	
	private Titular Cristina = new Titular ("107678654","14/07/2001", "Cristina dorado");
	
	private Titular Sam = new Titular ("10105413","10/20/2005", "Samuel Arce");

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
