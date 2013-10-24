package Condominio;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

public class ContatoTableModel extends AbstractTableModel{

		
	private List<Visitante> dados;
	private String[] colunas = {"Visitante", "CPF", "Morador", "Data/Hora"};
	

	
	public ContatoTableModel(){
		dados = new ArrayList<Visitante>();
	}

	public 	ContatoTableModel(List<Visitante> listavisitante){
		dados = new ArrayList<Visitante>(listavisitante);
	}

	/* Retorna a quantidade de colunas. */
    @Override
    public int getColumnCount() {
        // Est� retornando o tamanho do array 
        return colunas.length;
    }
    

    /* Retorna a quantidade de linhas. */
    @Override
    public int getRowCount() {
        // Retorna o tamanho da lista de s�cios.
        return dados.size();
    }
    
    /* Retorna o nome da coluna no �ndice especificado.
     * Este m�todo � usado pela JTable para saber o texto do cabe�alho. */
    @Override
    public String getColumnName(int columnIndex) {
        // Retorna o conte�do do Array que possui o nome das colunas
        // no �ndice especificado.
        return colunas[columnIndex];
    };
    
    
    /* Retorna a classe dos elementos da coluna especificada.
     * Este m�todo � usado pela JTable na hora de definir o editor da c�lula. */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Retorna a classe referente a coluna especificada.
        // Aqui � feito um switch para verificar qual � a coluna
        // e retornar o tipo adequado. As colunas s�o as mesmas
        // que foram especificadas no array "colunas".
        switch (columnIndex) {

        case 0: // Primeira coluna � o nome, que � uma String.
            return Long.class;
        case 1: // Segunda coluna � o CPF, que tamb�m � uma String..
            return String.class;
        case 2: // Segunda coluna � o Nome do Morador, que tamb�m � uma String.
            return String.class;
        case 3: // Segunda coluna � o Data/Hora, que tamb�m � uma String..
            return String.class;
        default:
            // Se o �ndice da coluna n�o for v�lido, lan�a um
            // IndexOutOfBoundsException (Exce��o de �ndice fora dos limites).
            // N�o foi necess�rio verificar se o �ndice da linha � inv�lido,
            // pois o pr�prio ArrayList lan�a a exce��o caso seja inv�lido.
        	throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }
    
    /* Retorna o valor da c�lula especificada
     * pelos �ndices da linha e da coluna. */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o s�cio da linha especificada.       
        Visitante vis = dados.get(rowIndex);
        Pessoa pes = dados.get(rowIndex);

        // Retorna o campo referente a coluna especificada.
        // Aqui � feito um switch para verificar qual � a coluna
        // e retornar o campo adequado. As colunas s�o as mesmas
        // que foram especificadas no array "colunas".
        switch (columnIndex) {
        case 0: 
            return vis.getNome();
        case 1: 
            return vis.getCPF();
        case 2: 
            return pes.getNome();
        case 3: 
            return vis.getTime();        
        default:
            // Se o �ndice da coluna n�o for v�lido, lan�a um
            // IndexOutOfBoundsException (Exce��o de �ndice fora dos limites).
            // N�o foi necess�rio verificar se o �ndice da linha � inv�lido,
            // pois o pr�prio ArrayList lan�a a exce��o caso seja inv�lido.
			throw new IndexOutOfBoundsException("columnIndex out of bounds");        }
    }
    
    /* Retorna um valor booleano que define se a c�lula em quest�o
     * pode ser editada ou n�o.
     * Este m�todo � utilizado pela JTable na hora de definir o editor da c�lula.
     * Neste caso, estar� sempre retornando false, n�o permitindo que nenhuma
     * c�lula seja editada. */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    
    
    /////////////////////////
    
    /* Retorna o s�cio da linha especificada. */
    public Visitante getFuncionario(int indiceLinha) {
            if(indiceLinha < dados.size()){
                return dados.get(indiceLinha);
            }
        return null;
    }
    

    /* Adiciona um registro. */
    public void addVisitante(Visitante vis) {
        // Adiciona o registro.
        dados.add(vis);

        // Pega a quantidade de registros e subtrai um para achar
        // o �ltimo �ndice. � preciso subtrair um, pois os �ndices
        // come�am pelo zero.
        int ultimoIndice = getRowCount() - 1;

        // Reporta a mudan�a. O JTable recebe a notifica��o
        // e se redesenha permitindo que visualizemos a atualiza��o.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    
    /* Remove a linha especificada. */
    public void removeVisitante(int indiceLinha) {
        // Remove o s�cio da linha especificada.  
            if(indiceLinha < dados.size()){
                dados.remove(indiceLinha);

        // Reporta a mudan�a. O JTable recebe a notifica��o
        // e se redesenha permitindo que visualizemos a atualiza��o.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
            }

    }
    
    
    /* Adiciona uma lista de s�cios ao final dos registros. */
    public void addListaDeVisitante(List<Visitante> vis) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        dados.addAll(vis);

        // Reporta a mudan�a. O JTable recebe a notifica��o
        // e se redesenha permitindo que visualizemos a atualiza��o.
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    
    /* Remove todos os registros. */
    public void limpar() {
        // Remove todos os elementos da lista de s�cios.
        dados.clear();

        // Reporta a mudan�a. O JTable recebe a notifica��o
        // e se redesenha permitindo que visualizemos a atualiza��o.
        fireTableDataChanged();
    }
    
    
    /* Verifica se este table model est� vazio. */
    public boolean isEmpty() {
        return dados.isEmpty();
    }
    
    public Object getObject(int index) {
        return dados.get(index);
    }
	
}
