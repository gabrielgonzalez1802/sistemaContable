package com.contable.app.dialogs;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.contable.app.ingresos.Ingresos;
import com.contable.app.ingresos.IngresosImpl;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormIngreso extends JDialog {

	private static final long serialVersionUID = 7991521074491827664L;
	private JTextField txtValor;
	private JTextField txtDetalle;
	private JTextField txtNota;
	private JLabel lblMsg;
	private IngresosImpl ingresosService = new IngresosImpl();

	/**
	 * Create the dialog.
	 */
	public FormIngreso() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setModal(true);
		setDefaultCloseOperation(0);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setAlwaysOnTop(true);
		setBounds(100, 100, 739, 491);
		getContentPane().setLayout(null);
		
		JLabel lblIngreso = new JLabel("Ingresos");
		lblIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreso.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
		lblIngreso.setBounds(26, 24, 669, 42);
		getContentPane().add(lblIngreso);
		
		lblMsg = new JLabel("");
		lblMsg.setForeground(Color.BLUE);
		lblMsg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMsg.setBounds(58, 379, 596, 26);
		getContentPane().add(lblMsg);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(60, 122, 242, 32);
		getContentPane().add(txtValor);
		
		txtDetalle = new JTextField();
		txtDetalle.setColumns(10);
		txtDetalle.setBounds(391, 122, 263, 32);
		getContentPane().add(txtDetalle);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValor.setBounds(60, 94, 186, 26);
		getContentPane().add(lblValor);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDetalle.setBounds(391, 94, 186, 26);
		getContentPane().add(lblDetalle);
		
		txtNota = new JTextField();
		txtNota.setColumns(10);
		txtNota.setBounds(58, 208, 596, 32);
		getContentPane().add(txtNota);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNota.setBounds(58, 178, 186, 26);
		getContentPane().add(lblNota);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegresar.setBounds(58, 270, 139, 42);
		getContentPane().add(btnRegresar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpiar.setBounds(291, 270, 139, 42);
		getContentPane().add(btnLimpiar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingresos ingreso = new Ingresos();
				String valor = txtValor.getText();
				if(valor.contains(",")) {
					valor = txtValor.getText().replace(",", ".");
				}
				ingreso.setValor(Double.valueOf(valor));
				ingreso.setDetalle(txtDetalle.getText());
				ingreso.setNota(txtNota.getText());
				ingreso.setId(0);
				
				int result = ingresosService.save(ingreso);
				
				if(result == 0) {
					lblMsg.setText("Error en la opeación, Intente mas tarde");
				}else if(result == 1){
					lblMsg.setText("Registro guardado correctamente");
				}
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAgregar.setBounds(517, 270, 139, 42);
		getContentPane().add(btnAgregar);
	}
	
	private void limpiar() {
		txtDetalle.setText("");
		txtNota.setText("");
		txtValor.setText("");
		lblMsg.setText("");
	}
}
