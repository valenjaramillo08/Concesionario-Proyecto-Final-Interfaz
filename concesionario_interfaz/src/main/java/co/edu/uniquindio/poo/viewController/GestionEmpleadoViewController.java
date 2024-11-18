package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.AdminController;
import co.edu.uniquindio.poo.model.AdministradorYaExisteException;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.VehiculoYaExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class GestionEmpleadoViewController {
    App app;
    AdminController adminController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_iniciar_empleado;

    @FXML
    private TextField txt_clave;

    @FXML
    private PasswordField txt_clave1;

    @FXML
    private TextField txt_nombre;

    @FXML
    private Button btn_regresar;


    @FXML
    void onIniciarEmpleado(ActionEvent event) {
        validarCredenciales();
    }

    private void validarCredenciales() {
        Empleado empleado = adminController.autenticar(txt_nombre.getText(), txt_clave.getText());
        if (empleado != null){
            app.openGestionEmpleadoVerificado(empleado);
        }
    }

    @FXML
    void onCallRegresar(ActionEvent event) throws AdministradorYaExisteException, VehiculoYaExisteException {
        app.openViewPrincipal();
    }

    @FXML
    void initialize() {
        adminController = new AdminController(app.administrador);

    }

    public void setApp(App app) {
        this.app = app;
    }
}
