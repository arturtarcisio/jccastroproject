package io.github.arturtcs.jccastroproject.service;

import io.github.arturtcs.jccastroproject.domain.Contato;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ContatoService {

    Contato save (Contato contato);
    Optional<Contato> buscarContatoPeloCelular (String celular);
    List<Contato> listarTodosOsContatos();

}
