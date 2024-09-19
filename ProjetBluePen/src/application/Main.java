package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage stage;
	private static Scene login;
	private static Scene main;
	private static Scene vendedor;
	private static Scene clientes;
	private static Scene distribuidor;
	private static Scene produto;
	private static Scene registroComp;
	private static Scene relatorio;
	private static Stage cadProduto;

	@Override
	public void start(Stage primaryStage) {
		try {

			stage = primaryStage;
			primaryStage.setTitle("BluePen");

			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/packView/ViewLogin.fxml"));
			login = new Scene(fxmlLogin);

			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/packView/ViewMain.fxml"));
			main = new Scene(fxmlMain);

			Parent fxmlVendedor = FXMLLoader.load(getClass().getResource("/packView/ViewVendedor.fxml"));
			vendedor = new Scene(fxmlVendedor);

			Parent fxmlClientes = FXMLLoader.load(getClass().getResource("/packView/ViewClientes.fxml"));
			clientes = new Scene(fxmlClientes);

			Parent fxmlDistribuidor = FXMLLoader.load(getClass().getResource("/packView/ViewDistribuidor.fxml"));
			distribuidor = new Scene(fxmlDistribuidor);

			Parent fxmlProduto = FXMLLoader.load(getClass().getResource("/packView/ViewProdutos.fxml"));
			produto = new Scene(fxmlProduto);

			Parent fxmlRegistroComp = FXMLLoader.load(getClass().getResource("/packView/ViewRegistroVendas.fxml"));
			registroComp = new Scene(fxmlRegistroComp);

			Parent fxmlRelatorio = FXMLLoader.load(getClass().getResource("/packView/ViewRelatorio.fxml"));
			relatorio = new Scene(fxmlRelatorio);

			stage.getIcons().add(new Image(getClass().getResourceAsStream("/packageIcons/caneta.jpg")));
			stage.setResizable(false);

			primaryStage.setScene(login);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void changeScreen(String tela) {
		if (tela.equals("login")) {
			stage.setScene(login);
			stage.centerOnScreen();
		} else if (tela.equals("main")) {
			stage.setScene(main);
			stage.centerOnScreen();
		} else if (tela.equals("vendedor")) {
			stage.setScene(vendedor); 
			stage.centerOnScreen();
		} else if (tela.equals("clientes")) {
			stage.setScene(clientes);
			stage.centerOnScreen();
		} else if (tela.equals("distribuidor")) {
			stage.setScene(distribuidor);
			stage.centerOnScreen();
		} else if (tela.equals("produto")) {
			stage.setScene(produto);
			stage.centerOnScreen();
		} else if (tela.equals("registroComp")) {
			stage.setScene(registroComp);
			stage.centerOnScreen();
		} else if (tela.equals("relatorio")) {
			stage.setScene(relatorio);
			stage.centerOnScreen();
		}
	}
	
	public static void TelaCadastroVendedor()throws IOException
	{
		FXMLLoader VendedorCadastro = new FXMLLoader();
		VendedorCadastro.setLocation(Main.class.getResource("/packView/ViewCadastrarVendedor.fxml"));
		Parent cadastroVendedor = VendedorCadastro.load();
		Scene scene2 = new Scene(cadastroVendedor);
		
		cadProduto = new Stage();
		cadProduto.setTitle("Cadastro/Edição de Vendedor - BLUEPEN");
		cadProduto.initModality(Modality.WINDOW_MODAL);
		cadProduto.setScene(scene2);
		cadProduto.centerOnScreen();
		cadProduto.showAndWait();
	}
	
	public static void TelaCadastroProduto()throws IOException
	{
		FXMLLoader ProdutoCadastro = new FXMLLoader();
		ProdutoCadastro.setLocation(Main.class.getResource("/packView/ViewCadastrarProduto.fxml"));
		Parent cadastroProduto = ProdutoCadastro.load();
		Scene scene2 = new Scene(cadastroProduto);
		
		cadProduto = new Stage();
		cadProduto.setTitle("Cadastro/Edição de Produto - BLUEPEN");
		cadProduto.initModality(Modality.WINDOW_MODAL);
		cadProduto.setScene(scene2);
		cadProduto.centerOnScreen();
		cadProduto.showAndWait();
	}
	
	public static void TelaCadastroCliente()throws IOException
	{
		FXMLLoader ClienteCadastro = new FXMLLoader();
		ClienteCadastro.setLocation(Main.class.getResource("/packView/ViewCadastrarClientes.fxml"));
		Parent clienteCadastro = ClienteCadastro.load();
		Scene scene2 = new Scene(clienteCadastro);
		
		cadProduto = new Stage();
		cadProduto.setTitle("Cadastro/Edição de Cliente - BLUEPEN");
		cadProduto.initModality(Modality.WINDOW_MODAL);
		cadProduto.setScene(scene2);
		cadProduto.centerOnScreen();
		cadProduto.showAndWait();
	}

	public static void TelaCadastroFornecedor()throws IOException
	{
		FXMLLoader FornecedorCadastro = new FXMLLoader();
		FornecedorCadastro.setLocation(Main.class.getResource("/packView/ViewCadastroFornecedor.fxml"));
		Parent fornecedorCadastro = FornecedorCadastro.load();
		Scene scene2 = new Scene(fornecedorCadastro);
		
		cadProduto = new Stage();
		cadProduto.setTitle("Cadastro/Edição de Fornecedor - BLUEPEN");
		cadProduto.initModality(Modality.WINDOW_MODAL);
		cadProduto.setScene(scene2);
		cadProduto.centerOnScreen();
		cadProduto.showAndWait();
	}
	
	public static void TelaCadastroCompra()throws IOException
	{
		FXMLLoader RevistroVenda = new FXMLLoader();
		RevistroVenda.setLocation(Main.class.getResource("/packView/ViewRegistroVendas.fxml"));
		Parent revistroVenda = RevistroVenda.load();
		Scene scene2 = new Scene(revistroVenda);
		
		cadProduto = new Stage();
		cadProduto.setTitle("Registrar Venda - BLUEPEN");
		cadProduto.initModality(Modality.WINDOW_MODAL);
		cadProduto.setScene(scene2);
		cadProduto.centerOnScreen();
		cadProduto.showAndWait();
	}
	
	public static void main(String[] args) {
		/*
		 * Connection con = ConnectionDataBase.getConnection();
		 * ConnectionDataBase.closeConnection(con);
		 */
		/*
		 * ArrayList <Produto> produto = new ArrayList<>(); ProdutoDAO p = new
		 * ProdutoDAO();
		 */

		// vd.delete("100765183");

		/*
		 * Cliente
		 * 
		 * Cliente cl = new Cliente(); cl.setNome("Cleitinho Ramos");
		 * cl.setCPF_CNPJ("132765183"); cl.setEmail("CleRJ@gmail.com");
		 * cl.setTelefone("63996794312"); cl.setDataNasc("1990-08-23");
		 * cl.setDataPriCom("2024-08-21"); cl.setEndereco("Rua 34 Setor Nunca Nem Vi");
		 * cl.setTipoJur("PF");
		 * 
		 * 
		 * c.update(cl); cliente = c.read();
		 * 
		 * for(int i = 0; i< cliente.size(); i++) { Cliente clt = cliente.get(i);
		 * System.out.println(); System.out.println(clt.getId_cliente()+"|");
		 * System.out.println(clt.getNome()+"|");
		 * System.out.println(clt.getCPF_CNPJ()+"|");
		 * System.out.println(clt.getEmail()+"|");
		 * System.out.println(clt.getTelefone()+"|");
		 * System.out.println(clt.getDataNasc()+"|");
		 * System.out.println(clt.getDataPriCom()+"|");
		 * System.out.println(clt.getEndereco()+"|");
		 * System.out.println(clt.getTipoJur()+"|"); }
		 */
		/*
		 * Cliente c = new Cliente(); c.setNome("Cleitinho Ramos");
		 * c.setCPF_CNPJ("132765183"); c.setEmail("rere@gmail.com");
		 * c.setTelefone("63996794312"); c.setDataNasc("1990-08-23");
		 * c.setDataPriCom("2024-08-21"); c.setEndereco("Rua 34 Setor Nunca Nem Vi");
		 * c.setTipoJur("PF");
		 * 
		 * ClienteDAO cl = new ClienteDAO(); cl.create(c);
		 */

		// Vendedor

		/*
		 * Vendedor vc = new Vendedor(); vc.setNome("Jefferson Luis");
		 * vc.setCPF("132765183"); vc.setEmail("rere@gmail.com");
		 * vc.setTelefone("63996004312"); vc.setDataNasc("2000-08-23");
		 * vc.setDataContrat("2024-08-23"); vc.setTotal_vend("35");
		 * vc.setEndereco("Rua 30 Setor Nunca Nem Vi N°25 ");
		 * 
		 * v.update(vc); vendedor = v.read();
		 * 
		 * //vd.create(v);
		 * 
		 */

		// Fornecedor
		/*
		 * Fornecedor fn = new Fornecedor(); fn.setNome("DestribuidorDeTristeza");
		 * fn.setCNPJ("453252511"); fn.setEmail("urtcia@email.com");
		 * fn.setTelefone("63998778432"); fn.setEndereco("Rua 0 Setor VISHKK N°F ");
		 * 
		 * 
		 * f.create(fn);
		 * 
		 * Fornecedor fn = new Fornecedor(); fn.setNome("DestribuidorDeTristeza");
		 * fn.setCNPJ("453252511"); fn.setEmail("FCHAT@email.com");
		 * fn.setTelefone("63998778432"); fn.setEndereco("Rua X Setor VISHKK N°5 ");
		 * 
		 * f.update(fn); fornecedor = f.read();
		 * 
		 * for(int i = 0; i< fornecedor.size(); i++) { Fornecedor fnr =
		 * fornecedor.get(i); System.out.println();
		 * System.out.println(fnr.getId_fornecedor()+"|");
		 * System.out.println(fnr.getNome()+"|"); System.out.println(fnr.getCNPJ()+"|");
		 * System.out.println(fnr.getEmail()+"|");
		 * System.out.println(fnr.getTelefone()+"|");
		 * System.out.println(fnr.getEndereco()+"|");
		 * 
		 * }
		 */

		// p.delete("17700824");
		/*
		 * Produto pd = new Produto(); pd.setNome("Tiúba"); pd.setCódigo("17700824");
		 * pd.setEstoque("10"); pd.setPreco("60.78"); pd.setDataFabr("1990-01-12");
		 * pd.setDataValid("2050-12-26"); pd.setTipo_Unit("Litro"); ProdutoDAO pr = new
		 * ProdutoDAO(); p.create(pd); //coloca as informações dentro do array cliente
		 */
		/*
		 * Produto pd = new Produto(); pd.setNome("Cachaça Tiúba");
		 * pd.setCódigo("17700824"); pd.setEstoque("10"); pd.setPreco("60.78");
		 * pd.setDataFabr("1990-01-12"); pd.setDataValid("2050-12-26");
		 * pd.setTipo_Unit("Litro");
		 * 
		 * p.update(pd); /* Compra cp = new Compra(); cp.setId_compra("16");
		 * cp.setId_cliente("4"); cp.setId_vendedor("2"); cp.setId_produto("5");
		 * cp.setQuantidade("2"); cp.setPreco_Total("179.52");
		 * 
		 * 
		 * c.update(cp); compra = c.read();
		 * 
		 * for(int i = 0; i< compra.size(); i++) { Compra cpa = compra.get(i);
		 * System.out.println(); System.out.println(cpa.getId_compra()+"|");
		 * System.out.println(cpa.getId_cliente()+"|");
		 * System.out.println(cpa.getId_vendedor()+"|");
		 * System.out.println(cpa.getId_produto()+"|");
		 * System.out.println(cpa.getQuantidade()+"|");
		 * System.out.println(cpa.getPreco_Total()+"|");
		 * 
		 * }
		 */
		launch(args);
	}
}
