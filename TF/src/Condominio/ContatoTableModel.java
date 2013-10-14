package Condominio;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

public class ContatoTableModel extends TableModel{

	private Serializable visitante;
	private List<String> colunas;
	
	private Visitante vis;
	
	public ContatoTableModel(Visitante vis){
		this.vis = vis;
		this.visitante = vis.toString();
		colunas = Array.asList("Visitante", "CPF", "Morador", "Data/Hora");		
	}
	
	public int getRowCount(){ return visitante.size();}
	
	public int getColumnCount(){return colunas.size();}
	
	public String getColumnName(int i){return colunas.get(i);}
	
	public Object getValueAt(int r, int c){
		
		Visitante visitante = visitante.get(r);
		switch (c){
		case 0: return visitante.getNome();
		case 1: return visitante.getCPF();
		case 2: return visitante.getNome();
		case 3: return visitante.getTime();
		
		}
		return null;
	}
		
	
}
