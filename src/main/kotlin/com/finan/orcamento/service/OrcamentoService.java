package com.finan.orcamento.service;

import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {
    @Autowired
    private OrcamentoRepository OrcamentoRepository;

    public List<OrcamentoModel> buscarCadastro(){
        return OrcamentoRepository.findAll();
    }

    public OrcamentoModel buscaId(Long id){
        Optional<OrcamentoModel>obj= OrcamentoRepository.findById(id);
        if(obj.isPresent()) {
            return obj.get();
        }
            else{
                throw new RuntimeException("Orcamento não encontrado");
            }

    }


    public OrcamentoModel cadastrarOrcamento(OrcamentoModel OrcamentoModel){
        return OrcamentoRepository.save(usuarioModel);
    }

    public OrcamentoModel atualizaUsuario(UsuarioModel usuarioModel, Long id){
        UsuarioModel newUsuarioModel = buscaId(id);
        newUsuarioModel.setNomeUsuario(usuarioModel.getNomeUsuario());
        return OrcamentoRepository.save(newUsuarioModel);
    }

    public void deletaUsuario(Long id){
        OrcamentoRepository.deleteById(id);
    }

}
