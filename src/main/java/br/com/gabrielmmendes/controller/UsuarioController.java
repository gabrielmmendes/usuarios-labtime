package br.com.gabrielmmendes.controller;

import br.com.gabrielmmendes.model.Usuario;
import br.com.gabrielmmendes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public Page<Usuario> usuariosPage(@PageableDefault Pageable pageable) {
        return repository.findAll(pageable);
    }

    @RequestMapping(value = "/all")
    public List findAll(){
        return repository.findAll();
    }
}
