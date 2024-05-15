public class Usuario {
    //Atributos
    private int IdUsuario;
    private String nome, email, senha, telefone, cpf, dtaNascimento;
    private Endereco endereco;

    //Setters and Getters
    public int getIdUsuario() {
        return IdUsuario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDtaNascimento() {
        return dtaNascimento;
    }
    public void setDtaNascimento(String dtaNascimento) {
        this.dtaNascimento = dtaNascimento;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    //Outros métodos
    //Método para verificar login e senha no BD
    public void autenticar() { //booleand com String email e String senha

    }

    //Método para cadastrar usuário no BD
    public void cadastrarUsuario(int idUsuario, String nome, String email, String senha, String telefone, String cpf, String dtaNascimento, Endereco endereco) {
        //Criar verificação de existencia no BD
        //Criar um novo objeto de usuário
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);
        novoUsuario.setDtaNascimento(dtaNascimento);
        novoUsuario.setTelefone(telefone);
        novoUsuario.setEndereco(endereco);
    }
}

