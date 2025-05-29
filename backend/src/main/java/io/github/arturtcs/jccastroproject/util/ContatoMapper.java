package io.github.arturtcs.jccastroproject.util;

import io.github.arturtcs.jccastroproject.domain.Contato;
import io.github.arturtcs.jccastroproject.domain.DTO.ContatoDTO;

import java.time.LocalDateTime;

public class ContatoMapper {

    public static Contato toEntity(ContatoDTO dto) {
        return Contato.builder()
                .nome(dto.nome())
                .email(dto.email())
                .celular(dto.celular())
                .telefone(dto.telefone())
                .favorito(dto.favorito())
                .ativo(dto.ativo())
                .dataCadastro(LocalDateTime.now())
                .build();
    }
}
