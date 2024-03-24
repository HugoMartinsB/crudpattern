package com.finan.orcamento.controller;

import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.repositories.UsuarioRepository;
import com.finan.orcamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path="/usuarios")
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> BuscaTodosUsuarios(){
        return ResponseEntity.ok(usuarioService.buscarUsuario());
    }

    @GetMapping(path="/pesquisaid/{id}")
    public ResponseEntity<UsuarioModel> buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(usuarioService.buscaId(id));
    }

}
