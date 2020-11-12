package org.springframework.samples.petclinic.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.component.JugadorValidator;
import org.springframework.samples.petclinic.constant.ViewConstant;
import org.springframework.samples.petclinic.controller.form.JugadorForm;
import org.springframework.samples.petclinic.model.Jugador;
import org.springframework.samples.petclinic.model.Partido;
import org.springframework.samples.petclinic.service.JugadorService;
import org.springframework.samples.petclinic.service.PartidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/partidos")
public class PartidoController {
		
	private static final Log LOG = LogFactory.getLog(PartidoController.class);
	
	@Autowired
	private PartidoService partidoService;
	
	@GetMapping("/showPartidos")
	public ModelAndView listadoJugadores() {
		
		ModelAndView mav = new ModelAndView(ViewConstant.VIEW_PARTIDOS);
		mav.addObject("partidos", partidoService.findAll());
		return mav;
	}
	
	@GetMapping("/showPartido")
	public Partido partido(int id) {
		Optional<Partido> partido = partidoService.findById(id);
		return partido.get();
	}
	
	
	@GetMapping("/partidoform")
	public String redirectPartidoForm(@RequestParam(name="id",required=false) Integer id, Model model) {
		Optional<Partido> partido = Optional.of(new Partido());
		if(id != 0) {
			partido = partidoService.findById(id);
		}
		model.addAttribute("partido", partido);
		return ViewConstant.VIEWS_PARTIDO_CREATE_OR_UPDATE_FORM;
	}
	
	
	@PostMapping("/addpartido")
	public String addJugador(@ModelAttribute(name="formPartido") Partido partido, Model model, final BindingResult result) {
		
		//LOG.info("addpartido() -- PARAMETROS: "+ form.getJugador().toString());
		
//		ValidationUtils.invokeValidator(jugadorFormValidator, form, result);
//		
//		if (result.hasErrors()) {
//			model.addAttribute("formJugador", form);
//			return ViewConstant.VIEWS_JUGADOR_CREATE_OR_UPDATE_FORM;
//		}else {
//		
		
		if(null != partidoService.savePartido(partido)) {
			model.addAttribute("result", 1);
			
		}else {
			model.addAttribute("result", 0); 
		}
		return "redirect:/partidos/showPartidos";
	//}
	
}
	
}