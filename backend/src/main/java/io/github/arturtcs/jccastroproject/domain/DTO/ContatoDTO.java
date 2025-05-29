package io.github.arturtcs.jccastroproject.domain.DTO;

public record ContatoDTO(
        String nome,
        String email,
        String celular,
        String telefone,
        Character favorito,
        Character ativo
) {}
