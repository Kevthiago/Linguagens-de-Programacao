import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaGUI extends JFrame {

    private JPanel painel = new JPanel();
    private JLabel titulo = new JLabel("BEM VINDO(A) A AGENDA DE CONTATOS");
    private JButton adicionar = new JButton("Adicionar Contatos");
    private JButton remover = new JButton("Remover Contatos");
    private JButton listar = new JButton("Listar Contatos");

    public AgendaGUI(){
        this.setTitle("Agenda Pessoal de Contatos");
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.configurarComponentes();
        this.getContentPane().add(painel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void configurarComponentes(){
        painel.setLayout(new GridLayout(4, 1, 100, 10));
        painel.setBackground(Color.WHITE);

        titulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        painel.add(titulo);
        painel.add(listar);
        painel.add(adicionar);
        painel.add(remover);

        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarContatos();
            }
        });

        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarContato();
            }
        });

        remover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerContato();
            }
        });
    }

    public void adicionarContato() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do contato:");
        if (nome != null) {
            String telefone = JOptionPane.showInputDialog(null, "Digite o telefone do contato:");
            String endereco = JOptionPane.showInputDialog(null, "Digite o endereço do contato:");
            Agenda.adicionarContato(nome, telefone, endereco);
            JOptionPane.showMessageDialog(null,"Novo contato adicionado!");
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
    }

    public void removerContato() {
        if (!Agenda.contatosList.isEmpty()) {
            String input = JOptionPane.showInputDialog(null, "Digite o índice do contato a excluir:");
            if (input != null) {
                try {
                    int indice = Integer.parseInt(input);
                    Agenda.excluirContato(indice);
                    JOptionPane.showMessageDialog(null,"Contato excluido!");
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um índice existente na Lista de Contatos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista vazia! Não há contatos para excluir.");
        }
    }

    public void listarContatos() {
        if (!Agenda.contatosList.isEmpty()) {
            StringBuilder mensagem = new StringBuilder();
            for (Contatos contato : Agenda.contatosList) {
                mensagem.append(contato).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensagem.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Lista vazia.");
        }
    }

    public static void main(String[] args) {
        new AgendaGUI();
    }
}
