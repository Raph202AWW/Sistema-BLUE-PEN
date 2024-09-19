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
import pack_Controlle.ClienteDAO;
import pack_Model.Cliente;

public class controllerClientes implements Initializable {

	@FXML
	private Button btVoltar;

	@FXML
	private Button btEnterVendedor;

	@FXML
	private Button btCadrastrar;

	@FXML
	private Button btEditar;

	@FXML
	private Button btEnterCliente;

	@FXML
	private Button btEnterDistribuidor;

	@FXML
	private Button btEnterProduto;

	@FXML
	private Button btEnterRegistComp;

	@FXML
	private Button btExcluir;

	@FXML
	private Button btPesquisar;

	@FXML
	private TextField TextFieldPesquisarC;

	@FXML
	private TableView<Cliente> TableViewClientes;

	@FXML
	private TableColumn<Cliente, String> columCPF;

	@FXML
	private TableColumn<Cliente, String> columDataNasc;

	@FXML
	private TableColumn<Cliente, String> columDataPrim;

	@FXML
	private TableColumn<Cliente, String> columEmail;

	@FXML
	private TableColumn<Cliente, String> columEnder;

	@FXML
	private TableColumn<Cliente, String> columId;

	@FXML
	private TableColumn<Cliente, String> columNome;

	@FXML
	private TableColumn<Cliente, String> columTelefone;

	@FXML
	private TableColumn<Cliente, String> columTipo;

	private ObservableList<Cliente> ArrayCliente;
	private ClienteDAO cliente = new ClienteDAO();
	public static Cliente clienteEditar = new Cliente();

	@FXML
	void btCadrastrarAction(ActionEvent event)throws IOException {
		clienteEditar = null;
		Main.TelaCadastroCliente();
	}

	@FXML
	void btEditarAction(ActionEvent event)throws IOException {
		if (TableViewClientes.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um cliente primeiro");
			mensagemDeErro.show();
		} else {
			int i = TableViewClientes.getSelectionModel().getSelectedIndex();
			clienteEditar = TableViewClientes.getItems().get(i);
			Main.TelaCadastroCliente();
		}
	}

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
	void btExcluirAction(ActionEvent event) {
		int i = TableViewClientes.getSelectionModel().getSelectedIndex();

		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um cliente primeiro");
			mensagemDeErro.show();
		} else {
			Cliente cliente = new Cliente();
			cliente = TableViewClientes.getItems().get(i);

			Alert mensagemDeErro = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeErro.setContentText("Deseja realmente EXCLUIR o cliente: " + cliente.getNome());

			Optional<ButtonType> resultado = mensagemDeErro.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ClienteDAO c = new ClienteDAO();
				c.delete(cliente.getCPF_CNPJ());

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Cliente excluido com sucesso!!!");
				mensagemDeExclusao.show();
				CarregarInfTableCliente();
			}
		}

	}

	@FXML
	void btPesquisarAction(ActionEvent event) {
		ArrayCliente = FXCollections.observableArrayList(cliente.search(TextFieldPesquisarC.getText()));

		columId.setCellValueFactory(new PropertyValueFactory<>("Id_cliente"));
		columNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columCPF.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));
		columTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columDataNasc.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columDataPrim.setCellValueFactory(new PropertyValueFactory<>("DataPriCom"));
		columTipo.setCellValueFactory(new PropertyValueFactory<>("TipoJur"));
		columEnder.setCellValueFactory(new PropertyValueFactory<>("Endereco"));

		TableViewClientes.setItems(ArrayCliente);
		TableViewClientes.refresh();
	}

	@FXML
	void btEnterVendedorAction(ActionEvent event) {
		Main.changeScreen("vendedor");
	}

	@FXML
	void btVoltarAction(ActionEvent event) {
		Main.changeScreen("main");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarInfTableCliente();
	}

	public void CarregarInfTableCliente() {
		ArrayCliente = FXCollections.observableArrayList(cliente.read());

		columId.setCellValueFactory(new PropertyValueFactory<>("Id_cliente"));
		columNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columCPF.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));
		columTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columDataNasc.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columDataPrim.setCellValueFactory(new PropertyValueFactory<>("DataPriCom"));
		columTipo.setCellValueFactory(new PropertyValueFactory<>("TipoJur"));
		columEnder.setCellValueFactory(new PropertyValueFactory<>("Endereco"));

		TableViewClientes.setItems(ArrayCliente);
	}

}
