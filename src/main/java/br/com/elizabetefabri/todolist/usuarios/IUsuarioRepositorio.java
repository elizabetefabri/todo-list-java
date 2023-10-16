package br.com.elizabetefabri.todolist.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUsuarioRepositorio extends JpaRepository<UsuarioModel, UUID> {
    UsuarioModel findByUsername(String username);
}
