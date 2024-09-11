package com.ipartek.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordenadores")
public class Ordenador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "precio")
	private double precio;

	@Column(name = "RAM")
	private String ram;

	@Column(name = "HDD")
	private String hdd;

	@ManyToOne
	private Marca marca;

	public Ordenador(int id, String nombre, double precio, String ram, String hdd, Marca marca) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.ram = ram;
		this.hdd = hdd;
		this.marca = marca;
	}

	public Ordenador() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0;
		this.ram = "";
		this.hdd = "";
		this.marca = new Marca();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHdd() {
		return hdd;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
