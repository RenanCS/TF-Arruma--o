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
        // Está retornando o tamanho do array 
        return colunas.length;
    }
   

    /* Retorna a quantidade de linhas. */
    @Override
    public int getRowCount() {
        // Retorna o tamanho da lista de sócios.
        return dados.size();
    }
    
    /* Retorna o nome da coluna no índice especificado.
     * Este método é usado pela JTable para saber o texto do cabeçalho. */
    @Override
    public String getColumnName(int columnIndex) {
        // Retorna o conteúdo do Array que possui o nome das colunas
        // no índice especificado.
        return colunas[columnIndex];
    };
    
    
    /* Retorna a classe dos elementos da coluna especificada.
     * Este método é usado pela JTable na hora de definir o editor da célula. */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Retorna a classe referente a coluna especificada.
        // Aqui é feito um switch para verificar qual é a coluna
        // e retornar o tipo adequado. As colunas são as mesmas
        // que foram especificadas no array "colunas".
        switch (columnIndex) {

        case 0: // Primeira coluna é o nome, que é uma String.
            return String.class;
        case 1: // Segunda coluna é o CPF, que também é uma String..
            return String.class;
        case 2: // Segunda coluna é o Nome do Morador, que também é uma String.
            return String.class;
        case 3: // Segunda coluna é o Data/Hora, que também é uma String..
            return String.class;
        default:
            // Se o índice da coluna não for válido, lança um
            // IndexOutOfBoundsException (Exceção de índice fora dos limites).
            // Não foi necessário verificar se o índice da linha é inválido,
            // pois o próprio ArrayList lança a exceção caso seja inválido.
        	throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }
    
    /* Retorna o valor da célula especificada
     * pelos índices da linha e da coluna. */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o pessoa da linha especificada.       
        Visitante vis = dados.get(rowIndex);
        Pessoa pes = dados.get(rowIndex);

        // Retorna o campo referente a coluna especificada.
        // Aqui é feito um switch para verificar qual é a coluna
        // e retornar o campo adequado. As colunas são as mesmas
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
            // Se o índice da coluna não for válido, lança um
            // IndexOutOfBoundsException (Exceção de índice fora dos limites).
            // Não foi necessário verificar se o índice da linha é inválido,
            // pois o próprio ArrayList lança a exceção caso seja inválido.
			throw new IndexOutOfBoundsException("columnIndex out of bounds");        }
    }
    
    /* Retorna um valor booleano que define se a célula em questão
     * pode ser editada ou não.
     * Este método é utilizado pela JTable na hora de definir o editor da célula.
     * Neste caso, estará sempre retornando false, não permitindo que nenhuma
     * célula seja editada. */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    
    
}
