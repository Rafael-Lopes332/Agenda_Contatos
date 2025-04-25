package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.ContatoControle;
import Model.ArvoreBinaria;

public class InterfaceUsuario {

    private ContatoControle controle;
    private ArvoreBinaria arvore;

    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;

    public InterfaceUsuario(ContatoControle controle, ArvoreBinaria arvore) {
        this.controle = controle;
        this.arvore = arvore;
        configurarInterface();
    }

    private void configurarInterface() {
        JFrame janela = new JFrame("Agenda de Contatos");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        janela.setSize(700, 500);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.setLayout(null);

        JLabel lbNome = new JLabel("Nome");
        lbNome.setBounds(40, 15, 100, 30);
        janela.add(lbNome);

        txtNome = new JTextField();
        txtNome.setBounds(40, 50, 270, 25);
        janela.add(txtNome);

        JLabel lbTelefone = new JLabel("Telefone");
        lbTelefone.setBounds(430, 15, 100, 30);
        janela.add(lbTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(430, 50, 210, 25);
        janela.add(txtTelefone);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setBounds(40, 80, 100, 30);
        janela.add(lbEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(40, 110, 270, 25);
        janela.add(txtEmail);

        JTextArea area = new JTextArea();

        area.setBounds(40, 170, 600, 200);
        area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        area.setEditable(false);

        janela.add(area);

        JButton btAdicionar = new JButton("Adicionar");
        btAdicionar.setBounds(40, 400, 100, 30);
        janela.add(btAdicionar);

        btAdicionar.addActionListener(e -> {
            String nome = txtNome.getText();
            String telefone = txtTelefone.getText();
            String email = txtEmail.getText();

            controle.adicionarContato(nome, telefone, email);

            atualizarAreaDeTexto(area);
        });

        JButton btBuscar = new JButton("Buscar");
        btBuscar.setBounds(190, 400, 100, 30);
        janela.add(btBuscar);

        JButton btEditar = new JButton("Editar");
        btEditar.setBounds(390, 400, 100, 30);
        janela.add(btEditar);

        JButton btExcluir = new JButton("Excluir");
        btExcluir.setBounds(540, 400, 100, 30);
        janela.add(btExcluir);

        String[] opcoes = { "Em ordem", "Pré-ordem", "Pós-ordem" };
        JComboBox<String> comboBusca = new JComboBox<>(opcoes);
        comboBusca.setBounds(430, 105, 210, 30);
        janela.add(comboBusca);

        comboBusca.addActionListener(e -> {
            String ordem = (String) comboBusca.getSelectedItem();
            String resultado = "";

            switch (ordem) {
                case "Em ordem":
                    resultado = controle.exibirContatosEmOrdem();
                    break;

                case "Pré-ordem":
                    resultado = controle.exibirContatosPreOrdem();
                    break;

                case "Pós-ordem":
                    resultado = controle.exibirContatosPosOrdem();
                    break;
            }

            area.setText(resultado);

        });

        janela.setVisible(true);

    }

    private void atualizarAreaDeTexto(JTextArea area) {
        area.setText(controle.exibirContatosEmOrdem());
    }

    private void limparCampos() {
        txtNome.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
    }

}
