package co.edu.poli.actividad1.Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Servicios.AdaptadorPais;
import co.edu.poli.actividad1.Servicios.EstadoNormal;
import co.edu.poli.actividad1.Servicios.EstadoRevision;
import co.edu.poli.actividad1.Servicios.FronteraCerrada;
import co.edu.poli.actividad1.Servicios.SolicitudVisa;
import co.edu.poli.actividad1.vista.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;

public class ControladorEstado implements Initializable {
	
	private ArrayList <AdaptadorPais> paisesA = new ArrayList<AdaptadorPais>();
	
	private ArrayList <Ciudad> ciudades = new ArrayList<Ciudad>();
	
	private ObservableList<String> paises;
	
	private ObservableList<String> estados;
	
	private EstadoNormal norm;
	
	private EstadoRevision rev;
	
	private SolicitudVisa sol;
	
	private FronteraCerrada fron;

    @FXML
    private Button bttEstado;

    @FXML
    private Button bttSwitch;

    @FXML
    private ComboBox<String> selectEstado;

    @FXML
    private ComboBox<String> selectPais;

    @FXML
    private TextField showCurrent;

    @FXML
    private TextArea showEstado;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//paises
		Pais colombia = new Pais ("1","Colombia","espaniol", ciudades);
				
		Pais KoreadelNorte = new Pais ("148","Korea del Norte","koreano", ciudades);
				
		Pais Mexico = new Pais ("49","Mexico","Espannol", ciudades);
				
		Pais EstadosUnidos = new Pais ("104", "EstadosUnidos", "ingles",ciudades);
		
		AdaptadorPais col = new AdaptadorPais(colombia);
		
		AdaptadorPais kor = new AdaptadorPais(KoreadelNorte);
		
		AdaptadorPais mex = new AdaptadorPais(Mexico);
		
		AdaptadorPais usa = new AdaptadorPais(EstadosUnidos);
		
		paisesA.add(col);
		paisesA.add(kor);
		paisesA.add(mex);
		paisesA.add(usa);
		
		//estados
		
		norm = new EstadoNormal();
		
		rev = new EstadoRevision();
		
		sol  = new SolicitudVisa();
		
		fron = new FronteraCerrada();
		
		col.setEstado(norm);
		kor.setEstado(norm);
		mex.setEstado(norm);
		usa.setEstado(norm);
		
		//combos
		paises  = FXCollections.observableArrayList();
		estados = FXCollections.observableArrayList();
		
		paises.add(colombia.getNombre());
		
		paises.add(KoreadelNorte.getNombre());
		
		paises.add(Mexico.getNombre());
		
		paises.add(EstadosUnidos.getNombre());
		
		estados.add("Estado Normal");
		
		estados.add("Estado Revision");
		
		estados.add("Solicitud de visa");
		
		estados.add("Frontera cerrada");
		
		selectPais.setItems(paises);
		
		selectEstado.setItems(estados);
		
	}

    @FXML
    void cambiarEstado(ActionEvent event) {

    	
    }

    @FXML
    void showEstado(ActionEvent event) {
    	
    	String pais = selectPais.getSelectionModel().getSelectedItem();
    	
    	for (int i = 0; i < paisesA.size(); i++) {
			if(paisesA.get(i).getPais().getNombre().equals(pais)) {
				llenarArbol(pais);
				break;
			}
		}
    }

    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
    	App.setRoot("primary");

    }
    
    private void llenarArbol(String estado) {
    	StringBuilder message = new StringBuilder();
    	String estadoActual = "";
    	for (int i = 0; i < paisesA.size(); i++) {
			if (paisesA.get(i).getPais().getNombre().equals(estado)) {
				estadoActual += paisesA.get(i).getEstado();
				message.append(paisesA.get(i).getPais().getNombre()+"\n");
			}
		}
    	if(estadoActual.equals("EstadoNormal")) {
    		String indentStr = "-".repeat(1);
    		message.append(indentStr);
    		message.append(estadoActual + "\n");
    		String notice = "-".repeat(2);
    		String indentStr1 = "-".repeat(3);
    		
    		message.append(notice);
    		message.append("Posibles estados a cambiar"  + "\n");
    		
    		message.append(indentStr1);
    		message.append("EstadoRevision"  + "\n");
    		
    		message.append(indentStr1);
    		message.append("SolicitudVisa"  + "\n");
    		
    		message.append(indentStr1);
    		message.append("FronteraCerrada"  + "\n");
    		
    		showEstado.setText(message.toString());
    	}else if(estadoActual.equals("EstadoRevision")) {
    		
    	}else if(estadoActual.equals("SolicitudVisa")) {
    		
    	}else if(estadoActual.equals("FronteraCerrada")) {
    		
    	}else {
    		showEstado.setText("Estado no valido");
    	}
    	
    }

}
