package org.springframework.samples.petclinic.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Personales;
import org.springframework.stereotype.Repository;

@Repository("personalesRepository")
public interface PersonalesRepository extends JpaRepository<Personales,Serializable>{
	
	public List<Personales> findByPropietario(String propietario);
	
	@Query("SELECT a FROM Personales a, Partido p WHERE p.id=:partido_id")
	public Optional<Personales> findByPartido(@Param("partido_id") int partido_id); 
	
	@Query("SELECT a FROM Personales a, Jugador j WHERE j.id=:jugador_id")
	public Optional<Personales> findByJugador(@Param("jugador_id") int jugador_id);

}
