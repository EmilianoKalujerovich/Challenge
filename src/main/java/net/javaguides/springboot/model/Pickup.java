package net.javaguides.springboot.model;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pickup")
public class Pickup {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "orden")
	private long orden;
	
	@Column(name = "pedido")
	private int pedido;
	
	@Column(name = "first_name")
	private String firstName;
	
	
	@Column(name = "productos_frios")
	private int productos_frios;
	
	@Column(name = "productos_congelados")
	private int productos_congelados;
	
	@Column(name = "productos_normales")
	private int productos_normales;
	
	@Column(name = "productos_cantidad")
	private int productos_cantidad;
	
	@Column(name = "hour")
	private LocalTime hour;
	
	
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public int getPedido() {
		return pedido;
	}
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public long getOrden() {
		return orden;
	}
	public void setOrden(long orden) {
		this.orden = orden;
	}
	public int getProductos_frios() {
		return productos_frios;
	}
	public void setProductos_frios(int productos_frios) {
		this.productos_frios = productos_frios;
	}
	public int getProductos_congelados() {
		return productos_congelados;
	}
	public void setProductos_congelados(int productos_congelados) {
		this.productos_congelados = productos_congelados;
	}
	public int getProductos_normales() {
		return productos_normales;
	}
	public void setProductos_normales(int productos_normales) {
		this.productos_normales = productos_normales;
	}
	public int getProductos_cantidad() {
		return productos_cantidad;
	}
	public void setProductos_cantidad(int productos_cantidad) {
		this.productos_cantidad = productos_cantidad;
	}
	public LocalTime getHour() {
		return hour;
	}
	public void setHour(LocalTime localTime) {
		this.hour = localTime;
	}
	
	
	
	
	
	
	
	

	

	
	
	
}
