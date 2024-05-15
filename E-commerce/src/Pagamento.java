public class Pagamento {
    //Atributos
    private int IdPagamento;
    private String tipoPagamento; //cartao_credito, cartao_debito, boleto e pix
    private String dadosPagamento; //numero_cartao, vencimento, codigo_segurança, parcelas...
    private String statusPagamento; //pendente, aprovado, recusado;
    private double valor;

    //Getters and Setters
    public int getIdPagamento() {
        return IdPagamento;
    }
    public void setIdPagamento(int idPagamento) {
        IdPagamento = idPagamento;
    }
    public String getTipoPagamento() {
        return tipoPagamento;
    }
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    public String getDadosPagamento() {
        return dadosPagamento;
    }
    public void setDadosPagamento(String dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }
    public String getStatusPagamento() {
        return statusPagamento;
    }
    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    //Outros métodos
    public void efetuarPagamento(){
        //processa o pagamento com a forma escolhida
    }
    public void consultarPagamento(){
        //verifica o status do pagamento
    }
}
