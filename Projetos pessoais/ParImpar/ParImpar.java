import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = 0, par = 0, imp = 0, soma = 0;
        while(num != -1){
            System.out.println("Digite um número ou '-1' para finalizar: ");
            num = scn.nextInt();
            if (num != -1)
                if (num %2 == 0)
                    par++;
                else
                    imp++;
        }
        soma = par + imp;
        System.out.println("A quantidade de pares é: " + par);
        System.out.println("A quantidade de ímpares é: " + imp);
        System.out.println("A quantidade total de números é: " + soma);
    }
}
