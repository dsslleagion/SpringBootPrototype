package br.gov.sp.fatec.springboot3topicos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.springboot3topicos.entity.Corpo;

public interface CorpoRepository extends JpaRepository<Corpo, Long> {

    
    @Query("SELECT c FROM Corpo c WHERE c.nome LIKE %:texto% AND c.distancia > :distancia")
    List<Corpo> findByNomeContainingAndDistanciaGreaterThan(@Param("texto") String texto, @Param("distancia") Float distancia);

}
