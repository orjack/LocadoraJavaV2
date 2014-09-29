package Model;

abstract class PessoaBean {
    protected int id;
    
    //Endereco
    protected String cep;
    protected String logradouro;
    protected String numero_logradouro;
    protected String bairro;
    protected String municipio;
    protected String uf;
    
    //Contato
    protected String numero_celular;
    protected String numero_residencial;
    protected String Email;
    
    //Situacao
    protected String situacao;

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
    public String getNumero_logradouro() {
        return numero_logradouro;
    }
    public void setNumero_logradouro(String numero_logradouro) {
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
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
    

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
}
