package packController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class controllerMain {
	@FXML
	private Button btEnterCliente;

	@FXML
	private Button btEnterDistribuidor;

	@FXML
	private Button btEnterProduto;

	@FXML
	private Button btEnterRegistComp;

	@FXML
	private Button btEnterRelatorio;

	@FXML
	private Button btEnterVendedor;

	@FXML
	private Button btVoltar;

	
	
	@FXML
	void btEnterDistribuidorAction(ActionEvent event) {
		Main.changeScreen("distribuidor");
	}

	@FXML
	void btEnterProdutoAction(ActionEvent event) {
		Main.changeScreen("produto");
	}

	@FXML
	void btEnterRegistCompAction(ActionEvent event) {
		Main.changeScreen("registroComp");
	}

	@FXML
	void btEnterRelatorioAction(ActionEvent event) {
		Main.changeScreen("relatorio");
	}

	@FXML
	void btEnterClienteAction(ActionEvent event) {
		Main.changeScreen("clientes");
	}

	@FXML
	void btEnterVendedorAction(ActionEvent event) {
		Main.changeScreen("vendedor");
	}

	@FXML
	void btVoltarTest(ActionEvent event) {

		Main.changeScreen("login");

	}

}
