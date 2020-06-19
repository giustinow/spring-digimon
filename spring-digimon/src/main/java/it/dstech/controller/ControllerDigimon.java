package it.dstech.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.dstech.model.Allenatore;
import it.dstech.model.Digimon;
import it.dstech.service.ServiceAllenatore;
import it.dstech.service.ServiceDigimon;

@Controller
public class ControllerDigimon {
	@Autowired
	private ServiceAllenatore serviceAllenatore;
	@Autowired
	private ServiceDigimon serviceDigimon;

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/azione", method = RequestMethod.POST)
	public ModelAndView azione(@RequestParam("azione") String azione, Map<String, Object> model) {
		if ("Allenatore".equals(azione)) {
			ModelAndView view = new ModelAndView("profilo");
			Allenatore allenatore = new Allenatore();
			model.put("allenatore", allenatore);
			view.addObject("lista", serviceAllenatore.listAll());
			return view;
		}
		return stampaDigimon();
	}
	@RequestMapping(value = "/digimonAllenatore")
	public ModelAndView digimonAllenatore(@RequestParam("id") Long id) {
			ModelAndView view = new ModelAndView("digimonAllenatore");
			view.addObject("lista", serviceAllenatore.listaDigimonAllenatore(id));
			view.addObject("id", id);
			return view;
	}
	@RequestMapping(value = "/nuovoAllenatore", method = RequestMethod.POST)
	public ModelAndView nuovoAllenatore(@ModelAttribute("allenatore") Allenatore allenatore) {
			serviceAllenatore.save(allenatore);
			ModelAndView view = new ModelAndView("profilo");
			view.addObject("lista", serviceAllenatore.listAll());
			view.addObject("id", allenatore.getId());
			return view;
	}

	@RequestMapping(value = "/digimonDaAggiungere")
	public ModelAndView digimonDaAggiungereAllenatore(@RequestParam("id") Long id) {
		ModelAndView view = new ModelAndView("digimonDaAggiungere");
		view.addObject("lista", serviceDigimon.listAll());
		view.addObject("id", id);
		view.addObject("listaDigimonAllenatore", serviceAllenatore.listaDigimonAllenatore(id));
		return view;
	}
	@RequestMapping(value = "/rimuoviAllenatore")
	public ModelAndView rimuoviAllenatore(@RequestParam("id") Long id, Map<String, Object> model) {
		serviceAllenatore.delete(id);
		ModelAndView view = new ModelAndView("profilo");
		Allenatore allenatore = new Allenatore();
		model.put("allenatore", allenatore);
		view.addObject("lista", serviceAllenatore.listAll());
		return view;
	}
	@RequestMapping(value = "/rimuovi")
	public ModelAndView digimonDaRimuovereAllenatore(@RequestParam("digimon") Long digimon,
			@RequestParam("id") Long id) {
		serviceAllenatore.removeDigimon(serviceDigimon.findDigimon(digimon), id);
		ModelAndView view = new ModelAndView("digimonAllenatore");
		view.addObject("lista", serviceAllenatore.listaDigimonAllenatore(id));
		view.addObject("id", id);
		return view;
	}

	@RequestMapping(value = "/aggiuntaDigimon", method = RequestMethod.POST)
	public ModelAndView aggiuntaDigimonAllenatore(@RequestParam("digimon") Long digimon,
			@RequestParam("id") Long id) {
		if (!serviceDigimon.checkAllenatore(serviceDigimon.findDigimon(digimon))) {
			ModelAndView view = new ModelAndView("digimonDaAggiungere");
			System.out.println("//////////////////////////////" + serviceDigimon.get(digimon));
			System.out.println("//////////////////////////////" + id);
			serviceAllenatore.saveDigimon(serviceDigimon.get(digimon), id);
			serviceDigimon.saveAllenatore(serviceDigimon.get(digimon), serviceAllenatore.findAllenatore(id));
			view.addObject("lista", serviceDigimon.listAll());
			view.addObject("listaDigimonAllenatore", serviceAllenatore.listaDigimonAllenatore(id));
			view.addObject("id", id);
			return view;
		}
		ModelAndView view = new ModelAndView("digimonDaAggiungere");
		view.addObject("lista", serviceDigimon.listAll());
		view.addObject("listaDigimonAllenatore", serviceAllenatore.listaDigimonAllenatore(id));
		view.addObject("id", id);
		return view;
	}
//Digimon	

	@RequestMapping(value = "/sceltaAggiuntaDigimon", method = RequestMethod.POST)
	public ModelAndView sceltaAggiuntaDigimon(Map<String, Object> model) {
		Digimon digimon = new Digimon();
		model.put("digimon", digimon);
		return new ModelAndView("nuovoDigimon");
	}

	@RequestMapping(value = "/nuovoDigimon", method = RequestMethod.POST)
	public ModelAndView aggiunta(@ModelAttribute("digimon") Digimon digimon) {
		serviceDigimon.save(digimon);
		return stampaDigimon();
	}

	@RequestMapping(value = "/stampa", method = RequestMethod.POST)
	public ModelAndView stampaDigimon() {
		return new ModelAndView("digimon", "lista", serviceDigimon.listAll());
	}

	@RequestMapping(value = "/elimina")
	public ModelAndView eliminaDigimon(@RequestParam("digimon") Long id) {
		serviceDigimon.delete(id);
		return stampaDigimon();
	}

	@RequestMapping(value = "/modifica")
	public ModelAndView modificaDigimon(@RequestParam("digimon") Long id) {
		ModelAndView view = new ModelAndView("modificaDigimon");
		view.addObject("digimon", serviceDigimon.get(id));
		return view;
	}
	
	@RequestMapping(value = "/aggiorna", method = RequestMethod.POST)
	public ModelAndView aggiornaModifica(@ModelAttribute("digimon") Digimon digimon) {
		serviceDigimon.save(digimon);
		return stampaDigimon();
	}

	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ModelAndView salvaModifica(@ModelAttribute("digimon") Digimon digimon) {
		serviceDigimon.save(digimon);
		return stampaDigimon();
	}

}
