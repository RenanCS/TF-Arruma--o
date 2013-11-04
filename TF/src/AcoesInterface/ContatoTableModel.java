package AcoesInterface;

import javax.swing.table.AbstractTableModel;
import ClassesPrincipais.Pessoa;
import ClassesPrincipais.Visitante;
import DoubleListIterator.ListDoubleLinked;

public class ContatoTableModel extends AbstractTableModel{
	
	private ListDoubleLinked<Visitante> dados;
	private String[] colunas = {"Visitante", "CPF", "Morador", "Data/Hora"};
	
	public ContatoTableModel(){
		dados = new ListDoubleLinked<Visitante>();
	}

	public 	ContatoTableModel(ListDoubleLinked<Visitante> listDoubleLinked){
		dados = listDoubleLinked;
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
            return String.class;
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
        // Pega o pessoa da linha especificada.       
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
            return vis.getTime();
        case 3: 
            return vis.getNomemorador();        
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
    
    
    
}
