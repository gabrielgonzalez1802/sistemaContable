package com.contable.app.conexion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDeDatos {
	
	private Connection conn;
	private String user;
	private String pwd;
	private String db;
	private String host;
	private int port;
	
	private Boolean conectado;
	private Properties propiedades = new Properties();

	public BaseDeDatos() {
		try {
			InputStream is = getClass().getResourceAsStream("/application.properties");
			propiedades.load(is);
			this.user=propiedades.getProperty("conexion.username");
			this.pwd=propiedades.getProperty("conexion.pwd");
			this.db=propiedades.getProperty("conexion.db");
			this.host=propiedades.getProperty("conexion.host");
			this.port=Integer.parseInt(propiedades.getProperty("conexion.port"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			conectado = false;
		} catch (IOException e) {
			e.printStackTrace();
			conectado = false;
		}
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
