import java.util.Scanner;
import java.util.Random;
public class Lotofacil {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rdn = new Random();

        int opcao = 0;

        try {
            do {
                //Criação do Menu Lotofacil
                System.out.println("**********************************");
                System.out.println("MENU LOTOFÁCIL");
                System.out.println("1) Apostar de 0 a 100: ");
                System.out.println("2) Apostar de A a Z: ");
                System.out.println("3) Apostar em par ou ímpar: ");
                System.out.println("0) Sair ");
                System.out.println("**********************************");
                System.out.println("Escolha uma opção: ");
                opcao = scn.nextInt();

                switch (opcao) {
                    case 1:
                        int numLido = 0, numRandom = 0;
                        numRandom = rdn.nextInt(101); //gera um número aleatório entre 0 e 100
                        System.out.println("Escolha um número entre 0 e 100: ");
                        numLido = scn.nextInt();

                        if (numLido >= 0 && numLido <= 100) {
                            if (numLido == numRandom) {
                                System.out.println("Parabéns, você ganhou R$1000,00!");
                            }
                            else {
                                System.out.println("Que pena. O número sorteado foi: " + numRandom);
                            }
                        } else {
                            System.out.println("Aposta inválida! Deve ser um número entre 0 e 100.");
                        }
                        break;
                    case 2:
                        char letraPremiada = 'K'; //Letra premiada
                        char letra;
                        System.out.println("Escolha uma letra de A à Z");
                        letra = (char) Character.toUpperCase(System.in.read());
                        if (Character.isLetter((char) letra)){
                            if (letra == letraPremiada){
                                System.out.println("Parabéns! Você ganhou R$500,00.");
                            }else{
                                System.out.println("Que pena! A letra sorteada foi: " + letraPremiada);
                            }
                        } else {
                            System.out.println("Aposta inválida! Deve ser uma letra entre A e Z.");
                        }
                        break;
                    case 3:
                        int num = 0;
                        System.out.println("Escolha um número inteiro aleatório: ");
                        num = scn.nextInt();
                        if (num % 2 == 0){
                            System.out.println("Parabéns! Você ganhou R$100,00.");
                        } else {
                            System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Comando inválido!");
                }
            } while (opcao != 0);
        } catch (Exception e){}
    }
}
