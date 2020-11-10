package org.springframework.samples.petclinic.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;


@Entity
@Table(name="sustituciones")
public class Sustituciones extends BaseEntity{
	
	/*@ManyToMany
	@JoinTable(name = "jugadores", joinColumns = @JoinColumn(name = "sustitucion_id"), 
			  inverseJoinColumns = @JoinColumn(name = "jugador_id"))
			Set<Jugador> jugadores;*/
	
	@ManyToOne
	@JoinColumn(name = "partido_id")
	private Partido partido;
	
	@Column(name = "minuto_sustitucion", nullable = false)
	@Min(0)
	private Integer minutoSustitucion;
	
	public Sustituciones() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sustituciones(Integer minutoSustitucion) {
		super();
		this.minutoSustitucion = minutoSustitucion;
	}

	public Partido getPartidos() {
		return partido;
	}

	public void setPartidos(Partido partidos) {
		this.partido = partidos;
	}

	public Integer getMinutoSustitucion() {
		return minutoSustitucion;
	}

	public void setMinutoSustitucion(Integer minutoSustitucion) {
		this.minutoSustitucion = minutoSustitucion;
	}

	@Override
	public String toString() {
		return "Sustituciones [partido=" + partido + ", minutoSustitucion=" + minutoSustitucion + "]";
	}
	
	

}