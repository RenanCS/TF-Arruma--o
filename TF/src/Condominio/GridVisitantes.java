package Condominio;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class GridVisitantes extends JFrame {

	private JTable  		tblVisitante;
	private ContatoTableModel model;
	
	public GridVisitantes(){
		super("Visitante");
		initialize();
	}

	private void initialize() {
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(new JScrollPane(getTblVisitantes()));
		
	}

	private JTable getTblVisitantes() {
		if (tblVisitante == null) {
			tblVisitante = new JTable();
			tblVisitante.setModel(new ContatoTableModel());
		}
		return tblVisitante;
	}

	private ContatoTableModel getModel() {
		if (model == null) {
			model = (ContatoTableModel) getTblVisitantes().getModel();
		}
		return model;
	}
		
	private List<Visitante> getVisitante() {
		List<Visitante> vis = new ArrayList<Visitante>();
		for (int i = 0; i < 10; i++) {
			vis.add((Visitante) getVisitante());
		}
		return vis;
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GridVisitantes().setVisible(true);
			}
		});
	}

}