package co.edu.poli.actividad1.Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Servicios.AdaptadorCiudad;
import co.edu.poli.actividad1.Servicios.EspacioGeografico;
import co.edu.poli.actividad1.Servicios.Region;
import co.edu.poli.actividad1.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


//tt
public class ControladorArbol implements Initializable{

    @FXML
    private Button bttAtras;

    @FXML
    private Button bttMostrar;
    
    @FXML
    private TextArea outArbol;
    
    private Region regiones;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		ArrayList<EspacioGeografico> superO = new ArrayList<EspacioGeografico>();
		regiones = new Region(superO, "Regiones");
		
		ArrayList<EspacioGeografico> listR1 = new ArrayList<EspacioGeografico>();
		ArrayList<EspacioGeografico> listR2 = new ArrayList<EspacioGeografico>();
		Ciudad C1 = new Ciudad ("0001", "C1", false, "001");
		Ciudad C2 = new Ciudad ("0002", "C2", false, "002");
		Ciudad C3 = new Ciudad ("0003", "C3", true, "003");
		
		AdaptadorCiudad adaptC1 = new AdaptadorCiudad(C1);
		AdaptadorCiudad adaptC2 = new AdaptadorCiudad(C2);
		AdaptadorCiudad adaptC3 = new AdaptadorCiudad(C3);

		Region R1 = new Region(listR1, "R1");
		Region R2 = new Region(listR2, "R2");
		
		regiones.add(R1);
		R1.add(R2);
		R1.add(adaptC3);
		R2.add(adaptC1);
		R2.add(adaptC2);
		
		/*ArrayList<EspacioGeografico> listAnd = new ArrayList<EspacioGeografico>();
		Region andina = new Region(listAnd, "Andina");
		regiones.add(andina);
		
		ArrayList<EspacioGeografico> listAnt = new ArrayList<EspacioGeografico>();
		Region antioquia = new Region(listAnt, "Antioquia");
		andina.add(antioquia);
		
		Ciudad medellin = new Ciudad("057021","Medellin",false,"057");
		AdaptadorCiudad med = new AdaptadorCiudad(medellin);
		antioquia.add(med);
		Ciudad envigado = new Ciudad("057022","Envigado",false,"057");
		AdaptadorCiudad env =  new AdaptadorCiudad(envigado);
		antioquia.add(env);
		
		ArrayList<EspacioGeografico> listcund = new ArrayList<EspacioGeografico>();
		Region cundinamarca = new Region(listcund, "Cundinamarca");
		andina.add(cundinamarca);
		
		Ciudad bogota =  new Ciudad("057011", "Bogotá", true, "057");
		AdaptadorCiudad bog = new AdaptadorCiudad(bogota);
		cundinamarca.add(bog);
		Ciudad cajica =  new Ciudad("057015", "Cajicá", false, "057");
		AdaptadorCiudad caj = new AdaptadorCiudad(cajica);
		cundinamarca.add(caj);
		
		ArrayList<EspacioGeografico> listCar = new ArrayList<EspacioGeografico>();
		Region caribe = new Region(listCar, "Caribe");
		regiones.add(caribe);
		
		ArrayList<EspacioGeografico> listCor = new ArrayList<EspacioGeografico>();
		Region cordoba = new Region(listCor, "Córdoba");
		caribe.add(cordoba);
		
		Ciudad monteria = new Ciudad("057301", "Montería", false, "057");
		AdaptadorCiudad mon =  new AdaptadorCiudad(monteria);
		cordoba.add(mon);
		Ciudad planetaRica = new Ciudad("057309", "Planeta Rica", false, "057");
		AdaptadorCiudad plan = new AdaptadorCiudad(planetaRica);
		cordoba.add(plan);
		
		ArrayList<EspacioGeografico> listMag = new ArrayList<EspacioGeografico>();
		Region magdalena = new Region(listMag, "Magdalena");
		caribe.add(magdalena);
		
		Ciudad santaMarta = new Ciudad("057251", "Santa Marta", false, "057");
		AdaptadorCiudad sant = new AdaptadorCiudad(santaMarta);
		magdalena.add(sant);
		Ciudad chibolo = new Ciudad("057259", "Chibolo", false, "057");
		AdaptadorCiudad chi = new AdaptadorCiudad(chibolo);
		magdalena.add(chi);
		
		ArrayList<EspacioGeografico> listPac = new ArrayList<EspacioGeografico>();
		Region pacifica = new Region(listPac, "Pacifica");
		regiones.add(pacifica);
		
		ArrayList<EspacioGeografico> listval = new ArrayList<EspacioGeografico>();
		Region vallecauca = new Region(listval, "Valle del cauca");
		pacifica.add(vallecauca);
		
		Ciudad cali = new Ciudad("057151", "Cali", false, "057");
		AdaptadorCiudad cal = new AdaptadorCiudad(cali);
		vallecauca.add(cal);
		Ciudad buenaventura = new Ciudad("057152", "Buenaventura", false, "057");
		AdaptadorCiudad bue = new AdaptadorCiudad(buenaventura);
		vallecauca.add(bue);
		
		ArrayList<EspacioGeografico> listchoc = new ArrayList<EspacioGeografico>();
		Region choco = new Region(listchoc, "Chocó");
		pacifica.add(choco);
		
		Ciudad quibdo = new Ciudad("057321", "Quibdo", false, "057");
		AdaptadorCiudad qui = new AdaptadorCiudad(quibdo);
		choco.add(qui);
		Ciudad condoto = new Ciudad("057325", "Condoto", false, "057");
		AdaptadorCiudad con = new AdaptadorCiudad(condoto);
		choco.add(con);*/
		
		

	}

    @FXML
    void getNombre(ActionEvent event) {
    	outArbol.setDisable(false);
    	outArbol.setText(regiones.getNombre(0));
    }

    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");

    }



}
