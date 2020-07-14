package com.contable.app.dialogs;

import java.awt.Font;

import javax.swing.JDialog;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.contable.app.contables.ContablesImpl;
import com.contable.app.empleados.Empleados;
import com.contable.app.empleados.EmpleadosImpl;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SolicitudAdelanto extends JDialog {

	private static final long serialVersionUID = -3817800501742530891L;
	private JTextField txtFind;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtIdentification;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtID;
	private JTextField txtAdelanto;
	private JLabel lblMsg;
	private JButton btnGenerarAdelanto;
	
	private EmpleadosImpl empleadosService = new EmpleadosImpl();
	private ContablesImpl contablesServie = new ContablesImpl();
	private JTextField txtDescription;
	private Empleados empleado;

	/**
	 * Create the dialog.
	 */
	public SolicitudAdelanto() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setLayout(null);
		
		JLabel lblSolicitudDeAdelanto = new JLabel("Generar Adelanto");
		lblSolicitudDeAdelanto.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
		lblSolicitudDeAdelanto.setBounds(157, 26, 413, 52);
		getContentPane().add(lblSolicitudDeAdelanto);
		
		txtFind = new JTextField();
		txtFind.setBounds(225, 91, 288, 34);
		getContentPane().add(txtFind);
		txtFind.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero de Identidad");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(49, 91, 213, 25);
		getContentPane().add(lblNewLabel);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String identification = txtFind.getText();
				lblMsg.setText("");
				empleado = null;
				if(identification.length() > 0) {
					empleado = empleadosService.findByIdentification(identification);
				}
				
				if(empleado!=null) {
					txtID.setText(empleado.getId().toString());
					txtNombre.setText(empleado.getFirstName());
					txtApellido.setText(empleado.getFirstSurname());
					txtIdentification.setText(empleado.getIdentificationNumber());
					txtTelefono.setText(empleado.getPhoneNumber());
					txtCorreo.setText(empleado.getEmail());
					txtAdelanto.setEditable(true);
					txtDescription.setEditable(true);
					btnGenerarAdelanto.setVisible(true);
					lblMsg.setText("");
				}else {
					limpiar();
					lblMsg.setText("No se encontraron coincidencias");
				}
			
			}
		});
		btnBuscar.setBounds(542, 91, 131, 34);
		getContentPane().add(btnBuscar);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(488, 258, 186, 32);
		getContentPane().add(txtCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(267, 258, 186, 32);
		getContentPane().add(txtTelefono);
		
		txtIdentification = new JTextField();
		txtIdentification.setEditable(false);
		txtIdentification.setColumns(10);
		txtIdentification.setBounds(49, 258, 186, 32);
		getContentPane().add(txtIdentification);
		
		JLabel lblIdentidad = new JLabel("N\u00FAmero de Identidad");
		lblIdentidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdentidad.setBounds(49, 232, 186, 26);
		getContentPane().add(lblIdentidad);
		
		JLabel lblTelefono = new JLabel("N\u00FAmero de Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(267, 231, 186, 26);
		getContentPane().add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo Electr\u00F3nico");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreo.setBounds(488, 231, 186, 26);
		getContentPane().add(lblCorreo);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(488, 186, 186, 32);
		getContentPane().add(txtApellido);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellido.setBounds(488, 158, 186, 26);
		getContentPane().add(lblApellido);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(267, 186, 186, 32);
		getContentPane().add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(267, 158, 186, 26);
		getContentPane().add(lblNombre);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(49, 186, 186, 32);
		getContentPane().add(txtID);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(49, 158, 186, 26);
		getContentPane().add(lblId);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 303, 697, 12);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 138, 697, 7);
		getContentPane().add(separator_1);
		
		txtAdelanto = new JTextField();
		txtAdelanto.setEditable(false);
		txtAdelanto.setBounds(196, 318, 121, 32);
		getContentPane().add(txtAdelanto);
		txtAdelanto.setColumns(10);
		
		JLabel lblMontoDelAdelanto = new JLabel("Monto del Adelanto");
		lblMontoDelAdelanto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMontoDelAdelanto.setBounds(49, 320, 186, 26);
		getContentPane().add(lblMontoDelAdelanto);
		
		btnGenerarAdelanto = new JButton("Generar Adelanto");
		btnGenerarAdelanto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblMsg.setText("");
					String adelanto = txtAdelanto.getText().replace(",", ".");
					String description = txtDescription.getText();
					double tempAdelanto = Double.valueOf(adelanto);
					int response = contablesServie.generarAdelanto(empleado, tempAdelanto, description);
					if(response==0) {
						lblMsg.setText("Ha ocurrido un error en la operación, Intente mas tarde");
					}else if(response==1) {
						lblMsg.setText("Operación exitosa al generar el adelanto!!");
					}
				} catch (Exception e2) {
					lblMsg.setText("Debe ingresar un número válido");
				}
				
			}
		});
		btnGenerarAdelanto.setBounds(488, 363, 185, 32);
		btnGenerarAdelanto.setVisible(false);
		getContentPane().add(btnGenerarAdelanto);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnRegresar.setBounds(79, 363, 151, 32);
		getContentPane().add(btnRegresar);
		
		lblMsg = new JLabel("");
		lblMsg.setForeground(Color.BLUE);
		lblMsg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMsg.setBounds(64, 408, 596, 26);
		getContentPane().add(lblMsg);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcin.setBounds(350, 320, 103, 26);
		getContentPane().add(lblDescripcin);
		
		txtDescription = new JTextField();
		txtDescription.setEditable(false);
		txtDescription.setColumns(10);
		txtDescription.setBounds(444, 318, 229, 32);
		getContentPane().add(txtDescription);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(286, 363, 151, 32);
		getContentPane().add(btnLimpiar);
		setModal(true);
		setDefaultCloseOperation(0);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setAlwaysOnTop(true);
		setBounds(100, 100, 739, 491);
	}
	
	private void limpiar() {
		txtID.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtIdentification.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtAdelanto.setText("");
		txtDescription.setText("");
		txtFind.setText("");
		txtAdelanto.setEditable(false);
		txtDescription.setEditable(false);
		btnGenerarAdelanto.setVisible(false);
		empleado=null;
	}
}
