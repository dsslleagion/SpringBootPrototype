package br.gov.sp.fatec.springboot3topicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.sp.fatec.springboot3topicos.entity.Trabalho;
import br.gov.sp.fatec.springboot3topicos.service.TrabalhoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trabalho")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Trabalho> cadastrarTrabalho(@RequestBody Trabalho trabalho) {
        Trabalho novoTrabalho = trabalhoService.cadastrarTrabalho(trabalho);
        return new ResponseEntity<>(novoTrabalho, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Trabalho>> listarTrabalhos() {
        List<Trabalho> trabalhos = trabalhoService.listarTrabalhos();
        return new ResponseEntity<>(trabalhos, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Trabalho> buscarPorId(@PathVariable Long id) {
        Optional<Trabalho> trabalho = trabalhoService.buscarPorId(id);
        return trabalho.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/trabalho/buscar")
    public ResponseEntity<List<Trabalho>> buscarTrabalhosPorTituloENota(@RequestParam String palavraChave, @RequestParam int nota) {
        List<Trabalho> trabalhos = trabalhoService.buscarTrabalhosPorTituloENota(palavraChave, nota);
        return ResponseEntity.ok(trabalhos);
    }
}

