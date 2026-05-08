package leituraApi.service;

import leituraApi.dto.DashboardDTO;
import leituraApi.model.Livro;
import leituraApi.model.StatusLeitura;
import leituraApi.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listar() {
        return repository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Livro não encontrado com id: " + id));
    }

    public Livro salvar(Livro livro) {
        return repository.save(livro);
    }

    public Livro atualizar(Long id, Livro livroAtualizado) {
        Livro livro = buscarPorId(id);
        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setGenero(livroAtualizado.getGenero());
        livro.setTotalPaginas(livroAtualizado.getTotalPaginas());
        livro.setPaginasLidas(livroAtualizado.getPaginasLidas());
        livro.setStatus(livroAtualizado.getStatus());
        livro.setAvaliacao(livroAtualizado.getAvaliacao());
        return repository.save(livro);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Livro não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }

    public DashboardDTO getDashboard() {
        List<Livro> todos = repository.findAll();

        DashboardDTO dto = new DashboardDTO();
        dto.setTotalLivros(todos.size());
        dto.setLendoAgora(todos.stream().filter(l -> l.getStatus() == StatusLeitura.LENDO).count());
        dto.setFinalizados(todos.stream().filter(l -> l.getStatus() == StatusLeitura.FINALIZADO).count());
        dto.setPaginasLidas(todos.stream()
                .mapToLong(l -> l.getPaginasLidas() != null ? l.getPaginasLidas() : 0)
                .sum());

        dto.setLivrosFinalizadosNoMes(dto.getFinalizados());
        dto.setMetaMensal(4);

        Map<String, Long> rankingGeneros = todos.stream()
                .filter(l -> l.getGenero() != null && !l.getGenero().isBlank())
                .collect(Collectors.groupingBy(Livro::getGenero, Collectors.counting()));
        dto.setRankingGeneros(rankingGeneros);

        return dto;
    }
}
