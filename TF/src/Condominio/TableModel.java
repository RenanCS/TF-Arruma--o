package Condominio;

public class TableModel {
	
	
	public int getRowCount(){
		return 0;
		
		
	}
	
	public int getColumCount(){
		
		return 0;		
	}
	/*
	 * Recupera o valor de uma determinada linha 
	 */
	public Object getValueAt(int linha, int coluna){
		return coluna;
		
		//Responsa por fornecer os dados para a tabela
		//será requisitado atra´ves do metodo getValueAt
	}
	
	public String getColumnName(int col){
		
		return null;
		
	}
	
	public boolean isCellEditable( int rowIndex, int columnIndex){
		return false;
	}
	
	/*
	 * 
	 */
	public Class getColumnClass(int c){
		return getValueAt(0,c).getClass();
		
	}

}
