package Model;

import java.util.ArrayList;

public class LocacaoBean {
    
    private int id;
    private ClienteBean cliente;
    private ArrayList<MidiaBean> midias;
    private double valor_pago;
    private String data_locacao;
    private String data_devolucao;
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
        this.midias.add(midia);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_locacao() {
        return data_locacao;
    }

    public void setData_locacao(String data_locacao) {
        this.data_locacao = data_locacao;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
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

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
}
