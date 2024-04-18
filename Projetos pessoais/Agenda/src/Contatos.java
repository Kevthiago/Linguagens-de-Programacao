public class Contatos {
    //Atributos
    private String nome;
    private String telefones;
    private String endereco;
    private int indice;

    //Construtor
    public Contatos(String nome, String numero, String endereco, int i) {
        this.nome = nome;
        this.telefones = numero;
        this.endereco = endereco;
        this.indice = i + 1;
    }

    //Getters and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefones() {
        return telefones;
    }
    public void setNumero(String numero) {
        this.telefones = numero;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getIndice() {
        return indice;
    }
    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public String toString() {
        return "Contato " + getIndice() + ":" + "\nNome: " + getNome() + "\nTelefone: " + getTelefones() + "\nEndereço: "
                + getEndereco();
    }

}
