import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Classe principal que estende JFrame e implementa ActionListener para lidar com eventos de botão
public class JogoForcaGUI extends JFrame implements ActionListener {

    // Declaração dos componentes da interface
    private JPanel painel = new JPanel(); // Painel para organizar os componentes
    private JLabel wordLabel, resultLabel; // Rótulos para exibir a palavra e o resultado
    private JTextField letterField; // Campo de texto para inserir as letras
    private JButton guessButton; // Botão para adivinhar a letra
    private String wordToGuess = "JAVA"; // Palavra a ser adivinhada
    private int attemptsLeft = 6; // Tentativas restantes
    private String guessedLetters = ""; // Letras adivinhadas
    private JLabel regra = new JLabel("Digite uma letra por vez para jogar"); // Rótulo para exibir a regra do jogo

    // Construtor da classe
    public JogoForcaGUI(){
        this.painel.setLayout(null); // Definindo layout absoluto para o painel
        this.setTitle("Jogo da Forca"); // Título da janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Comportamento ao fechar a janela
        this.setSize(400,300); // Tamanho da janela
        this.setLocationRelativeTo(null); // Centralizando a janela na tela
        this.setResizable(false); // Impedindo redimensionamento da janela
        this.painel.setLayout(null); // Definindo layout absoluto para o painel
        configurarComponentes(); // Configurando os componentes da interface

        this.getContentPane().add(painel); // Adicionando o painel ao JFrame

        this.setVisible(true); // Tornando a janela visível
    }

    // Método para configurar os componentes da interface
    public void configurarComponentes(){
        // Instanciando e configurando os componentes
        wordLabel = new JLabel(displayWord()); // Exibe a palavra a ser adivinhada
        resultLabel = new JLabel("Tentativas restantes: " + attemptsLeft); // Exibe o número de tentativas restantes
        letterField = new JTextField(1); // Campo de texto para inserir uma letra
        guessButton = new JButton("Adivinhar"); // Botão para adivinhar a letra
        guessButton.addActionListener(this); // Adicionando um ActionListener ao botão

        // Definindo as coordenadas e o tamanho dos componentes
        regra.setBounds(100, 20, 200, 30);
        wordLabel.setBounds(180, 60, 200, 30); // Centralizando horizontalmente com base na largura do painel
        resultLabel.setBounds(135, 140, 200, 30); // Centralizando horizontalmente com base na largura do painel
        letterField.setBounds(100, 100, 200, 30); // Centralizando horizontalmente com base na largura do painel
        guessButton.setBounds(150, 190, 100, 30); // Centralizando horizontalmente com base na largura do painel

        // Adicionando os componentes ao painel
        painel.add(wordLabel);
        painel.add(resultLabel);
        painel.add(letterField);
        painel.add(guessButton);
        painel.add(regra);
    }

    // Método para exibir a palavra oculta com traços para letras não adivinhadas
    private String displayWord(){
        StringBuilder displayedWord = new StringBuilder();
        for(char letter : wordToGuess.toCharArray()){
            if (guessedLetters.indexOf(letter) != -1){
                displayedWord.append(letter).append(" "); // Exibindo a letra se foi adivinhada
            } else {
                displayedWord.append("_").append(" "); // Exibindo um traço para letras não adivinhadas
            }
        }
        return displayedWord.toString();
    }

    // Método para lidar com eventos de botão
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) { // Verificando se o evento foi disparado pelo botão
            String letter = letterField.getText().toUpperCase(); // Obtendo a letra digitada pelo usuário em maiúsculas
            if (letter.length() == 1) { // Verificando se foi digitada apenas uma letra
                if (wordToGuess.contains(letter)) { // Verificando se a letra está na palavra a ser adivinhada
                    guessedLetters += letter; // Adicionando a letra às letras adivinhadas
                    wordLabel.setText(displayWord()); // Atualizando a exibição da palavra
                    if (!wordLabel.getText().contains("_")) { // Verificando se todas as letras foram adivinhadas
                        JOptionPane.showMessageDialog(null, "Parabéns! Você venceu!"); // Exibindo mensagem de vitória
                        guessButton.setEnabled(false); // Desabilitando o botão
                    }
                } else {
                    attemptsLeft--; // Reduzindo o número de tentativas restantes
                    resultLabel.setText("Tentativas restantes: " + attemptsLeft); // Atualizando o rótulo de tentativas restantes
                    if (attemptsLeft == 0) { // Verificando se as tentativas acabaram
                        JOptionPane.showMessageDialog(null, "Você perdeu! A palavra era " + wordToGuess); // Exibindo mensagem de derrota
                        guessButton.setEnabled(false); // Desabilitando o botão
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, insira apenas uma letra.", "Erro", JOptionPane.ERROR_MESSAGE); // Exibindo mensagem de erro se mais de uma letra foi digitada
            }
            letterField.setText(""); // Limpando o campo de texto
        }
    }

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        new JogoForcaGUI(); // Criando uma instância da classe JogoForcaGUI
    }
}
