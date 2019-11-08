package com.usuarios.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarios.apirest.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findById(long id);

}
