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

import ues.induccion.demo.entity.Empresa;
import ues.induccion.demo.service.EmpresaService;

@Controller
@RequestMapping("/estudiante")
public class EmpresaController {

	private static final String INDEX_VIEW = "empresa/index";
	private static final String CREATE_VIEW = "empresa/create";
	private static final String EDIT_VIEW = "empresa/edit";
	
	@Autowired
	@Qualifier("empresaServiceImpl")
	private EmpresaService empresaService;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(INDEX_VIEW);
		
		List<Empresa> empresas = empresaService.getAll();  
		
		mav.addObject("empresas", empresas);
		
		return mav;
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView(CREATE_VIEW);
		
		mav.addObject("empresa", new Empresa());
		
		return mav;
	}
	
	@PostMapping("/store")
	public String store(@ModelAttribute("empresa") Empresa empresa) {
		
		empresaService.store(empresa);
		
		return "redirect:/empresa/index";
	}
	
	@GetMapping("/edit/{id_empresa}")
	public ModelAndView edit(@PathVariable int id_empresa) {
		ModelAndView mav = new ModelAndView(EDIT_VIEW);
		
		Empresa estudiante = empresaService.findById(id_empresa);
		
		mav.addObject("empresa", estudiante);
		
		return mav;
		
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("empresa") Empresa empresa) {
		Empresa empresaModificado = empresaService.findById(empresa.getId());
		
		empresaModificado.setNombre(empresa.getNombre());
		empresaModificado.setTelefono(empresa.getTelefono());
		empresaModificado.setDireccion(empresa.getDireccion());
		empresaModificado.setCantidad_empleados(empresa.getCantidad_empleados());
		empresaModificado.setFecha_fundacion(empresa.getFecha_fundacion());
		
		empresaService.update(empresaModificado);
		
		 return "redirect:/empresa/index";
	}
	
	@PostMapping("/destroy")
	public String destroy(@RequestParam("idEmpresa") int id_empresa) {
		Empresa empresa = empresaService.findById(id_empresa);
		
		empresaService.destroy(empresa);
		return "redirect:/empresa/index";
	}
}
