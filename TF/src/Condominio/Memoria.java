package Condominio;

import java.util.ArrayList;

public class Memoria {


    private static ArrayList<Pessoa> pessoa;  
    private static ArrayList<Morador> morador;
	LeituraGravacaoArquivo arquivo;
	
	Memoria(){
		pessoa = new ArrayList<Pessoa>();
		morador = new ArrayList<Morador>();
		
	}
	
	public void adicionaPes(Pessoa pes){
		pessoa.add(pes);
	}
	
	public void adicionarMorador(Morador mo){
		morador.add(mo);		
		LeituraGravacaoArquivo.gravarDados(morador);
	}
	
	public int tamanhoMorador(){
		int contador;
		contador = morador.size();
		return contador;
	}
	
}
