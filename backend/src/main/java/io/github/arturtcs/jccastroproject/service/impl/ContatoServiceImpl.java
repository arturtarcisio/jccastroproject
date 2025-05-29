package io.github.arturtcs.jccastroproject.service.impl;

import io.github.arturtcs.jccastroproject.domain.Contato;
import io.github.arturtcs.jccastroproject.repository.ContatoRepository;
import io.github.arturtcs.jccastroproject.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepository contatoRepository;

    @Override
    @Transactional
    public Contato save(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public List<Contato> listarTodosOsContatos() {
        return contatoRepository.findAll();
    }

    @Override
    public void excluirContato(Long id) {
        if (contatoRepository.findById(id).isPresent())
            contatoRepository.deleteById(id);
    }

}
