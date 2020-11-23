package org.springframework.samples.petclinic.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.model.Entrenamiento;
import org.springframework.samples.petclinic.model.LineaMaterial;
import org.springframework.stereotype.Service;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class LineaMaterialServiceTests {

	@Autowired
	private LineaMaterialService lineaMaterialService;



	@Test
	public void testFindAllInitialData() {
		List<LineaMaterial>lineamaterial=new ArrayList<LineaMaterial>(lineaMaterialService.findAll());
		assertEquals(lineamaterial.size(), 5);//
	}



	@Test
	public void testFindByIdInitialDataFinding() {
		int id=1;
		Optional<LineaMaterial> lineamaterial=lineaMaterialService.findById(id);
		assertNotNull(lineamaterial);
	}
	
	@Test
	public void testFindByIdInitialDataNotFinding() {
		int id=1000;
		Optional<LineaMaterial> lineamaterial=lineaMaterialService.findById(id);
		assertEquals(lineamaterial, Optional.empty());
	}

	@Test
	public void testFindByCantidadInitialDataFinding() {
		int cantidad=9;
		List<LineaMaterial> lineamaterial = new ArrayList<LineaMaterial>(lineaMaterialService.findByCantidad(cantidad));
		assertEquals(lineamaterial.size(), 1);//
	}
	@Test
	public void testFindByCantidadInitialDataNotFinding() {
		int cantidad=8;
		List<LineaMaterial> lineamaterial = new ArrayList<LineaMaterial>(lineaMaterialService.findByCantidad(cantidad));
		assertEquals(lineamaterial.size(), 0);//
	}

	@Test
	public void testFindByMaterialInitialDataFinding() {
		int material_id=4;
		List<LineaMaterial> lineamaterial=lineaMaterialService.findByMaterial(material_id);
		assertEquals(lineamaterial.size(), 1);///
	}
	@Test
	public void testFindByMaterialInitialDataNotFinding() {
		int material_id=5;
		List<LineaMaterial> lineamaterial=lineaMaterialService.findByMaterial(material_id);
		assertEquals(lineamaterial.size(),0);//
	}
	@Test
	public void testFindByEntrenamientoInitialDataFinding() {
		int entrenamiento_id=6;
		List<LineaMaterial> lineamaterial=lineaMaterialService.findByEntrenamiento(entrenamiento_id);
		assertEquals(lineamaterial.size(), 0);//
	}
	@Test
	public void testFindByEntrenamientoInitialDataNotFinding() {
		int entrenamiento_id=6;
		List<LineaMaterial> lineamaterial=lineaMaterialService.findByEntrenamiento(entrenamiento_id);
		assertEquals(lineamaterial.size(),0);//
	}


	@Test
	public void testSaveLineaMaterial() {
		LineaMaterial lineaMaterial = new LineaMaterial(6);	

		LineaMaterial linea = lineaMaterialService.saveLineaMaterial(lineaMaterial);

		assertNotNull(linea);

	}
}