package org.springframework.samples.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.samples.petclinic.model.Autobus;

public interface AutobusService {

	public abstract List<Autobus> findAll();
	public abstract Optional<Autobus> findById(int id);
	public abstract Autobus saveAutobus(Autobus autobus);
}
