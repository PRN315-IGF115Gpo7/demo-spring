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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ues.induccion.demo.entity.Estudiante;
import ues.induccion.demo.service.EstudianteService;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

	private static final String INDEX_VIEW = "estudiante/index";
	private static final String CREATE_VIEW = "estudiante/create";
	private static final String EDIT_VIEW = "estudiante/edit";
	
	@Autowired
	@Qualifier("estudianteServiceImpl")
	private EstudianteService estudianteService;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(INDEX_VIEW);
		
		List<Estudiante> estudiantes = estudianteService.getAll();  
		
		mav.addObject("estudiantes", estudiantes);
		
		return mav;
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView(CREATE_VIEW);
		
		mav.addObject("estudiante", new Estudiante());
		
		return mav;
	}
	
	@PostMapping("/store")
	public String store(@ModelAttribute("estudiante") Estudiante estudiante) {
		
		estudianteService.store(estudiante);
		
		return "redirect:/estudiante/index";
	}
	
	@GetMapping("/edit/{id_estudiante}")
	public ModelAndView edit(@PathVariable int id_estudiante) {
		ModelAndView mav = new ModelAndView(EDIT_VIEW);
		
		Estudiante estudiante = estudianteService.findById(id_estudiante);
		
		mav.addObject("estudiante", estudiante);
		
		return mav;
		
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("estudiante") Estudiante estudiante) {
		Estudiante estudianteModificado = estudianteService.findById(estudiante.getId());
		
		estudianteModificado.setNombre(estudiante.getNombre());
		estudianteModificado.setApellido(estudiante.getApellido());
		estudianteModificado.setCarnet(estudiante.getCarnet());
		estudianteModificado.setAnioIngreso(estudiante.getAnioIngreso());
		
		estudianteService.update(estudianteModificado);
		
		 return "redirect:/estudiante/index";
	}
	
	@PostMapping("/destroy")
	public String destroy(@RequestParam("idEstudiante") int id_estudiante) {
		Estudiante estudiante = estudianteService.findById(id_estudiante);
		
		estudianteService.destroy(estudiante);
		return "redirect:/estudiante/index";
	}
}
