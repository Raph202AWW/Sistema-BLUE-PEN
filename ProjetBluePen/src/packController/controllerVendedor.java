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
import pack_Controlle.VendedorDAO;
import pack_Model.Vendedor;

public class controllerVendedor implements Initializable {

	@FXML
	private Button btVoltar;

	@FXML
	private TextField TextFieldPesquisarV;

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
	private TableView<Vendedor> TableVendedor;

	@FXML
	private TableColumn<Vendedor, String> columCPF;

	@FXML
	private TableColumn<Vendedor, String> columDataContr;

	@FXML
	private TableColumn<Vendedor, String> columDataNasc;

	@FXML
	private TableColumn<Vendedor, String> columEmail;

	@FXML
	private TableColumn<Vendedor, String> columEnder;

	@FXML
	private TableColumn<Vendedor, String> columId;

	@FXML
	private TableColumn<Vendedor, String> columNome;

	@FXML
	private TableColumn<Vendedor, String> columTelefone;

	@FXML
	private TableColumn<Vendedor, String> columTotalVend;

	private ObservableList<Vendedor> ArrayVendedor;
	private VendedorDAO vendedor = new VendedorDAO();
	public static Vendedor vendedorEditar = new Vendedor();

	@FXML
	void btCadrastrarAction(ActionEvent event) throws IOException {
		vendedorEditar = null;
		Main.TelaCadastroVendedor();
	}

	@FXML
	 void btEditarAction(ActionEvent event) throws IOException {
		if (TableVendedor.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um vendedor primeiro");
			mensagemDeErro.show();
		} else {
			int i = TableVendedor.getSelectionModel().getSelectedIndex();
			vendedorEditar = TableVendedor.getItems().get(i);
			Main.TelaCadastroVendedor();
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
	void btExcluirAction(ActionEvent event) {
		int i = TableVendedor.getSelectionModel().getSelectedIndex();

		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um vendedor primeiro");
			mensagemDeErro.show();
		} else {
			Vendedor vend = new Vendedor();
			vend = TableVendedor.getItems().get(i);

			Alert mensagemDeErro = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeErro.setContentText("Deseja realmente EXCLUIR o vendedor: " + vend.getNome());

			Optional<ButtonType> resultado = mensagemDeErro.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				VendedorDAO v = new VendedorDAO();
				v.delete(vend.getCPF());

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Vendedor excluido com sucesso!!!");
				mensagemDeExclusao.show();
				CarregarInfTableVendedor();
			}
		}

	}

	@FXML
	void btPesquisarAction(ActionEvent event) {
		ArrayVendedor = FXCollections.observableArrayList(vendedor.search(TextFieldPesquisarV.getText()));

		columId.setCellValueFactory(new PropertyValueFactory<>("Id_vendedor"));
		columNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		columTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columDataNasc.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columDataContr.setCellValueFactory(new PropertyValueFactory<>("DataContrat"));
		columTotalVend.setCellValueFactory(new PropertyValueFactory<>("Total_vend"));
		columEnder.setCellValueFactory(new PropertyValueFactory<>("Endereco"));

		TableVendedor.setItems(ArrayVendedor);
		TableVendedor.refresh();
	}

	@FXML
	void btEnterClienteAction(ActionEvent event) {
		Main.changeScreen("clientes");
	}

	@FXML
	void btVoltarAction(ActionEvent event) {
		Main.changeScreen("main");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarInfTableVendedor();
	}

	public void CarregarInfTableVendedor()

	{
		ArrayVendedor = FXCollections.observableArrayList(vendedor.read());

		columId.setCellValueFactory(new PropertyValueFactory<>("Id_vendedor"));
		columNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		columTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columDataNasc.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columDataContr.setCellValueFactory(new PropertyValueFactory<>("DataContrat"));
		columTotalVend.setCellValueFactory(new PropertyValueFactory<>("Total_vend"));
		columEnder.setCellValueFactory(new PropertyValueFactory<>("Endereco"));

		TableVendedor.setItems(ArrayVendedor);
	}

}
