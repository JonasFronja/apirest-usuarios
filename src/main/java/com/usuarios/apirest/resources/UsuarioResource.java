package com.usuarios.apirest.resources;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.apirest.repository.UsuarioRepository;



import com.usuarios.apirest.model.Usuario;

@RestController
@RequestMapping(value="/api")
public class UsuarioResource {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@GetMapping("/usuarios-listar")
	public List<Usuario> listaProdutos(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuario-listar/{id}")
	public Usuario listaUsuarioUnico(@PathVariable(value="id") long id){
		return usuarioRepository.findById(id);
	}
	
	@PostMapping("/usuario-insert")
	public Usuario inserirUsuario(@RequestBody Usuario usuario) throws ParseException{
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		usuario.setData_cadastro(formatter.format(date));
		
		
		if(idade(usuario.getData_nascimento())) {
			
			return usuarioRepository.save(usuario);
		}
		
		return null;
			
	}
	
	@DeleteMapping("/usuario-delete")
	public void deletarUsuario(@RequestBody Usuario usuario){
		usuarioRepository.delete(usuario);
	}
	
	@PutMapping("/usuario-editar")
	public Usuario atualizarUsuario(@RequestBody Usuario usuario) throws ParseException{
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		usuario.setData_atualizacao(formatter.format(date));
		

		if(idade(usuario.getData_nascimento())) {
			
			return usuarioRepository.save(usuario);
		}
		
		return null;
	}
	
	
	public boolean idade(String data) throws ParseException{
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dateOfBirth = formato.parse(data);
		Calendar dob = Calendar.getInstance();  
		dob.setTime(dateOfBirth);  
		Calendar today = Calendar.getInstance();  
		int idade = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
		if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
		  idade--;  
		} else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
		    && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
		  idade--;  
		}
		
		return idade > 17;
	}
	
	
	
}
