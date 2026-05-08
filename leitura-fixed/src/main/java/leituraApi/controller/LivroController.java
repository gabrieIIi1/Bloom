package leituraApi.controller;

import leituraApi.dto.DashboardDTO;
import leituraApi.model.Livro;
import leituraApi.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin("*")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Livro> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardDTO> getDashboard() {
        return ResponseEntity.ok(service.getDashboard());
    }

    @PostMapping
    public ResponseEntity<Livro> salvar(@RequestBody Livro livro) {
        return ResponseEntity.ok(service.salvar(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        return ResponseEntity.ok(service.atualizar(id, livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
