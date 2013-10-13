package Condominio;

import java.util.ArrayList;

public class Memoria {


    private ArrayList<Morador> morador; 
	private ArrayList<Visitante> visitante; 
	
    Memoria(){
    	morador = new ArrayList<Morador>();
    	visitante = new ArrayList<Visitante>();
    }
	
	public void adicionaPes(Visitante vis){
		visitante.add(vis);
		LeituraGravacaoArquivo.gravarDadosVisitante(visitante);
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
