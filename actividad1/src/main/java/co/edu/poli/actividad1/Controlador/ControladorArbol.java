package co.edu.poli.actividad1.Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.poli.actividad1.Servicios.EspacioGeografico;
import co.edu.poli.actividad1.Servicios.Region;
import co.edu.poli.actividad1.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControladorArbol implements Initializable{

    @FXML
    private Button bttAtras;

    @FXML
    private Button bttMostrar;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//jota
		// TODO Auto-generated method stub
		
		ArrayList<EspacioGeografico> listAnd = new ArrayList<EspacioGeografico>();
		Region andina = new Region(listAnd, "Andina");
		
		ArrayList<EspacioGeografico> listCar = new ArrayList<EspacioGeografico>();
		Region caribe = new Region(listCar, "Caribe");
		
		ArrayList<EspacioGeografico> listPac = new ArrayList<EspacioGeografico>();
		Region pacifica = new Region(listPac, "Pacifica");
		
		ArrayList<EspacioGeografico> listOri = new ArrayList<EspacioGeografico>();
		Region orinoquia = new Region(listOri, "Orinoquia");
		
		ArrayList<EspacioGeografico> listAma = new ArrayList<EspacioGeografico>();
		Region Amazonas = new Region(listAma, "Amazonias");
		
	}

    @FXML
    void getNombre(ActionEvent event) {

    }

    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");

    }



}
