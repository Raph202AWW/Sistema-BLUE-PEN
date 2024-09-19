package packController;

import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pack_Controlle.ClienteDAO;
import pack_Controlle.CompraDAO;
import pack_Controlle.ProdutoDAO;
import pack_Controlle.VendedorDAO;
import pack_Model.Cliente;
import pack_Model.Compra;
import pack_Model.Produto;

public class controllerRegistroComp implements Initializable {

	@FXML
	private Button btCancelar;

	@FXML
	private Button btPesquisar;

	@FXML
	private Button btSalvar;
	@FXML
	private Button btVoltar;

	@FXML
	private TextField TextFieldPesquisarR;

	@FXML
	private TableView<Produto> TableRegistProduto;

	@FXML
	private TableColumn<Produto, String> columDataFabr;

	@FXML
	private TableColumn<Produto, String> columDataVal;

	@FXML
	private TableColumn<Produto, String> columId;

	@FXML
	private TableColumn<Produto, String> columNome;

	@FXML
	private TextField txtCPFV;

	@FXML
	private TextField txtCPF_CNPJ;

	@FXML
	private TextField txtCodigo;

	@FXML
	private TextField txtDesconto;

	@FXML
	private TextField txtIdcliente;

	@FXML
	private TextField txtIdvendedor;

	@FXML
	private TextField txtNomeC;

	@FXML
	private TextField txtNomeV;

	@FXML
	private TextField txtPrecoTotal;

	@FXML
	private TextField txtPrecoUni;

	@FXML
	private TextField txtQuantidade;

	ArrayList<Cliente> cliente1 = new ArrayList<>();
	Produto produto = new Produto();
	Cliente cliente2 = new Cliente();
	private ClienteDAO clienteDAO = new ClienteDAO();
	private ObservableList<Produto> ArrayCompra;
	private ProdutoDAO compra = new ProdutoDAO();
	VendedorDAO v = new VendedorDAO();

	@FXML
	void btCancelarAction(ActionEvent event) {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	void btPesquisarAction(ActionEvent event) {
		ArrayCompra = FXCollections.observableArrayList(compra.search(TextFieldPesquisarR.getText()));

		columId.setCellValueFactory(new PropertyValueFactory<>("Id_produto"));
		columNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columDataFabr.setCellValueFactory(new PropertyValueFactory<>("DataFabr"));
		columDataVal.setCellValueFactory(new PropertyValueFactory<>("DataValid"));

		TableRegistProduto.setItems(ArrayCompra);
		TableRegistProduto.refresh();
	}

	@FXML
	void btSalvarAction(ActionEvent event) {
		if (cliente2 != null && produto != null && txtIdvendedor != null) {
			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente Salvar a venda para o vendedor : " + txtNomeV.getText());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				
				CompraDAO compraDAO = new CompraDAO();
				Compra compra = new Compra();
				compra.setId_cliente(cliente2.getId_cliente());
				compra.setId_vendedor(txtIdvendedor.getText());
				compra.setId_produto(produto.getId_produto());
				compra.setQuantidade(txtQuantidade.getText());
				compra.setPreco_Total(txtPrecoTotal.getText());
				compraDAO.create(compra);
				txtIdcliente.setText("");
				txtNomeC.setText("");
				txtCPF_CNPJ.setText("");
				txtCodigo.setText("");
				txtQuantidade.setText("");
				txtPrecoUni.setText("");
				txtPrecoTotal.setText("");
				txtDesconto.setText("");
				cliente2 = null;
				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Venda realizada com sucesso!");
				mensagemDeExclusao.show();
			}
		} else {
			Alert mensagemDeExclusao = new Alert(Alert.AlertType.ERROR);
			mensagemDeExclusao.setContentText("Error ao salvar. Informações incompletas");
			mensagemDeExclusao.show();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregrarTableCompra();
		cliente2 = null;
		// Parte do código responsável por carregar de forma automática as informações
		// do vendedor para preencher os campos ID, CPF e Nome
		// do vendedor na tela de Registrar venda, de acordo com o usuário que realizou
		// Login.
		//
		txtCPFV.setText(controllerLogin.vend.getCPF());
		txtNomeV.setText(controllerLogin.vend.getNome());
		txtIdvendedor.setText(controllerLogin.vend.getId_vendedor());
		txtQuantidade.setText("0");

		TableRegistProduto.setOnMouseClicked((MouseEvent clique) -> {
			if (clique.getClickCount() == 2) {
				int i = TableRegistProduto.getSelectionModel().getSelectedIndex();
				produto = TableRegistProduto.getItems().get(i);
				txtCodigo.setText(produto.getCódigo());
				TextFieldPesquisarR.setText(produto.getNome());
				txtPrecoUni.setText(produto.getPreco());
			}
		});

	}

	private void CarregrarTableCompra() {
		ArrayCompra = FXCollections.observableArrayList(compra.read());

		columId.setCellValueFactory(new PropertyValueFactory<>("Id_produto"));
		columNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columDataFabr.setCellValueFactory(new PropertyValueFactory<>("DataFabr"));
		columDataVal.setCellValueFactory(new PropertyValueFactory<>("DataValid"));

		TableRegistProduto.setItems(ArrayCompra);
	}

	@FXML
	void definirPrecoTotal(KeyEvent event) {
		if (txtQuantidade.getText() != "" && txtQuantidade.getText() != null) {

			double quantidade = Double.parseDouble(txtQuantidade.getText());
			if (quantidade < 30) {
				txtDesconto.setText("");
				double precoTotal = Double.parseDouble(txtPrecoUni.getText())
						* Double.parseDouble(txtQuantidade.getText());
				txtPrecoTotal.setText(Double.toString(precoTotal));

			} else {
				double precoTotal = (Double.parseDouble(txtPrecoUni.getText())
						* Double.parseDouble(txtQuantidade.getText()));
				precoTotal = precoTotal * 0.85;
				txtPrecoTotal.setText(Double.toString(precoTotal));
				Double desconto = precoTotal * 0.15;
				txtDesconto.setText(Double.toString(desconto));

			}
		}
	}

	@FXML
	void definirCliente(KeyEvent evente) {
		if (clienteDAO.search(txtCPF_CNPJ.getText()) != null) {
			cliente1 = clienteDAO.search(txtCPF_CNPJ.getText());
			cliente2 = cliente1.get(0);
			txtIdcliente.setText(cliente2.getId_cliente());
			txtNomeC.setText(cliente2.getNome());
		}
	}

	@FXML
	void btVoltarAction(ActionEvent event) {
		Main.changeScreen("main");
	}
}
