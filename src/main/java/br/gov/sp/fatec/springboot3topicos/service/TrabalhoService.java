package br.gov.sp.fatec.springboot3topicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springboot3topicos.entity.Trabalho;
import br.gov.sp.fatec.springboot3topicos.repository.TrabalhoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public Trabalho cadastrarTrabalho(Trabalho trabalho) {
        return trabalhoRepository.save(trabalho);
    }

    public List<Trabalho> listarTrabalhos() {
        return trabalhoRepository.findAll();
    }

    public Optional<Trabalho> buscarPorId(Long id) {
        return trabalhoRepository.findById(id);
    }

    public List<Trabalho> buscarTrabalhosPorTituloENota(String palavraChave, int nota) {
        return trabalhoRepository.findByTituloAndNota(palavraChave, nota);
    }
}

