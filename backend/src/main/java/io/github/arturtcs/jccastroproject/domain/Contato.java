package io.github.arturtcs.jccastroproject.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50, name = "contato_id")
    private Long id;

    @Column(nullable = false, length = 100, name = "contato_nome")
    private String nome;

    @Column(length = 255, name = "contato_email")
    private String email;

    @Column(nullable = false, length = 11, name = "contato_celular")
    private String celular;

    @Column(length = 11, name = "contato_telefone")
    private String telefone;

    @Column(length = 1, name = "contato_sn_favorito")
    private Character favorito;

    @Column(length = 1, name = "contato_sn_ativo")
    private Character ativo;

    @Column(name = "contato_dh_cad")
    private LocalDateTime dataCadastro;



}
