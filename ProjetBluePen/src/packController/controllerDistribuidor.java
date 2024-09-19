package packController;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pack_Controlle.FornecedorDAO;
import pack_Model.Fornecedor;

public class controllerDistribuidor implements Initializable {
	@FXML
	private Button btVoltar;

	@FXML
	private Button btCadrastrar;

	@FXML
	private Button btEditar;

	@FXML
	private Button btEnterCliente;

	@FXML
	private Button btEnterProduto;

	@FXML
	private Button btEnterRegistComp;

	@FXML
	private Button btEnterVendedor;

	@FXML
	private Button btExcluir;

	@FXML
	private Button btPesquisar;

	@FXML
	private TextField TextFieldPesquisarD;

	@FXML
	private TableView<Fornecedor> TableViewDistribuidor;

	@FXML
	private TableColumn<Fornecedor, String> columCNPJ;

	@FXML
	private TableColumn<Fornecedor, String> columEmail;

	@FXML
	private TableColumn<Fornecedor, String> columEnder;

	@FXML
	private TableColumn<Fornecedor, String> columId;

	@FXML
	private TableColumn<Fornecedor, String> columNome;

	@FXML
	private TableColumn<Fornecedor, String> columTelefone;

	private ObservableList<Fornecedor> ArrayFornecedor;
	private FornecedorDAO fornecedor = new FornecedorDAO();
	public static Fornecedor fornecedorEditar = new Fornecedor();

	@FXML
	void btCadrastrarAction(ActionEvent event) throws IOException {
		fornecedorEditar = null;
		Main.TelaCadastroFornecedor();
	}

	@FXML
	void btEditarAction(ActionEvent event) throws IOException {
		if (TableViewDistribuidor.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um fornecedor primeiro");
			mensagemDeErro.show();
		} else {
			int i = TableViewDistribuidor.getSelectionModel().getSelectedIndex();
			fornecedorEditar = TableViewDistribuidor.getItems().get(i);
			Main.TelaCadastroFornecedor();
		}
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
	void btEnterVendedorAction(ActionEvent event) {
		Main.changeScreen("vendedor");
	}

	@FXML
	void btExcluirAction(ActionEvent event) {
		int i = TableViewDistribuidor.getSelectionModel().getSelectedIndex();

		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um fornecedor primeiro");
			mensagemDeErro.show();
		} else {
			Fornecedor f = new Fornecedor();
			f = TableViewDistribuidor.getItems().get(i);

			Alert mensagemDeErro = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeErro.setContentText("Deseja realmente EXCLUIR o fornecedor: " + f.getNome());

			Optional<ButtonType> resultado = mensagemDeErro.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				FornecedorDAO FO = new FornecedorDAO();
				FO.delete(f.getCNPJ());

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Fornecedor excluido com sucesso!!!");
				mensagemDeExclusao.show();
				CarregarInfTableFornecedor();
			}
		}

	}

	@FXML
	void btPesquisarAction(ActionEvent event) {
		ArrayFornecedor = FXCollections.observableArrayList(fornecedor.search(TextFieldPesquisarD.getText()));

		columId.setCellValueFactory(new PropertyValueFactory<>("Id_fornecedor"));
		columNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		columTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columEnder.setCellValueFactory(new PropertyValueFactory<>("Endereco"));

		TableViewDistribuidor.setItems(ArrayFornecedor);
		TableViewDistribuidor.refresh();
	}

	@FXML
	void btEnterClienteAction(ActionEvent event) {
		Main.changeScreen("clientes");
	}

	@FXML
	void btVoltarAction(ActionEvent event) {
		Main.changeScreen("main");
	}

	public void CarregarInfTableFornecedor() {
		ArrayFornecedor = FXCollections.observableArrayList(fornecedor.read());

		columId.setCellValueFactory(new PropertyValueFactory<>("Id_fornecedor"));
		columNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		columTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columEnder.setCellValueFactory(new PropertyValueFactory<>("Endereco"));

		TableViewDistribuidor.setItems(ArrayFornecedor);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarInfTableFornecedor();
	}

}
