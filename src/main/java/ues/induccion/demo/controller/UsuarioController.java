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

import ues.induccion.demo.entity.Usuario;
import ues.induccion.demo.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private static final String INDEX_VIEW = "usuario/index";
	private static final String CREATE_VIEW = "usuario/create";
	private static final String EDIT_VIEW = "usuario/edit";
	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioService usuarioService;
	
    @GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(INDEX_VIEW);
		
		List<Usuario> usuarios = usuarioService.getAll();
		
		mav.addObject("usuarios", usuarios);
		
		return mav;
	}
    
    @GetMapping("/create")
    public ModelAndView create() {
    	ModelAndView mav = new ModelAndView(CREATE_VIEW);
    	
    	mav.addObject("usuario", new Usuario());
    	
		return mav;
    }
    
    @PostMapping("/store")
    public String store(@ModelAttribute("usuario")Usuario usuario){
    	
    	usuarioService.store(usuario);
    	
    	return "redirect:/usuario/index";
    }
    
    @GetMapping("/edit/{id_usuario}")
    public ModelAndView edit(@PathVariable int id_usuario) {
    	ModelAndView mav = new ModelAndView(EDIT_VIEW);
    	
    	Usuario usuario = usuarioService.findById(id_usuario);
    	
    	mav.addObject("usuario", usuario);
    	
    	return mav;
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("usuario")Usuario usuario) {
    	Usuario usuarioModificado = usuarioService.findById(usuario.getId());
    	
    	usuarioModificado.setUsername(usuario.getUsername());
    	usuarioModificado.setPassword(usuario.getPassword());
    	usuarioModificado.setEs_activo(usuario.isEs_activo());
    	usuarioModificado.setIntentos(usuario.getIntentos());
    	
    	usuarioService.update(usuarioModificado);
    	
    	return "redirect:/usuario/index";
    }
    @PostMapping("/destroy")
    public String destroy(@RequestParam("idUsuario")int id_usuario) {
    	Usuario usuario = usuarioService.findById(id_usuario);
    	
    	usuarioService.destroy(usuario);
    	
    	return "redirect:/usuario/index";
    }
}
