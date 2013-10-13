package Condominio;

import java.util.ArrayList;

public class Memoria {


    private static ArrayList<Pessoa> pessoa;  
    ArrayList<Morador> morador = new ArrayList<Morador>();
	ArrayList<Visitante> visitante = new ArrayList<Visitante>();
	
	
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
