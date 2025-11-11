package co.edu.poli.actividad1.Controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Servicios.AdaptadorPais;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;

public class ControladorEstado implements Initializable {
	
	private ArrayList <AdaptadorPais> paisesA = new ArrayList<AdaptadorPais>();
	
	private ArrayList <Ciudad> ciudades = new ArrayList<Ciudad>();
	
	private ObservableList<String> paises;

    @FXML
    private Button bttEstado;

    @FXML
    private Button bttSwitch;

    @FXML
    private ComboBox<?> selectEstado;

    @FXML
    private ComboBox<?> selectPais;

    @FXML
    private TextField showCurrent;

    @FXML
    private TreeView<?> showEstado;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Paises
		//paises
		Pais colombia = new Pais ("1","Colombia","espaniol", ciudades);
				
		Pais KoreadelNorte = new Pais ("148","Korea del Norte","koreano", ciudades);
				
		Pais Mexico = new Pais ("49","Mexico","Espannol", ciudades);
				
		Pais EstadosUnidos = new Pais ("104", "EstadosUnidos", "ingles",ciudades);
		
		AdaptadorPais col = new AdaptadorPais(colombia);
		
		AdaptadorPais kor = new AdaptadorPais(KoreadelNorte);
		
		AdaptadorPais mex = new AdaptadorPais(Mexico);
		
		AdaptadorPais usa = new AdaptadorPais(EstadosUnidos);
		
	}

    @FXML
    void cambiarEstado(ActionEvent event) {

    }

    @FXML
    void showEstado(ActionEvent event) {

    }

    @FXML
    void switchToPrimary(ActionEvent event) {

    }

}
