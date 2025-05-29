package io.github.arturtcs.jccastroproject.exception;

public class ContatoNaoEncontradoException extends RuntimeException{
    public ContatoNaoEncontradoException(Long id) {
        super("Contato com ID " + id + " não encontrado");
    }
}
