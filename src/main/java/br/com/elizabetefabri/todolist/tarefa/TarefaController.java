package br.com.elizabetefabri.todolist.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private ITarefaRepositorio tarefaRepositorio;

    @PostMapping("/")
    public TarefaModel create(@RequestBody TarefaModel tarefaModel){
        System.out.println("Chegou no Controller");
        var tarefa = this.tarefaRepositorio.save(tarefaModel);
        return tarefa;
    }

}
