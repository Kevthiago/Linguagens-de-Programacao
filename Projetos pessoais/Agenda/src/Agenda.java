import java.util.ArrayList;

public class Agenda {

    //ARRAYLIST CRIADO
    static ArrayList<Contatos> contatosList = new ArrayList<>();

    //Método main
    public static void main(String[] args) {

        // Dados dos contatos
        String[] nomes = {"Kevin", "Poly", "Lucas", "Ana", "Carlos", "Mariana"};
        String[] telefones = {"(31)996597558", "(31)900000000", "(11)987654321", "(41)123456789", "(21)999888777", "(32)55556666"};
        String[] enderecos = {"Rua Catumbi 104", "Avenida Paraná 1820", "Rua São Paulo 123", "Rua Rio de Janeiro 456", "Avenida São João 789", "Avenida Brasil 432"};

        //Adicionando os contatos na agenda
        for (int i = 0; i < nomes.length; i++){
            contatosList.add(new Contatos(nomes[i], telefones[i], enderecos[i], i));
        }
        listarContatos();
        excluirContato(2);
        listarContatos();
    }

    //Métodos de funcionalidade

    //Adicionar contato
    public static void adicionarContato(String nome, String telefones, String endereco){
        contatosList.add(new Contatos(nome, telefones, endereco, contatosList.size()));
        //System.out.println("Novo contato adicionado!\n");
    }

    //Excluir contato
    public static void excluirContato(int indice) {
        if (indice >= 0 && indice <= contatosList.size()){
            contatosList.remove(indice);
            //System.out.println("Contato excluído!\n");
        } else {
            //System.out.println("Índice inválido!\n");
        }
    }

    //Listar contatos
    public static void listarContatos(){
        for (Contatos contatos : Agenda.contatosList) {
            System.out.println(contatos.toString());
            System.out.println();
        }
    }
}
