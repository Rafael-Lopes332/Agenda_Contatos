package View;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.List;

import Controller.ValidarContato;
import Controller.ContatoControle;
import View.InterfaceUsuario;

import java.awt.GridLayout;

import Model.Contato;

public class InterfaceEditarContato extends JDialog {

    private InterfaceUsuario interfacePrincipal;
    private ContatoControle controle;

    private JTextField txtNome, txtTelefone, txtEmail;
    private JButton btSalvar;
    private Contato contato;

    public InterfaceEditarContato(Contato contato, InterfaceUsuario interfacePrincipal, ContatoControle controle) {

        setTitle("Editar Contato");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        this.contato = contato;
        this.interfacePrincipal = interfacePrincipal;
        this.controle = controle;

        add(new JLabel("Nome:"));
        txtNome = new JTextField(contato.getNome());
        add(txtNome);

        add(new JLabel("Telefone:"));
        txtTelefone = new JTextField(contato.getTelefone());
        add(txtTelefone);

        add(new JLabel("Email:"));
        txtEmail = new JTextField(contato.getEmail());
        add(txtEmail);

        btSalvar = new JButton("Salvar");
        btSalvar.addActionListener(e -> salvarEdicao(contato));
        add(btSalvar);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    private void salvarEdicao(Contato contato) {
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String email = txtEmail.getText();

        if (controle.editarContato(nome, telefone, email)) {
            List<Contato> contatosAtualizados = controle.buscarTodosContatos();
            interfacePrincipal.atualizarTabela(contatosAtualizados);

            JOptionPane.showMessageDialog(this, "Contato Atualizado com sucesso!");

            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar contato!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

}
