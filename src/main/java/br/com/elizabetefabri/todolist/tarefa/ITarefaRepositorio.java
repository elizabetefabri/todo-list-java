package br.com.elizabetefabri.todolist.tarefa;

import br.com.elizabetefabri.todolist.usuarios.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ITarefaRepositorio extends JpaRepository<TarefaModel, UUID> {
    List<TarefaModel> findByIdUsuario(UUID idUsuario);
}
