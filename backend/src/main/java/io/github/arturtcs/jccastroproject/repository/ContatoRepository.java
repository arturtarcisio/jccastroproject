package io.github.arturtcs.jccastroproject.repository;

import io.github.arturtcs.jccastroproject.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    Contato findByCelular(String celular);

}
