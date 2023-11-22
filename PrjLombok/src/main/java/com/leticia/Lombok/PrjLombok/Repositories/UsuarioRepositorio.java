package com.leticia.Lombok.PrjLombok.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leticia.Lombok.PrjLombok.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

}
