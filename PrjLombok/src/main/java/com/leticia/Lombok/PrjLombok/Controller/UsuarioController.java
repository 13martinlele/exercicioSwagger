package com.leticia.Lombok.PrjLombok.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leticia.Lombok.PrjLombok.entities.Usuario;
import com.leticia.Lombok.PrjLombok.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Usuarios", description = "API REST DE GERENCIAMENTO DE USUÁRIOS")
@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

		private final UsuarioService UsuarioService;

		@Autowired
		public UsuarioController(UsuarioService UsuarioService) {
			this.UsuarioService = UsuarioService;
		}

		@GetMapping("/{id}")
		@Operation(summary = "Localiza usuário porID")
		public ResponseEntity<Usuario> findUsuariobyId(@PathVariable Long id) {
			Usuario usuario = UsuarioService.findUsuarioById(id);
			if (usuario != null) {
				return ResponseEntity.ok(usuario);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping("/")
		@Operation(summary = "Apresenta todos os usuários")
		public ResponseEntity<List<Usuario>> findAllUsuarioscontrol() {
			List<Usuario> usuarios = UsuarioService.findAllUsuario();
			return ResponseEntity.ok(usuarios);
		}

		@PostMapping("/{id}")
		@Operation(summary = "Cadastra usuário")
		public ResponseEntity<Usuario> insertUsuariosControl(@RequestBody @Valid Usuario usuario) {
			Usuario novoUsuario = UsuarioService.insertUsuario(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
		}

		@PutMapping("/id")
		@Operation(summary = "Altera usuário")
		public ResponseEntity<Usuario> updateUsuarioControl(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
			Usuario mudausuario = UsuarioService.updateUsuario(id, usuario);
			if (mudausuario != null) {
				return ResponseEntity.ok(usuario);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@DeleteMapping("/id")
		@Operation(summary = "Exclui usuário")
		public ResponseEntity<String> deleteUsuarioControl(@PathVariable Long id) {
			boolean remover = UsuarioService.deleteUsuario(id);
			if (remover) {
				return ResponseEntity.ok().body("usuario Excluido com sucesso");
			} else {
				return ResponseEntity.notFound().build();
			}
		}

	
}
