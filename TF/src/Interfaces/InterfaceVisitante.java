package Interfaces;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

import ClassesPrincipais.Visitante;
import Condominio.Memoria;
import Condominio.Verificacao;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.ComponentOrientation;

public class InterfaceVisitante extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtApto;
	Memoria memoria = new Memoria();

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(22, 84, 46, 14);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(22, 117, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblNmeroApto = new JLabel("N\u00FAmero Apto:");
		lblNmeroApto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNmeroApto.setBounds(22, 156, 92, 14);
		contentPane.add(lblNmeroApto);

		txtNome = new JTextField();
		txtNome.setBounds(124, 84, 264, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtCPF = new JTextField();
		txtCPF.setBounds(122, 115, 86, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);

		txtApto = new JTextField();
		txtApto.setBounds(124, 153, 61, 20);
		contentPane.add(txtApto);
		txtApto.setColumns(10);

		JButton btnVisitante = new JButton("Visitante");
		btnVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});
		btnVisitante.setBounds(227, 140, 148, 48);
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

		Visitante vis = new Visitante();
		Verificacao verificar = new Verificacao();

		String nome = txtNome.getText();
		String CPF = txtCPF.getText();
		String apto = txtApto.getText();
		String morador = null;
		if (!(verificar.Validacao(nome, CPF, apto))) {

			if ((morador = verificar.VerificaMoradorVisitante(apto)) != null) {
				SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Calendar cal = new GregorianCalendar();

				vis.setNome(nome);
				vis.setCPF(CPF);
				vis.setNapto(apto);
				vis.setTime(String.format(data.format(cal.getTime())));
				vis.setNomemorador(morador);
				memoria.adicionaPes(vis);
				JOptionPane.showMessageDialog(null,
						"CADASTRO VISITANTE EFETUADO COM SUCESSO!");
				dispose();

			} else {
				JOptionPane.showMessageDialog(null,
						"NUMERO APARTAMENTO NAO EXISTE");
			}

		}
	}

}
