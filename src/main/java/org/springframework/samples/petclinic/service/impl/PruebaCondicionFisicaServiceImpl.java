package org.springframework.samples.petclinic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.samples.petclinic.enumerate.TipoPrueba;
import org.springframework.samples.petclinic.model.Equipo;
import org.springframework.samples.petclinic.model.Jugador;
import org.springframework.samples.petclinic.model.PruebaCondicionFisica;
import org.springframework.samples.petclinic.repository.EquipoRepository;
import org.springframework.samples.petclinic.repository.PruebaCondicionFisicaRepository;
import org.springframework.samples.petclinic.service.EquipoService;
import org.springframework.samples.petclinic.service.JugadorService;
import org.springframework.samples.petclinic.service.PruebaCondicionFisicaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("pruebaCondicionFisicaService")
public class PruebaCondicionFisicaServiceImpl implements PruebaCondicionFisicaService {

	@Autowired
	@Qualifier("pruebaCondicionFisicaRepository")
	private PruebaCondicionFisicaRepository pruebaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Optional<PruebaCondicionFisica> findById(int id) {
		return pruebaRepository.findById(id);
	}
	
	@Autowired
	private JugadorService jugadorService;

	@Override
	@Transactional(readOnly = true)
	public List<PruebaCondicionFisica> findByJugador(int jugador_id) {
		Optional<Jugador> jugador = jugadorService.findById(jugador_id);
		if(!jugador.equals(Optional.empty())) {
			return pruebaRepository.findByJugador(jugador.get());
		} else {
			return new ArrayList<PruebaCondicionFisica>();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<PruebaCondicionFisica> findByTipoPrueba(TipoPrueba tipo_prueba) {
		
		return pruebaRepository.findByTipoPrueba(tipo_prueba);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PruebaCondicionFisica> findByDatoLessThanEqual(double dato) {
		
		return pruebaRepository.findByDatoLessThanEqual(dato);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PruebaCondicionFisica> findByDatoAndTipoPrueba(double dato, TipoPrueba tipo_prueba) {
		
		return pruebaRepository.findByDatoAndTipoPrueba(dato, tipo_prueba);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PruebaCondicionFisica> findByTipoPruebaAndDatoLessThanEqual(TipoPrueba tipo_prueba, double dato) {
		
		return pruebaRepository.findByTipoPruebaAndDatoLessThanEqual(tipo_prueba, dato);
	}

	@Override
	public PruebaCondicionFisica savePruebaCondicionFisica(PruebaCondicionFisica prueba) {
		return pruebaRepository.save(prueba);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PruebaCondicionFisica> findByJugadorAndTipoPrueba(Jugador jugador, TipoPrueba tipo_prueba) {
		
		return pruebaRepository.findByJugadorAndTipoPrueba(jugador, tipo_prueba);
	}

	@Override
	public void deletePruebaCondicionFisica(int id) {
		pruebaRepository.deleteById(id);
		
	}

	
	
}
