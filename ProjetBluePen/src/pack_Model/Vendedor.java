package pack_Model;

public class Vendedor {

	private String Id_vendedor;
	private String Nome;
	private String CPF;
	private String Email;
	private String Telefone;
	private String DataNasc;
	private String DataContrat;
	private String Total_vend;
	private String Endereco;
	private String Password;
	

	public Vendedor() {
		super();
	}

	public Vendedor(String id_vendedor, String nome, String cPF,
			String email, String telefone, String dataNasc,
			String dataContrat, String total_vend, String endereco, String password) {
		super();
		Id_vendedor = id_vendedor;
		Nome = nome;
		CPF = cPF;
		Email = email;
		Telefone = telefone;
		DataNasc = dataNasc;
		DataContrat = dataContrat;
		Total_vend = total_vend;
		Endereco = endereco;
		Password = password;
	}

	public String getId_vendedor() {
		return Id_vendedor;
	}

	public void setId_vendedor(String id_vendedor) {
		Id_vendedor = id_vendedor;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getDataNasc() {
		return DataNasc;
	}

	public void setDataNasc(String dataNasc) {
		DataNasc = dataNasc;
	}

	public String getDataContrat() {
		return DataContrat;
	}

	public void setDataContrat(String dataContrat) {
		DataContrat = dataContrat;
	}

	public String getTotal_vend() {
		return Total_vend;
	}

	public void setTotal_vend(String total_vend) {
		Total_vend = total_vend;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
	
}
