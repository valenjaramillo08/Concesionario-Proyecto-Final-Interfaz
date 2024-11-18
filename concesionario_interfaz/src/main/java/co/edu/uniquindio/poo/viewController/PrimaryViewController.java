package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryViewController {

    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_admin;

    @FXML
    private Button btn_empleado;

    @FXML
    void initialize() {
        assert btn_admin != null : "fx:id=\"btn_admin\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn_empleado != null : "fx:id=\"btn_empleado\" was not injected: check your FXML file 'primary.fxml'.";

    }

    @FXML
    void onCallEmpleado(ActionEvent event) {
        app.openGestionEmpleado();
    }

    @FXML
    void onCallAdmin(ActionEvent event) {
        app.openGestionAdmin();
    }

    public void setApp(App app) {
        this.app = app;
    }

}
