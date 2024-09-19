package packController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pack_Controlle.CompraDAO;
import pack_Model.Compra;

public class controllerRelatorio implements Initializable {

	@FXML
	private TableView<Compra> TableViewRelat;

	@FXML
	private TextField TextFieldPesquisarRV;

	@FXML
	private Button btCadrastrar;

	@FXML
	private Button btPesquisar;

	@FXML
	private Button btVoltar;

	@FXML
	private TableColumn<Compra, String> columCliente;

	@FXML
	private TableColumn<Compra, String> columId;

	@FXML
	private TableColumn<Compra, String> columPrecoTotal;

	@FXML
	private TableColumn<Compra, String> columProduto;

	@FXML
	private TableColumn<Compra, String> columQuantidade;

	@FXML
	private TableColumn<Compra, String> columVendedor;

	private ObservableList<Compra> ArrayCompra;
	private CompraDAO compra = new CompraDAO();
	public static Compra compraEditar = new Compra();

	@FXML
	void btCadrastrarAction(ActionEvent event) throws IOException {
		compraEditar = null;
		Main.TelaCadastroCompra();
	}

	@FXML
	void btPesquisarAction(ActionEvent event) {
		ArrayCompra = FXCollections.observableArrayList(compra.search(TextFieldPesquisarRV.getText()));
		columId.setCellValueFactory(new PropertyValueFactory<>("Id_compra"));
		columCliente.setCellValueFactory(new PropertyValueFactory<>("Id_cliente"));
		columPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("Preco_Total"));
		columProduto.setCellValueFactory(new PropertyValueFactory<>("Id_produto"));
		columQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		columVendedor.setCellValueFactory(new PropertyValueFactory<>("Id_vendedor"));

		TableViewRelat.setItems(ArrayCompra);
		TableViewRelat.refresh();
	}

	private void CarregrarTableRelatorio() {
		ArrayCompra = FXCollections.observableArrayList(compra.read());

		columId.setCellValueFactory(new PropertyValueFactory<>("Id_compra"));
		columCliente.setCellValueFactory(new PropertyValueFactory<>("Id_cliente"));
		columPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("Preco_Total"));
		columProduto.setCellValueFactory(new PropertyValueFactory<>("Id_produto"));
		columQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		columVendedor.setCellValueFactory(new PropertyValueFactory<>("Id_vendedor"));

		TableViewRelat.setItems(ArrayCompra);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregrarTableRelatorio();
	}

	@FXML
	void btVoltarAction(ActionEvent event) {
		Main.changeScreen("main");
	}

}
