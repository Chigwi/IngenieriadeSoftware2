package co.edu.poli.actividad1.Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Servicios.AdaptadorPais;
import co.edu.poli.actividad1.Servicios.Estado;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;

public class ControladorEstado implements Initializable {
	
	private ArrayList <AdaptadorPais> paisesA = new ArrayList<AdaptadorPais>();
	
	private ArrayList <Estado> states = new ArrayList<Estado>();
	
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
    private Label showCurrent;

    @FXML
    private TextArea showEstado;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//paises y adaptadores
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
		
		//crear nuevos estados
		
		norm = new EstadoNormal();
		
		rev = new EstadoRevision();
		
		sol  = new SolicitudVisa();
		
		fron = new FronteraCerrada();
		
		
		
		//colocar el estado normal a los paises de base
		col.setEstado(norm);
		kor.setEstado(norm);
		mex.setEstado(norm);
		usa.setEstado(norm);
		
		//añadir estados a la lista de estados totales
		states.add(rev);
		states.add(fron);
		states.add(norm);
		states.add(sol);
		
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
		//en caso de añadir uno nuevo añadir aqui a el combo box
		
		selectPais.setItems(paises);
		
		selectEstado.setItems(estados);
		
	}

    @FXML
    void cambiarEstado(ActionEvent event) {
    	String deseado = selectEstado.getSelectionModel().getSelectedItem();
    	
    	String pais = selectPais.getSelectionModel().getSelectedItem();
    	
    	//verificar que los campos esten seleccionados
    	if(deseado != null && pais != null) {
    		AdaptadorPais p = null;
        	//buscar pais seleccionado
        	for (int i = 0; i < paisesA.size(); i++) {
    			if(paisesA.get(i).getPais().getNombre().equals(pais)) {
    				p = paisesA.get(i);
    			}
    		}
        	//actualizar estado
        	//el nombre debe ser igual que en el combo box
        	if(deseado.equals("Estado Normal")) {
        		p.cambiarEstado(norm);
        		showCurrent.setText(deseado);
        		llenarArbol(pais);
        	}else if(deseado.equals("Estado Revision")) {
        		p.cambiarEstado(rev);
        		showCurrent.setText(deseado);
        		llenarArbol(pais);
        	}else if(deseado.equals("Solicitud de visa")) {
        		p.cambiarEstado(sol);
        		showCurrent.setText(deseado);
        		llenarArbol(pais);
        	}else if(deseado.equals("Frontera cerrada")) {
        		System.out.println("spp");
        		p.cambiarEstado(fron);
        		showCurrent.setText(deseado);
        		llenarArbol(pais);
        	}else if(deseado.equals("InserteEstadoAqui")) {
        		//cambiar estado al deseado
        	}
    	}else {
    		Alert a = new Alert (AlertType.INFORMATION);
    		
        	a.setContentText("Seleccione un pais y un estado a cambiar");
        	
        	a.showAndWait();
    	}
    	
    }

    @FXML //muestra el estado actual del pais seleccionado
    void showEstado(ActionEvent event) {
    	
    	String pais = selectPais.getSelectionModel().getSelectedItem();
    	
    	for (int i = 0; i < paisesA.size(); i++) {
			if(paisesA.get(i).getPais().getNombre().equals(pais)) {
				//busca el pais seleccionado y muestra los datos
				llenarArbol(paisesA.get(i).getPais().getNombre());
				showCurrent.setText(paisesA.get(i).getEstado().toString());
			}
		}
    }

    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
    	App.setRoot("primary");

    }
    //muestra los datos del estado actual
    private void llenarArbol(String estado) {
    	//limpia el area
    	showEstado.clear();
    	StringBuilder message = new StringBuilder();
    	String estadoActual = "";
    	//busca el pais actual y su estado
    	for (int i = 0; i < paisesA.size(); i++) {
			if (paisesA.get(i).getPais().getNombre().equals(estado)) {
				estadoActual += paisesA.get(i).getEstado();
				
				message.append(paisesA.get(i).getPais().getNombre()+"\n");
			}
		}
    	//busca los casos para estados a los que se puede mover
    	if(estadoActual.equals("EstadoNormal")) {
    		String indentStr = "-".repeat(1);
    		message.append(indentStr);
    		message.append(estadoActual + "\n");
    		String notice = "-".repeat(2);
    		String indentStr1 = "-".repeat(3);
    		
    		message.append(notice);
    		message.append("Posibles estados a cambiar"  + "\n");
    		//indica los posibles estados a mover
    		message.append(indentStr1);
    		message.append(">EstadoRevision"  + "\n");
    		
    		message.append(indentStr1);
    		message.append(">SolicitudVisa"  + "\n");
    		
    		message.append(indentStr1);
    		message.append(">FronteraCerrada"  + "\n");
    		
    		showEstado.setText(message.toString());
    	}else if(estadoActual.equals("EstadoRevision")) {
    		String indentStr = "-".repeat(1);
    		message.append(indentStr);
    		message.append(estadoActual + "\n");
    		String notice = "-".repeat(2);
    		String indentStr1 = "-".repeat(3);
    		
    		message.append(notice);
    		message.append("Posibles estados a cambiar"  + "\n");
    		//indica los posibles estados a mover
    		message.append(indentStr1);
    		message.append(">SolicitudVisa"  + "\n");
    		
    		showEstado.setText(message.toString());
    	}else if(estadoActual.equals("SolicitudVisa")) {
    		String indentStr = "-".repeat(1);
    		message.append(indentStr);
    		message.append(estadoActual + "\n");
    		String notice = "-".repeat(2);
    		String indentStr1 = "-".repeat(3);
    		
    		message.append(notice);
    		message.append("Posibles estados a cambiar"  + "\n");
    		//indica los posibles estados a mover
    		message.append(indentStr1);
    		message.append(">FronteraCerrada"  + "\n");
    		
    		message.append(indentStr1);
    		message.append(">EstadoNormal"  + "\n");
    		
    		showEstado.setText(message.toString());
    	}else if(estadoActual.equals("FronteraCerrada")) {
    		String indentStr = "-".repeat(1);
    		message.append(indentStr);
    		message.append(estadoActual + "\n");
    		String notice = "-".repeat(2);
    		String indentStr1 = "-".repeat(3);
    		
    		message.append(notice);
    		message.append("Posibles estados a cambiar"  + "\n");
    		//indica los posibles estados a mover
    		message.append(indentStr1);
    		message.append(">EstadoNormal"  + "\n");
    		
    		showEstado.setText(message.toString());
    	}else if(estadoActual.equals("InserteEstadoAqui")) {
    		//plantilla para nodo nuevo
    		String indentStr = "-".repeat(1);
    		message.append(indentStr);
    		message.append(estadoActual + "\n");
    		String notice = "-".repeat(2);
    		String indentStr1 = "-".repeat(3);
    		
    		message.append(notice);
    		message.append("Posibles estados a cambiar"  + "\n");
    		//estados a los que el nuevo nodo conecta
    		message.append(indentStr1);
    		message.append(">EstadoRevision"  + "\n");
    		
    		message.append(indentStr1);
    		message.append(">SolicitudVisa"  + "\n");
    		
    		message.append(indentStr1);
    		message.append(">FronteraCerrada"  + "\n");
    		
    		showEstado.setText(message.toString());
    	}else {
    		showEstado.setText("Estado no valido");
    	}
    	estadosPosibles(estadoActual);
    	
    }
    //muestra en el combo box los estados posibles
    private void estadosPosibles(String estado) {
    	if(estado.equals("EstadoNormal")) {
    		//limpia el area
    		estados.clear();
    		//indica los estados a los que se puede cambiar
    		estados.add("Estado Revision");
    		
    		estados.add("Solicitud de visa");
    		
    		estados.add("Frontera cerrada");
    		selectEstado.setItems(estados);
    		
    	}else if(estado.equals("EstadoRevision")) {
    		estados.clear();
    		//indica los estados a los que se puede cambiar
    		estados.add("Solicitud de visa");
    		
    		selectEstado.setItems(estados);
    		
    	}else if(estado.equals("SolicitudVisa")) {
    		estados.clear();
    		//indica los estados a los que se puede cambiar
    		estados.add("Estado Normal");
    		
    		estados.add("Frontera cerrada");
    		
    		selectEstado.setItems(estados);
    		
    	}else if(estado.equals("FronteraCerrada")) {
    		estados.clear();
    		//indica los estados a los que se puede cambiar
    		estados.add("Estado Normal");
    		
    		selectEstado.setItems(estados);
    		
    	}else if(estado.equals("inserteEstadoAqui")){
    		//plantilla para nodo nuevo
    		//limpiar el area
    		estados.clear();
    		estados.add("Estado Normal");
    		//indicar los estados a los que se puede cambiar
    		estados.add("Estado Revision");
    		
    		estados.add("Solicitud de visa");
    		
    		estados.add("Frontera cerrada");
    		selectEstado.setItems(estados);
    	}else {
    		showEstado.setText("Estado no valido");
    	}
    }

}
