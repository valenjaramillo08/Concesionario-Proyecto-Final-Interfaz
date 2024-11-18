package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.AdministradorYaExisteException;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.TipoCombustible;
import co.edu.uniquindio.poo.model.TipoTransmision;
import co.edu.uniquindio.poo.model.VehiculoYaExisteException;
import co.edu.uniquindio.poo.viewController.CompraVentaVehiculoViewController;
import co.edu.uniquindio.poo.viewController.CrudClienteViewController;
import co.edu.uniquindio.poo.viewController.GestionAdminVerificadoViewController;
import co.edu.uniquindio.poo.viewController.GestionAdminViewController;
import co.edu.uniquindio.poo.viewController.GestionEmpleadoVerificadoViewController;
import co.edu.uniquindio.poo.viewController.GestionEmpleadoViewController;
import co.edu.uniquindio.poo.viewController.PrimaryViewController;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    public Scene previouScene;
    public static Administrador administrador = new Administrador("val", "123", "Pregunta", "Respuesta", 1000, "Admin");
    public static Concesionario concesionario = new Concesionario("Mi carro UQ", administrador);

    @Override
    public void start(Stage primaryStage) throws IOException, AdministradorYaExisteException, VehiculoYaExisteException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de Clientes");
        openViewPrincipal();
    }

    public void openViewPrincipal() throws AdministradorYaExisteException, VehiculoYaExisteException {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            PrimaryViewController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
    public void openGestionEmpleado() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("gestionEmpleado.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            GestionEmpleadoViewController gestionEmpleadoViewController = loader.getController();
            gestionEmpleadoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openGestionAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("gestionAdmin.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            GestionAdminViewController gestionAdminViewController = loader.getController();
            gestionAdminViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openGestionEmpleadoVerificado(Empleado empleado) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("gestionEmpleadoVerificado.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            GestionEmpleadoVerificadoViewController gestionEmpleadoVerificadoViewController = loader.getController();
            gestionEmpleadoVerificadoViewController.setApp(this, empleado);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudCliente(Empleado empleado) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudCliente.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            CrudClienteViewController crudClienteViewController = loader.getController();
            crudClienteViewController.setApp(this, empleado);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCompraVentaVehiculo(Empleado empleado) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("compraVentaVehiculo.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            CompraVentaVehiculoViewController compraVentaVehiculoViewController = loader.getController();
            compraVentaVehiculoViewController.setApp(this, empleado);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openGestionAdminVerificado() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("gestionAdminVerificado.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            GestionAdminVerificadoViewController gestionAdminVerificadoViewController = loader.getController();
            gestionAdminVerificadoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //servicios

    public void inicializarData() throws VehiculoYaExisteException{
        Empleado empleado = new Empleado("test", "test", "pregunta", "respuesta", 1000, 123, true, "Empleado");
        //Moto moto = new Moto("123", "honda", "navi", true, TipoCombustible.GASOLINA, TipoTransmision.AUTOMATICA, 1, 80, 100, true);
        //empleado.agregarVehiculo(moto);
        administrador.agregarEmpleado(empleado);
    }

}