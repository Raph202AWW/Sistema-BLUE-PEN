package packController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import pack_Controlle.VendedorDAO;
import pack_Model.Vendedor;

public class controllerLogin {

	@FXML
	private Button btEntrar;

	@FXML
	private PasswordField txtPassword;
	@FXML
	private ToggleButton VerSenha;

	@FXML
	private TextField txtSenha;

	@FXML
	private TextField txtUser;

	public static Vendedor vend = new Vendedor();

	@FXML
	void btVoltarTeste(ActionEvent event) {
		VendedorDAO v = new VendedorDAO();
		vend = v.autenticarUser(txtUser.getText(), txtPassword.getText());

		if (vend.getPassword() != null && vend.getCPF() != null) {
			Alert saudacao = new Alert(Alert.AlertType.CONFIRMATION);
			saudacao.setTitle("Saudações!");
			saudacao.setHeaderText("Seja Bem-Vindo!");
			saudacao.setContentText("Seja bem vindo de volta " + vend.getNome() + "!!!");
			saudacao.show();
			Main.changeScreen("main");
		} else {
			Alert erro = new Alert(Alert.AlertType.ERROR);
			erro.setTitle("Falha ao realizar login!!!");
			erro.setHeaderText("ERRO!!!");
			erro.setContentText("Usuário ou senha incorretos! Verifique as informações");
			erro.show();
		}

	}

	@FXML
	void visualizarSenha(ActionEvent event) {
		if (VerSenha.isSelected()) {
			txtSenha.setText(txtPassword.getText());
			txtPassword.setVisible(false);
			txtSenha.setVisible(true);
		} else {
			txtPassword.setText(txtSenha.getText());
			txtPassword.setVisible(true);
			txtSenha.setVisible(false);
		}
	}
}
