// Importações necessárias para utilizar componentes Swing e funcionalidades de eventos e geradores de números aleatórios
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

// Classe principal que estende JFrame para criar a interface gráfica do jogo Monty Hall
public class MontyHallGUI extends JFrame{

    // Declaração de variáveis para armazenar informações sobre as portas escolhidas e premiadas
    int portaEscolhida, portaVazia, portaPremiada, portaOriginal;
    Random rdn = new Random(); // Objeto Random para gerar números aleatórios

    // Declaração de componentes Swing
    private JPanel painel = new JPanel(); // Painel que contém os componentes
    private JButton jogar = new JButton("Jogar"); // Botão para iniciar o jogo
    private JLabel titulo1 = new JLabel("Bem vindo(a) ao jogo Monty Hall!"); // Rótulo de boas-vindas

    // Construtor da classe MontyHallGUI
    public MontyHallGUI(){
        // Configurações iniciais da janela
        this.setTitle("Monty Hall");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null); // Centraliza a janela na tela
        this.setVisible(true); // Exibe a janela
        this.setLayout(new BorderLayout());
        this.setResizable(false); // Impede que a janela seja redimensionada pelo usuário
        configurarComponentes(); // Configura os componentes Swing
    }

    // Método para configurar os componentes Swing
    private void configurarComponentes(){
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20)); // Define o layout do painel
        painel.setBackground(new Color(93, 143, 224)); // Define a cor de fundo do painel
        painel.add(titulo1); // Adiciona o rótulo de boas-vindas ao painel
        painel.add(jogar); // Adiciona o botão "Jogar" ao painel
        this.getContentPane().add(painel); // Adiciona o painel à janela

        // Define a ação a ser executada quando o botão "Jogar" é clicado
        jogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                escolherPorta(); // Chama o método para o jogador escolher uma porta
            }
        });
    }

    // Método para permitir que o jogador escolha uma porta
    public void escolherPorta(){
        // Exibe um diálogo de entrada para que o jogador escolha uma porta
        String entrada = JOptionPane.showInputDialog(null, "Escolha uma porta (1, 2 ou 3):");

        try {
            portaEscolhida = Integer.parseInt(entrada); // Converte a entrada do jogador para um número inteiro

            // Verifica se a entrada do jogador está dentro dos limites permitidos (1, 2 ou 3)
            if (portaEscolhida < 1 || portaEscolhida > 3){
                // Exibe uma mensagem de erro se a entrada do jogador for inválida
                JOptionPane.showMessageDialog(null, "Entrada inválida. Escolha entre (1, 2 ou 3)!");
                jogar.setVisible(true); // Torna o botão "Jogar" visível novamente para permitir outra tentativa
            } else {
                // Escolhe aleatoriamente uma porta premiada e uma porta vazia
                portaPremiada = rdn.nextInt(3) + 1;
                do {
                    portaVazia = rdn.nextInt(3) + 1;
                } while (portaVazia == portaPremiada || portaVazia == portaEscolhida);
                // Exibe uma mensagem informando que o apresentador abriu uma porta vazia
                JOptionPane.showMessageDialog(null, "O apresentador abriu a porta " + portaVazia + " , que está vazia.");
                opcaoTroca(); // Chama o método para oferecer a opção de trocar de porta
            }
        } catch (NumberFormatException ex) {
            // Exibe uma mensagem de erro se a entrada do jogador não for um número válido
            JOptionPane.showMessageDialog(null, "Entrada inválida. Digite um número.");
            jogar.setVisible(true); // Torna o botão "Jogar" visível novamente para permitir outra tentativa
        }
    }

    // Método para oferecer ao jogador a opção de trocar de porta
    public void opcaoTroca(){
        // Exibe um diálogo de confirmação para perguntar se o jogador deseja trocar de porta
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja trocar a porta " + portaEscolhida + " pela outra disponível, porta " + portaPremiada + "?", "Trocar de porta", JOptionPane.YES_NO_OPTION);

        boolean trocarPorta = (opcao == JOptionPane.YES_OPTION);

        // Armazena a porta original escolhida pelo jogador
        portaOriginal = portaEscolhida;

        if (trocarPorta) {
            // Escolhe aleatoriamente outra porta diferente da porta vazia e da porta original
            do {
                portaEscolhida = rdn.nextInt(3) + 1;
            } while (portaEscolhida == portaVazia || portaEscolhida == portaOriginal);
            // Exibe uma mensagem informando que o apresentador abriu uma porta vazia
            JOptionPane.showMessageDialog(null, "O apresentador abriu a porta " + portaVazia + " , que está vazia.");
        }

        // Determina o resultado final do jogo e exibe uma mensagem ao jogador
        if (portaEscolhida == portaPremiada) {
            JOptionPane.showMessageDialog(null, "Parabéns, você ganhou!");
        } else {
            JOptionPane.showMessageDialog(null, "Você perdeu! A porta premiada era: " + portaPremiada);
        }

        // Exibe informações sobre as portas escolhidas e o resultado final do jogo
        System.out.println("\nPorta premiada: " + portaPremiada);
        System.out.println("Porta vazia: " + portaVazia);
        System.out.println("Porta escolhida: " + portaEscolhida);
        System.out.println("Porta escolhida originalmente: " + portaOriginal);
    }

    // Método main para iniciar o programa
    public static void main(String[] args) {
        new MontyHallGUI(); // Cria uma instância da classe MontyHallGUI para iniciar o jogo
    }
}
