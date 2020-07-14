package com.contable.app.contables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.LinkedList;
import java.util.List;

import com.contable.app.conexion.BaseDeDatos;
import com.contable.app.empleados.Empleados;

public class ContablesImpl implements IContables {

	public List<Contables> findAll() {
		BaseDeDatos conn = null;
		PreparedStatement stmt = null;
		List<Contables> contables = new LinkedList<Contables>();
		try {
			  conn = new BaseDeDatos();
			  if(conn.conectar()){
				  stmt = conn.getConn().prepareStatement("SELECT * FROM contables");
				  ResultSet rs = stmt.executeQuery();

				  while (rs.next()) {
					  Contables contable = new Contables();
					  contable.setId(rs.getInt("id"));
					  contable.setDetalle(rs.getString("detalle"));
					  contable.setNota(rs.getString("nota"));
					  contable.setTipo(rs.getString("tipo"));
					  contable.setValor(rs.getDouble("valor"));
					  contable.setCreated(rs.getString("created"));
					  contables.add(contable);
				  }
				  conn.close();
				  rs.close();
				  stmt.close();
				  return contables;
			  }
			} catch (SQLException sqle) { 
			  System.out.println("Error en la ejecución:" 
			    + sqle.getErrorCode() + " " + sqle.getMessage());    
			}
		return null;
	
	}
	
	public int generarAdelanto(Empleados empleado, Double monto, String descripcion) {
		Contables contable = new Contables();
		contable.setTipo("EGRESO");
		contable.setDetalle("Anticipos de Remuneraciones");
		contable.setNota("Adelanto de pago al empleado "+empleado.getFirstName()+" "+empleado.getFirstSurname()+" por concepto de "+descripcion);
		contable.setValor(monto);
		return save(contable);
	}

	public int save(Contables contable) {
		BaseDeDatos conn = null;
		PreparedStatement stmt = null;
		String sql = null;
		int insert = 0;
		try {
			  conn = new BaseDeDatos();
			  if(conn.conectar()){
				  
				  //update
				  if(contable.getId()>0) {
					  sql = "UPDATE contables SET valor = ? "
						  		+ ", detalle = ? , nota = ?, tipo = ? WHERE id = ?";
					  insert = 2;
				  }else {
					sql = "INSERT INTO contables (valor,detalle,nota,tipo) values (?,?,?,?)";
					  insert = 1;
				  }
				  
				  stmt = conn.getConn().prepareStatement(sql);
				  stmt.setDouble(1, contable.getValor());
				  stmt.setString(2, contable.getDetalle());
				  stmt.setString(3, contable.getNota());
				  stmt.setString(4, "EGRESO");
				  if(insert==2) {
					  stmt.setInt(5, contable.getId());
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
