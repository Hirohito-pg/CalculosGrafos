import menu.Sobre;
import menu.Tutorial;

public class AtributosGrafo {
    private String caminho;
    private String nome;
    private String PrimeiraLinha;
    private long TempoInicio;
    private long TempoFinal;
    private Double TempoSegundos;
    private int TotalVertice;
    private int MaiorGrau;
    private int[] VerticeCores;
    private int[][] VerticeLigacao;
    private int[][] Posicao;
    private Boolean ValoresGrafoTXTCorreto = Boolean.valueOf(false);
    private Boolean ImprimirMatriz;
    private Sobre Csobre = new Sobre();
    private Tutorial Ctutorial = new Tutorial();
    private MatrizAdjacencia imprimir_matriz;

    public AtributosGrafo(long TempoFinal) {
        this.TempoFinal = TempoFinal;
    }

    public String getCaminho() {
        return this.caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrimeiraLinha() {
        return this.PrimeiraLinha;
    }

    public void setPrimeiraLinha(String PrimeiraLinha) {
        this.PrimeiraLinha = PrimeiraLinha;
    }

    public long getTempoInicio() {
        return this.TempoInicio;
    }

    public void setTempoInicio(long TempoInicio) {
        this.TempoInicio = TempoInicio;
    }

    public long getTempoFinal() {
        return this.TempoFinal;
    }

    public void setTempoFinal(long TempoFinal) {
        this.TempoFinal = TempoFinal;
    }

    public Double getTempoSegundos() {
        return this.TempoSegundos;
    }

    public void setTempoSegundos(Double TempoSegundos) {
        this.TempoSegundos = TempoSegundos;
    }

    public int getTotalVertice() {
        return this.TotalVertice;
    }

    public void setTotalVertice(int TotalVertice) {
        this.TotalVertice = TotalVertice;
    }

    public int getMaiorGrau() {
        return this.MaiorGrau;
    }

    public void setMaiorGrau(int MaiorGrau) {
        this.MaiorGrau = MaiorGrau;
    }

    public int[] getVerticeCores() {
        return this.VerticeCores;
    }

    public void setVerticeCores(int[] VerticeCores) {
        this.VerticeCores = VerticeCores;
    }

    public int[][] getPosicao() {
        return this.Posicao;
    }

    public void setPosicao(int[][] Posicao) {
        this.Posicao = Posicao;
    }

    public int[][] getVerticeLigacao() {
        return this.VerticeLigacao;
    }

    public void setVerticeLigacao(int[][] VerticeLigacao) {
        this.VerticeLigacao = VerticeLigacao;
    }

    public Boolean getValoresGrafoTXTCorreto() {
        return this.ValoresGrafoTXTCorreto;
    }

    public void setValoresGrafoTXTCorreto(Boolean ValoresGrafoTXTCorreto) {
        this.ValoresGrafoTXTCorreto = ValoresGrafoTXTCorreto;
    }

    public Boolean getImprimirMatriz() {
        return this.ImprimirMatriz;
    }

    public void setImprimirMatriz(Boolean ImprimirMatriz) {
        this.ImprimirMatriz = ImprimirMatriz;
    }

    public Sobre getCsobre() {
        return this.Csobre;
    }

    public void setCsobre(Sobre Csobre) {
        this.Csobre = Csobre;
    }

    public Tutorial getCtutorial() {
        return this.Ctutorial;
    }

    public void setCtutorial(Tutorial Ctutorial) {
        this.Ctutorial = Ctutorial;
    }

    public MatrizAdjacencia getImprimir_matriz() {
        return this.imprimir_matriz;
    }

    public void setImprimir_matriz(MatrizAdjacencia imprimir_matriz) {
        this.imprimir_matriz = imprimir_matriz;
    }
}