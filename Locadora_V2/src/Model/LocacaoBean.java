package Model;

import java.util.ArrayList;
import java.util.Date;

public class LocacaoBean {
    
    private int id;
    private ClienteBean cliente;
    private ArrayList<MidiaBean> midias;
    private double valorPago;
    private Date dataLocacao;
    private Date dataDevolucao;
    private int situacao;
    
    public static int SITUACAO_ABERTO = 1;
    public static int SITUACAO_DEVOLVIDO = 2;

    public LocacaoBean() {
        midias = new ArrayList();
        situacao = SITUACAO_ABERTO;
    }
    
    public String getSituacaoDisplay() {
        if (this.getSituacao() == SITUACAO_ABERTO) {
            return "Aberto";
        }
        else if (this.getSituacao() == SITUACAO_DEVOLVIDO) {
            return "Devolvido";
        }
        return null;
    }

    public void addMidia(MidiaBean midia) {
        this.getMidias().add(midia);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteBean getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }

    public ArrayList<MidiaBean> getMidias() {
        return midias;
    }

    public void setMidias(ArrayList<MidiaBean> midias) {
        this.midias = midias;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
}
