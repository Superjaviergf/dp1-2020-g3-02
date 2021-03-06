package org.springframework.samples.petclinic.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.samples.petclinic.model.padres.EstadisticasEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "partidos")
public class Partido extends EstadisticasEntity{
	
	@ManyToMany
	@JoinTable(name = "juegaPartido", joinColumns = @JoinColumn(name = "partido_id"), 
	  inverseJoinColumns = @JoinColumn(name = "jugador_id"))
	private List<Jugador> jugadores;
	
	@ManyToMany
	@JoinTable(name = "jugandoPartido", joinColumns = @JoinColumn(name = "partido_id"), 
	  inverseJoinColumns = @JoinColumn(name = "jugador_id"))
	private List<Jugador> jugadoresJugando;
	
	@ManyToOne
	@JoinTable(name = "jugandoDeLibero", joinColumns = @JoinColumn(name = "partido_id"), 
	  inverseJoinColumns = @JoinColumn(name = "jugador_id"))
	private Jugador jugadorLibero;
	
	@OneToMany( mappedBy = "partido")
	private Set<EstadisticaPersonalPartido> estadisticas_personales_partidos;
	
	@OneToMany(mappedBy = "partido")
	private Set<Sustitucion> sustituciones;
	
	@OneToMany(mappedBy = "partido")
	private List<SistemaJuego> sistemasJuego;
	
	@ManyToOne
	@JoinColumn(name = "equipo_id")
	private Equipo equipo;
	
	@Column(name = "fecha", nullable = false)
	private LocalDate fecha;
	
	@Column(name = "hora", nullable = false, length = 5)
	private String hora;
	
	@Column(name = "num_amarillas", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numAmarillas;
	
	@Column(name = "num_rojas", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numRojas;
	
	@Column(name = "num_puntos_set1", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numPuntosSet1;
	
	@Column(name = "num_puntos_set2", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numPuntosSet2;
	
	@Column(name = "num_puntos_set3", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numPuntosSet3;
	
	@Column(name = "num_puntos_set4", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numPuntosSet4;
	
	@Column(name = "num_puntos_set5", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numPuntosSet5;
	
	@Column(name = "num_puntos_set1_contrario", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numPuntosSet1Contrario;
	
	@Column(name = "num_puntos_set2_contrario", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numPuntosSet2Contrario;
	
	@Column(name = "num_puntos_set3_contrario", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numPuntosSet3Contrario;
	
	@Column(name = "num_puntos_set4_contrario", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numPuntosSet4Contrario;
	
	@Column(name = "num_puntos_set5_contrario", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numPuntosSet5Contrario;
	
	@Column(name = "num_puntos_totales", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numPuntosTotales;
	
	@Column(name = "num_tiempos_muertos_totales", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numTiemposMuertosTotales;
	
	@Column(name = "tiempo_total_partido", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int tiempoTotalPartido;
	
	@Column(name = "num_sustituciones", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int numSustituciones;
	
	@Column(name = "tiempo_colocador_general", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int tiempoColocadorGeneral;
	
	@Column(name = "tiempo_5_1", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int tiempo51;
	
	@Column(name = "tiempo_4_2", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int tiempo42;
	
	@Column(name = "tiempo_6_2", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int tiempo62;
	
	@Column(name = "tiempo_calentamiento", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int tiempoCalentamiento;
	
	@Column(name = "hour", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int hour;
	
	@Column(name = "minute", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int minute;
	
	@Column(name = "second", nullable = false, columnDefinition = "integer default 0")
	@Min(0)
	private int second;
	
	@Column(name = "set_jugados", nullable = false, columnDefinition = "integer default 1")
	@Min(0)
	private int setJugados;
	
	@Column(name = "partido_finalizado", nullable = false, columnDefinition = "integer default 0")
	private boolean partidoFinalizado;
}
