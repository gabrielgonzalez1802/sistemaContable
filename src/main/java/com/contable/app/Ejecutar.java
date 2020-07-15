package com.contable.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.contable.app.conexion.BaseDeDatos;
import com.contable.app.dialogs.BalanceGeneral;
import com.contable.app.dialogs.FormEgreso;
import com.contable.app.dialogs.FormEmpleado;
import com.contable.app.dialogs.FormIngreso;
import com.contable.app.dialogs.ListaEmpleados;
import com.contable.app.dialogs.SolicitudAdelanto;
import com.contable.app.panels.PanelInicio;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejecutar extends JFrame {

	private static final long serialVersionUID = -3654268615867351584L;
	private JPanel contentPane;
	private static Ejecutar frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseDeDatos db = new BaseDeDatos();
					frame = new Ejecutar();
					frame.setResizable(false);
					frame.setDefaultCloseOperation(0);
					frame.setVisible(true);
					if(!db.conectar()) {
						JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
						frame.dispose();
					}
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
		mnOpciones.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnOpciones);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frame.isDisplayable()) {
	                   frame.dispose();
	                   System.out.println("Fin de la ejecución");
	               }
			}
		});
		mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnOpciones.add(mntmSalir);
		
		JMenu mnNewMenu = new JMenu("N\u00F3mina");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmListaDeEmpleados = new JMenuItem("Lista de Empleados");
		mntmListaDeEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEmpleados listaEmpleados = new ListaEmpleados();
				listaEmpleados.setVisible(true);
			}
		});
		mntmListaDeEmpleados.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(mntmListaDeEmpleados);
		
		JMenuItem mntmAgregarEmpleado = new JMenuItem("Agregar Empleado");
		mntmAgregarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormEmpleado formEmpleado = new FormEmpleado();
				formEmpleado.setVisible(true);
			}
		});
		mntmAgregarEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(mntmAgregarEmpleado);
		
		JMenu mnBalanceGeneral = new JMenu("Ingresos y Egresos");
		mnBalanceGeneral.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnBalanceGeneral);
		
		JMenuItem mntmIngresos = new JMenuItem("Ingresos");
		mntmIngresos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormIngreso formIngreso = new FormIngreso();
				formIngreso.setVisible(true);
			}
		});
		mntmIngresos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnBalanceGeneral.add(mntmIngresos);
		
		JMenuItem mntmEgresos = new JMenuItem("Egresos");
		mntmEgresos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormEgreso formEgreso = new FormEgreso();
				formEgreso.setVisible(true);
			}
		});
		mntmEgresos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnBalanceGeneral.add(mntmEgresos);
		
		JMenu mnBalance = new JMenu("Balance");
		mnBalance.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnBalance);
		
		JMenuItem mntmBalanceGeneral = new JMenuItem("Balance General");
		mntmBalanceGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BalanceGeneral balanceGeneral = new BalanceGeneral();
				balanceGeneral.setVisible(true);
			}
		});
		mntmBalanceGeneral.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnBalance.add(mntmBalanceGeneral);
		
		JMenuItem mntmSolicitudes = new JMenuItem("Solicitudes");
		mntmSolicitudes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SolicitudAdelanto adelanto = new SolicitudAdelanto();
				adelanto.setVisible(true);
			}
		});
		mntmSolicitudes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnBalance.add(mntmSolicitudes);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaContable = new JLabel("CEDEA M&G");
		lblSistemaContable.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
		lblSistemaContable.setBounds(126, 43, 401, 42);
		contentPane.add(lblSistemaContable);
		
		PanelInicio panelInicio = new PanelInicio();
		panelInicio.setBounds(32, 122, 546, 270);
		contentPane.add(panelInicio);
	}
}
