package Model;

import java.util.Date;

public class MidiaBean {
    private int id;
    private FornecedorBean fornecedor;
    private DiretorBean diretor;
    private AutorBean autor;
    
    private int grupo;
    private int genero;
    private int censura;
    
    private String produtora;
    private String titulo;
    private int categoria;
    private int anoLancamento;
    private double valorCusto;
    private double valorLocacao;
    private int quantidade;
    private String sinopse;
    private int situacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FornecedorBean getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorBean fornecedor) {
        this.fornecedor = fornecedor;
    }

    public DiretorBean getDiretor() {
        return diretor;
    }

    public void setDiretor(DiretorBean diretor) {
        this.diretor = diretor;
    }

    public AutorBean getAutor() {
        return autor;
    }

    public void setAutor(AutorBean autor) {
        this.autor = autor;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getCensura() {
        return censura;
    }

    public void setCensura(int censura) {
        this.censura = censura;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    
    public String getSituacaoDisplay() {
        return this.situacao == 1 ? "Ativo" : "Inativo";
    }
    
}
