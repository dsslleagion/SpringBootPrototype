package br.gov.sp.fatec.springboot3topicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3topicos.entity.Corpo;

import br.gov.sp.fatec.springboot3topicos.repository.CorpoRepository;

@Service
public class CorpoService {
    
    @Autowired
    private CorpoRepository corpoRepository;

    public List<Corpo> buscarCorposPorNomeEDistancia(String texto, Float distancia) {
        return corpoRepository.findByNomeContainingAndDistanciaGreaterThan(texto, distancia);
    }

    public Corpo cadastrarCorpo(Corpo corpo) {

        if (corpo == null || 
        corpo.getNome() == null ||
        corpo.getNome().isBlank() ||
        corpo.getDescricao() == null ||
        corpo.getDescricao().isBlank() ||
        corpo.getDistancia() == null
        ) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para criar o departamento");
    }
        return corpoRepository.save(corpo);
    }

    public List<Corpo> listarCorpos() {
        return corpoRepository.findAll();
    }

    public Optional<Corpo> buscarPorId(Long id) {
        return corpoRepository.findById(id);
    }

    // public List<Corpo> buscarCorposPorTituloENota(String palavraChave, int nota) {
    //     return corpoRepository.findByTituloAndNota(palavraChave, nota);
    // }
}
