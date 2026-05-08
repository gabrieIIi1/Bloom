package leituraApi.dto;

import java.util.Map;

public class DashboardDTO {

    private long totalLivros;
    private long lendoAgora;
    private long finalizados;
    private long paginasLidas;
    private long livrosFinalizadosNoMes;
    private int metaMensal;
    private Map<String, Long> rankingGeneros;

    public DashboardDTO() {}

    public long getTotalLivros() { return totalLivros; }
    public void setTotalLivros(long totalLivros) { this.totalLivros = totalLivros; }

    public long getLendoAgora() { return lendoAgora; }
    public void setLendoAgora(long lendoAgora) { this.lendoAgora = lendoAgora; }

    public long getFinalizados() { return finalizados; }
    public void setFinalizados(long finalizados) { this.finalizados = finalizados; }

    public long getPaginasLidas() { return paginasLidas; }
    public void setPaginasLidas(long paginasLidas) { this.paginasLidas = paginasLidas; }

    public long getLivrosFinalizadosNoMes() { return livrosFinalizadosNoMes; }
    public void setLivrosFinalizadosNoMes(long livrosFinalizadosNoMes) { this.livrosFinalizadosNoMes = livrosFinalizadosNoMes; }

    public int getMetaMensal() { return metaMensal; }
    public void setMetaMensal(int metaMensal) { this.metaMensal = metaMensal; }

    public Map<String, Long> getRankingGeneros() { return rankingGeneros; }
    public void setRankingGeneros(Map<String, Long> rankingGeneros) { this.rankingGeneros = rankingGeneros; }
}
