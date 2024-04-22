package br.gov.sp.fatec.springboot3topicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3topicos.entity.Trabalho;

import java.util.List;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    @Query("SELECT t FROM Trabalho t WHERE t.titulo LIKE %?1% AND t.nota > ?2")
    List<Trabalho> findByTituloAndNota(String palavraChave, int nota);
}
