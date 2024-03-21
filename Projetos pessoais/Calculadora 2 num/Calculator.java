import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        //DECLARAÇÃO E INICIALIZAÇÃO DAS VARIÁVEIS
        int num1 = 0, num2 = 0, calc = 0, op = 0;

        //BOOLEAN PARA VERIFICAR A ENTRADA
        boolean entradaValida = false;

        while (!entradaValida){ //VERIFICA A ENTRADA
            try {
                System.out.println("Digite o primeiro número: ");
                num1 = scn.nextInt();

                System.out.println("Escolha a operação:" +
                        "\n1-Soma\n2-Subtração\n3-Multiplicação\n4-Divisão\n" +
                        "Digite o código da operação: ");
                op = scn.nextInt();

                System.out.println("Digite o segundo número: ");
                num2 = scn.nextInt();

                entradaValida = true; //BOOLEAN COMO TRUE PARA SAIR DO LOOP DE VERIFICAÇÃO

            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida." + e.getMessage()); //MENSAGEM DE ERRO
                scn.nextLine(); //LIMPA O BUFFER DA ENTRADA
            }
        }
        try {
            switch (op) {
                case 1:
                    op = 1;
                    calc = num1 + num2;
                    break;
                case 2:
                    op = 2;
                    calc = num1 - num2;
                    break;
                case 3:
                    op = 3;
                    calc = num1 * num2;
                    break;
                case 4:
                    op = 4;
                    calc = num1 / num2;
                    break;
                default:
                    System.out.println("Comando inválido. Reinicie!");
            }
        } catch (ArithmeticException e) { //VERIFICA EXCESSÕES POR ERRO ARITIMÉTICO, COMO DIVISÃO POR ZERO
            System.err.println("\nOperação inválida." + e.getMessage()); //MENSAGEM DE ERRO
        }
        System.out.println( "Resultado da operação: "+ calc);
    }
}
