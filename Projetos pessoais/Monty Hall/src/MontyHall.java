import java.util.Scanner;
import java.util.Random;

public class MontyHall {
    public static void main(String[] args) {
        //atributos
        Scanner scn = new Scanner(System.in);
        Random rdn = new Random();
        int portaEscolhida, portaVazia, portaPremiada, portaOriginal;

        //inicio
        System.out.println("Bem vindo(a) ao jogo Monty Hall!");
        System.out.println("Escolha uma porta (1, 2 ou 3):");
        portaEscolhida = scn.nextInt();

        //verificar a entrada
        if (portaEscolhida < 1 || portaEscolhida > 3){
            System.out.println("Entrada inválida. Escolha entre (1, 2 ou 3)!");
        } else {
            //porta premiada aleatoriamente
            portaPremiada = rdn.nextInt(3) + 1;

            //porta vazia aleatoriamente
            do {
                portaVazia = rdn.nextInt(3) + 1;
            } while (portaVazia == portaPremiada || portaVazia == portaEscolhida);
            System.out.println("O apresentador abriu a porta " + portaVazia + " , que está vazia.");

            //oferecer opção de troca de porta
            System.out.println("Deseja trocar a porta " + portaEscolhida + " pela outra disponível, porta " + portaPremiada + "?");
            System.out.println("Digite (s) para trocar ou (n) para continuar com a porta original:");
            String opcao = scn.next();
            boolean trocarPorta = opcao.equalsIgnoreCase("s");

            //verificando a entrada
            if (opcao.equalsIgnoreCase("s")){
                trocarPorta = true;
            } else if (opcao.equalsIgnoreCase("n")){
                trocarPorta = false;
            } else {
                System.out.println("Comando errado. Continuando com a porta original...");
                trocarPorta = false;
            }

            //determinando a nova escolha
            portaOriginal = portaEscolhida;

            if (trocarPorta){
                do {
                    portaEscolhida = rdn.nextInt(3) + 1;
                } while (portaEscolhida == portaVazia || portaEscolhida == portaOriginal);
                System.out.println("O apresentador abriu a porta " + portaVazia + " , que está vazia.");
            }

            //determinando o resultado final
            if (portaEscolhida == portaPremiada){
                System.out.println("Parabéns, você ganhou!");
            } else {
                System.out.println("Você perdeu! A porta premiada era: " + portaPremiada);
            }

            //resultado final
            System.out.println("\nPorta premiada: " + portaPremiada);
            System.out.println("Porta vazia: " + portaVazia);
            System.out.println("Porta escolhida: " + portaEscolhida);
            System.out.println("Porta escolhida originalmente: " + portaOriginal);
        }
    }
}
