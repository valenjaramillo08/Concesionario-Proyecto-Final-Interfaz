package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.EmpleadoController;
import co.edu.uniquindio.poo.model.Bus;
import co.edu.uniquindio.poo.model.Camion;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.TipoCamion;
import co.edu.uniquindio.poo.model.TipoCombustible;
import co.edu.uniquindio.poo.model.TipoTransmision;
import co.edu.uniquindio.poo.model.TransaccionInvalidaException;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.VehiculoYaExisteException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CompraVentaVehiculoViewController {

    App app;
    Empleado empleado;
    EmpleadoController empleadoController;
    ObservableList<Vehiculo> listVehiculos = FXCollections.observableArrayList();
    Vehiculo selectedVehiculo;
    ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    Cliente selectedCliente;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Vehiculo, String> tbcCombustibleVehiculo;

    @FXML
    private Button btn_comprar;

    @FXML
    private TableColumn<Cliente, String> tbcCedulaCliente;

    @FXML
    private TableColumn<Vehiculo, String> tbcMarcaVehiculo;

    @FXML
    private TableColumn<Vehiculo, String> tbcFechaVehiculo;

    @FXML
    private Button btn_regresar;

    @FXML
    private TableView<Vehiculo> tblListVehiculo;

    @FXML
    private TableColumn<Vehiculo, String> tbcPlacaVehiculo;

    @FXML
    private TableView<Cliente> tblListCliente;

    @FXML
    private Button btn_vender;

    @FXML
    private TableColumn<Cliente, String> tbcDireccionCliente;

    @FXML
    private TableColumn<Cliente, String> tbcNombreCliente;

    @FXML
    private TableColumn<Cliente, String> tbcTelefonoCliente;

    @FXML
    private TableColumn<Vehiculo, String> tbcModeloVehiculo;

    @FXML
    private TextField txtModelo;

    @FXML
    private DatePicker DTFecha;

    @FXML
    private ChoiceBox<TipoTransmision> CBTrasnmision;

    @FXML
    private ChoiceBox<TipoCombustible> CBCombustible;

    @FXML
    private TextField txtPlaca;

    @FXML
    private CheckBox BTecnomecanica;

    @FXML
    private TextField txtMarca;

    @FXML
    private ChoiceBox<String> CBTipoVehiculo;

    //////////////////////////////////////////////// bus fields

    @FXML
    private Label pasajerosBusLabel;

    @FXML
    private Label PuertasBusLabel;

    @FXML
    private CheckBox CBAireAcondicionadoBus;

    @FXML
    private TextField txtBolsasAireBus;

    @FXML
    private TextField txtEjesBus;

    @FXML
    private TextField txtSalidasEmergenciaBus;

    @FXML
    private TextField txtPasajerosBus;

    @FXML
    private CheckBox CBCamaraReversaBus;

    @FXML
    private TextField txtMaleteroBus;

    @FXML
    private CheckBox CBAbsBus;

    @FXML
    private TextField txtPuertasBus;

    @FXML
    private Label absBusLabel;

    @FXML
    private Label salidasEmergenciaBusLabel;

    @FXML
    private Label aireAcondicionadoBusLabel;

    @FXML
    private Label capacidadMaleteroBusLabel;

    @FXML
    private Label bolsaAireBusLabel;

    @FXML
    private Label ejesBusLabel;

    @FXML
    private Label camaraReversaBusLabel;

    ///////////////////////////////////////////////// camion fields

    @FXML
    private Label CapacidadCargaCamionLabel;

    @FXML
    private Label tipoCamionLabel;

    @FXML
    private Label frenosAireCamionLabel;

    @FXML
    private CheckBox CBAireAcondicionadoCamion;

    @FXML
    private ChoiceBox<TipoCamion> CBTipoCamion;

    @FXML
    private Label ACCamionLabel;

    @FXML
    private TextField txtEjesCamion;

    @FXML
    private Label absCamionLabel;

    @FXML
    private CheckBox CBabsCamion;

    @FXML
    private CheckBox CBFrenosAireCamion;

    @FXML
    private Label EjesCamionLabel;

    @FXML
    private TextField txtCapacidadCargaCamion;

    ////////////////////////////////////////////////////////////////////////// camioneta
    //////////////////////////////////////////////////////////////////////////

    @FXML
    private TextField txtCapacidadMaleteroCamioneta;

    @FXML
    private Label CapacidadMaleteroCamionetaLabel;

    @FXML
    private Label BolsasAireCamionetaLabel;

    @FXML
    private CheckBox CamionetaCBSensoresC;

    @FXML
    private Label sensoresColisionCamionetaLabel;

    @FXML
    private TextField txtBolsasAireCamioneta;

    @FXML
    private TextField txtPuertasCamioneta;

    @FXML
    private CheckBox CamionetaCBAireAcondicionado;

    @FXML
    private Label velocidadCCamionetaLabel;

    @FXML
    private Label PasajerosCamionetaLabel;

    @FXML
    private Label asistenteCCamionetaLabel;

    @FXML
    private CheckBox CamionetaCBCamaraReversa;

    @FXML
    private CheckBox CamionetaCB4por4;

    @FXML
    private CheckBox CamionetaCBAbs;

    @FXML
    private Label cuatroporcuatroCamionetaLabel;

    @FXML
    private Label absCamionetaLabel;

    @FXML
    private Label PuertasCamionetaLabel;

    @FXML
    private TextField txtPasajerosCamioneta;

    @FXML
    private CheckBox CamionetaCBasistentecarril;

    @FXML
    private CheckBox CamionetaCBVelocidadCrucero;

    @FXML
    private Label ACCamionetaLabel;

    @FXML
    private Label CamaraDeReversaCamionetaLabel;

    @FXML
    void onComprar(ActionEvent event) throws VehiculoYaExisteException, TransaccionInvalidaException {
        comprarVehiculo();
    }

    @FXML
    void onVender(ActionEvent event) {

    }

    @FXML
    void onCallRegresar(ActionEvent event) {
        app.openGestionEmpleadoVerificado(empleado);
    }

    @FXML
    void initialize() {
        initTipoCamion();
        initTipoTransmision();
        initTipoCombustible();
        initFields();
    }

    private void initTipoCamion(){
                // Obtener los valores del enumerador TipoTransmision
                ObservableList<TipoCamion> tipoCamiones = FXCollections.observableArrayList(TipoCamion.values());
        
                // Asignar los valores al ChoiceBox
                CBTipoCamion.setItems(tipoCamiones);
    }

    private void initTipoCombustible() {
        // Obtener los valores del enumerador TipoTransmision
        ObservableList<TipoCombustible> tipoCombustibles = FXCollections.observableArrayList(TipoCombustible.values());
        
        // Asignar los valores al ChoiceBox
        CBCombustible.setItems(tipoCombustibles);
    }
    
    private void initTipoTransmision() {
        // Obtener los valores del enumerador TipoTransmision
        ObservableList<TipoTransmision> tiposTransmision = FXCollections.observableArrayList(TipoTransmision.values());

        // Asignar los valores al ChoiceBox
        CBTrasnmision.setItems(tiposTransmision);
    }

    private void initFields() {
        ///////////////////////////////////////////////// setteo bus en false
        pasajerosBusLabel.setVisible(false);
        txtPasajerosBus.setVisible(false);
        PuertasBusLabel.setVisible(false);
        txtPuertasBus.setVisible(false);
        capacidadMaleteroBusLabel.setVisible(false);
        txtMaleteroBus.setVisible(false);
        aireAcondicionadoBusLabel.setVisible(false);
        CBAireAcondicionadoBus.setVisible(false);
        camaraReversaBusLabel.setVisible(false);
        CBCamaraReversaBus.setVisible(false);
        bolsaAireBusLabel.setVisible(false);
        txtBolsasAireBus.setVisible(false);
        absBusLabel.setVisible(false);
        CBAbsBus.setVisible(false);
        ejesBusLabel.setVisible(false);
        txtEjesBus.setVisible(false);
        salidasEmergenciaBusLabel.setVisible(false);
        txtSalidasEmergenciaBus.setVisible(false);
        ///////////////////////////////////////////////// setteo camion en false
        CapacidadCargaCamionLabel.setVisible(false);
        tipoCamionLabel.setVisible(false);
        frenosAireCamionLabel.setVisible(false);
        CBAireAcondicionadoCamion.setVisible(false);
        CBTipoCamion.setVisible(false);
        ACCamionLabel.setVisible(false);
        txtEjesCamion.setVisible(false);
        absCamionLabel.setVisible(false);
        CBabsCamion.setVisible(false);
        CBFrenosAireCamion.setVisible(false);
        EjesCamionLabel.setVisible(false);
        /////////////////////////////////////////////// setteo camioneta en false
        txtCapacidadCargaCamion.setVisible(false);
        txtCapacidadMaleteroCamioneta.setVisible(false);
        CapacidadMaleteroCamionetaLabel.setVisible(false);
        BolsasAireCamionetaLabel.setVisible(false);
        CamionetaCBSensoresC.setVisible(false);
        sensoresColisionCamionetaLabel.setVisible(false);
        txtBolsasAireCamioneta.setVisible(false);
        txtPuertasCamioneta.setVisible(false);
        CamionetaCBAireAcondicionado.setVisible(false);
        velocidadCCamionetaLabel.setVisible(false);
        PasajerosCamionetaLabel.setVisible(false);
        asistenteCCamionetaLabel.setVisible(false);
        CamionetaCBCamaraReversa.setVisible(false);
        CamionetaCB4por4.setVisible(false);
        CamionetaCBAbs.setVisible(false);
        cuatroporcuatroCamionetaLabel.setVisible(false);
        absCamionetaLabel.setVisible(false);
        PuertasCamionetaLabel.setVisible(false);
        txtPasajerosCamioneta.setVisible(false);
        CamionetaCBasistentecarril.setVisible(false);
        CamionetaCBVelocidadCrucero.setVisible(false);
        ACCamionetaLabel.setVisible(false);
        CamaraDeReversaCamionetaLabel.setVisible(false);

    }

    public void setApp(App app, Empleado miEmpleado) {
        this.app = app;
        this.empleado = miEmpleado;
        this.empleadoController = new EmpleadoController(empleado);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBindingCliente();
        initDataBindingVehiculo();

        // Obtiene la lista
        obtenerClientes();
        obtenerVehiculos();

        // Limpiar la tabla
        tblListCliente.getItems().clear();
        tblListVehiculo.getItems().clear();

        // Agregar los elementos a la tabla
        tblListCliente.setItems(listClientes);
        tblListVehiculo.setItems(listVehiculos);

        // Seleccionar elemento de la tabla
        listenerSelectionCliente();
        listenerSelectionVehiculo();
        showSelectionTipoVehiculo();
    }

    private void showSelectionTipoVehiculo() {
        // Inicializar el ChoiceBox con opciones
        CBTipoVehiculo.getItems().addAll("Bus", "Camion", "Camioneta");

        // Agregar un ChangeListener al ChoiceBox
        CBTipoVehiculo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////// setteo
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////// BUS
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////// en
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////// false
            pasajerosBusLabel.setVisible(false);
            txtPasajerosBus.setVisible(false);
            PuertasBusLabel.setVisible(false);
            txtPuertasBus.setVisible(false);
            capacidadMaleteroBusLabel.setVisible(false);
            txtMaleteroBus.setVisible(false);
            aireAcondicionadoBusLabel.setVisible(false);
            CBAireAcondicionadoBus.setVisible(false);
            camaraReversaBusLabel.setVisible(false);
            CBCamaraReversaBus.setVisible(false);
            bolsaAireBusLabel.setVisible(false);
            txtBolsasAireBus.setVisible(false);
            absBusLabel.setVisible(false);
            CBAbsBus.setVisible(false);
            ejesBusLabel.setVisible(false);
            txtEjesBus.setVisible(false);
            salidasEmergenciaBusLabel.setVisible(false);
            txtSalidasEmergenciaBus.setVisible(false);
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////// setteo
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////// CAMION
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////// en
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////// false
            CapacidadCargaCamionLabel.setVisible(false);
            tipoCamionLabel.setVisible(false);
            frenosAireCamionLabel.setVisible(false);
            CBAireAcondicionadoCamion.setVisible(false);
            CBTipoCamion.setVisible(false);
            ACCamionLabel.setVisible(false);
            txtEjesCamion.setVisible(false);
            absCamionLabel.setVisible(false);
            CBabsCamion.setVisible(false);
            CBFrenosAireCamion.setVisible(false);
            EjesCamionLabel.setVisible(false);
            txtCapacidadCargaCamion.setVisible(false);
            /////////////////////////////////////////////// setteo camioneta en false
            txtCapacidadCargaCamion.setVisible(false);
            txtCapacidadMaleteroCamioneta.setVisible(false);
            CapacidadMaleteroCamionetaLabel.setVisible(false);
            BolsasAireCamionetaLabel.setVisible(false);
            CamionetaCBSensoresC.setVisible(false);
            sensoresColisionCamionetaLabel.setVisible(false);
            txtBolsasAireCamioneta.setVisible(false);
            txtPuertasCamioneta.setVisible(false);
            CamionetaCBAireAcondicionado.setVisible(false);
            velocidadCCamionetaLabel.setVisible(false);
            PasajerosCamionetaLabel.setVisible(false);
            asistenteCCamionetaLabel.setVisible(false);
            CamionetaCBCamaraReversa.setVisible(false);
            CamionetaCB4por4.setVisible(false);
            CamionetaCBAbs.setVisible(false);
            cuatroporcuatroCamionetaLabel.setVisible(false);
            absCamionetaLabel.setVisible(false);
            PuertasCamionetaLabel.setVisible(false);
            txtPasajerosCamioneta.setVisible(false);
            CamionetaCBasistentecarril.setVisible(false);
            CamionetaCBVelocidadCrucero.setVisible(false);
            ACCamionetaLabel.setVisible(false);
            CamaraDeReversaCamionetaLabel.setVisible(false);

            // Mostrar el campo correspondiente a la opción seleccionada
            if ("Bus".equals(newValue)) {
                pasajerosBusLabel.setVisible(true);
                txtPasajerosBus.setVisible(true);
                PuertasBusLabel.setVisible(true);
                txtPuertasBus.setVisible(true);
                capacidadMaleteroBusLabel.setVisible(true);
                txtMaleteroBus.setVisible(true);
                aireAcondicionadoBusLabel.setVisible(true);
                CBAireAcondicionadoBus.setVisible(true);
                camaraReversaBusLabel.setVisible(true);
                CBCamaraReversaBus.setVisible(true);
                bolsaAireBusLabel.setVisible(true);
                txtBolsasAireBus.setVisible(true);
                absBusLabel.setVisible(true);
                CBAbsBus.setVisible(true);
                ejesBusLabel.setVisible(true);
                txtEjesBus.setVisible(true);
                salidasEmergenciaBusLabel.setVisible(true);
                txtSalidasEmergenciaBus.setVisible(true);
            } else if ("Camion".equals(newValue)) {
                CapacidadCargaCamionLabel.setVisible(true);
                tipoCamionLabel.setVisible(true);
                frenosAireCamionLabel.setVisible(true);
                CBAireAcondicionadoCamion.setVisible(true);
                CBTipoCamion.setVisible(true);
                ACCamionLabel.setVisible(true);
                txtEjesCamion.setVisible(true);
                absCamionLabel.setVisible(true);
                CBabsCamion.setVisible(true);
                CBFrenosAireCamion.setVisible(true);
                EjesCamionLabel.setVisible(true);
                txtCapacidadCargaCamion.setVisible(true);
            } else if ("Camioneta".equals(newValue)) {
                txtCapacidadCargaCamion.setVisible(true);
                txtCapacidadMaleteroCamioneta.setVisible(true);
                CapacidadMaleteroCamionetaLabel.setVisible(true);
                BolsasAireCamionetaLabel.setVisible(true);
                CamionetaCBSensoresC.setVisible(true);
                sensoresColisionCamionetaLabel.setVisible(true);
                txtBolsasAireCamioneta.setVisible(true);
                txtPuertasCamioneta.setVisible(true);
                CamionetaCBAireAcondicionado.setVisible(true);
                velocidadCCamionetaLabel.setVisible(true);
                PasajerosCamionetaLabel.setVisible(true);
                asistenteCCamionetaLabel.setVisible(true);
                CamionetaCBCamaraReversa.setVisible(true);
                CamionetaCB4por4.setVisible(true);
                CamionetaCBAbs.setVisible(true);
                cuatroporcuatroCamionetaLabel.setVisible(true);
                absCamionetaLabel.setVisible(true);
                PuertasCamionetaLabel.setVisible(true);
                txtPasajerosCamioneta.setVisible(true);
                CamionetaCBasistentecarril.setVisible(true);
                CamionetaCBVelocidadCrucero.setVisible(true);
                ACCamionetaLabel.setVisible(true);
                CamaraDeReversaCamionetaLabel.setVisible(true);
            }
        });
    }

    private void initDataBindingCliente() {
        tbcCedulaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdCliente()));
        tbcNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcDireccionCliente
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        tbcTelefonoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void initDataBindingVehiculo() {
        tbcPlacaVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
        tbcMarcaVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tbcCombustibleVehiculo.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getTipoCombustible().name()));
        tbcModeloVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerClientes() {
        listClientes.addAll(empleadoController.getClientes());
    }

    private void obtenerVehiculos() {
        listVehiculos.addAll(empleadoController.getVehiculos());
    }

    private void listenerSelectionCliente() {
        tblListCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
        });
    }

    private void listenerSelectionVehiculo() {
        tblListVehiculo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedVehiculo = newSelection;
        });
    }

    private void limpiarSeleccion() {
        tblListCliente.getSelectionModel().clearSelection();
        limpiarCamposVehiculo();
    }

    private void limpiarCamposVehiculo() {
        txtMarca.clear();
        txtModelo.clear();
        txtPlaca.clear();
    }

    private void comprarVehiculo() throws VehiculoYaExisteException, TransaccionInvalidaException {
        if (selectedCliente != null) {
            try {
                // Obtener los datos de los campos de texto
                String placa = txtPlaca.getText();
                String marca = txtMarca.getText();
                String modelo = txtModelo.getText();
                boolean nuevo = BTecnomecanica.isSelected();
                TipoCombustible combustible = CBCombustible.getValue();
                TipoTransmision transmision = CBTrasnmision.getValue();
                Vehiculo vehiculo = null;
                // Crear una instancia del vehículo según el tipo seleccionado en CBTipoVehiculo
                switch (CBTipoVehiculo.getValue()) {
                    case "Bus":
                        int pasajeros = Integer.parseInt(txtPasajerosBus.getText());
                        int puertas = Integer.parseInt(txtPuertasBus.getText());
                        double capacidadMaletero = Double.parseDouble(txtMaleteroBus.getText());
                        boolean aireAcondicionado = CBAireAcondicionadoBus.isSelected();
                        boolean camaraReversa = CBCamaraReversaBus.isSelected();
                        int bolsasAire = Integer.parseInt(txtBolsasAireBus.getText());
                        boolean abs = CBAbsBus.isSelected();
                        int ejes = Integer.parseInt(txtEjesBus.getText());
                        int salidasEmergencia = Integer.parseInt(txtSalidasEmergenciaBus.getText());

                        Bus bus = new Bus(placa, marca, modelo, nuevo, combustible, transmision, pasajeros, puertas, capacidadMaletero, aireAcondicionado, camaraReversa, bolsasAire, abs, ejes, salidasEmergencia, true);

                        vehiculo = bus;
                        break;
                    case "Camion":
                        double capacidadCarga = Double.parseDouble(txtCapacidadCargaCamion.getText());
                        aireAcondicionado = CBAireAcondicionadoCamion.isSelected();
                        boolean frenosAire = CBFrenosAireCamion.isSelected();
                        abs = CBabsCamion.isSelected();
                        ejes = Integer.parseInt(txtEjesCamion.getText());
                        TipoCamion tipo = CBTipoCamion.getValue();
                        Camion camion  = new Camion(placa, marca, modelo, nuevo, combustible, transmision, capacidadCarga, aireAcondicionado, frenosAire, abs, ejes, tipo, true);
                        vehiculo = camion;
                        break;
                    case "Camioneta":
                        pasajeros = Integer.parseInt(txtPasajerosCamioneta.getText());
                        puertas = Integer.parseInt(txtPuertasCamioneta.getText());
                        capacidadMaletero = Double.parseDouble(txtCapacidadMaleteroCamioneta.getText());
                        aireAcondicionado = CamionetaCBAireAcondicionado.isSelected();
                        camaraReversa = CamionetaCBCamaraReversa.isSelected();
                        bolsasAire = Integer.parseInt(txtBolsasAireCamioneta.getText());
                        abs = CamionetaCBAbs.isSelected();
                        boolean sensoresColision = CamionetaCBSensoresC.isSelected();
                        boolean sensorTraficoCruzado = CamionetaCBSensoresC.isSelected();
                        boolean asistenteCarril = CamionetaCBasistentecarril.isSelected();
                        boolean es4x4 = CamionetaCB4por4.isSelected();
                        //boolean frenosAire = CBFrenosAirecamioneta.isSelected();

                        Camioneta camioneta = new Camioneta(placa, marca, modelo, nuevo, combustible, transmision, pasajeros, puertas, capacidadMaletero, aireAcondicionado, camaraReversa, true, bolsasAire, abs, sensoresColision, sensorTraficoCruzado, asistenteCarril, es4x4, true);
                        vehiculo = camioneta;
                        break;
                    // Agregar casos para otros tipos de vehículos
                    default:
                        // Manejar caso de tipo de vehículo no válido
                        break;
                }

                if (vehiculo != null) {
                    // Realizar la compra del vehículo
                    empleadoController.realizarCompra(vehiculo, DTFecha.getValue(), selectedCliente);
                    vehiculo = null;
                    // Actualizar las listas de vehículos y clientes
                    obtenerVehiculos();


                    limpiarCamposVehiculo();
                } else {
                        // Crear una instancia de Alert
                        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        
                        // Configurar el título y el encabezado de la alerta
                        alerta.setTitle("Transaccion fallida");
                        alerta.setHeaderText("Transaccion fallida");
                        
                        // Establecer el contenido de la alerta
                        alerta.setContentText("Transaccion fallida no se pudo realizar la compra");
                        
                        // Mostrar la alerta
                        alerta.showAndWait();
                }
            } catch (NumberFormatException e) {
                // Manejar el caso en que los campos numéricos no tengan un formato válido
                // ...
            }
        } else {
            // Mostrar un mensaje de error si no se ha seleccionado un cliente
            // ...
        }
    }

}
