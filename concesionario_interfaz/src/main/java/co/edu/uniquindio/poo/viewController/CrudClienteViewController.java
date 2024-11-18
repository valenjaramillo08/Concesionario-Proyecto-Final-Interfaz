package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.AdminController;
import co.edu.uniquindio.poo.controller.EmpleadoController;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.ClienteYaExisteException;
import co.edu.uniquindio.poo.model.Empleado;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudClienteViewController {
    App app;
    Empleado empleado;
    EmpleadoController empleadoController;
    ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    Cliente selectedCliente;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableColumn<Cliente, String> tbcDireccion;

    @FXML
    private TextField txtTel;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private Button btbAgregarCliente;

    @FXML
    private TableColumn<Cliente, String> tbcCedula;

    @FXML
    private TextField txtCedula;

    @FXML
    private TableColumn<Cliente, String> tbcTelefono;

    @FXML
    private TextField txtNombre;

    @FXML
    private TableView<Cliente> tblListCliente;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<Cliente, String> tbcNombre;

    @FXML
    private TextField txtDir;

    @FXML
    private Button btn_regresar;

    @FXML
    void onAgregarCliente(ActionEvent event) throws ClienteYaExisteException {
        agregarCliente();
    }

    @FXML
    void onActualizarCliente(ActionEvent event) {
        actualizarCliente();
    }

    @FXML
    void onLimpiar(ActionEvent event) {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar(ActionEvent event) {
        eliminarCliente();
    }

    @FXML
    void onCallRegresar(ActionEvent event) {
        app.openGestionEmpleadoVerificado(empleado);;   
    }

    @FXML
    void initialize(Empleado empleado) {
        

    }

    public void setApp(App app, Empleado miEmpleado) {
        this.app = app;
        this.empleado = miEmpleado;
        this.empleadoController = new EmpleadoController(empleado);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerClientes();

        // Limpiar la tabla
        tblListCliente.getItems().clear();

        // Agregar los elementos a la tabla
        tblListCliente.setItems(listClientes);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdCliente()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        tbcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerClientes() {
        listClientes.addAll(empleadoController.getClientes());
    }

    private void listenerSelection() {
        tblListCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            mostrarInformacionCliente(selectedCliente);
        });
    }

    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txtCedula.setText(cliente.getIdCliente());
            txtNombre.setText(cliente.getNombre());
            txtDir.setText(cliente.getDireccion());
            txtTel.setText(cliente.getTelefono());
        }
    }

    private void agregarCliente() throws ClienteYaExisteException {
        Cliente cliente = buildCliente();
        if (empleadoController.agregarCliente(cliente)) {
            listClientes.add(cliente);
            limpiarCamposCliente();
        }
    }

    private void limpiarCamposCliente() {
        txtCedula.clear();
        txtNombre.clear();
        txtDir.clear();
        txtTel.clear();
    }

    private Cliente buildCliente() {
        Cliente cliente = new Cliente(txtCedula.getText(), txtNombre.getText(), txtDir.getText(),
                txtTel.getText());
        return cliente;
    }

    private void actualizarCliente() {

        if (selectedCliente != null &&
                empleadoController.actualizarCliente(selectedCliente.getIdCliente(), buildCliente())) {

            int index = listClientes.indexOf(selectedCliente);
            if (index >= 0) {
                listClientes.set(index, buildCliente());
            }

            tblListCliente.refresh();
            limpiarSeleccion();
            limpiarCamposCliente();
        }
    }

    private void limpiarSeleccion() {
        tblListCliente.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }

    private void eliminarCliente() {
        if (empleadoController.eliminarCliente(txtCedula.getText())) {
            listClientes.remove(selectedCliente);
            limpiarCamposCliente();
            limpiarSeleccion();
        }
    }
}
