package co.edu.poli.actividad1.Controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import co.edu.poli.actividad1.Modelo.Biometrico;
import co.edu.poli.actividad1.Modelo.Blockchain;
import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.ElementoSeguridad;
import co.edu.poli.actividad1.Modelo.MicroChip;
import co.edu.poli.actividad1.Modelo.PDiplomatico;
import co.edu.poli.actividad1.Modelo.POrdinario;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Modelo.Titular;
import co.edu.poli.actividad1.Repositorios.CiudadDao;
import co.edu.poli.actividad1.Repositorios.PaisDao;
import co.edu.poli.actividad1.Repositorios.PasaporteDao;
import co.edu.poli.actividad1.Repositorios.TitularDao;
import co.edu.poli.actividad1.Servicios.AdaptadorPasaporte;
import co.edu.poli.actividad1.Servicios.Asesor;
import co.edu.poli.actividad1.Servicios.Cancilleria;
import co.edu.poli.actividad1.Servicios.CareTaker;
import co.edu.poli.actividad1.Servicios.CertificarBiometria;
import co.edu.poli.actividad1.Servicios.CertificarBlockChain;
import co.edu.poli.actividad1.Servicios.CertificarMicroChip;
import co.edu.poli.actividad1.Servicios.Command;
import co.edu.poli.actividad1.Servicios.CommandManager;
import co.edu.poli.actividad1.Servicios.CommandValidarFecha;
import co.edu.poli.actividad1.Servicios.CommandValidarTipo;
import co.edu.poli.actividad1.Servicios.CommandValidarTitular;
import co.edu.poli.actividad1.Servicios.ConcreteMemento;
import co.edu.poli.actividad1.Servicios.ContextoSeguridad;
import co.edu.poli.actividad1.Servicios.DatabaseConnection;
import co.edu.poli.actividad1.Servicios.DiplomaticoCreator;
import co.edu.poli.actividad1.Servicios.Memento;
import co.edu.poli.actividad1.Servicios.Migracion;
import co.edu.poli.actividad1.Servicios.OrdinarioCreator;
import co.edu.poli.actividad1.Servicios.PasaporteOriginator;
import co.edu.poli.actividad1.Servicios.Policia;
import co.edu.poli.actividad1.Servicios.Publisher;
import co.edu.poli.actividad1.Servicios.RelacionesExteriores;
import co.edu.poli.actividad1.Servicios.Supervisor;
import co.edu.poli.actividad1.Servicios.Validacion;
import co.edu.poli.actividad1.vista.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ControlPantallaPasaporte implements Initializable {
	
	private Validacion val;
	
	private Connection con;
	
	private PasaporteDao regPas;
	
	private CiudadDao regCiu;
	
	private PaisDao regPais;
	
	private TitularDao regTit;
	
	private ArrayList <Pais> totiPais = new ArrayList<Pais>();
	
	private ArrayList <Titular> totiTit = new ArrayList<Titular>();
	
	private ArrayList <Ciudad> ciudades = new ArrayList<Ciudad>();
	
	private ArrayList <Ciudad> ciudadesKorea = new ArrayList<Ciudad>();
	
	private ArrayList <Ciudad> ciudadesMexico= new ArrayList<Ciudad>();
	
	private ArrayList <Ciudad> gringos= new ArrayList<Ciudad>();

    @FXML
    private Button bttInsertar;
    
    @FXML
    private Button bttRestaurar;

    @FXML
    private Button bttGuardar;

    @FXML
    private Button bttconfirmar;
    

    @FXML
    private Button bttSolicitar;
    
    @FXML
    private Button bttValFecha;

    @FXML
    private Button bttValTipo;

    @FXML
    private Button bttValTitular;
    

    @FXML
    private ComboBox<Integer> selectCambios;

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
    private ComboBox<String> selectCiudad;

    @FXML
    private DatePicker selectFecha;
    
    @FXML
    private Button bttVerificar;

    @FXML
    private ComboBox<String> selectElemento;

    @FXML
    private ComboBox<String> selectPais;

    @FXML
    private ComboBox<String> selectUsuarios;

    @FXML
    private ToggleGroup tipoPasaporte;
    
    @FXML
    private Button bttSelectAll;
    
    @FXML
    private Button bttSiguiente;
    
    //paises strategy
    
    private ArrayList<String> stratP =  new ArrayList<String>();

	//lista observable
	private ObservableList<String> paises;
	
	private ObservableList<String> ciudad;
	
	private ObservableList<String> titulares;
	
	private ObservableList<String> elementos;
	
	private ObservableList<Integer>cambios;
	
	private DiplomaticoCreator dC;
	
	private OrdinarioCreator oC;
	
	private boolean textEmpty;
	
	private CareTaker historial;
	
	private Integer cambio;
	
	
	
	
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//estado del metodo selectAll
		
		textEmpty = true;
		
		//fabricas
		
		dC = new DiplomaticoCreator();
		
		oC = new OrdinarioCreator();
		
		//lista observable
		
		paises  = FXCollections.observableArrayList();
		
		ciudad = FXCollections.observableArrayList();
		
		titulares  = FXCollections.observableArrayList();
		
		elementos = FXCollections.observableArrayList();
		
		//quema de objetos
		
		//paises
		Pais colombia = new Pais ("1","Colombia","espaniol", ciudades);
		
		Pais KoreadelNorte = new Pais ("148","Korea del Norte","koreano", ciudadesKorea);
		
		Pais Mexico = new Pais ("49","Mexico","Espannol", ciudadesMexico);
		
		Pais EstadosUnidos = new Pais ("104", "EstadosUnidos", "ingles",gringos);
		
		//estados unidos
		Ciudad Washington = new Ciudad ("0001", "washington", true,"104");
		
		Ciudad Miami = new Ciudad ("0002", "Miami", false, "104");
		
		Ciudad newYork = new Ciudad ("0003", "New York", false, "104");
		
		//mexico
		Ciudad CiudadDeMexico = new Ciudad ("0521", "Ciudad De mexico", true,"49");
		
		Ciudad Cancun = new Ciudad ("0522", "Cancun", false,"49");
		
		Ciudad Monterrey = new Ciudad ("0523", "Monterrey", false,"49");
		
		//colombia
		Ciudad Tunja = new Ciudad("0573", "Tunja", false, "1");
		
		Ciudad medellin = new Ciudad ("0572", "Medellin", false , "1");
		
		Ciudad Bogotá = new Ciudad("0571", "Bogotá", true, "1");
		
		//korea del norte
		
		Ciudad Pionyang = new Ciudad ("8501", "Pionyang", true,"148");
		
		Ciudad Sinuiju = new Ciudad ("8502", "Sinuiju", false,"148");
		
		Ciudad Haeju = new Ciudad ("8503", "Haeju", false,"148");
		
		//titulares
		Titular SalomeDorado = new Titular ("1023530646", "17/03/04", "SalomeDorado");
		
		Titular Allyson = new Titular ("1000034908","14/04/2002", "Allyson Velandia");
		
		Titular Cristina = new Titular ("107678654","14/07/2001", "Cristina dorado");
		
		Titular Sam = new Titular ("10105413","10/20/2005", "Samuel Arce");
		
		
		
		//conexiones de daos
		con =  DatabaseConnection.getInstance().getConnection();
		
		regPas = new PasaporteDao();
		
		regPais  = new PaisDao();
		
		regCiu  = new CiudadDao();
		
		regTit  = new TitularDao();
		
		regPas.setConnection(con);
		
		regPais.setConnection(con);
		
		regCiu.setConnection(con);
		
		regTit.setConnection(con);
		
		
		//llenar totiPais

		totiPais.add(colombia);
		totiPais.add(EstadosUnidos);
		totiPais.add(KoreadelNorte);
		totiPais.add(Mexico);
		
		//llenar totitit

		totiTit.add(SalomeDorado);
		totiTit.add(Allyson);
		totiTit.add(Cristina);
		totiTit.add(Sam);
		
		//ciudades colombia

		ciudades.add(Bogotá);
		ciudades.add(medellin);
		ciudades.add(Tunja);
		//ciudades estados unidos

		gringos.add(Washington);
		gringos.add(Miami);
		gringos.add(newYork);
		//ciudades Mexico

		ciudadesMexico.add(CiudadDeMexico);
		ciudadesMexico.add(Monterrey);
		ciudadesMexico.add(Cancun);
		//ciudades korea

		ciudadesKorea.add(Pionyang);
		ciudadesKorea.add(Haeju);
		ciudadesKorea.add(Sinuiju);
		
		//añadir paises
		paises.add(colombia.getNombre());
		paises.add(EstadosUnidos.getNombre());
		paises.add(KoreadelNorte.getNombre());
		paises.add(Mexico.getNombre());
		
		stratP.add(colombia.getNombre());
		stratP.add(EstadosUnidos.getNombre());
		stratP.add(KoreadelNorte.getNombre());
		stratP.add(Mexico.getNombre());
		
		selectPais.setItems(paises);
		
		//añadir titulares
		titulares.add(Allyson.getNombre());
		titulares.add(Cristina.getNombre());
		titulares.add(SalomeDorado.getNombre());
		titulares.add(Sam.getNombre());
		
		selectUsuarios.setItems(titulares);
		
		selectCiudad.setDisable(true);
		
		//elementos de seguridad
		
		 elementos.add("MicroChip");
		 elementos.add("Biometrico");
		 elementos.add("Blockchain");
		 
		 selectElemento.setItems(elementos);
		 
		 //bloqueo de actualizar hasta que se lea
	    	bttactualizar.setDisable(true);
	    	bttVerificar.setVisible(false);
	    	bttVerificar.setDisable(true);		
	    	
	    //bloqueo botones memento
	    	bttconfirmar.setVisible(false);
			bttGuardar.setVisible(false);
			bttRestaurar.setVisible(false);
	    	bttconfirmar.setDisable(true);
			bttGuardar.setDisable(true);
			bttRestaurar.setDisable(true);
			selectCambios.setVisible(false);
			bttSolicitar.setDisable(true);
		//historial memento
		historial = new CareTaker();
		cambio = 0;
		cambios =  FXCollections.observableArrayList();
		
		//strategy
		bttInsertar.setDisable(true);
		bttdelete.setDisable(true);
		bttShow.setDisable(true);
		inExtra.setDisable(true);
		selectFecha.setDisable(true);
		selectPais.setDisable(true);
		selectUsuarios.setDisable(true);
		inDiplomatico.setDisable(true);
		inOrdinario.setDisable(true);
		
		//command
		bttValFecha.setDisable(true);
		bttValTipo.setDisable(true);
		bttValTitular.setDisable(true);
		val = new Validacion(regPas);
	}

    @FXML
    void selectStrategy(ActionEvent event) {
    	if(selectElemento.getSelectionModel().getSelectedItem().equals("MicroChip")) {
    		CertificarMicroChip c = new CertificarMicroChip();
    		ContextoSeguridad con = new ContextoSeguridad(c);
    		HashMap<String, String> strat = con.certificar(stratP);
    		strategy(strat);
    	}else if(selectElemento.getSelectionModel().getSelectedItem().equals("Biometrico")) {
    		CertificarBiometria c = new CertificarBiometria();
    		ContextoSeguridad con = new ContextoSeguridad(c);
    		HashMap<String, String> strat = con.certificar(stratP);
    		strategy(strat);
    	}else {
    		CertificarBlockChain c = new CertificarBlockChain();
    		ContextoSeguridad con = new ContextoSeguridad(c);
    		HashMap<String, String> strat = con.certificar(stratP);
    		strategy(strat);
    	}
    }
    private void strategy(HashMap<String,String>estrategia) {
    	
    	bttInsertar.setDisable(false);
		bttdelete.setDisable(false);
		bttShow.setDisable(false);
		inExtra.setDisable(false);
		selectFecha.setDisable(false);
		selectUsuarios.setDisable(false);
		
		
		selectPais.setDisable(false);
		inDiplomatico.setDisable(true);
		inOrdinario.setDisable(true);
		
		ObservableList<String> newP = FXCollections.observableArrayList();
		
		for(Map.Entry<String, String> entry : estrategia.entrySet()) {
			String val = entry.getValue();
			String key = entry.getKey();
			if(!val.equals("Bloqueado")) {
				newP.add(key);
				if(val.equals("Ordinario")) {
					inOrdinario.setDisable(false);
				}else {
					inDiplomatico.setDisable(false);
				}
			}
		}

		selectPais.setItems(newP);
    }
	
    @FXML
    void SelectPais(ActionEvent event) {
    	
    	if(ciudad.size()>0) {
    		ciudad.clear();
    	}

    	String pais = selectPais.getSelectionModel().getSelectedItem();
    	for (int i = 0; i < totiPais.size(); i++) {
			if(totiPais.get(i).getNombre().equals(pais)) {
				int toti = totiPais.get(i).getCiudades().size();
				Pais p = totiPais.get(i);
				for (int j = 0; j < toti ; j++) {
					ciudad.add(p.getCiudades().get(j).getNombre());
				}
			}
		}
    	selectCiudad.setItems(ciudad);
    	selectCiudad.setDisable(false);
    	
    }
    @FXML
    void DeletePasaporte(ActionEvent event) {
    	
    	if(textEmpty == false) {
    		inExtra.clear();
    	}
    	
    	bttactualizar.setDisable(true);
    	bttVerificar.setVisible(false);
    	bttVerificar.setDisable(true);		
    	
    	bttconfirmar.setVisible(false);
		bttGuardar.setVisible(false);
		bttRestaurar.setVisible(false);
    	bttconfirmar.setDisable(true);
		bttGuardar.setDisable(true);
		bttRestaurar.setDisable(true);
		selectCambios.setVisible(false);
		
    	inIdPasaporte.setDisable(false);
    	inIdPasaporte.setVisible(true);
    	
    	bttselect.setDisable(false);
    	bttselect.setVisible(true);
    
    	bttselect.setText("Eliminar");
    	


    }

    @FXML
    void actualizarPasaporte(ActionEvent event) {
    	
    	if(textEmpty == false) {
    		inExtra.clear();
    	}
    	
    	bttconfirmar.setVisible(true);
		bttGuardar.setVisible(true);
		bttRestaurar.setVisible(true);
    	
    	bttconfirmar.setDisable(false);
		bttGuardar.setDisable(false);
		bttRestaurar.setDisable(false);
		selectCambios.setVisible(true);
    	
    	inIdPasaporte.setDisable(false);
    	inIdPasaporte.setVisible(true);
    	
    	bttselect.setDisable(true);
    	bttselect.setVisible(true);
    	
    	bttVerificar.setVisible(true);
    	bttVerificar.setDisable(false);
    	bttselect.setText("Actualizar");
    	bttselect.setDisable(true);
    


    }

    @FXML
    void insertarPasaporte(ActionEvent event) {
    	
    	bttactualizar.setDisable(true);
    	bttVerificar.setVisible(false);
    	bttVerificar.setDisable(true);		
    	
    	bttconfirmar.setVisible(false);
		bttGuardar.setVisible(false);
		bttRestaurar.setVisible(false);
    	bttconfirmar.setDisable(true);
		bttGuardar.setDisable(true);
		bttRestaurar.setDisable(true);
		selectCambios.setVisible(false);
    	
    	if(!inDiplomatico.isSelected() && !inOrdinario.isSelected()) {
    		Alert a = new Alert (AlertType.INFORMATION);
    		
        	a.setContentText("Seleccione un tipo de pasaporte a insertar");
        	
        	a.showAndWait();
    	}
    	
    	if(textEmpty == false) {
    		inExtra.clear();
    	}
    	
    	inIdPasaporte.setDisable(true);
    	inIdPasaporte.setVisible(false);
    	
    	bttselect.setDisable(true);
    	bttselect.setVisible(false);
    	
    	if(isEmpty()) {
    		
    		
    	if(inDiplomatico.isSelected()) {
    		PDiplomatico p = dC.createPasaporte();
    		
    		p = llenarDiplomatico(p);

    		regPas.insert(p);
    		System.out.println(p.getNumeroId());

    		Alert a = new Alert (AlertType.INFORMATION);
    		
        	a.setContentText(p.toString());
        	
        	a.showAndWait();
        
        	
    	}else if(inOrdinario.isSelected()) {
		
    		POrdinario p = oC.createPasaporte();
    		
    		p = llenarOrdinario(p);
    		
    		regPas.insert(p);
    		System.out.println(p.getNumeroId());

    		Alert a = new Alert (AlertType.INFORMATION);
    		
        	a.setContentText(p.toString());
        	
        	a.showAndWait();
		
    	}
    	
    	}else {
    		Alert a = new Alert (AlertType.INFORMATION);
    		
        	a.setContentText("ingrese los datos completos del pasaporte");
        	
        	a.showAndWait();
        	
    		
    	}
    	

    }

    @FXML
    void selectPasaporte(ActionEvent event) {
    	
    	String funcion ="";
    	try {
    		if(bttselect.getText().equals("Buscar")) {
    			bttactualizar.setDisable(false);
    			funcion = "Busqueda";
        		read(inIdPasaporte.getText());
        		
        	}
        	else if(bttselect.getText().equals("Eliminar")) {
        		funcion = "Eliminacion";
        		
        		delete(inIdPasaporte.getText());
        		
        	}
        	else if(bttselect.getText().equals("Actualizar")) {
        		funcion = "Actualizacion";
        		
        		if(inDiplomatico.isSelected() == true) {
        			
        			PDiplomatico p = dC.createPasaporte();
        			
        			update(inIdPasaporte.getText(), p);
        			
        			
            		
            		
                	
        		}else if (inOrdinario.isSelected()) {

        			POrdinario p = oC.createPasaporte();
        			
            		update(inIdPasaporte.getText(), p);
            		
            		
                	
        		}else {
        			Alert a = new Alert (AlertType.INFORMATION);
                	a.setContentText("seleccione tipo de pasaporte");
                	a.show();
        		}

        	}
    	}catch(Exception e) {
    		Alert a = new Alert (AlertType.INFORMATION);
        	a.setContentText("Error de " + funcion + e.getMessage());
        	a.show();
    		
    	}
    	

    }

    @FXML
    void showSelect(ActionEvent event) {
    	bttactualizar.setDisable(true);
    	bttVerificar.setVisible(false);
    	bttVerificar.setDisable(true);		
    	
    	bttconfirmar.setVisible(false);
		bttGuardar.setVisible(false);
		bttRestaurar.setVisible(false);
    	bttconfirmar.setDisable(true);
		bttGuardar.setDisable(true);
		bttRestaurar.setDisable(true);
		selectCambios.setVisible(false);
		
    	inIdPasaporte.setDisable(false);
    	inIdPasaporte.setVisible(true);
    	
    	bttselect.setDisable(false);
    	bttselect.setVisible(true);
    	
    	
    	bttselect.setText("Buscar");
    	
    	

    }

    @FXML
    void textDiplomatico(ActionEvent event) {
    	
    	inExtra.setPromptText("ingrese mision diplomatica");

    }

    @FXML
    void textOrdinario(ActionEvent event) {
    	
    	inExtra.setPromptText("ingrese mision de viaje");

    }
    
    @FXML
    void validarFecha(ActionEvent event) {
    	
    	
    	
    	if(inDiplomatico.isSelected()) {
    		PDiplomatico pd = (PDiplomatico)dC.createPasaporte();
    		pd = llenarDiplomatico(pd);
    		
    		pd.setNumeroId(inIdPasaporte.getText());
    		
    		String fecha = pd.getFechaEmision();
        	
        	CommandValidarFecha valFecha = new CommandValidarFecha(val, fecha);
        	
        	CommandManager man = new CommandManager(valFecha);
        	
        	String msg = man.execute();
        	
        	Alert a = new Alert(AlertType.INFORMATION);
    		
    		a.setContentText(msg);
        	
        	a.showAndWait();
    	}else {
    		POrdinario po = (POrdinario)oC.createPasaporte();
    		po = llenarOrdinario(po);
    		
    		po.setNumeroId(inIdPasaporte.getText());
    		
    		String fecha = po.getFechaEmision();
        	
        	CommandValidarFecha valFecha = new CommandValidarFecha(val, fecha);
        	
        	CommandManager man = new CommandManager(valFecha);
        	
        	String msg = man.execute();
        	
        	Alert a = new Alert(AlertType.INFORMATION);
    		
    		a.setContentText(msg);
        	
        	a.showAndWait();
    	}

    }

    @FXML
    void validarTitular(ActionEvent event) {

    	if(inDiplomatico.isSelected()) {
    		
    		PDiplomatico pd = dC.createPasaporte();
    		pd = llenarDiplomatico(pd);
    		
    		pd.setNumeroId(inIdPasaporte.getText());
    		
    		AdaptadorPasaporte adaptada = new AdaptadorPasaporte(pd);
    		
    		CommandValidarTitular c = new CommandValidarTitular(adaptada, val);
    		
    		CommandManager man = new CommandManager(c);
    		
    		String msg = man.execute();
        	
        	Alert a = new Alert(AlertType.INFORMATION);
    		
    		a.setContentText(msg);
        	
        	a.showAndWait();
    		
    	}else {
    		
    		POrdinario po = oC.createPasaporte();
    		po = llenarOrdinario(po);
    		
    		po.setNumeroId(inIdPasaporte.getText());
    		
    		AdaptadorPasaporte adaptada = new AdaptadorPasaporte(po);
    		
    		CommandValidarTitular c = new CommandValidarTitular(adaptada, val);
    		
    		CommandManager man = new CommandManager(c);
    		
    		String msg = man.execute();
        	
        	Alert a = new Alert(AlertType.INFORMATION);
    		
    		a.setContentText(msg);
        	
        	a.showAndWait();
    		
    	}
    	
    }

    @FXML
    void valildarTipo(ActionEvent event) {
    	
    	if (inDiplomatico.isSelected()) {
    		String tipo = "diplomatico";
    		
    		PDiplomatico pd = dC.createPasaporte();
    		pd = llenarDiplomatico(pd);
    		
    		pd.setNumeroId(inIdPasaporte.getText());
    		
    		pd.setNumeroId(inIdPasaporte.getText());
    		
    		AdaptadorPasaporte adaptada = new AdaptadorPasaporte(pd);
    		
    		CommandValidarTipo c = new CommandValidarTipo(tipo, val, adaptada);
    		
    		CommandManager man = new CommandManager(c);
    		
    		String msg = man.execute();
        	
        	Alert a = new Alert(AlertType.INFORMATION);
    		
    		a.setContentText(msg);
        	
        	a.showAndWait();
    		
    	}else {
    		
    		String tipo = "ordinario";
    		
    		POrdinario po = oC.createPasaporte();
    		po = llenarOrdinario(po);
    		
    		po.setNumeroId(inIdPasaporte.getText());
    		
    		AdaptadorPasaporte adaptada = new AdaptadorPasaporte(po);
    		
    		CommandValidarTipo c = new CommandValidarTipo(tipo, val, adaptada);
    		
    		CommandManager man = new CommandManager(c);
    		
    		String msg = man.execute();
        	
        	Alert a = new Alert(AlertType.INFORMATION);
    		
    		a.setContentText(msg);
        	
        	a.showAndWait();
    		
    	}

    }
   

    @FXML
    void selectAll(ActionEvent event) {

    	bttactualizar.setDisable(true);
    	bttVerificar.setVisible(false);
    	bttVerificar.setDisable(true);		
    	
    	bttconfirmar.setVisible(false);
		bttGuardar.setVisible(false);
		bttRestaurar.setVisible(false);
    	bttconfirmar.setDisable(true);
		bttGuardar.setDisable(true);
		bttRestaurar.setDisable(true);
		selectCambios.setVisible(false);
    	
    	textEmpty = false;
    	
    	inExtra.setText(regPas.selectAll().toString());

    
    }
    
    @FXML
    void switchToSecondary(ActionEvent event) throws IOException {
        App.setRoot("Secondary");

    }
    
    
    private String idGen(String id) {
        Random g = new Random();
        StringBuilder Nid = new StringBuilder();
        if(regPas.select(id)==null) {
        	// Generate 2 uppercase letters (A-Z)
            for (int i = 0; i < 2; i++) {
                char letter = (char) ('A' + g.nextInt(26));  // 'A' + 0..25
                Nid.append(letter);
            }

            // Generate 4 digits (0-9)
            for (int i = 0; i < 4; i++) {
                char digit = (char) ('0' + g.nextInt(10));  // '0' + 0..9
                Nid.append(digit);
            }
        	return Nid.toString();
        	
        }else {
        	return idGen(Nid.toString());
        }
    }
    
    private void read(String id) throws SQLException, Exception {
    	
    	if(inIdPasaporte.getText().equals("")) {
    		Alert a = new Alert(AlertType.INFORMATION);
    		
    		a.setContentText("por favor ingrese un identificador a buscar.");
        	
        	a.showAndWait();
    	}else {
    		Pasaporte p = regPas.select(id);
        	
        	Alert a = new Alert(AlertType.INFORMATION);
    		
    		a.setContentText(p.toString());
        	
        	a.showAndWait();
    	}
    	
    	

    }
    
    private void update(String id, Pasaporte p) throws SQLException {
    	//metodo que ejecuta la actualizacion despues de confirmar los datos
    	if (!inIdPasaporte.getText().equals(null)) {
    		if (isEmpty()) {
    			if (inDiplomatico.isSelected()) {
    				p = llenarDiplomatico((PDiplomatico)p);
    				p.setNumeroId(id);
    				
    				if (regPas.select(id) != null) {
    					
    					regPas.Update(p);
    					
    					visualizarCampoPasaporte(p);
    					
    					Publisher ob = new Publisher();
    					
    					Policia policia = new Policia();
    					
    					Migracion migracion = new Migracion();
    					
    					Cancilleria cancilleria = new Cancilleria();
    					
    					ob.subscribir(cancilleria);
    					ob.subscribir(migracion);
    					ob.subscribir(policia);
    					
    					Alert a = new Alert(AlertType.INFORMATION);
    	        		
    	        		a.setContentText(ob.notificar(id));
    	            	
    	            	a.showAndWait();
    				}
    				else {
    					Alert a = new Alert(AlertType.INFORMATION);
    	        		
    	        		a.setContentText("Pasaporte no existe");
    	            	
    	            	a.showAndWait();
    				}
    			}
    			else {
    				
    				p = llenarOrdinario((POrdinario)p);
    				p.setNumeroId(id);
    				
    				if (regPas.select(id) != null) {
    					
    					regPas.Update(p);
    					
    					visualizarCampoPasaporte(p);
    					
    					Publisher ob = new Publisher();
    					
    					Policia policia = new Policia();
    					
    					Migracion migracion = new Migracion();
    					
    					Cancilleria cancilleria = new Cancilleria();
    					
    					ob.subscribir(cancilleria);
    					ob.subscribir(migracion);
    					ob.subscribir(policia);
    					
    					Alert a = new Alert(AlertType.INFORMATION);
    	        		
    	        		a.setContentText(ob.notificar(id));
    	            	
    	            	a.showAndWait();
    				}
    				else {
    					Alert a = new Alert(AlertType.INFORMATION);
    	        		
    	        		a.setContentText("Pasaporte no existe");
    	            	
    	            	a.showAndWait();
    				}
    			}
    		}
    		else {
    			Alert a = new Alert(AlertType.INFORMATION);
        		
        		a.setContentText("por favor ingrese los datos completos del pasaporte.");
            	
            	a.showAndWait();
    		}
    	}
    	else {
    		Alert a = new Alert(AlertType.INFORMATION);
    		
    		a.setContentText("por favor ingrese un identificador a actualizar.");
        	
        	a.showAndWait();
    	}
    }
    
    private void delete (String id) throws SQLException {
    	if(inIdPasaporte.getText().equals("")) {
    		Alert a = new Alert(AlertType.INFORMATION);
    		
    		a.setContentText("por favor ingrese un identificador a eliminar.");
        	
        	a.showAndWait();
    	}else {
    		regPas.Delete(id);
    		Alert a = new Alert (AlertType.INFORMATION);
    		
        	a.setContentText("eliminacion exitosa!");
        	
        	a.show();
    	}
    	
    	
    }
    private boolean isEmpty () {
	   if (selectFecha.getValue() != null &&
				selectPais.getSelectionModel().getSelectedItem() != null &&
				selectCiudad.getSelectionModel().getSelectedItem()!= null &&
				selectUsuarios.getSelectionModel().getSelectedItem()!=null &&
				selectElemento.getSelectionModel().getSelectedItem()!=null &&
				!inExtra.getText().isBlank()) {
		   return true;
		   
	   }else {
		   return false;
	   }
   }
    
    private PDiplomatico llenarDiplomatico(PDiplomatico p) {
    	//metodo que crea los objetos necesarios para crear un pasaporte diplomatico
    	String nPais = selectPais.getSelectionModel().getSelectedItem().toString();
		
		Pais pa = new Pais(null, null, null, null);
		
		for (int i = 0; i < totiPais.size(); i++) {
			if (totiPais.get(i).getNombre().equals(nPais)) {
				pa = totiPais.get(i);
			}
		}
		String nCiu = selectCiudad.getSelectionModel().getSelectedItem().toString();
		
		Ciudad ci = new Ciudad(null, null, false, null);
		
		for (int i = 0; i < pa.getCiudades().size(); i++) {
			if (pa.getCiudades().get(i).getNombre().equals(nCiu)) {
				ci = pa.getCiudades().get(i);
			}
		}
		String nTit = selectUsuarios.getSelectionModel().getSelectedItem().toString();
		
		Titular ti = new Titular(null, null, null);
		
		for (int i = 0; i < totiTit.size(); i++) {
			if(totiTit.get(i).getNombre().equals(nTit)) {
				ti = totiTit.get(i);
			}
		}
		LocalDate fecha = selectFecha.getValue();
		
		String fechae = "01/01/2035";
		
		String id = "";
		
		String elementoSeguridar = selectElemento.getSelectionModel().getSelectedItem().toString();
		
		ElementoSeguridad es;
		
		if (elementoSeguridar.equals("MicroChip")) {
			es = new MicroChip(null, null, null, null);
		}else if(elementoSeguridar.equals("Biometrico")) {
			es = new Biometrico(null, null, null, null);
		}else {
			es = new Blockchain(null, null, null, null);
		}
		
		p.setCiudadEmision(ci);
		p.setFechaEmision(fecha.toString());
		p.setFechaExpiracion(fechae);
		p.setPaisEmisor(pa);
		p.setNumeroId(idGen(id));
		p.setMisionDiplomatica(inExtra.getText());
		p.setTitular(ti);
		p.setEs(es);
		
		return p;
    }
    
    private POrdinario llenarOrdinario(POrdinario p) {
    	//metodo que crea los objetos necesarios para crear un pasaporte ordinario
    	String nPais = selectPais.getSelectionModel().getSelectedItem().toString();
		
		Pais pa = new Pais(null, null, null, null);
		
		for (int i = 0; i < totiPais.size(); i++) {
			if (totiPais.get(i).getNombre().equals(nPais)) {
				pa = totiPais.get(i);
			}
		}
		String nCiu = selectCiudad.getSelectionModel().getSelectedItem().toString();
		
		Ciudad ci = new Ciudad(null, null, false, null);
		
		for (int i = 0; i < pa.getCiudades().size(); i++) {
			if (pa.getCiudades().get(i).getNombre().equals(nCiu)) {
				ci = pa.getCiudades().get(i);
			}
		}
		String nTit = selectUsuarios.getSelectionModel().getSelectedItem().toString();
		
		Titular ti = new Titular(null, null, null);
		
		for (int i = 0; i < totiTit.size(); i++) {
			if(totiTit.get(i).getNombre().equals(nTit)) {
				ti = totiTit.get(i);
			}
		}
		LocalDate fecha = selectFecha.getValue();
		
		String fechae = "01/01/2035";
		
		String id = "";

		String elementoSeguridar = selectElemento.getSelectionModel().getSelectedItem().toString();
		
		ElementoSeguridad es;
		
		if (elementoSeguridar.equals("MicroChip")) {
			es = new MicroChip(null, null, null, null);
		}else if(elementoSeguridar.equals("Biometrico")) {
			es = new Biometrico(null, null, null, null);
		}else {
			es = new Blockchain(null, null, null, null);
		}
		
		p.setCiudadEmision(ci);
		p.setFechaEmision(fecha.toString());
		p.setFechaExpiracion(fechae);
		p.setPaisEmisor(pa);
		p.setNumeroId(idGen(id));
		p.setRazonViaje(inExtra.getText());
		p.setTitular(ti);
		p.setEs(es);
		
		return p;
    }
    @FXML
    void verificar(ActionEvent event) {
    	
    	bttselect.setDisable(false);
    	bttactualizar.setDisable(false);
    	bttValFecha.setDisable(false);
    	bttValTipo.setDisable(false);
    	bttValTitular.setDisable(false);
    	
    	if (!inIdPasaporte.getText().equals(null)) {
    		String id = inIdPasaporte.getText();
    		
    		if (!regPas.select(id).equals(null)) {
    			Pasaporte p = regPas.select(id);
    			if (p instanceof POrdinario) {
    				POrdinario po = (POrdinario) p;
    				visualizarCampoPasaporte(po);
    			}else {
    				PDiplomatico pd = (PDiplomatico) p;
    				visualizarCampoPasaporte(pd);
    			}
    		}else {
    			Alert a = new Alert(AlertType.INFORMATION);
        		
        		a.setContentText("Pasaporte no existe");
            	
            	a.showAndWait();
    		}
    	}else {
    		Alert a = new Alert(AlertType.INFORMATION);
    		
    		a.setContentText("Inserte pasaporte a verificar.");
        	
        	a.showAndWait();
    	}
    	
    }
    
    void visualizarCampoPasaporte (Pasaporte in) {
    	bttselect.setDisable(true);
    	
    	Alert a = new Alert(AlertType.INFORMATION);
		
		a.setContentText("Recuerde que esto visualiza los datos, \n Favor llenar los datos completos");
    	
    	a.showAndWait();
    	
    	selectPais.setValue(in.getPaisEmisor().getNombre());
    	selectCiudad.setValue(in.getCiudadEmision().getNombre());
    	selectUsuarios.setValue(in.getTitular().getNombre());
    	
    	selectFecha.setValue(LocalDate.parse(in.getFechaEmision()));
    	selectFecha.setPromptText(in.getFechaEmision());
    	ElementoSeguridad elemen = in.getEs();
    	
    	
    	if(elemen instanceof MicroChip) {
    		selectElemento.setValue("MicroChip");
    	}else if (elemen instanceof Biometrico) {
    		selectElemento.setValue("Biometrico");
    	}else {
    		selectElemento.setValue("Blockchain");
    	}
    	if(in instanceof POrdinario) {
    		POrdinario p = (POrdinario) in;
    		inOrdinario.setSelected(true);
    		inDiplomatico.setSelected(false);
    		inExtra.setText(p.getRazonViaje());
    	}else {
    		PDiplomatico p = (PDiplomatico)in;
    		inDiplomatico.setSelected(true);
    		inOrdinario.setSelected(false);
    		inExtra.setText(p.getMisionDiplomatica());
    		
    	}
    	
    }

    @FXML
    void restore(ActionEvent event) {
    	if(selectCambios.getSelectionModel().getSelectedItem() == null) {
    		Alert a = new Alert(AlertType.INFORMATION);
    		
    		a.setContentText("Porfavor seleccione el cambio a restaurar");
        	
        	a.showAndWait();
    	}else {
    		ConcreteMemento og = (ConcreteMemento)historial.getMemento(selectCambios.getSelectionModel().getSelectedItem());
        	visualizarCampoPasaporte(og.getMemento().getState());
    		
    	}
    

    }

    @FXML
    void confirmar(ActionEvent event) {
    	bttSolicitar.setDisable(false);
    }
    

    @FXML
    void saveMemento(ActionEvent event) {
    	bttselect.setDisable(true);
     
    		if(isEmpty()) {
        		Pasaporte p = null;
            	if(inDiplomatico.isSelected()) {
            		p = new PDiplomatico(null,null,null,null,null,null,null,null);
            		p =llenarDiplomatico((PDiplomatico)p);
            	}else if(inOrdinario.isSelected()) {
            		p = new POrdinario(null,null,null,null,null,null,null,null);
            		p =llenarOrdinario((POrdinario)p);
            	}else {
                	Alert a = new Alert(AlertType.INFORMATION);
            		
            		a.setContentText("Seleccione un tipo de pasaporte");
                	
                	a.showAndWait();
            	}
            	p.setNumeroId(inIdPasaporte.getText());
            	PasaporteOriginator og = new PasaporteOriginator(p);
            	
            	cambio = cambio+1;
            	historial.addMemento(cambio, og.createMemento());
            	cambios.add(cambio);
            	selectCambios.setItems(cambios);
        	}
        	else {
        		Alert a = new Alert(AlertType.INFORMATION);
        		
        		a.setContentText("Porfavor ingrese los datos completos del pasaporte");
            	
            	a.showAndWait();
        	}
    }
    
    @FXML
    void solicitar(ActionEvent event) {
    	Random ran = new Random();
    	Asesor as1 = new Asesor();
    	Asesor as2 = new Asesor();
    	Supervisor sup1 = new Supervisor();
    	Supervisor sup2 = new Supervisor();
    	RelacionesExteriores ministro = new RelacionesExteriores();
    	
    	as1.setNextHandler(as2);
    	as2.setNextHandler(sup1);
    	sup1.setNextHandler(sup2);
    	sup2.setNextHandler(ministro);
    	
    	Integer in = ran.nextInt(60);
    	String sol = "";
    	
    	
    	bttselect.setDisable(false);
    	
    	Alert a = new Alert(AlertType.INFORMATION);
		
		a.setContentText(as1.manejarSolicitud(in, sol));
    	
    	a.showAndWait();
    }
    

 }

