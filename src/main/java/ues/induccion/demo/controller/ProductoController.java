package ues.induccion.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ues.induccion.demo.entity.Estudiante;
import ues.induccion.demo.entity.Producto;
import ues.induccion.demo.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	private static final String INDEX_VIEW = "producto/index";
	
	@Autowired
	@Qualifier("productoServiceImpl")
	private ProductoService productoService;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(INDEX_VIEW);
		
		mav.addObject("productos", productoService.getAll());
		mav.addObject("producto", new Producto());
		
		return mav;
	}
	
	@PostMapping("/store")
	public String store(@ModelAttribute("producto") Producto producto) {
		
		productoService.store(producto);
		
		return "redirect:/producto/index";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("producto") Producto producto) {
		Producto productoModificado = productoService.findById(producto.getId());
		
		productoModificado.setNombre(producto.getNombre());
		productoModificado.setMargenGanacia(producto.getMargenGanacia());
		productoModificado.setEsNacional(producto.getEsNacional());
		
		productoService.update(productoModificado);
		
		 return "redirect:/producto/index";
	}
}
