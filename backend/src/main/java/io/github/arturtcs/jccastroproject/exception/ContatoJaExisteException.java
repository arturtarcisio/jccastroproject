package io.github.arturtcs.jccastroproject.exception;

public class ContatoJaExisteException extends RuntimeException {
    public ContatoJaExisteException(String celular) {
        super("Já existe um contato com o celular: " + celular);
    }
}
