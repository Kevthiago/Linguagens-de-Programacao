import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class LotoInterface extends JFrame{

    Scanner scn = new Scanner(System.in);
    Random rdn = new Random();

    //atributos
    private JPanel painel = new JPanel();
    private JButton buttonZeroCem = new JButton("Apostar 'de 0 a 100'");
    private JButton buttonLetra = new JButton("Apostar 'Letra Premiada'");
    private JButton buttonParImp = new JButton("Apostar em 'par ou ímpar'");
    private JTextField jTextFieldTexto = new JTextField("Teste", 20);


    //construtor
    public LotoInterface(){
        this.setTitle("Exemplo de Interface Gráfica");
        this.setSize(400,200);
        configurarComponentes();
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setVisible(true); // Exibir janela
        setLayout(new BorderLayout());
        setResizable(false); // Impede que a janela seja redimensionada pelo usuário
    }

    private void configurarComponentes(){
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255,255,255));
        jTextFieldTexto.setFont(new Font("Arial", Font.PLAIN, 16));
        painel.add(buttonZeroCem);
        painel.add(buttonLetra);
        painel.add(buttonParImp);
        this.getContentPane().add(painel);

        //funcionalidade
        buttonZeroCem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarNumero();
            }
        });
        buttonLetra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarLetra();
            }
        });
        buttonParImp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarParImpar();
            }
        });
    }

    //métodos
    public void apostarNumero() {
        try {
            JTextField textField = new JTextField(10); // Criando um JTextField para entrada de texto
            int option = JOptionPane.showConfirmDialog(null, textField, "Escolha um número entre 0 e 100:", JOptionPane.OK_CANCEL_OPTION);

            int numRandom = rdn.nextInt(101); // Gera um número aleatório entre 0 e 100
            int numLido = Integer.parseInt(textField.getText()); // Lê o texto do JTextField e converte para int
            if (numLido >= 0 && numLido <= 100) {
                if (numLido == numRandom) {
                    JOptionPane.showMessageDialog(null, "Parabéns, você ganhou R$1000,00!");
                } else {
                    JOptionPane.showMessageDialog(null, "Que pena. O número sorteado foi: " + numRandom);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aposta inválida! Deve ser um número entre 0 e 100.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao processar a aposta de número.");
        }
    }

    public void apostarLetra() {
        try {
            JTextField textField = new JTextField(10); // Criando um JTextField para entrada de texto
            int option = JOptionPane.showConfirmDialog(null, textField, "Escolha uma letra de A à Z:", JOptionPane.OK_CANCEL_OPTION);

            char letraPremiada = 'K';
            String texto = textField.getText().toUpperCase(); // Obtém o texto do JTextField e converte para maiúsculas
            if (texto.length() == 1 && Character.isLetter(texto.charAt(0))) { // Verifica se o texto tem apenas um caractere e se é uma letra
                char letra = texto.charAt(0); // Obtém o caractere digitado pelo usuário
                if (letra == letraPremiada) {
                    JOptionPane.showMessageDialog(null, "Parabéns! Você ganhou R$500,00.");
                } else {
                    JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraPremiada);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aposta inválida! Deve ser uma letra entre A e Z.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao processar a aposta de letra.");
        }
    }

    public void apostarParImpar() {
        try {
            JTextField textField = new JTextField(10); // Criando um JTextField para entrada de texto
            int option = JOptionPane.showConfirmDialog(null, textField, "Escolha um número inteiro aleatório:", JOptionPane.OK_CANCEL_OPTION);

            int num = Integer.parseInt(textField.getText()); // Lê o texto do JTextField e converte para int
            if (num % 2 == 0) {
                JOptionPane.showMessageDialog(null, "Parabéns! Você ganhou R$100,00.");
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! O número digitado é ímpar e a premiação foi para números pares.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao processar a aposta de par ou ímpar.");
        }
    }

    public static void main(String[] args) {
        new LotoInterface();
    }
}

