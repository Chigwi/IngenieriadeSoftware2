package co.edu.poli.actividad1.Controlador;

import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Random;
import java.util.ResourceBundle;



import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.PDiplomatico;
import co.edu.poli.actividad1.Modelo.POrdinario;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Modelo.Titular;
import co.edu.poli.actividad1.Repositorios.CiudadDao;
import co.edu.poli.actividad1.Repositorios.PaisDao;
import co.edu.poli.actividad1.Repositorios.PasaporteDao;
import co.edu.poli.actividad1.Repositorios.TitularDao;
import co.edu.poli.actividad1.Servicios.DatabaseConnection;
import co.edu.poli.actividad1.Servicios.DiplomaticoCreator;
import co.edu.poli.actividad1.Servicios.OrdinarioCreator;
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
	
	private Connection con = DatabaseConnection.getInstance().getConnection();
	
	private PasaporteDao regPas = new PasaporteDao();
	
	private CiudadDao regCiu = new CiudadDao();
	
	private PaisDao regPais = new PaisDao();
	
	private TitularDao regTit = new TitularDao();
	
	private ArrayList <Pais> totiPais = new ArrayList<Pais>();
	private ArrayList <Titular> totiTit = new ArrayList<Titular>();
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
    private ComboBox<String> selectCiudad;

    @FXML
    private DatePicker selectFecha;

    @FXML
    private ComboBox<String> selectPais;

    @FXML
    private ComboBox<String> selectUsuarios;

    @FXML
    private ToggleGroup tipoPasaporte;

	//lista observable
	private ObservableList<String> paises = FXCollections.observableArrayList();
	
	private ObservableList<String> ciudad = FXCollections.observableArrayList();
	
	private ObservableList<String> titulares = FXCollections.observableArrayList();
	
	private DiplomaticoCreator dC = new DiplomaticoCreator();
	
	private OrdinarioCreator oC = new OrdinarioCreator();
	
	
	
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//conexiones de daos
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
		
		selectPais.setItems(paises);
		
		//añadir titulares
		titulares.add(Allyson.getNombre());
		titulares.add(Cristina.getNombre());
		titulares.add(SalomeDorado.getNombre());
		titulares.add(Sam.getNombre());
		
		selectUsuarios.setItems(titulares);
		
		selectCiudad.setDisable(true);
		
	}
    
    @FXML
    void SelectCiudades(ActionEvent event) {
    	
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
    	
    	inIdPasaporte.setDisable(false);
    	inIdPasaporte.setVisible(true);
    	
    	bttselect.setDisable(false);
    	bttselect.setVisible(true);
    
    	bttselect.setText("Eliminar");
    	


    }

    @FXML
    void actualizarPasaporte(ActionEvent event) {
    	
    	inIdPasaporte.setDisable(false);
    	inIdPasaporte.setVisible(true);
    	
    	bttselect.setDisable(false);
    	bttselect.setVisible(true);
    	
    	bttselect.setText("Actualizar");
    


    }

    @FXML
    void insertarPasaporte(ActionEvent event) {
    	
    	inIdPasaporte.setDisable(true);
    	inIdPasaporte.setVisible(false);
    	
    	bttselect.setDisable(true);
    	bttselect.setVisible(false);
    	
    	if(isEmpty()) {
    		
    		
    	if(inDiplomatico.isSelected()) {
    		PDiplomatico p = dC.createPasaporte();
    		
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
				if (pa.getCiudades().get(i).equals(nCiu)) {
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
    		
    		p.setCiudadEmision(ci);
    		p.setFechaEmision(fecha.toString());
    		p.setFechaExpiracion(fechae);
    		p.setPaisEmisor(pa);
    		p.setNumeroId(idGen(id));
    		p.setMisionDiplomatica(inExtra.getText());
    		p.setTitular(ti);
    		
    		
    		System.out.println(p.getNumeroId());
    		regPas.insert(p);

    		Alert a = new Alert (AlertType.INFORMATION);
    		
        	a.setContentText(p.toString());
        	
        	a.showAndWait();
        
        	
    	}else if(inOrdinario.isSelected()) {
		
    		POrdinario p = oC.createPasaporte();
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
				if (pa.getCiudades().get(i).equals(nCiu)) {
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
    		
    		p.setCiudadEmision(ci);
    		p.setFechaEmision(fecha.toString());
    		p.setFechaExpiracion(fechae);
    		p.setPaisEmisor(pa);
    		p.setNumeroId(idGen(id));
    		p.setRazonViaje(inExtra.getText());
    		p.setTitular(ti);
    		System.out.println(regPas.insert(p));
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
    	
    	if(bttselect.getText().equals("Buscar")) {
    		read(inIdPasaporte.getText());
    		Alert a = new Alert (AlertType.INFORMATION);
        	a.setContentText("lectura");
        	a.show();
    	}
    	else if(bttselect.getText().equals("Eliminar")) {
    		
    		delete(inIdPasaporte.getText());
    		
    		Alert a = new Alert (AlertType.INFORMATION);
    		
        	a.setContentText("eliminacion exitosa!");
        	
        	a.show();
    	}
    	else if(bttselect.getText().equals("Actualizar")) {
    		if(inDiplomatico.isSelected() == true) {
    			
    			PDiplomatico p = dC.createPasaporte();
    			
        		update(inIdPasaporte.getText(), p);
        		
        		Alert a = new Alert (AlertType.INFORMATION);
        		
            	a.setContentText("actualizatura");
            	
            	a.show();
            	
    		}else if (inOrdinario.isSelected()) {

    			POrdinario p = oC.createPasaporte();
    			
        		update(inIdPasaporte.getText(), p);
        		
        		Alert a = new Alert (AlertType.INFORMATION);
        		
            	a.setContentText("actualizatura");
            	
            	a.show();
            	
    		}else {
    			Alert a = new Alert (AlertType.INFORMATION);
            	a.setContentText("seleccione tipo de pasaporte");
            	a.show();
    		}

    	}

    }

    @FXML
    void showSelect(ActionEvent event) {
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
    
    private void read(String id) {

    }
    
    private void update(String id, Pasaporte p) {

    }
    
    private void delete (String id) {
    	
    	
    	System.out.println(regPas.Delete(id));
    	
    	

    }
    private boolean isEmpty () {
	   if (selectFecha.getValue() != null &&
				selectPais.getSelectionModel().getSelectedItem() != null &&
				selectCiudad.getSelectionModel().getSelectedItem()!= null &&
				selectUsuarios.getSelectionModel().getSelectedItem()!=null &&
				!inExtra.getText().isBlank()) {
		   return true;
		   
	   }else {
		   return false;
	   }
   }
}
