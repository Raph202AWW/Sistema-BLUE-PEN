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
import pack_Controlle.VendedorDAO;
import pack_Model.Vendedor;

public class controllerCadastroVendedor implements Initializable {

	@FXML
	private Button btCancelar;

	@FXML
	private Button btSalvar;

	@FXML
	private TextField txtCPF;

	@FXML
	private DatePicker txtDataCont;

	@FXML
	private DatePicker txtDataNasc;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTelefone;

	@FXML
	private TextField txtEndereco;

	@FXML
	void btCancelarAction(ActionEvent event) {
		txtNome.setText("");
		txtCPF.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		controllerVendedor.vendedorEditar = null;

		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	void btSalvarAction(ActionEvent event) {
		if (controllerVendedor.vendedorEditar == null) {
			Vendedor vendedor = new Vendedor();
			vendedor.setNome(txtNome.getText());
			vendedor.setCPF(txtCPF.getText());
			vendedor.setEmail(txtEmail.getText());
			vendedor.setDataContrat(txtDataCont.getValue().toString());
			vendedor.setDataNasc(txtDataNasc.getValue().toString());
			vendedor.setTelefone(txtTelefone.getText());
			vendedor.setEndereco(txtEndereco.getText());

			VendedorDAO vend = new VendedorDAO();
			vend.create(vendedor);

			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		} else {
			Vendedor vendedor = new Vendedor();
			vendedor.setNome(txtNome.getText());
			vendedor.setCPF(txtCPF.getText());
			vendedor.setEmail(txtEmail.getText());
			vendedor.setDataContrat(txtDataCont.getValue().toString());
			vendedor.setDataNasc(txtDataNasc.getValue().toString());
			vendedor.setTelefone(txtTelefone.getText());
			vendedor.setEndereco(txtEndereco.getText());

			VendedorDAO vend = new VendedorDAO();
			vend.update(vendedor);

			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (controllerVendedor.vendedorEditar != null) {
			txtNome.setText(controllerVendedor.vendedorEditar.getNome());
			txtCPF.setText(controllerVendedor.vendedorEditar.getCPF());
			txtEmail.setText(controllerVendedor.vendedorEditar.getEmail());
			txtTelefone.setText(controllerVendedor.vendedorEditar.getTelefone());
		}

	}

}
