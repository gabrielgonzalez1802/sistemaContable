package com.contable.app.ingresos;

public class Ingresos {
	private Integer id;
	private Double valor;
	private String detalle;
	private String nota;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return "Ingresos [id=" + id + ", valor=" + valor + ", detalle=" + detalle + ", nota=" + nota + "]";
	}
	
}
