package io.github.arturtcs.jccastroproject.service.impl;

import io.github.arturtcs.jccastroproject.domain.Contato;
import io.github.arturtcs.jccastroproject.domain.DTO.ContatoDTO;
import io.github.arturtcs.jccastroproject.exception.ContatoJaExisteException;
import io.github.arturtcs.jccastroproject.repository.ContatoRepository;
import io.github.arturtcs.jccastroproject.service.ContatoService;
import io.github.arturtcs.jccastroproject.util.ContatoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepository contatoRepository;

    @Override
    @Transactional
    public Contato cadastrarContato(ContatoDTO dto) {
        Optional<Contato> contatoExiste = contatoRepository.findByCelular(dto.celular());

        if (contatoExiste.isPresent()) {
            throw new ContatoJaExisteException(dto.celular());
        }

        Contato contato = ContatoMapper.toEntity(dto);
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
