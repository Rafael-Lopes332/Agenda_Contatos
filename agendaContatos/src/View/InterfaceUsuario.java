package View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controller.ContatoControle;
import Model.ArvoreBinaria;
import Model.Contato;

public class InterfaceUsuario {

    private ContatoControle controle;
    private ArvoreBinaria arvore;

    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;

    private JButton btEditar;

    private JTable tabelaContatos;

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

        JLabel lbExemploTelefone = new JLabel("Ex: (11) 91234-5678");
        lbExemploTelefone.setFont(new Font("Arial", Font.ITALIC, 12));
        lbExemploTelefone.setForeground(Color.GRAY);
        lbExemploTelefone.setBounds(430, 75, 200, 15);
        janela.add(lbExemploTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(430, 50, 210, 25);
        janela.add(txtTelefone);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setBounds(40, 80, 100, 30);
        janela.add(lbEmail);

        JLabel lbExemploEmail = new JLabel("Ex: nome@email.com");
        lbExemploEmail.setFont(new Font("Arial", Font.ITALIC, 12));
        lbExemploEmail.setForeground(Color.GRAY);
        lbExemploEmail.setBounds(40, 135, 200, 15);
        janela.add(lbExemploEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(40, 110, 270, 25);
        janela.add(txtEmail);

        String[] colunas = { "Nome", "Telefone", "Email" };
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaContatos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaContatos);
        scrollPane.setBounds(40, 170, 600, 200);

        tabelaContatos.setRowSelectionAllowed(true);
        tabelaContatos.setColumnSelectionAllowed(false);
        tabelaContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaContatos.getTableHeader().setReorderingAllowed(false);

        janela.add(scrollPane);

        tabelaContatos.getSelectionModel().addListSelectionListener(e -> {
            int linhaSelecionada = tabelaContatos.getSelectedRow();

            if (linhaSelecionada != -1) {
                String nome = (String) modeloTabela.getValueAt(linhaSelecionada, 0);
                String telefone = (String) modeloTabela.getValueAt(linhaSelecionada, 1);
                String email = (String) modeloTabela.getValueAt(linhaSelecionada, 2);

                txtNome.setText(nome);
                txtTelefone.setText(telefone);
                txtEmail.setText(email);

                btEditar.setEnabled(true);
            }
        });

        JButton btAdicionar = new JButton("Adicionar");
        btAdicionar.setBounds(40, 400, 100, 30);
        janela.add(btAdicionar);

        btAdicionar.addActionListener(e -> {
            String nome = txtNome.getText();
            String telefone = txtTelefone.getText();
            String email = txtEmail.getText();

            if (controle.adicionarContato(nome, telefone, email)) {
                modeloTabela.addRow(new Object[] { nome, telefone, email });

                limparCampos();
            }

        });

        JButton btBuscar = new JButton("Buscar");
        btBuscar.setBounds(190, 400, 100, 30);
        janela.add(btBuscar);

        btBuscar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String telefone = txtTelefone.getText().trim();
            String email = txtEmail.getText().trim();

            Contato contato = null;

            if (!nome.isEmpty()) {
                contato = controle.buscarPorNome(nome);
            } else if (!telefone.isEmpty()) {
                contato = controle.buscarPorTelefone(telefone);
            } else if (!email.isEmpty()) {
                contato = controle.buscarPorEmail(email);
            } else {
                JOptionPane.showMessageDialog(null, "Digite nome, telefone ou email para buscar.");
                return;
            }

            if (contato != null) {
                txtNome.setText(contato.getNome());
                txtTelefone.setText(contato.getTelefone());
                txtEmail.setText(contato.getEmail());
            } else {
                JOptionPane.showMessageDialog(null, "Contato não encontrado.");
            }
        });

        btEditar = new JButton("Editar");
        btEditar.setBounds(390, 400, 100, 30);
        janela.add(btEditar);

        btEditar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String novoTelefone = txtTelefone.getText().trim();
            String novoEmail = txtEmail.getText().trim();

            controle.editarContato(nome, novoTelefone, novoEmail);

            atualizarTabela(controle.buscarTodosContatos());

            limparCampos();
        });

        JButton btExcluir = new JButton("Excluir");
        btExcluir.setBounds(540, 400, 100, 30);
        janela.add(btExcluir);

        String[] opcoes = { "Em ordem", "Pré-ordem", "Pós-ordem" };
        JComboBox<String> comboBusca = new JComboBox<>(opcoes);
        comboBusca.setBounds(430, 105, 210, 30);
        janela.add(comboBusca);

        comboBusca.addActionListener(e -> {
            String ordem = (String) comboBusca.getSelectedItem();
            List<Contato> contatos = new ArrayList<>();

            switch (ordem) {
                case "Em ordem":
                    contatos = controle.exibirContatosEmOrdem();
                    break;

                case "Pré-ordem":
                    contatos = controle.exibirContatosPreOrdem();
                    break;

                case "Pós-ordem":
                    contatos = controle.exibirContatosPosOrdem();
                    break;
            }

            atualizarTabela(contatos);

        });

        janela.setVisible(true);

    }

    private void limparCampos() {
        txtNome.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
    }

    private void atualizarTabela(List<Contato> contatos) {

        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaContatos.getModel();
        modeloTabela.setRowCount(0);

        for (Contato contato : contatos) {
            modeloTabela.addRow(new Object[] { contato.getNome(), contato.getTelefone(), contato.getEmail() });
        }
    }

}
