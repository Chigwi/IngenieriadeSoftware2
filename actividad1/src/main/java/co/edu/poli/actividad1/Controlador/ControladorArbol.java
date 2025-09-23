package co.edu.poli.actividad1.Controlador;

import java.io.IOException;

import co.edu.poli.actividad1.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControladorArbol {

    @FXML
    private Button bttAtras;

    @FXML
    private Button bttMostrar;

    @FXML
    void getNombre(ActionEvent event) {

    }

    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");

    }

}
