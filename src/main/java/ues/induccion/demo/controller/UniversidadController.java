package ues.induccion.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import ues.induccion.demo.entity.Estudiante;
import ues.induccion.demo.entity.Universidad;
import ues.induccion.demo.service.UniversidadService;

@Controller
@RequestMapping("/universidad")
public class UniversidadController {
	private static final String INDEX_VIEW="universidad/index";
	private static final String CREATE_VIEW="universidad/create";
	private static final String EDIT_VIEW="universidad/edit";
	
	@Autowired
	@Qualifier("universidadServiceImpl")
	private UniversidadService universidadService;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(INDEX_VIEW);
		
		List<Universidad> universidades= universidadService.getAll();
		mav.addObject("universidades", universidades);
		
		return mav;
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView mav=new ModelAndView(CREATE_VIEW);
		mav.addObject("universidad", new Universidad());
		
		return mav;
	}
	
	@PostMapping("/store")
	public String store(@ModelAttribute("universidad") Universidad universidad) {
		universidadService.store(universidad);
		
		return "redirect:/universidad/index";
	}
	
	@GetMapping("/edit/{id_universidad}")
	public ModelAndView edit(@PathVariable int id_universidad) {
		ModelAndView mav= new ModelAndView(EDIT_VIEW);
		
		Universidad universidad=universidadService.findById(id_universidad);
		
		mav.addObject("universidad", universidad);
		
		return mav;
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("universidad") Universidad universidad) {
		
		Universidad universidadModificado = universidadService.findById(universidad.getId());
		
		universidadModificado.setNombre(universidad.getNombre());
		universidadModificado.setCantidad_carreras(universidad.getCantidad_carreras());
		universidadModificado.setDireccion(universidad.getDireccion());
		universidadModificado.setEs_publica(universidad.getEs_publica());
		universidadModificado.setFecha_fundacion(universidad.getFecha_fundacion());
		
		universidadService.update(universidadModificado);
		return "redirect:/universidad/index";
	}
	
	@PostMapping("/destroy")
	public String destroy(@RequestParam("id_universidad") int id_universidad) {
		Universidad universidad=universidadService.findById(id_universidad);
		
		universidadService.destroy(universidad);
		return "redirect:/universidad/index";
	}
}
