package Condominio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ClassesPrincipais.Morador;
import ClassesPrincipais.Visitante;

public class Memoria {

	
    public static ArrayList<Morador> morador = new ArrayList<Morador>(); 
    public static ArrayList<Visitante> visitante = new ArrayList<Visitante>(); 
	public static int contador = 0;
	
    public Memoria(){   	

    }
       
    public Memoria(ArrayList listamorador, ArrayList listavisitante) {
    	morador = new ArrayList<Morador>(listamorador);     	
    	visitante = new ArrayList<Visitante>(listavisitante);
    	contador = listamorador.size();
	}
	
	public static void adicionaPes(Visitante vis){
	visitante.add(vis);
	LeituraGravacaoArquivo.gravarDadosVisitante(visitante);
	}
	
	public static void adicionarMorador(Morador mo){
		morador.add(mo);		
		LeituraGravacaoArquivo.gravarDados(morador);
	}
	
	public static int tamanhoMorador(){
		contador = morador.size();
		return contador;
	}

//	public void adicionaPesLeitura(Visitante pessoaVisitante) {
	//	visitante.add(pessoaVisitante);
//	}
	
}
