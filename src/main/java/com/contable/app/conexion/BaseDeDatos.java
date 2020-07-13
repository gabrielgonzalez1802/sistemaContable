package com.contable.app.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {
	
	private Connection conn;
	private String user;
	private String pwd;
	private String db;
	private String host;
	private int port;
	
	private Boolean conectado;

	
	public BaseDeDatos() {
		this.user="gabo";
		this.pwd="gabo";
		this.db="contable";
		this.host="localhost";
		this.port=3306;
	}

	public boolean conectar() {
		try {
			String sURL = "jdbc:mysql://" + host + ":" + port + "/" + this.db
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			this.conn = DriverManager.getConnection(sURL,this.user,this.pwd);
			conectado = true;
			System.out.println("Conectado a la BD: "+this.db);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al conectar con la DB");
			conectado = false;
		}
		
		return conectado;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public void close() throws SQLException {
		this.conn.close();
	}

}
