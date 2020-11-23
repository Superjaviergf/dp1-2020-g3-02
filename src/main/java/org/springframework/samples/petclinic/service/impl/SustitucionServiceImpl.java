package org.springframework.samples.petclinic.service.impl;

import java.util.List;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.samples.petclinic.model.Sustitucion;
import org.springframework.samples.petclinic.repository.SustitucionRepository;
import org.springframework.samples.petclinic.service.SustitucionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sustitucionesService")
public class SustitucionServiceImpl implements SustitucionService{
	private static final Log LOG = LogFactory.getLog(SustitucionServiceImpl.class);
	
	@Autowired
	@Qualifier("sustitucionRepository")
	private SustitucionRepository sustitucionRepository;
	 

	@Override
	@Transactional(readOnly = true)
	public Optional<Sustitucion> findById(int id) {
		return sustitucionRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sustitucion> findByMinutoSustitucion(int minuto_sustitucion) {
		return sustitucionRepository.findByMinutoSustitucion(minuto_sustitucion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sustitucion> findByPartido(int partido_id) {
		return sustitucionRepository.findByPartido(partido_id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sustitucion> findByJugador(int jugador_id) {
		return sustitucionRepository.findByJugador(jugador_id);
	}

	@Override
	public List<Sustitucion> findAll() {
		return sustitucionRepository.findAll();
	}

	@Override
	public Sustitucion saveSustitucion(Sustitucion substitution) {
		Sustitucion sust=sustitucionRepository.save(substitution);
		LOG.info(sust.toString());
		
		return sust;
	}

	@Override
	public int substitutionCount() {
		return (int) sustitucionRepository.count();
	}
}