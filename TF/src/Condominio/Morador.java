package Condominio;

public class Morador extends Pessoa{

	private String telefone; 
	
	Morador(String nome, String CPF, String napto, String telefone){
	super(nome, CPF, napto);
	setTelefone(telefone);
	}
    
	public Morador() {
		
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Morador [" + nome + "," + telefone + ","+ CPF + "," + napto + "]";
	}	
	
	
	
}
