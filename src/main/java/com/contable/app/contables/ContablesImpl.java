package com.contable.app.contables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.contable.app.conexion.BaseDeDatos;

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
	
}
