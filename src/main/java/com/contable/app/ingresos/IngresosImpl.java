package com.contable.app.ingresos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.contable.app.conexion.BaseDeDatos;

public class IngresosImpl implements IIngresos {

	public Integer save(Ingresos ingreso) {
		BaseDeDatos conn = null;
		PreparedStatement stmt = null;
		String sql = null;
		int insert = 0;
		try {
			  conn = new BaseDeDatos();
			  if(conn.conectar()){
				  
				  //update
				  if(ingreso.getId()>0) {
					  sql = "UPDATE contables SET valor = ? "
						  		+ ", detalle = ? , nota = ?, tipo = ? WHERE id = ?";
					  insert = 2;
				  }else {
					sql = "INSERT INTO contables (valor,detalle,nota,tipo) values (?,?,?,?)";
					  insert = 1;
				  }
				  
				  stmt = conn.getConn().prepareStatement(sql);
				  stmt.setDouble(1, ingreso.getValor());
				  stmt.setString(2, ingreso.getDetalle());
				  stmt.setString(3, ingreso.getNota());
				  stmt.setString(4, "INGRESO");
				  if(insert==2) {
					  stmt.setInt(5, ingreso.getId());
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
