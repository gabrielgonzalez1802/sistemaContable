package com.contable.app.egresos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.contable.app.conexion.BaseDeDatos;

public class EgresosImpl implements IEgresos {

	public Integer save(Egresos egreso) {
		BaseDeDatos conn = null;
		PreparedStatement stmt = null;
		String sql = null;
		int insert = 0;
		try {
			  conn = new BaseDeDatos();
			  if(conn.conectar()){
				  
				  //update
				  if(egreso.getId()>0) {
					  sql = "UPDATE contables SET valor = ? "
						  		+ ", detalle = ? , nota = ?, tipo = ? WHERE id = ?";
					  insert = 2;
				  }else {
					sql = "INSERT INTO contables (valor,detalle,nota,tipo) values (?,?,?,?)";
					  insert = 1;
				  }
				  
				  stmt = conn.getConn().prepareStatement(sql);
				  stmt.setDouble(1, egreso.getValor());
				  stmt.setString(2, egreso.getDetalle());
				  stmt.setString(3, egreso.getNota());
				  stmt.setString(4, "EGRESO");
				  if(insert==2) {
					  stmt.setInt(5, egreso.getId());
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
