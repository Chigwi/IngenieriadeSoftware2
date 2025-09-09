module co.edu.poli.actividad1.vista {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;

    opens co.edu.poli.actividad1.vista to javafx.fxml;
    exports co.edu.poli.actividad1.vista;
    
    opens co.edu.poli.actividad1.Controlador to javafx.fxml;
    exports co.edu.poli.actividad1.Controlador;
}
