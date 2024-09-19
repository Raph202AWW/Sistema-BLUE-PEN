package pack_Model;

public class Compra {

	private String Id_compra;
	private String Id_cliente;
	private String Id_vendedor;
	private String Id_produto;
	private String Quantidade;
	private String Preco_Total;
	
	public Compra() {
		super();
	}

	public Compra(String id_compra, String id_cliente, String id_vendedor,
			String id_produto, String quantidade,
			String preco_Total) {
		super();
		Id_compra = id_compra;
		Id_cliente = id_cliente;
		Id_vendedor = id_vendedor;
		Id_produto = id_produto;
		Quantidade = quantidade;
		Preco_Total = preco_Total;
	}

	public String getId_compra() {
		return Id_compra;
	}

	public void setId_compra(String id_compra) {
		Id_compra = id_compra;
	}

	public String getId_cliente() {
		return Id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		Id_cliente = id_cliente;
	}

	public String getId_vendedor() {
		return Id_vendedor;
	}

	public void setId_vendedor(String id_vendedor) {
		Id_vendedor = id_vendedor;
	}

	public String getId_produto() {
		return Id_produto;
	}

	public void setId_produto(String id_produto) {
		Id_produto = id_produto;
	}

	public String getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(String quantidade) {
		Quantidade = quantidade;
	}

	public String getPreco_Total() {
		return Preco_Total;
	}

	public void setPreco_Total(String preco_Total) {
		Preco_Total = preco_Total;
	}
	
}
