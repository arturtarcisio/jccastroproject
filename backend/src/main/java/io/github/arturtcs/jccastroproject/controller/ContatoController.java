package io.github.arturtcs.jccastroproject.controller;

import io.github.arturtcs.jccastroproject.domain.Contato;
import io.github.arturtcs.jccastroproject.domain.DTO.ContatoDTO;
import io.github.arturtcs.jccastroproject.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/contatos")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;

    @PostMapping
    public ResponseEntity<Contato> cadastrarContato(@RequestBody ContatoDTO dto) {
        Contato contatoSalvo = contatoService.cadastrarContato(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contatoSalvo.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(contatoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Contato>> listarTodos() {
        List<Contato> contatos = contatoService.listarTodosOsContatos();
        return ResponseEntity.ok(contatos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirContato(@PathVariable Long id) {
        contatoService.excluirContato(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizarContato(@PathVariable Long id, @RequestBody ContatoDTO dto ) {
        Contato contatoAtualizado = contatoService.atualizarContato(id, dto);
        return ResponseEntity.ok(contatoAtualizado);
    }
}
