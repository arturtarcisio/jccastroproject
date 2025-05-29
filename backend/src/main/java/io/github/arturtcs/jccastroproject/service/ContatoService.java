package io.github.arturtcs.jccastroproject.service;

import io.github.arturtcs.jccastroproject.domain.Contato;
import io.github.arturtcs.jccastroproject.domain.DTO.ContatoDTO;

import java.util.List;


public interface ContatoService {

    Contato cadastrarContato(ContatoDTO dto);
    List<Contato> listarTodosOsContatos();
    void excluirContato(Long id);
    Contato atualizarContato(Long id, ContatoDTO dto);

}
