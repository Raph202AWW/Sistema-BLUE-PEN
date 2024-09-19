package pack_Model;

public class Produto {

	private String Id_produto;
	private String Nome;
	private String Código;
	private String Estoque;
	private String Preco;
	private String Tipo_Unit;
	private String DataFabr;
	private String DataValid;
	
	public Produto() {
		super();
	}

	public Produto(String id_produto, String nome, String código,
			String estoque, String preco, String tipo_Unit,
			String dataFabr, String dataValid) {
		super();
		Id_produto = id_produto;
		Nome = nome;
		Código = código;
		Estoque = estoque;
		Preco = preco;
		Tipo_Unit = tipo_Unit;
		DataFabr = dataFabr;
		DataValid = dataValid;
	}

	public String getId_produto() {
		return Id_produto;
	}

	public void setId_produto(String id_produto) {
		Id_produto = id_produto;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCódigo() {
		return Código;
	}

	public void setCódigo(String código) {
		Código = código;
	}

	public String getEstoque() {
		return Estoque;
	}

	public void setEstoque(String estoque) {
		Estoque = estoque;
	}

	public String getPreco() {
		return Preco;
	}

	public void setPreco(String preco) {
		Preco = preco;
	}

	public String getTipo_Unit() {
		return Tipo_Unit;
	}

	public void setTipo_Unit(String tipo_Unit) {
		Tipo_Unit = tipo_Unit;
	}

	public String getDataFabr() {
		return DataFabr;
	}

	public void setDataFabr(String dataFabr) {
		DataFabr = dataFabr;
	}

	public String getDataValid() {
		return DataValid;
	}

	public void setDataValid(String dataValid) {
		DataValid = dataValid;
	}
	
}
