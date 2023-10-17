package br.com.elizabetefabri.todolist.usuarios;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UsuarioModel usuarioModel){
        var usuario = this.usuarioRepositorio.findByUsername(usuarioModel.getUsername());
        if (usuario != null){
            /*System.out.println("Usuário já existe");*/
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        var senhaHash = BCrypt.withDefaults().hashToString(12, usuarioModel.getSenha().toCharArray());
        usuarioModel.setSenha(senhaHash);

        var usuarioCadastrado = this.usuarioRepositorio.save(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCadastrado);
    }
}
