package packController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pack_Controlle.FornecedorDAO;
import pack_Controlle.ProdutoDAO;
import pack_Model.Produto;

public class controllerCadastroProduto implements Initializable{

    @FXML
    private Button btCancelar;

    @FXML
    private Button btSalvar;

    @FXML
    private TextField txtCodigo;

    @FXML
    private DatePicker txtDataFabr;

    @FXML
    private DatePicker txtDataValid;

    @FXML
    private TextField txtEstoque;

    @FXML
    private ChoiceBox<String> txtFornecedorList;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPrec;

    @FXML
    private TextField txtTipoUn;

    @FXML
    void btCancelarAction(ActionEvent event) {
    	txtNome.setText("");
		txtCodigo.setText("");
		txtEstoque.setText("");
		txtTipoUn.setText("");
		txtPrec.setText("");
		controllerProdutos.produtoEditar = null;

		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
    }

    @FXML
    void btSalvarAction(ActionEvent event) {
    	if (controllerProdutos.produtoEditar == null) {
			Produto produto = new Produto();
			produto.setNome(txtNome.getText());
			produto.setCódigo(txtCodigo.getText());
			produto.setEstoque(txtEstoque.getText());
			produto.setDataFabr(txtDataFabr.getValue().toString());
			produto.setDataValid(txtDataValid.getValue().toString());
			produto.setPreco(txtPrec.getText());
			produto.setTipo_Unit(txtTipoUn.getText());

			ProdutoDAO prod = new ProdutoDAO();
			prod.create(produto);

			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		} else {
			Produto produto = new Produto();
			produto.setNome(txtNome.getText());
			produto.setCódigo(txtCodigo.getText());
			produto.setEstoque(txtEstoque.getText());
			produto.setDataFabr(txtDataFabr.getValue().toString());
			produto.setDataValid(txtDataValid.getValue().toString());
			produto.setPreco(txtPrec.getText());
			produto.setTipo_Unit(txtTipoUn.getText());

			ProdutoDAO prod = new ProdutoDAO();
			prod.update(produto);

			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		}
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) 
   {
    	FornecedorDAO fornecedor = new FornecedorDAO();
    	txtFornecedorList.setItems(fornecedor.readNome());
    	
    	
		if (controllerProdutos.produtoEditar != null) {
			txtNome.setText(controllerProdutos.produtoEditar.getNome());
			txtCodigo.setText(controllerProdutos.produtoEditar.getCódigo());
			txtEstoque.setText(controllerProdutos.produtoEditar.getEstoque());
			txtPrec.setText(controllerProdutos.produtoEditar.getPreco());
			txtTipoUn.setText(controllerProdutos.produtoEditar.getTipo_Unit());
		}

	}

}
