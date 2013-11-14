package Interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Condominio.LeituraGravacaoArquivo;
import Condominio.Memoria;

import java.awt.Toolkit;
import java.util.ArrayList;

public class MenuCondominio extends JFrame {
//A
	private JPanel contentPane;
	Memoria memoria;
	LeituraGravacaoArquivo grave;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCondominio frame = new MenuCondominio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuCondominio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("L:\\PUCRS\\2\u00BA Semestre\\Alpro2\\condominio.jpg"));
		setTitle("Alpro2 - Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Dados");
		menuBar.add(mnMenu);

		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnMenu.add(mnCadastrar);

		JMenuItem mntmNewMenuItem = new JMenuItem("Morador");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfaceMorador morador = new InterfaceMorador();
				morador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				morador.setLocationRelativeTo(null);
				morador.setVisible(true);
			}
		});
		mnCadastrar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem1 = new JMenuItem("Visitante");
		mntmNewMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfaceVisitante visitante = new InterfaceVisitante();
				visitante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				visitante.setLocationRelativeTo(null);
				visitante.setVisible(true);				
			}
		});
		mnCadastrar.add(mntmNewMenuItem1);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmSobre = new JMenuItem("About Condominio");
		mnHelp.add(mntmSobre);
		
		JMenuItem mntmContato = new JMenuItem("Contato Fornecer");
		mnHelp.add(mntmContato);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenu.setBounds(122, 11, 156, 44);
		contentPane.add(lblMenu);
		
		final JRadioButton rdbtnCadastrarVisitante = new JRadioButton("Cadastrar Visitante");
		rdbtnCadastrarVisitante.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnCadastrarVisitante.setBounds(49, 80, 156, 23);
		contentPane.add(rdbtnCadastrarVisitante);

		final JRadioButton rdbtnCadastrarMorador = new JRadioButton("Cadastrar Morador");
		rdbtnCadastrarMorador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnCadastrarMorador.setBounds(49, 128, 156, 23);
		contentPane.add(rdbtnCadastrarMorador);

		final JRadioButton rdbtnVisitaMes = new JRadioButton("Consultar Visitas");
		rdbtnVisitaMes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnVisitaMes.setBounds(240, 80, 188, 23);
		contentPane.add(rdbtnVisitaMes);
		
		final JRadioButton rbtQuantidade = new JRadioButton("Quantidade Moradores");
		rbtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbtQuantidade.setBounds(240, 130, 188, 23);
		contentPane.add(rbtQuantidade);

		ButtonGroup opcao = new ButtonGroup();
		opcao.add(rdbtnVisitaMes);
		opcao.add(rdbtnCadastrarMorador);
		opcao.add(rdbtnCadastrarVisitante);
		opcao.add(rbtQuantidade);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(140, 195, 156, 33);
		contentPane.add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				memoria = new Memoria(grave.LerDadosMorador(), grave.lerDadosVisitante());
				
				if (rdbtnVisitaMes.isSelected()) {
					GridVisitantes consultavisitante = new GridVisitantes();
					consultavisitante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					consultavisitante.setLocationRelativeTo(null);
					consultavisitante.setVisible(true);

				}
				if (rdbtnCadastrarMorador.isSelected()) {
					InterfaceMorador morador = new InterfaceMorador();
					morador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					morador.setLocationRelativeTo(null);
					morador.setVisible(true);

				}
				if (rdbtnCadastrarVisitante.isSelected()) {
					InterfaceVisitante visitante = new InterfaceVisitante();
					visitante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					visitante.setLocationRelativeTo(null);
					visitante.setVisible(true);
				}
				if (rbtQuantidade.isSelected()) {
					JOptionPane.showMessageDialog(null,"QUANTIDADE DE MORADORES SÃO: " + Memoria.tamanhoMorador());
				}

				
			}
		});
		
	
	}
}
