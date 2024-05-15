public class Endereco extends Usuario{
    //Atributos
    private int IdEndereco;
    private String logradouro, numero, complemento, bairro, cidade, estado, CEP;

    //Getters and Setters
    public int getIdEndereco() {
        return IdEndereco;
    }
    public void setIdEndereco(int idEndereco) {
        IdEndereco = idEndereco;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCEP() {
        return CEP;
    }
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    //Outros métodos
    //Método para salvar endereco no BD
    public void cadastrarEndereco(int idEndereco, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String CEP) {
        Endereco novoEndereco = new Endereco();
        novoEndereco.setLogradouro(logradouro);
        novoEndereco.setNumero(numero);
        novoEndereco.setComplemento(complemento);
        novoEndereco.setBairro(bairro);
        novoEndereco.setCidade(cidade);
        novoEndereco.setEstado(estado);
        novoEndereco.setCEP(CEP);
    }
}
