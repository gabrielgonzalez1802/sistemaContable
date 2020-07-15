package com.contable.app.empleados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.contable.app.conexion.BaseDeDatos;

public class EmpleadosImpl implements IEmpleados {

	public List<Empleados> findAll() {
		BaseDeDatos conn = null;
		PreparedStatement stmt = null;
		List<Empleados> empleados = new LinkedList<Empleados>();
		try {
			  conn = new BaseDeDatos();
			  if(conn.conectar()){
				  stmt = conn.getConn().prepareStatement("SELECT * FROM empleados");
				  ResultSet rs = stmt.executeQuery();

				  while (rs.next()) {
					  Empleados empleado = new Empleados();
					  empleado.setId(rs.getInt("id"));
					  empleado.setFirstName(rs.getString("firstName"));
					  empleado.setFirstSurname(rs.getString("firstSurname"));
					  empleado.setIdentificationNumber(rs.getString("identificationNumber"));
					  empleado.setPhoneNumber(rs.getString("phoneNumber"));
					  empleado.setEmail(rs.getString("email"));
					  empleados.add(empleado);
				  }
				  conn.close();
				  rs.close();
				  stmt.close();
				  return empleados;
			  }
			} catch (SQLException sqle) { 
			  System.out.println("Error en la ejecución:" 
			    + sqle.getErrorCode() + " " + sqle.getMessage());    
			}
		return null;
	}

	public Empleados findByIdentification(String identification) {
		BaseDeDatos conn = null;
		PreparedStatement stmt = null;
		try {
			  conn = new BaseDeDatos();
			  if(conn.conectar()){
				  stmt = conn.getConn().prepareStatement("SELECT * FROM empleados WHERE identificationNumber = ?");
				  stmt.setString(1, identification);
				  ResultSet rs = stmt.executeQuery();

				  if (rs.next()) {
					  Empleados empleado = new Empleados();
					  empleado.setId(rs.getInt("id"));
					  empleado.setFirstName(rs.getString("firstName"));
					  empleado.setFirstSurname(rs.getString("firstSurname"));
					  empleado.setIdentificationNumber(rs.getString("identificationNumber"));
					  empleado.setPhoneNumber(rs.getString("phoneNumber"));
					  empleado.setEmail(rs.getString("email"));
					  conn.close();
					  stmt.close();
					  rs.close();
					  return empleado;
				  }
			  }
			} catch (SQLException sqle) { 
			  System.out.println("Error en la ejecución:" 
			    + sqle.getErrorCode() + " " + sqle.getMessage());    
			}
		return null;
	}

	public Empleados findByEmail(String email) {
		BaseDeDatos conn = null;
		PreparedStatement stmt = null;
		try {
			  conn = new BaseDeDatos();
			  if(conn.conectar()){
				  stmt = conn.getConn().prepareStatement("SELECT * FROM empleados WHERE email = ?");
				  stmt.setString(1, email);
				  ResultSet rs = stmt.executeQuery();

				  if (rs.next()) {
					  Empleados empleado = new Empleados();
					  empleado.setId(rs.getInt("id"));
					  empleado.setFirstName(rs.getString("firstName"));
					  empleado.setFirstSurname(rs.getString("firstSurname"));
					  empleado.setIdentificationNumber(rs.getString("identificationNumber"));
					  empleado.setPhoneNumber(rs.getString("phoneNumber"));
					  empleado.setEmail(rs.getString("email"));
					  conn.close();
					  stmt.close();
					  rs.close();
					  return empleado;
				  }
			  }
			} catch (SQLException sqle) { 
			  System.out.println("Error en la ejecución:" 
			    + sqle.getErrorCode() + " " + sqle.getMessage());    
			}
		return null;
	}

	public Empleados findByIdentificationAndEmail(String identification, String email) {
		BaseDeDatos conn = null;
		PreparedStatement stmt = null;
		try {
			  conn = new BaseDeDatos();
			  if(conn.conectar()){
				  stmt = conn.getConn().prepareStatement("SELECT * FROM empleados WHERE identificationNumber = ? AND email = ?");
				  stmt.setString(1, identification);
				  stmt.setString(2, email);
				  ResultSet rs = stmt.executeQuery();

				  if (rs.next()) {
					  Empleados empleado = new Empleados();
					  empleado.setId(rs.getInt("id"));
					  empleado.setFirstName(rs.getString("firstName"));
					  empleado.setFirstSurname(rs.getString("firstSurname"));
					  empleado.setIdentificationNumber(rs.getString("identificationNumber"));
					  empleado.setPhoneNumber(rs.getString("phoneNumber"));
					  empleado.setEmail(rs.getString("email"));
					  conn.close();
					  stmt.close();
					  rs.close();
					  return empleado;
				  }
			  }
			} catch (SQLException sqle) { 
			  System.out.println("Error en la ejecución:" 
			    + sqle.getErrorCode() + " " + sqle.getMessage());    
			}
		return null;
	}

	public Integer save(Empleados empleado) {
		BaseDeDatos conn = null;
		PreparedStatement stmt = null;
		String sql = null;
		int insert = 0;
		try {
			  conn = new BaseDeDatos();
			  if(conn.conectar()){
				  
				  //update
				  if(empleado.getId()>0) {
					  sql = "UPDATE empleados SET firstName = ? "
						  		+ ", firstSurname = ? , identificationNumber = ? , "
						  		+ "phoneNumber = ? ,"
						  		+ " email = ? WHERE id = ?";
					  insert = 2;
				  }else {
					sql = "INSERT INTO empleados (firstName,firstSurname,identificationNumber,phoneNumber,email) values (?,?,?,?,?)";
					  insert = 1;
				  }
				  
				  stmt = conn.getConn().prepareStatement(sql);
				  stmt.setString(1, empleado.getFirstName());
				  stmt.setString(2, empleado.getFirstSurname());
				  stmt.setString(3, empleado.getIdentificationNumber());
				  stmt.setString(4, empleado.getPhoneNumber());
				  stmt.setString(5, empleado.getEmail());
				  if(insert==2) {
					  stmt.setInt(6, empleado.getId());
				  }
				  
				  int result = stmt.executeUpdate();
				  stmt.close();
				  conn.close();
				  if (result > 0) {
					 return insert;
				  }else {
					  return 0;
				  }
			  }
			} catch (SQLException sqle) { 
			  System.out.println("Error en la ejecución:" 
			    + sqle.getErrorCode() + " " + sqle.getMessage());    
			}
		return insert;
	}

}
