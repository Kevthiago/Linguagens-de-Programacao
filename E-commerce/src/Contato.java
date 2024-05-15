public class Contato {
    //Atributos
    private String email_loja;
    private String telefone_loja;

    //Construtor
    public Contato(String email_loja, String telefone_loja) {
        this.email_loja = email_loja;
        this.telefone_loja = telefone_loja;
    }

    //Getters and Setters
    public String getEmail_loja() {
        return email_loja;
    }
    public void setEmail_loja(String email_loja) {
        this.email_loja = email_loja;
    }
    public String getTelefone_loja() {
        return telefone_loja;
    }
    public void setTelefone_loja(String telefone_loja) {
        this.telefone_loja = telefone_loja;
    }

    //Outros métodos
    public void enviarContato(){
        //enviar mensagem para o suporte da loja
    }
}
