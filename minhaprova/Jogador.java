public class Jogador {
    //Atributos
    private String nome;
    private int votos;

    //Construtor
    public Jogador(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    //Getters
    public String getNome() {
        return nome;
    }
    public int getVotos() {
        return votos;
    }

    //Método
    public void adicionarVotos(){
        votos++;
    }

}
