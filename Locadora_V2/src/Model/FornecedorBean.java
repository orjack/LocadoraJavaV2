package Model;

public class FornecedorBean {
    private int id;
    private String razao_social;
    private String cnpj;
    private String inscricao_estadual;
    
    //Endereco
    private String cep;
    private String logradouro;
    private int numero_logradouro;
    private String bairro;
    private String municipio;
    private int uf;
    
    //Contato
    private String numero_celular;
    private String numero_residencial;
    private String Email;
    private int situacao;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public int getNumero_logradouro() {
        return numero_logradouro;
    }
    public void setNumero_logradouro(int numero_logradouro) {
        this.numero_logradouro = numero_logradouro;
    }
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }

    public String getNumero_celular() {
        return numero_celular;
    }

    public void setNumero_celular(String numero_celular) {
        this.numero_celular = numero_celular;
    }

    public String getNumero_residencial() {
        return numero_residencial;
    }

    public void setNumero_residencial(String numero_residencial) {
        this.numero_residencial = numero_residencial;
    }
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        Integer.valueOf(situacao == 1 ? "Ativo" : "Inativo");
        this.situacao = situacao;
    }
}
