package Condominio;

import javax.swing.JOptionPane;

public class Verificacao {
	
	public Verificacao(){
	
	}

	public boolean Validacao(String nome, String cpf, String apto){
		
		if( nome.equals("") || nome.length() < 8 ){ 
			JOptionPane.showMessageDialog(null,"CAMPO NOME INCOMPLETO");
			return true;}
		if( cpf.equals("") || cpf.length() <= 10 ){ 
			JOptionPane.showMessageDialog(null,"CAMPO CPF INCOMPLETO");
			return true;}
		if( apto.equals("") || apto.length() <=0 ){ 
			JOptionPane.showMessageDialog(null,"CAMPO NUMERO APARTAMENTO EM BRANCO");		
			return true;}

		return false;
			
	}
	
	public boolean ValidacaoMorador(String nome, String cpf, String apto, String telefone){
		
		if( nome.equals("") || nome.length() < 8 ){ 
			JOptionPane.showMessageDialog(null,"CAMPO NOME INCOMPLETO");
			return true;}
		if( cpf.equals("") || cpf.length() <= 10 ){ 
			JOptionPane.showMessageDialog(null,"CAMPO CPF INCOMPLETO");
			return true;}
		if( apto.equals("") || apto.length() <=0 ){ 
			JOptionPane.showMessageDialog(null,"CAMPO NUMERO APARTAMENTO EM BRANCO");
			return true;}
		if( telefone.equals("") || telefone.length() <= 7 ){
			JOptionPane.showMessageDialog(null,"CAMPO TELEFONE INCOMPLETO");
			return true;}

		return false;
			
	}


	public String VerificaMoradorVisitante(String apto) {
		String pessoa = null;
		if((pessoa =Memoria.verificarVisitaMorador(apto)) != null){return pessoa;}
		else {return pessoa;}
	}
	
}

