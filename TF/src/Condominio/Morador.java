package Condominio;

public class Morador extends Pessoa{

	private int telefone; 
	
	Morador(String nome, int CPF, int napto, int telefone){
	super(nome, CPF, napto);
	setTelefone(telefone);
	}
    
	public Morador() {
		
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}	
	
}
