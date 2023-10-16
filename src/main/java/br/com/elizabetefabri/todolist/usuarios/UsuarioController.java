package br.com.elizabetefabri.todolist.usuarios;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @PostMapping("/")
    public void create(@RequestBody UsuarioModel usuarioModel){
        System.out.println(usuarioModel.getUsername());
    }
}
