package com.contable.app.dialogs;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.contable.app.empleados.Empleados;
import com.contable.app.empleados.EmpleadosImpl;

import java.awt.SystemColor;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaEmpleados extends JDialog {

	private static final long serialVersionUID = -8323875485359883546L;
	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel model = new DefaultTableModel();
	private EmpleadosImpl empeladosService = new EmpleadosImpl();
	
	/**
	 * Create the dialog.
	 */
	public ListaEmpleados() {
		setModal(true);
		setDefaultCloseOperation(0);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setAlwaysOnTop(true);
		setBounds(100, 100, 739, 491);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblListaDeEmpleados = new JLabel("Lista de Empleados");
		lblListaDeEmpleados.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
		lblListaDeEmpleados.setBounds(117, 27, 435, 42);
		contentPanel.add(lblListaDeEmpleados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 100, 638, 274);
		contentPanel.add(scrollPane);
		
		//Definimos las columnas
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Número de Identidad");
		model.addColumn("Teléfono");
		model.addColumn("Correo");
		
		//Cargamos los datos
		List<Empleados> empleados = empeladosService.findAll();
		for (Empleados empleado : empleados) {
			String[] datos = {empleado.getFirstName(), empleado.getFirstSurname(),
					empleado.getIdentificationNumber(), empleado.getPhoneNumber(),
					empleado.getEmail()};
			model.addRow(datos);
		}
		table = new JTable(model);
		table.setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				model.setColumnCount(0);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setForeground(SystemColor.windowText);
		btnNewButton.setBounds(274, 387, 152, 31);
		contentPanel.add(btnNewButton);
	}
}
