package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.AdminController;
import co.edu.uniquindio.poo.controller.ConcesionarioController;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.AdministradorYaExisteException;
import co.edu.uniquindio.poo.model.VehiculoYaExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class GestionAdminViewController {
    App app;
    ConcesionarioController concesionarioController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_iniciar_admin;


    @FXML
    private PasswordField txt_clave;

    @FXML
    private TextField txt_nombre;

    @FXML
    private Button btn_regresar;

    @FXML
    void onIniciarAdmin(ActionEvent event) {
        validarCredenciales();
    }

    @FXML
    void onCallRegresar(ActionEvent event) throws AdministradorYaExisteException, VehiculoYaExisteException {
        app.openViewPrincipal();
    }
    @FXML
    void initialize() {
        concesionarioController = new ConcesionarioController(app.concesionario);
    }

    private void validarCredenciales() {
        Administrador admin = concesionarioController.autenticar(txt_nombre.getText(), txt_clave.getText());
        if(admin != null){
            app.openGestionAdminVerificado();
        }
    }

    public void setApp(App app) {
        this.app = app;
    }
}
