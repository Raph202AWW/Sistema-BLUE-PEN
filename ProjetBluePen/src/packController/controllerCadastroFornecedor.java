package packController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pack_Controlle.FornecedorDAO;
import pack_Model.Fornecedor;

public class controllerCadastroFornecedor implements Initializable {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btSalvar;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;

    @FXML
    void btCancelarAction(ActionEvent event) {
    	txtNome.setText("");
		txtCNPJ.setText("");
		txtEndereco.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		controllerDistribuidor.fornecedorEditar = null;

		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
    }

    @FXML
    void btSalvarAction(ActionEvent event) {
    	if (controllerDistribuidor.fornecedorEditar == null) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setNome(txtNome.getText());
			fornecedor.setCNPJ(txtCNPJ.getText());
			fornecedor.setEmail(txtEmail.getText());
			fornecedor.setTelefone(txtTelefone.getText());
			fornecedor.setEndereco(txtEndereco.getText());

			FornecedorDAO clie = new FornecedorDAO();
			clie.create(fornecedor);

			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		} else {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setNome(txtNome.getText());
			fornecedor.setCNPJ(txtCNPJ.getText());
			fornecedor.setEmail(txtEmail.getText());
			fornecedor.setTelefone(txtTelefone.getText());
			fornecedor.setEndereco(txtEndereco.getText());

			FornecedorDAO clie = new FornecedorDAO();
			clie.update(fornecedor);

			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if (controllerDistribuidor.fornecedorEditar != null) {
			txtNome.setText(controllerDistribuidor.fornecedorEditar.getNome());
			txtCNPJ.setText(controllerDistribuidor.fornecedorEditar.getCNPJ());
			txtEmail.setText(controllerDistribuidor.fornecedorEditar.getEmail());
			txtTelefone.setText(controllerDistribuidor.fornecedorEditar.getTelefone());
			txtEndereco.setText(controllerDistribuidor.fornecedorEditar.getEndereco());
		}
	}

}
