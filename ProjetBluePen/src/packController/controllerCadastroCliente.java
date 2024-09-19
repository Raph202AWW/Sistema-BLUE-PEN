package packController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pack_Controlle.ClienteDAO;
import pack_Model.Cliente;

public class controllerCadastroCliente implements Initializable {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btSalvar;

    @FXML
    private TextField txtCPF;

    @FXML
    private DatePicker txtData;
    
    @FXML
    private DatePicker txtData1;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtTipoJur;

    @FXML
    void btCancelarAction(ActionEvent event) {
		txtNome.setText("");
		txtCPF.setText("");
		txtEndereco.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtTipoJur.setText("");
		controllerClientes.clienteEditar = null;

		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
    }

    @FXML
    void btSalvarAction(ActionEvent event) {
    	if (controllerClientes.clienteEditar == null) {
			Cliente cliente = new Cliente();
			cliente.setNome(txtNome.getText());
			cliente.setCPF_CNPJ(txtCPF.getText());
			cliente.setEmail(txtEmail.getText());
			cliente.setDataNasc(txtData.getValue().toString());
			cliente.setDataPriCom(txtData1.getValue().toString());
			cliente.setTipoJur(txtTipoJur.getText());
			cliente.setTelefone(txtTelefone.getText());
			cliente.setEndereco(txtEndereco.getText());

			ClienteDAO clie = new ClienteDAO();
			clie.create(cliente);

			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		} else {
			Cliente cliente = new Cliente();
			cliente.setNome(txtNome.getText());
			cliente.setCPF_CNPJ(txtCPF.getText());
			cliente.setEmail(txtEmail.getText());
			cliente.setTipoJur(txtTipoJur.getText());
			cliente.setDataNasc(txtData.getValue().toString());
			cliente.setDataPriCom(txtData1.getValue().toString());
			cliente.setTelefone(txtTelefone.getText());
			cliente.setEndereco(txtEndereco.getText());

			ClienteDAO clie = new ClienteDAO();
			clie.update(cliente);

			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if (controllerClientes.clienteEditar != null) {
			txtNome.setText(controllerClientes.clienteEditar.getNome());
			txtCPF.setText(controllerClientes.clienteEditar.getCPF_CNPJ());
			txtEmail.setText(controllerClientes.clienteEditar.getEmail());
			txtTelefone.setText(controllerClientes.clienteEditar.getTelefone());
			txtTipoJur.setText(controllerClientes.clienteEditar.getTipoJur());
			txtEndereco.setText(controllerClientes.clienteEditar.getEndereco());
		}
	}

}

