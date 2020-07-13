package com.contable.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.contable.app.panels.PanelInicio;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Ejecutar extends JFrame {

	private static final long serialVersionUID = -3654268615867351584L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejecutar frame = new Ejecutar();
					frame.setResizable(false);
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
	public Ejecutar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 471);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		JMenuItem mntmInicio = new JMenuItem("Inicio");
		mnOpciones.add(mntmInicio);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnOpciones.add(mntmSalir);
		
		JMenu mnNewMenu = new JMenu("N\u00F3mina");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmListaDeEmpleados = new JMenuItem("Lista de Empleados");
		mnNewMenu.add(mntmListaDeEmpleados);
		
		JMenuItem mntmAgregarEmpleado = new JMenuItem("Agregar Empleado");
		mnNewMenu.add(mntmAgregarEmpleado);
		
		JMenu mnBalanceGeneral = new JMenu("Ingresos y Egresos");
		menuBar.add(mnBalanceGeneral);
		
		JMenuItem mntmIngresos = new JMenuItem("Ingresos");
		mnBalanceGeneral.add(mntmIngresos);
		
		JMenuItem mntmEgresos = new JMenuItem("Egresos");
		mnBalanceGeneral.add(mntmEgresos);
		
		JMenu mnBalance = new JMenu("Balance");
		menuBar.add(mnBalance);
		
		JMenuItem mntmBalanceGeneral = new JMenuItem("Balance General");
		mnBalance.add(mntmBalanceGeneral);
		
		JMenuItem mntmSolicitudes = new JMenuItem("Solicitudes");
		mnBalance.add(mntmSolicitudes);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaContable = new JLabel("Sistema Contable");
		lblSistemaContable.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
		lblSistemaContable.setBounds(97, 52, 401, 42);
		contentPane.add(lblSistemaContable);
		
		PanelInicio panelInicio = new PanelInicio();
		panelInicio.setBounds(32, 122, 546, 270);
		contentPane.add(panelInicio);
	}
}
