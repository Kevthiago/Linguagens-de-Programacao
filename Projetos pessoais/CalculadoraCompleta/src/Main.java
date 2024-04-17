import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    // Declaração dos componentes da interface do usuário
    private JPanel painel = new JPanel(); // Painel que contém todos os componentes
    private JTextField caixaDeTexto = new JTextField(" "); // Caixa de texto para exibir os números e resultados
    private JButton buttonClean = new JButton("Limpar"); // Botão para limpar a caixa de texto
    private JButton buttonDelete = new JButton("Delete"); // Botão para deletar o último caractere da caixa de texto
    private JButton[] botoesNumericos = new JButton[10]; // Array para armazenar os botões numéricos de 0 a 9
    private JButton buttonMais = new JButton("+"); // Botão para adição
    private JButton buttonMenos = new JButton("-"); // Botão para subtração
    private JButton buttonMult = new JButton("*"); // Botão para multiplicação
    private JButton buttonDiv = new JButton("/"); // Botão para divisão
    private JButton buttonIgual = new JButton("="); // Botão para mostrar o resultado da operação
    private JButton buttonPerCent = new JButton("%"); // Botão para calcular a porcentagem
    private JLabel rodape = new JLabel("Criado por Kevin para fins de estudo.");
    public Main(){
        // Configurações da janela principal
        this.setTitle("Calculadora");
        this.setSize(479,450);
        configurarComponentes();
        this.setVisible(true);
        this.setResizable(false);
    }

    public void configurarComponentes(){
        // Configurações do painel
        painel.setLayout(null);
        painel.setBackground(new Color(0xABABBD));

        caixaDeTexto.setHorizontalAlignment(SwingConstants.RIGHT); // Alinhar o texto à direita na caixa de texto
        caixaDeTexto.setBounds(20,30, 420, 50); // Define a posição e o tamanho da caixa de texto
        caixaDeTexto.setBorder(BorderFactory.createLineBorder(new Color(0x34495E))); // Cor da borda da caixa de texto
        caixaDeTexto.setFont(new Font("Arial", Font.PLAIN, 20)); // Fonte da caixa de texto
        caixaDeTexto.setEditable(false);

        // Adiciona o rodapé
        rodape.setHorizontalAlignment(SwingConstants.CENTER); // Alinhamento centralizado
        rodape.setBounds(20, 385, 420, 20); // Posicionamento na parte inferior
        rodape.setFont(new Font("Arial", Font.PLAIN, 10));

        // Adiciona a caixa de texto ao painel
        painel.add(caixaDeTexto);

        // Adiciona os botões "Limpar" e "Deletar" ao painel
        buttonClean.setBounds(20, 100, 100, 50);
        buttonClean.setBackground(new Color(0xFF0000)); // Cor de fundo do botão Limpar
        buttonClean.setForeground(Color.WHITE); // Cor do texto do botão Limpar
        painel.add(buttonClean);
        buttonClean.setFont(new Font("Arial", Font.BOLD, 14)); // Define a fonte do botão Limpar

        buttonDelete.setBounds(125, 100, 100, 50);
        buttonDelete.setBackground(new Color(0xFFD500)); // Cor de fundo do botão Delete
        buttonDelete.setForeground(Color.WHITE); // Cor do texto do botão Limpar
        painel.add(buttonDelete);
        buttonDelete.setFont(new Font("Arial", Font.BOLD, 14)); // Define a fonte do botão Delete

        // Adiciona os botões numéricos de 0 a 9 ao painel
        for (int i = 1; i <= 9; i++) {
            botoesNumericos[i] = new JButton(Integer.toString(i));
            botoesNumericos[i].setBounds(20 + ((i - 1) % 3) * 105, 155 + ((i - 1) / 3) * 55, 100, 50);
            botoesNumericos[i].setFont(new Font("Arial", Font.BOLD, 14)); // Define a fonte dos botões numéricos
            painel.add(botoesNumericos[i]);
            adicionarListener(botoesNumericos[i]); // Adiciona um ouvinte de ação aos botões numéricos
        }
        botoesNumericos[0] = new JButton("0");
        botoesNumericos[0].setBounds(125, 320, 100, 50);
        botoesNumericos[0].setFont(new Font("Arial", Font.BOLD, 14)); // Define a fonte dos botões numéricos
        painel.add(botoesNumericos[0]);
        adicionarListener(botoesNumericos[0]);

        // Adiciona os botões de operação (+, -, *, /) e de igualdade (=) ao painel
        buttonDiv.setBounds(340, 100, 100, 50);
        buttonDiv.setFont(new Font("Arial", Font.BOLD, 14));

        buttonPerCent.setBounds(230, 100, 100, 50);
        buttonPerCent.setFont(new Font("Arial", Font.BOLD, 14));

        buttonMais.setBounds(340, 155, 100, 50);
        buttonMais.setFont(new Font("Arial", Font.BOLD, 14));

        buttonMenos.setBounds(340, 210, 100, 50);
        buttonMenos.setFont(new Font("Arial", Font.BOLD, 14));

        buttonMult.setBounds(340, 265, 100, 50);
        buttonMult.setFont(new Font("Arial", Font.BOLD, 14));

        buttonIgual.setBounds(340, 320, 100, 50);
        buttonIgual.setFont(new Font("Arial", Font.BOLD, 14));

        buttonIgual.setBackground(new Color(0x1ABC9C));
        buttonIgual.setForeground(Color.WHITE);

        painel.add(buttonMais);
        painel.add(buttonMenos);
        painel.add(buttonMult);
        painel.add(buttonDiv);
        painel.add(buttonPerCent);
        painel.add(buttonIgual);
        painel.add(rodape);

        // Adiciona um ouvinte de ação aos botões de operação e ao botão de porcentagem
        adicionarListener(buttonDiv);
        adicionarListener(buttonIgual);
        adicionarListener(buttonMais);
        adicionarListener(buttonMenos);
        adicionarListener(buttonMult);
        adicionarListener(buttonPerCent);

        this.getContentPane().add(painel);

        // Funções de limpeza e exclusão de caracteres da caixa de texto
        buttonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caixaDeTexto.setText(""); // Limpa a caixa de texto
            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoAtual = caixaDeTexto.getText();
                if (!textoAtual.isEmpty()){
                    String novoTexto = textoAtual.substring(0, textoAtual.length() - 1); // Remove o último caractere
                    caixaDeTexto.setText(novoTexto);
                }
            }
        });

    }

    // Método para adicionar um ouvinte de ação a um botão
    private void adicionarListener(JButton botao) {
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoAtual = caixaDeTexto.getText(); // Obtém o texto atual na caixa de texto
                String textoBotao = botao.getText(); // Obtém o texto do botão clicado
                caixaDeTexto.setText(textoAtual + textoBotao); // Adiciona o texto do botão ao texto atual na caixa de texto
            }
        });
    }

    // Método principal para executar o programa
    public static void main(String[] args) {
        new Main(); // Cria uma instância da classe Main ao iniciar o programa
    }
}
