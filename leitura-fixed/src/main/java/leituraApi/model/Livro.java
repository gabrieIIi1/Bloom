package leituraApi.model;

import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String genero;
    private Integer totalPaginas;
    private Integer paginasLidas;
    private Integer avaliacao;

    @Enumerated(EnumType.STRING)
    private StatusLeitura status;

    public Livro() {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTotalPaginas() {
        return totalPaginas;
    }

    public Integer getPaginasLidas() {
        return paginasLidas;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public StatusLeitura getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setTotalPaginas(Integer totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public void setPaginasLidas(Integer paginasLidas) {
        this.paginasLidas = paginasLidas;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setStatus(StatusLeitura status) {
        this.status = status;
    }

    public int getProgresso() {

        if (totalPaginas == null || totalPaginas == 0) {
            return 0;
        }

        return (paginasLidas * 100) / totalPaginas;
    }
}