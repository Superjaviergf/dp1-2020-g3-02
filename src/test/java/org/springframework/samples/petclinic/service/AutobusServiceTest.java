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
import org.springframework.samples.petclinic.model.Autobus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class AutobusServiceTest {

	@Autowired
	@Qualifier("autobusService")
	private AutobusService autobusService;
	
	@Test
	@Transactional(readOnly = true)
	public void testFindAllInitialData() {
		List<Autobus> autobus=new ArrayList<Autobus>(autobusService.findAll());
		assertEquals(autobus.size(), 3);
	}

	@Test
	@Transactional(readOnly = true)
	public void testFindByIdInitialDataFinding() {
		int id=1;
		Optional<Autobus> autobus=autobusService.findById(id);
		assertNotNull(autobus);
	}

	@Test
	@Transactional(readOnly = true)
	public void testFindByIdInitialDataNotFinding() {
		int id=500;
		Optional<Autobus> autobus=autobusService.findById(id);
		assertEquals(autobus, Optional.empty());
	}

	@Test
	@Transactional(readOnly = true)
    public void testFindByPartidoInitialDataFinding() {
        int partido_id = 1;
        List<Integer> bus=autobusService.findByPartido(partido_id);
        assertEquals(bus.size(), 2);
    }

	@Test
	@Transactional(readOnly = true)
	public void testFindByPartidoInitialDataNotFinding() {
		int partido_id = 3;
		List<Integer> bus=autobusService.findByPartido(partido_id);
		assertEquals(bus.size(), 0);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByJugadorInitialDataFinding() {
		int jugador_id = 1;
		List<Integer> autobus=autobusService.findByJugador(jugador_id);
		assertEquals(autobus.size(), 1);
	}

	@Test
	@Transactional(readOnly = true)
	public void testFindByJugadorInitialDataNotFinding() {
		int jugador_id = 6;
		List<Integer> autobus=autobusService.findByJugador(jugador_id);
		assertEquals(autobus.size(),0);
	}

	@Test
	@Transactional(readOnly = true)
	public void testFindByHoraSalidaInitialDataFinding() {
		String hora_salida="12:30";
		List<Autobus> autobus=autobusService.findByHoraSalida(hora_salida);
		assertEquals(autobus.size(), 1);
	}

	@Test
	@Transactional(readOnly = true)
	public void testFindByHoraSalidaInitialDataNotFinding() {
		String hora_salida="07:00";
		List<Autobus> autobus=autobusService.findByHoraSalida(hora_salida);
		assertEquals(autobus.size(), 0);
	}

	@Test
	@Transactional(readOnly = true)
	public void testFindByHoraLlegadaInitialDataFinding() {
		String hora_llegada="14:00";
		List<Autobus> autobus=autobusService.findByHoraLlegada(hora_llegada);
		assertEquals(autobus.size(), 1);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByHoraLlegadaInitialDataNotFinding() {
		String hora_llegada="00:00";
		List<Autobus> autobus=autobusService.findByHoraLlegada(hora_llegada);
		assertEquals(autobus.size(), 0);
	}
	
	@Test
	@Transactional
	public void testSaveAutobus() {
		Autobus autobus = new Autobus("12:30", "14:00");
		autobus.setId(3);
		
		Autobus bus = autobusService.saveAutobus(autobus);
		
		assertNotNull(bus);
	}
}
