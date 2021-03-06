package org.springframework.samples.petclinic.service;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.model.EstadisticaPersonalPartido;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class EstadisticaPersonalPartidoServiceTests {
	
	@Autowired
	@Qualifier("estadisticaPersonalPartidoService")
	private EstadisticaPersonalPartidoService ePartidoService;
	
	@Test
	@Transactional(readOnly = true)
	public void testFindAllInitialDataFinding() {
		List<EstadisticaPersonalPartido> ePartido = ePartidoService.findAll();
		assertNotNull(ePartido);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByIdInitialDataFinding() {
		int id = 1;
		Optional<EstadisticaPersonalPartido> ePartido = ePartidoService.findById(id);
		assertNotNull(ePartido);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByIdInitialDataNotFinding() {
		int id = 50;
		Optional<EstadisticaPersonalPartido> ePartido = ePartidoService.findById(id);
		assertEquals(ePartido, Optional.empty());
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeSaquesLessThanEqualInitialDataFinding() {
		double percent = 0.8;
		List<EstadisticaPersonalPartido> ePartido = ePartidoService.findByPorcentajeSaquesLessThanEqual(percent);
		assertNotNull(ePartido);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeSaquesLessThanEqualInitialDataNotFinding() {
		double percent = 0.2;
		List<EstadisticaPersonalPartido> ePartido = ePartidoService.findByPorcentajeSaquesLessThanEqual(percent);
		assertEquals(ePartido.size(), 0);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeRecepcionesLessThanEqualInitialDataFinding() {
		double percentIntroducido=50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=ePartidoService.findByPorcentajeRecepcionesLessThanEqual(percent);
		assertEquals(ePartido.size(), 12);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeRecepcionesLessThanEqualInitialDataNotFinding() {
		double percentIntroducido=-50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeRecepcionesLessThanEqual(percent));
		assertEquals(ePartido.size(), 0);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeColocacionesLessThanEqualInitialDataFinding() {
		double percentIntroducido=50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeColocacionesLessThanEqual(percent));
		assertEquals(ePartido.size(), 13);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeColocacionesLessThanEqualInitialDataNotFinding() {
		double percentIntroducido=-50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeColocacionesLessThanEqual(percent));
		assertEquals(ePartido.size(), 0);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeDefensasLessThanEqualInitialDataFinding() {
		double percentIntroducido=50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeDefensasLessThanEqual(percent));
		assertEquals(ePartido.size(), 12);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeDefensasLessThanEqualInitialDataNotFinding() {
		double percentIntroducido=-50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeDefensasLessThanEqual(percent));
		assertEquals(ePartido.size(), 0);
	}
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeBloqueosLessThanEqualInitialDataFinding() {
		double percentIntroducido=50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeBloqueosLessThanEqual(percent));
		assertEquals(ePartido.size(), 15);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeBloqueosLessThanEqualInitialDataNotFinding() {
		double percentIntroducido=-50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeBloqueosLessThanEqual(percent));
		assertEquals(ePartido.size(), 0);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeRematesLessThanEqualInitialDataFinding() {
		double percentIntroducido=50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeRematesLessThanEqual(percent));
		assertEquals(ePartido.size(), 13);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeRematesLessThanEqualInitialDataNotFinding() {
		double percentIntroducido=-50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeRematesLessThanEqual(percent));
		assertEquals(ePartido.size(), 0);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeFintasLessThanEqualInitialDataFinding() {
		double percentIntroducido=50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeFintasLessThanEqual(percent));
		assertEquals(ePartido.size(), 15);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeFintasLessThanEqualInitialDataNotFinding() {
		double percentIntroducido=-50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeFintasLessThanEqual(percent));
		assertEquals(ePartido.size(), 0);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeAtaquesRapidosLessThanEqualInitialDataFinding() {
		double percentIntroducido=50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeAtaquesRapidosLessThanEqual(percent));
		assertEquals(ePartido.size(), 13);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByPorcentajeAtaquesRapidosLessThanEqualInitialDataNotFinding() {
		double percentIntroducido=-50;
		double percent=percentIntroducido/100;
		List<EstadisticaPersonalPartido> ePartido=new ArrayList<EstadisticaPersonalPartido>(ePartidoService.findByPorcentajeAtaquesRapidosLessThanEqual(percent));
		assertEquals(ePartido.size(), 0);
	}
	
	

}
