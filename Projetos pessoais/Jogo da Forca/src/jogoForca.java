import java.util.InputMismatchException;
import java.util.Scanner;

public class jogoForca {
    public static void main(String[] args) {
        //atributos
        String palavraPremiada = "ARVORE"; //Definindo uma palavra premiada
        String palavraEscondida = esconderPalavra(palavraPremiada); //Esconendo a palavra com o método
        int tentativas = 6; //Quantidades de tentativas
        Scanner scanner = new Scanner(System.in); //Criando um Scanner
        int totalLetras = contarLetras(palavraPremiada); //Contando letras da palavra premiada

        //menu
        System.out.println("----------------------------");
        System.out.println("BEM VINDO AO JOGO DA FORCA!");
        System.out.println("A palavra tem: " + totalLetras + " letras.");
        System.out.println("----------------------------");

        //condicional
        do {
            try {
                System.out.println("Palavra: " + palavraEscondida);
                System.out.println("Tentativas restantes: " + tentativas);
                System.out.println("Escolha uma letra:");
                char letraEscolhida = scanner.nextLine().toUpperCase().charAt(0); //Lendo o caracter do usuário com o scanner e convertendo para maiúsculo
                if (Character.isLetter((letraEscolhida))){ //Conferindo SE é uma letra
                    if (palavraPremiada.contains(String.valueOf(letraEscolhida))) { //Conferindo se a palavra premiada contém a letra
                        palavraEscondida = relevarLetra(palavraPremiada, palavraEscondida, letraEscolhida); //Revelando onde está a letra
                        System.out.println("Letra encontrada!");
                    } else {
                        System.out.println("Letra não encontrada. Tente novamente!");
                        tentativas--; //Decrementando a quantidade de tentativas
                    }
                } else {
                    throw new InputMismatchException("Caracter inválido! Entre com letras de 'A' a 'Z'.");
                }
            } catch (Exception e){ //Exceção para entrada inválida
                System.err.println(e.getMessage());;
            }
        }while (tentativas > 0); //Limite de tentativas para funcionanamento
        System.err.println("Suas tentativas acabaram!");
        System.err.println("A palavra era: " + palavraPremiada);
    }

    //método para contar as letras da palavra
    public static int contarLetras(String texto){
        int contador = 0;
        for (int i = 0; i < texto.length(); i++){
            if (Character.isLetter(texto.charAt(i))){
                contador++;
            }
        }
        return contador;
    }

    //método para esconder palavra
    public static String esconderPalavra(String palavra){
        StringBuilder escondida = new StringBuilder();
        for (int i = 0; i < palavra.length(); i++){
            escondida.append("-");
        }
        return escondida.toString();
    }

    //método para relevar letras
    public static String relevarLetra(String palavra, String palavraEscondida, char letra){
        StringBuilder novaPalavraEscondida = new StringBuilder(palavraEscondida);
        for (int i = 0; i < palavra.length(); i++){
            if (palavra.charAt(i) == letra){
                novaPalavraEscondida.setCharAt(i, letra);
            }
        }
        return novaPalavraEscondida.toString();
    }
}
