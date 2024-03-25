package com.finan.orcamento.controller;

import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.repositories.UsuarioRepository;
import com.finan.orcamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/usuarios")
@RestController
public class OrcamentoController {
    @Autowired
    private OrcamentoService orcamentoService;
    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @GetMapping
    public ResponseEntity<List<OrcamentoModel>> BuscaTodosOrcamentos(){
        return ResponseEntity.ok(orcamentoService.buscarCadastro());
    }

    @GetMapping(path="/pesquisaid/{id}")
    public ResponseEntity<OrcamentoModel> buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(orcamentoService.buscaId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioModel> cadastraOrcametno(@RequestBody OrcamentoModel orcamentoModel){
        return ResponseEntity.ok(orcamentoService.cadastrarUsuario(orcamentoModel));
    }

    @PostMapping(path = "/put/{id}")
    public ResponseEntity<UsuarioModel> atualizaUsuario(@RequestBody UsuarioModel usuarioModel, @PathVariable Long id) {
        UsuarioModel usuarioNewObj = orcamentoService.atualizaUsuario(usuarioModel, id);
        return ResponseEntity.ok().body(usuarioNewObj);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUsuario(@PathVariable Long id){
        orcamentoService.deletaUsuario(id);
    }



}
