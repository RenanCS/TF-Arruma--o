package Condominio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class GridVisitantes extends JFrame {

	public GridVisitantes(){
		super("Visitante");
		Visitante vis = new Visitante();
		ContatoTableModel tm  = new ContatoTableModel(vis);
		JTable t = new JTable (tm);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(t);
		add(scroll);
		setSize(200,180);	
	}
	
	public static void main (String[] args){
		GridVisitantes grid = new GridVisitantes();
		grid.setVisible(true);
	}
}