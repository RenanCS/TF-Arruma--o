package Condominio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InterfaceVisitante extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtApto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceVisitante frame = new InterfaceVisitante();
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
	public InterfaceVisitante() {
		setTitle("Alpro2.Visitante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(45, 113, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(45, 144, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNmeroApto = new JLabel("N\u00FAmero Apto.:");
		lblNmeroApto.setBounds(45, 185, 71, 14);
		contentPane.add(lblNmeroApto);
		
		txtNome = new JTextField();
		txtNome.setBounds(123, 110, 264, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(121, 141, 266, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		txtApto = new JTextField();
		txtApto.setBounds(126, 182, 71, 20);
		contentPane.add(txtApto);
		txtApto.setColumns(10);
		
		JButton btnVisitante = new JButton("Visitante");
		btnVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});
		btnVisitante.setBounds(239, 172, 147, 33);
		contentPane.add(btnVisitante);
		
		JLabel lblCadastroDeVisitantes = new JLabel("Cadastro de Visitantes");
		lblCadastroDeVisitantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeVisitantes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastroDeVisitantes.setBounds(56, 25, 317, 48);
		contentPane.add(lblCadastroDeVisitantes);
	}

	/*
	 * CADASTRAR DADOS DO VISITANTE
	 */
	private void cadastrar() {
		
		Memoria memoria = new Memoria();
		Pessoa pes = new Pessoa();
		Verificacao verificar = new Verificacao();
		
		
			String nome = txtNome.getText();
			String CPF = txtCPF.getText();
			String apto = txtApto.getText();
			
			if(!(verificar.Validacao(nome, CPF, apto))){
				
				pes.setNome(nome);
				pes.setCPF(Integer.parseInt(CPF));
				pes.setNapto(Integer.parseInt(apto));			
				memoria.adicionaPes(pes); 
				JOptionPane.showMessageDialog(null,"Cadastro do Visitante Efetuado com Sucesso!");
				dispose();
				
			
	
			}
			else{
				 JOptionPane.showMessageDialog(null,"EXISTE CAMPOS EM ABERTO");
			}
}






}
