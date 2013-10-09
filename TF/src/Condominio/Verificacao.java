package Condominio;

public class Verificacao {
	
	public Verificacao(){
	
	}

	public boolean Validacao(String nome, String cpf, String apto){
		
		if( nome.equals("")){ return true;}
		if( cpf.equals("") || cpf.length() <= 10 ){ return true;}
		if( apto.equals("") || apto.length() <=0 ){ return true;}

		return false;
			
	}
	
}

