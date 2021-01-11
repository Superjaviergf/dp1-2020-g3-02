package org.springframework.samples.petclinic.model.auxiliares;

import org.springframework.samples.petclinic.model.Capitan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipoCAP {

	private Integer id;
	
	private String categoria;
	
	private Integer idcap;
	
}