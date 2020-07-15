package com.contable.app.contables;

public class Contables {
	private Integer id;
	private Double valor;
	private String detalle;
	private String nota;
	private String tipo;
	private String created;
	
	public Contables() {
		this.id=0;
	}
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "Contables [id=" + id + ", valor=" + valor + ", detalle=" + detalle + ", nota=" + nota + ", tipo=" + tipo
				+ ", created=" + created + "]";
	}
}
