package io.github.arturtcs.jccastroproject.service.impl;

import io.github.arturtcs.jccastroproject.domain.Contato;
import io.github.arturtcs.jccastroproject.repository.ContatoRepository;
import io.github.arturtcs.jccastroproject.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepository customerRepository;

    @Override
    @Transactional
    public Contato save(Contato contato) {
        return customerRepository.save(contato);
    }

    @Override
    public Optional<Contato> buscarContatoPeloCelular(String celular) {
        return Optional.empty();
    }

    @Override
    public List<Contato> listarTodosOsContatos() {
        return List.of();
    }
}
