import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApuracaoVotos {
    public static void main(String[] args) {
        //Criando o ArrayList dos participantes e adicionando-os
        ArrayList<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Alane Dias"));
        jogadores.add(new Jogador("Beatriz Reis"));
        jogadores.add(new Jogador("Davi Brito"));
        jogadores.add(new Jogador("Deniziane Ferreira"));
        jogadores.add(new Jogador("Fernanda Bande"));
        jogadores.add(new Jogador("Giovanna Lima"));
        jogadores.add(new Jogador("Giovanna Pitel"));
        jogadores.add(new Jogador("Isabelle Nogueira"));
        jogadores.add(new Jogador("Juninho"));
        jogadores.add(new Jogador("Leidy Elin"));
        jogadores.add(new Jogador("Lucas Henrique"));
        jogadores.add(new Jogador("Lucas Luigi"));
        jogadores.add(new Jogador("Lucas Pizane"));
        jogadores.add(new Jogador("Marcus Vinicius"));
        jogadores.add(new Jogador ("Matteus Amaral"));
        jogadores.add(new Jogador ("Maycon Cosmer"));
        jogadores.add(new Jogador ("MC Bin Laden"));
        jogadores.add(new Jogador ("Michel Nogueira"));
        jogadores.add(new Jogador ("Nizam"));
        jogadores.add(new Jogador ("Raquele Cardozo"));
        jogadores.add(new Jogador ("Rodriguinho"));
        jogadores.add(new Jogador ("Thalyta Alves"));
        jogadores.add(new Jogador ("Vanessa Lopes"));
        jogadores.add(new Jogador ("Vinicius Rodrigues"));
        jogadores.add(new Jogador ("Wanessa Camargo"));
        jogadores.add(new Jogador ("Yasmin Brunet"));

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        //Repetição
        do {
            try {
                //Menu de opções
                System.out.println("\nVotação BBB - Modo Eliminação");
                System.out.println("---------------------------------");
                System.out.println("1- Em quem você vota");
                System.out.println("2- Apurar resultado");
                System.out.println("3- Sair");
                System.out.println("Escolha uma opção:");

                //Lendo a entrada
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException exception){
                System.err.println("Entrada inválida!" + exception.getMessage());
                scanner.nextLine(); //Limpa o buffer de entrada
            }

            //Switch dos casos
            switch (opcao){
                case 1:
                    votarEmParticipante(jogadores, scanner);
                    break;
                case 2:
                    apurarResultado(jogadores);
                    break;
                case 3:
                    System.out.println("Saindo do sistema de votação...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);
    }

    //Método para votar
    private static void votarEmParticipante(ArrayList<Jogador> jogadores, Scanner scanner){
        System.out.println("\nLista de participantes:");
        for (int i = 0; i < jogadores.size(); i++){
            System.out.println((i + 1) + "." + jogadores.get(i).getNome());
        }
        //Recebendo a entrada
        try {
            System.out.println("Digite o número do participante em que deseja votar para sair:");
            int numeroParticipante = scanner.nextInt() - 1;

            if (numeroParticipante >= 0 && numeroParticipante < jogadores.size()){
                jogadores.get(numeroParticipante).adicionarVotos();
                System.out.println("Voto registrado com sucesso para " + jogadores.get(numeroParticipante).getNome() + "!");
            } else {
                System.out.println("Número de participante inválido! Tente novamente.");
            }
        } catch (InputMismatchException e){
            System.err.println("ENTRADA INVÁLIDA! " + e.getMessage());
        }
    }

    //Método para exibir mais votado
    private static void apurarResultado(ArrayList<Jogador> jogadores){
        Jogador maisVotado = null;
        int maiorVotos = 0;

        for (Jogador jogador : jogadores){
            int votos = jogador.getVotos();
            if (votos > maiorVotos){
                maiorVotos = votos;
                maisVotado = jogador;
            }
        }
        if (maisVotado != null){
            System.out.println("Participante com mais votos para eliminação:");
            System.out.println("Nome: " + maisVotado.getNome());
            System.out.println("Votos: " + maisVotado.getVotos());
            System.out.println("Mensagem de eliminação:\n" +
                    "                    Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir\n" +
                    "                    domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu\n" +
                    "                    conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu\n" +
                    "                    vou conseguir te eliminar com alegria. Com " + maisVotado.getVotos() + " voto(s) é você quem sai, " + maisVotado.getNome() + "!"
            );
        } else {
            System.out.println("Ainda não há votos registrados.");
        }
    }
}
