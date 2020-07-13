package com.contable.app.dialogs;

import java.awt.Font;

import javax.swing.JDialog;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.contable.app.empleados.Empleados;
import com.contable.app.empleados.EmpleadosImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FormEmpleado extends JDialog {
	private static final long serialVersionUID = 226746786919938295L;
	private JTextField txtFindIdentification;
	private JTextField txtFindCorreo;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtIdentification;
	private JTextField txtTelefono;
	private JTextField txtApellido;
	
	private JLabel lblMsg;
	
	private EmpleadosImpl empleadosService = new EmpleadosImpl();

	/**
	 * Create the dialog.
	 */
	public FormEmpleado() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setModal(true);
		setDefaultCloseOperation(0);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setAlwaysOnTop(true);
		setBounds(100, 100, 739, 491);
		getContentPane().setLayout(null);
		
		JLabel lblBuscarmodificarEmpleado = new JLabel("Operaciones del Empleado");
		lblBuscarmodificarEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarmodificarEmpleado.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
		lblBuscarmodificarEmpleado.setBounds(25, 13, 669, 42);
		getContentPane().add(lblBuscarmodificarEmpleado);
		
		txtFindIdentification = new JTextField();
		txtFindIdentification.setBounds(46, 121, 186, 32);
		getContentPane().add(txtFindIdentification);
		txtFindIdentification.setColumns(10);
		
		txtFindCorreo = new JTextField();
		txtFindCorreo.setColumns(10);
		txtFindCorreo.setBounds(264, 121, 186, 32);
		getContentPane().add(txtFindCorreo);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(46, 209, 186, 32);
		getContentPane().add(txtID);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(264, 209, 186, 32);
		getContentPane().add(txtNombre);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(485, 281, 186, 32);
		getContentPane().add(txtCorreo);
		
		txtIdentification = new JTextField();
		txtIdentification.setColumns(10);
		txtIdentification.setBounds(46, 281, 186, 32);
		getContentPane().add(txtIdentification);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(264, 281, 186, 32);
		getContentPane().add(txtTelefono);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(485, 209, 186, 32);
		getContentPane().add(txtApellido);
		
		JButton btnFind = new JButton("Buscar");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String identification = txtFindIdentification.getText();
				String correo = txtFindCorreo.getText();
				lblMsg.setText("");
				Empleados empleado = null;
				if(identification.length() > 0 && correo.length() > 0) {
					empleado = empleadosService.findByIdentificationAndEmail(identification, correo);
				}else if(identification.length() > 0 && correo.length() == 0) {
					empleado = empleadosService.findByIdentification(identification);
				}else if(identification.length() == 0 && correo.length() > 0) {
					empleado = empleadosService.findByEmail(correo);
				}
				
				if(empleado!=null) {
					txtID.setText(empleado.getId().toString());
					txtNombre.setText(empleado.getFirstName());
					txtApellido.setText(empleado.getFirstSurname());
					txtIdentification.setText(empleado.getIdentificationNumber());
					txtTelefono.setText(empleado.getPhoneNumber());
					txtCorreo.setText(empleado.getEmail());
				}else {
					txtID.setText("");
					txtNombre.setText("");
					txtApellido.setText("");
					txtIdentification.setText("");
					txtTelefono.setText("");
					txtCorreo.setText("");
				}
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFind.setBounds(504, 121, 151, 32);
		getContentPane().add(btnFind);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleados empleado = new Empleados();
				empleado.setId(txtID.getText().equals("")?0:Integer.parseInt(txtID.getText()));
				empleado.setFirstName(txtNombre.getText());
				empleado.setFirstSurname(txtApellido.getText());
				empleado.setIdentificationNumber(txtIdentification.getText());
				empleado.setPhoneNumber(txtTelefono.getText());
				empleado.setEmail(txtCorreo.getText());
				
				int result = empleadosService.save(empleado);
					
				if(result == 0) {
					lblMsg.setText("Error en la opeación, Intente mas tarde");
				}else if(result == 1){
					lblMsg.setText("Registro guardado correctamente");
				}else if(result == 2){
					lblMsg.setText("Registro modificado correctamente");
				}
			}
		});
		btnGuardar.setBounds(382, 352, 151, 32);
		getContentPane().add(btnGuardar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnRegresar.setBounds(180, 352, 151, 32);
		getContentPane().add(btnRegresar);
		
		JLabel lblFindIdentidad = new JLabel("N\u00FAmero de identidad");
		lblFindIdentidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFindIdentidad.setBounds(46, 93, 186, 26);
		getContentPane().add(lblFindIdentidad);
		
		JLabel lblFindCorreo = new JLabel("Correo Electr\u00F3nico");
		lblFindCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFindCorreo.setBounds(264, 93, 186, 26);
		getContentPane().add(lblFindCorreo);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(46, 181, 186, 26);
		getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(264, 181, 186, 26);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellido.setBounds(485, 181, 186, 26);
		getContentPane().add(lblApellido);
		
		JLabel lblIdentidad = new JLabel("N\u00FAmero de Identidad");
		lblIdentidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdentidad.setBounds(46, 255, 186, 26);
		getContentPane().add(lblIdentidad);
		
		JLabel lblTelefono = new JLabel("N\u00FAmero de Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(264, 254, 186, 26);
		getContentPane().add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo Electr\u00F3nico");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreo.setBounds(485, 254, 186, 26);
		getContentPane().add(lblCorreo);
		
		lblMsg = new JLabel("");
		lblMsg.setForeground(Color.BLUE);
		lblMsg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMsg.setBounds(75, 405, 596, 26);
		getContentPane().add(lblMsg);
	}
}
