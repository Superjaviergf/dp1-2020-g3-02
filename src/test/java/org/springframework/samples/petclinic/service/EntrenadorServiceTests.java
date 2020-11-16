package org.springframework.samples.petclinic.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.model.Entrenador;
import org.springframework.samples.petclinic.model.User;
import org.springframework.stereotype.Service;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class EntrenadorServiceTests {

	@Autowired
	@Qualifier("entrenadorService")
	private EntrenadorService entrenadorService;
	
	@Test
	public void testFindAllInitialData() {
		List<Entrenador> entrenador=new ArrayList<Entrenador>(entrenadorService.findAll());
		assertEquals(entrenador.size(), 2);
	}
	
	@Test
	public void testFindByIdInitialDataFinding() {
		int id=1;
		Optional<Entrenador> entrenador=entrenadorService.findById(id);
		assertNotNull(entrenador);
	}
	
	@Test
	public void testFindByIdInitialDataNotFinding() {
		int id=500;
		Optional<Entrenador> entrenador=entrenadorService.findById(id);
		assertEquals(entrenador, Optional.empty());
	}
	
	@Test
	public void testCountWithInitialData() {
		int count=entrenadorService.entrenadorCount();
		assertEquals(count, 2);
	}
	
	@Test
	public void testFindByFirstNameInitialDataFinding() {
		String name="Teodoro";
		List<Entrenador> jugadores = new ArrayList<Entrenador>(entrenadorService.findByFirstName(name));
		assertEquals(jugadores.size(), 1);
	}
	
	@Test
	public void testFindByFirstNameInitialDataNotFinding() {
		String name="Vlad";
		List<Entrenador> entrenador = new ArrayList<Entrenador>(entrenadorService.findByFirstName(name));
		assertEquals(entrenador.size(), 0);
	}
	
	@Test
	public void testFindByEmailDataFinding() {
		String email = "teodorocoach@gmail.com";
		List<Entrenador> entrenadores=new ArrayList<Entrenador>(entrenadorService.findByEmail(email));
		assertEquals(entrenadores.size(), 1);
	}
	
	@Test
	public void testFindByEmailDataNotFinding() {
		String email = "paco123@gmail.com";
		List<Entrenador> entrenadores=new ArrayList<Entrenador>(entrenadorService.findByEmail(email));
		assertEquals(entrenadores.size(), 0);
	}
	
	@Test
	public void testFechaNacimientoBetweenOrderByFechaNacimientoInitialDataFinding() {
		LocalDate firstDate = LocalDate.of(1978, 11, 5);
		LocalDate secondDate = LocalDate.of(2000, 11, 7);
		List<Entrenador> entrenadores=new ArrayList<Entrenador>(entrenadorService.findByFechaNacimientoBetweenOrderByFechaNacimiento(firstDate, secondDate));
		assertEquals(entrenadores.size(), 2);
	}
	
	@Test
	public void testFindByFechaNacimientoBetweenOrderByFechaNacimientoInitialDataNotFinding() {
		LocalDate firstDate = LocalDate.of(2020, 11, 1);
		LocalDate secondDate = LocalDate.of(2020, 11, 3);
		List<Entrenador> entrenadores=new ArrayList<Entrenador>(entrenadorService.findByFechaNacimientoBetweenOrderByFechaNacimiento(firstDate, secondDate));
		assertEquals(entrenadores.size(), 0);
	}
	
	@Test
	public void testFindByFechaNacimientoAfterOrderByFechaNacimientoInitialDataFinding() {
		LocalDate date = LocalDate.of(1996, 11, 5);
		List<Entrenador> entrenadores=new ArrayList<Entrenador>(entrenadorService.findByFechaNacimientoAfterOrderByFechaNacimiento(date));
		assertEquals(entrenadores.size(), 1);
	}
	
	@Test
	public void testFindByFechaNacimientoAfterOrderByFechaNacimientoInitialDataNotFinding() {
		LocalDate date = LocalDate.of(2020, 11, 7);
		List<Entrenador> entrenadores=new ArrayList<Entrenador>(entrenadorService.findByFechaNacimientoAfterOrderByFechaNacimiento(date));
		assertEquals(entrenadores.size(), 0);
	}
	
	@Test
	public void testSaveEntrenador() {
		Entrenador entrenador = new Entrenador("elvitor@gmail.com", LocalDate.of(1957, 8, 19));
		entrenador.setFirstName("Vitor");
		entrenador.setLastName("González Pérez");
		entrenador.setUser(new User());
		entrenador.getUser().setUsername("TeodoroCoach");
		entrenador.getUser().setPassword("asdf1234");
		entrenador.getUser().setEnabled(true);
		
		Entrenador coach = entrenadorService.saveEntrenador(entrenador);
		
		assertNotNull(coach);
		
	}
}