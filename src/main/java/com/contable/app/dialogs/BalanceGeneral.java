package com.contable.app.dialogs;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.contable.app.contables.Contables;
import com.contable.app.contables.ContablesImpl;
import com.contable.app.empleados.Empleados;
import com.contable.app.empleados.EmpleadosImpl;

public class BalanceGeneral extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel model = new DefaultTableModel();
	private ContablesImpl contablesService = new ContablesImpl();

	private static final long serialVersionUID = -4459759965510378245L;

	/**
	 * Create the dialog.
	 */
	public BalanceGeneral() {
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
		
		JLabel lblBalanceGeneral = new JLabel("Balance General");
		lblBalanceGeneral.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
		lblBalanceGeneral.setBounds(117, 27, 435, 42);
		contentPanel.add(lblBalanceGeneral);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 100, 638, 274);
		contentPanel.add(scrollPane);
		
		//Definimos las columnas
		model.addColumn("Detalle");
		model.addColumn("Nota");
		model.addColumn("Fecha");
		model.addColumn("Ingresos");
		model.addColumn("Egresos");
		model.addColumn("Saldo");
		
		Double subTotal=0.0;
		Double grandTotal=0.0;
		
		//Cargamos los datos
		List<Contables> contables = contablesService.findAll();
		for (Contables contable : contables) {
			if(contable.getTipo().equals("INGRESO")) {
				subTotal+=contable.getValor();
			}else {
				subTotal-=contable.getValor();
			}
			String[] datos = {contable.getDetalle(), contable.getNota(),
					contable.getCreated(), contable.getTipo().equals("INGRESO")?contable.getValor().toString():"",
							contable.getTipo().equals("EGRESO")?contable.getValor().toString():"",subTotal.toString()};
			model.addRow(datos);
			grandTotal=subTotal;
		}
		String[] datosTotal = {
				"","","","","TOTAL:",grandTotal.toString()
		};
		model.addRow(datosTotal);
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
