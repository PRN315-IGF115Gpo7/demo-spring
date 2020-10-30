package ues.induccion.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ues.induccion.demo.service.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	private static final String INDEX_VIEW = "empleado/index";
	private static final String CREATE_VIEW = "empleado/create";
	private static final String EDIT_VIEW = "empleado/edit";
	
	@Autowired
	@Qualifier("empleadoServicemlp")
	private EmpleadoService empleadoservice;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(INDEX_VIEW);
		mav.addObject("empleados", empleadoservice.getAll());
		return mav;
	}
}
