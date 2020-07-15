package com.contable.app.dialogs;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.contable.app.egresos.Egresos;
import com.contable.app.egresos.EgresosImpl;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormEgreso extends JDialog {

	private static final long serialVersionUID = 8393806567019810763L;
	private JTextField txtValor;
	private JTextField txtDetalle;
	private JTextField txtNota;
	private JLabel lblMsg;
	private EgresosImpl egresosService = new EgresosImpl();

	/**
	 * Create the dialog.
	 */
	public FormEgreso() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setModal(true);
		setDefaultCloseOperation(0);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setAlwaysOnTop(true);
		setBounds(100, 100, 739, 491);
		getContentPane().setLayout(null);
		
		JLabel lblegreso = new JLabel("Egresos");
		lblegreso.setHorizontalAlignment(SwingConstants.CENTER);
		lblegreso.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
		lblegreso.setBounds(26, 24, 669, 42);
		getContentPane().add(lblegreso);
		
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
				Egresos egreso = new Egresos();
				String valor = txtValor.getText();
				if(valor.contains(",")) {
					valor = txtValor.getText().replace(",", ".");
				}
				egreso.setValor(Double.valueOf(valor));
				egreso.setDetalle(txtDetalle.getText());
				egreso.setNota(txtNota.getText());
				egreso.setId(0);
				
				int result = egresosService.save(egreso);
				
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
