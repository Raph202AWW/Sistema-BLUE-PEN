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
import pack_Controlle.ProdutoDAO;
import pack_Model.Produto;

public class controllerProdutos implements Initializable {

	@FXML
	private Button btVoltar;

	@FXML
	private Button btCadrastrar;

	@FXML
	private Button btEditar;

	@FXML
	private Button btEnterCliente;

	@FXML
	private Button btEnterRegistComp;

	@FXML
	private Button btEnterVendedor;

	@FXML
	private Button btExcluir;
	

    @FXML
    private TextField TextFieldPesquisarP;

	@FXML
	private Button btEnterDistribuidor;

	@FXML
	private Button btPesquisar;

	@FXML
	private TableView<Produto> TableViewProdutos;

	@FXML
	private TableColumn<Produto, String> columCodigo;

	@FXML
	private TableColumn<Produto, String> columDataFabr;

	@FXML
	private TableColumn<Produto, String> columDataVal;

	@FXML
	private TableColumn<Produto, String> columEstoque;

	@FXML
	private TableColumn<Produto, String> columId;

	@FXML
	private TableColumn<Produto, String> columNome;

	@FXML
	private TableColumn<Produto, String> columPrec;

	@FXML
	private TableColumn<Produto, String> columTipoUn;

	private ObservableList<Produto> ArrayProduto;
	private ProdutoDAO produto = new ProdutoDAO();
	public static Produto produtoEditar = new Produto();

	@FXML
	void btCadrastrarAction(ActionEvent event)  throws IOException{
		produtoEditar = null;
		Main.TelaCadastroProduto();
	}

	@FXML
	void btEditarAction(ActionEvent event)throws IOException {
		if (TableViewProdutos.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um vendedor primeiro");
			mensagemDeErro.show();
		} else {
			int i = TableViewProdutos.getSelectionModel().getSelectedIndex();
			produtoEditar = TableViewProdutos.getItems().get(i);
			Main.TelaCadastroProduto();
		}
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
		int i = TableViewProdutos.getSelectionModel().getSelectedIndex();

		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um produto primeiro");
			mensagemDeErro.show();
		} else {
			Produto p = new Produto();
			p = TableViewProdutos.getItems().get(i);

			Alert mensagemDeErro = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeErro.setContentText("Deseja realmente EXCLUIR o produto: " + p.getNome());

			Optional<ButtonType> resultado = mensagemDeErro.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ProdutoDAO PR = new ProdutoDAO();
				PR.delete(p.getCódigo());

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Produto excluido com sucesso!!!");
				mensagemDeExclusao.show();
				CarregarInfTableProduto();
			}
		}

	}

	@FXML
	void btPesquisarAction(ActionEvent event) {
		ArrayProduto = FXCollections.observableArrayList(produto.search(TextFieldPesquisarP.getText()));

		columId.setCellValueFactory(new PropertyValueFactory<>("Id_produto"));
		columNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columCodigo.setCellValueFactory(new PropertyValueFactory<>("Código"));
		columEstoque.setCellValueFactory(new PropertyValueFactory<>("Estoque"));
		columPrec.setCellValueFactory(new PropertyValueFactory<>("Preco"));
		columTipoUn.setCellValueFactory(new PropertyValueFactory<>("Tipo_Unit"));
		columDataFabr.setCellValueFactory(new PropertyValueFactory<>("DataFabr"));
		columDataVal.setCellValueFactory(new PropertyValueFactory<>("DataValid"));

		TableViewProdutos.setItems(ArrayProduto);
		TableViewProdutos.refresh();
	}

	@FXML
	void btEnterDistribuidorAction(ActionEvent event) {
		Main.changeScreen("distribuidor");
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
		CarregarInfTableProduto();
	}

	public void CarregarInfTableProduto() {
		ArrayProduto = FXCollections.observableArrayList(produto.read());

		columId.setCellValueFactory(new PropertyValueFactory<>("Id_produto"));
		columNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columCodigo.setCellValueFactory(new PropertyValueFactory<>("Código"));
		columEstoque.setCellValueFactory(new PropertyValueFactory<>("Estoque"));
		columPrec.setCellValueFactory(new PropertyValueFactory<>("Preco"));
		columTipoUn.setCellValueFactory(new PropertyValueFactory<>("Tipo_Unit"));
		columDataFabr.setCellValueFactory(new PropertyValueFactory<>("DataFabr"));
		columDataVal.setCellValueFactory(new PropertyValueFactory<>("DataValid"));

		TableViewProdutos.setItems(ArrayProduto);
	}
}
