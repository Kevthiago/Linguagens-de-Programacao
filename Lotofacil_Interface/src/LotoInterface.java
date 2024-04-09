import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LotoInterface extends JFrame {

    Random rdn = new Random();

    //atributos
    private JPanel painel = new JPanel();
    private JButton buttonZeroCem = new JButton("Apostar 'de 0 a 100'");
    private JButton buttonLetra = new JButton("Apostar 'Letra Premiada'");
    private JButton buttonParImp = new JButton("Apostar em 'par ou ímpar'");
    ImageIcon icon = new ImageIcon(getClass().getResource("img/fortune-wheel.png")); // Ajuste o caminho conforme a localização real da sua imagem
    JLabel imageLabel = new JLabel(icon);

    //construtor
    public LotoInterface() {
        this.setTitle("Lotofácil");
        this.setSize(450, 200);
        configurarComponentes();
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setVisible(true); // Exibir janela
        setResizable(false); // Impede que a janela seja redimensionada pelo usuário
    }

    private void configurarComponentes() {
        painel.setLayout(null); // Usando layout nulo para poder definir manualmente as posições dos componentes
        painel.setBackground(new Color(255, 255, 255));

        // Definindo as posições e tamanhos dos componentes
        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon imgRedimensionada = new ImageIcon(img);
        imageLabel = new JLabel(imgRedimensionada);
        buttonZeroCem.setBounds(200, 20, 200, 30); // Ajuste as coordenadas conforme necessário
        buttonLetra.setBounds(200, 60, 200, 30); // Ajuste as coordenadas conforme necessário
        buttonParImp.setBounds(200, 100, 200, 30); // Ajuste as coordenadas conforme necessário
        imageLabel.setBounds(40, 25, 100, 100); // Ajuste as coordenadas conforme necessário

        // Adicionando os componentes ao painel
        painel.add(buttonZeroCem);
        painel.add(buttonLetra);
        painel.add(buttonParImp);
        painel.add(imageLabel);

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

    // métodos de apostas...

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
