package co.edu.uniquindio.poo.viewController;

import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.AdministradorYaExisteException;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.VehiculoYaExisteException;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GestionEmpleadoVerificadoViewController {

    App app;
    Empleado empleado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private Button btn_registrar_cliente;


    @FXML
    private Button btn_realizar_alquiler;

    @FXML
    private Button btn_cerrar_sesion;

    @FXML
    private Button btn_compra_venta_vehiculo;

    @FXML
    void onRealizarAlquiler(ActionEvent event) {

    }

    @FXML
    void onCompraVentaVehiculo(ActionEvent event) {
        app.openCompraVentaVehiculo(empleado);
    }

    @FXML
    void onCallRegistrarCliente(ActionEvent event) {
        app.openCrudCliente(empleado);
    }

    @FXML
    void onCallRergesar(ActionEvent event) throws AdministradorYaExisteException, VehiculoYaExisteException {
        app.openViewPrincipal();
    }

    @FXML
    void initialize() {

    }

    public void setApp(App app, Empleado empleado) {
        this.app = app;
        this.empleado = empleado;
    }
}
