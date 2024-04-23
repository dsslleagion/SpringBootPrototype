package br.gov.sp.fatec.springboot3topicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.sp.fatec.springboot3topicos.entity.Corpo;
import br.gov.sp.fatec.springboot3topicos.service.CorpoService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/corpo")
public class CorpoController {
    @Autowired
    private CorpoService corpoService;

    @PostMapping
    public ResponseEntity<Corpo> cadastrarCorpo(@RequestBody Corpo corpo) {
        Corpo novoCorpo = corpoService.cadastrarCorpo(corpo);
        return new ResponseEntity<>(novoCorpo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Corpo>> listarCorpos() {
        List<Corpo> corpos = corpoService.listarCorpos();
        return new ResponseEntity<>(corpos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Corpo> buscarPorId(@PathVariable Long id) {
        Optional<Corpo> corpo = corpoService.buscarPorId(id);
        return corpo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/corpos")
    public List<Corpo> buscarCorposPorNomeEDistancia(
            @RequestParam("texto") String texto,
            @RequestParam("distancia") Float distancia) {
        return corpoService.buscarCorposPorNomeEDistancia(texto, distancia);
    }
}
