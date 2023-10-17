package br.com.elizabetefabri.todolist.tarefa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_tarefas")
public class TarefaModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String descricao;

    @Column(length = 50)
    private String titulo;
    private LocalDateTime data_inicio;
    private LocalDateTime data_termino;
    private String prioridade;

    private UUID idUsuario;

    @CreationTimestamp
    private LocalDateTime data_criacao;
}
