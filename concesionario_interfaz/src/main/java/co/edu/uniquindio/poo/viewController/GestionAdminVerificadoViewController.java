package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.AdministradorYaExisteException;
import co.edu.uniquindio.poo.model.VehiculoYaExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GestionAdminVerificadoViewController {
    App app;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_test;

    @FXML
    private Button btn_cerrar_sesion;

    @FXML
    void onTest(ActionEvent event) {

    }

    @FXML
    void onCallRegresar(ActionEvent event) throws AdministradorYaExisteException, VehiculoYaExisteException {
        app.openViewPrincipal();
    }

    @FXML
    void initialize() {
        assert btn_test != null : "fx:id=\"btn_test\" was not injected: check your FXML file 'gestionAdminVerificado.fxml'.";
        assert btn_cerrar_sesion != null : "fx:id=\"btn_cerrar_sesion\" was not injected: check your FXML file 'gestionAdminVerificado.fxml'.";

    }
    public void setApp(App app) {
        this.app = app;
    }
}
