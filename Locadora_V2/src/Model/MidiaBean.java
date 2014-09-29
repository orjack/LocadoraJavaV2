package Model;

import java.util.ArrayList;

public class MidiaBean {
    private int id;
    private FornecedorBean fornecedor;
    private DiretorBean diretor;
    private AutorBean autor;
    
    private String grupo;
    private String genero;
    private String censura;
    
    private String produtora;
    private String titulo;
    private String categoria;
    private String data_lancamento;
    private String valor_custo;
    private String valor_locacao;
    private String quantidade;
    private String sinopse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCensura() {
        return censura;
    }

    public void setCensura(String censura) {
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public String getValor_custo() {
        return valor_custo;
    }

    public void setValor_custo(String valor_custo) {
        this.valor_custo = valor_custo;
    }

    public String getValor_locacao() {
        return valor_locacao;
    }

    public void setValor_locacao(String valor_locacao) {
        this.valor_locacao = valor_locacao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
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
}
