package io.github.arturtcs.jccastroproject.service.impl;

import io.github.arturtcs.jccastroproject.domain.Contato;
import io.github.arturtcs.jccastroproject.domain.DTO.ContatoDTO;
import io.github.arturtcs.jccastroproject.exception.ContatoJaExisteException;
import io.github.arturtcs.jccastroproject.exception.ContatoNaoEncontradoException;
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
    @Transactional
    public void excluirContato(Long id) {
        if (contatoRepository.findById(id).isPresent())
            contatoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Contato atualizarContato(Long id, ContatoDTO dto) {
        var contatoExistente = contatoRepository.findById(id)
                .orElseThrow(() -> new ContatoNaoEncontradoException(id));

        verificarCelularUnico(dto.celular(), id);

        if (dto.nome() != null) contatoExistente.setNome(dto.nome());
        if (dto.email() != null) contatoExistente.setEmail(dto.email());
        if (dto.celular() != null) contatoExistente.setCelular(dto.celular());
        if (dto.telefone() != null) contatoExistente.setTelefone(dto.telefone());
        if (dto.favorito() != null) contatoExistente.setFavorito(dto.favorito());
        if (dto.ativo() != null) contatoExistente.setAtivo(dto.ativo());

        return contatoRepository.save(contatoExistente);
    }

    private void verificarCelularUnico(String celular, Long idAtualizacao) {
        contatoRepository.findByCelular(celular).ifPresent(contato -> {
            if (!contato.getId().equals(idAtualizacao)) {
                throw new ContatoJaExisteException(celular);
            }
        });
    }



}
