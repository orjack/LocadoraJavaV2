package Model;

public class DiretorBean {
    private int id;
    private String nome;
    private int situacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSitucacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    
    public String getSituacaoDisplay() {
        return this.situacao == 1 ? "Ativo" : "Inativo";
    }
}
