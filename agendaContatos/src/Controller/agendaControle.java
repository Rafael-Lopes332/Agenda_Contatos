package Controller;

import javax.swing.JOptionPane;

import Model.ArvoreBinaria;
import Model.Contato;
import Controller.ValidarContato;

public class AgendaControle {

    private ArvoreBinaria arvore;

    public AgendaControle() {
        this.arvore = new ArvoreBinaria();
    }

    public void adicionarContato(String nome, String telefone, String email) {
        try {
            if (!ValidarContato.telefoneValido(telefone)) {
                JOptionPane.showMessageDialog(null, "Telefone inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!ValidarContato.emailValido(email)) {
                JOptionPane.showMessageDialog(null, "Email inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (ValidarContato.contatoExiste(telefone, email, arvore)) {
                JOptionPane.showMessageDialog(null, "Contato já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Contato novoContato = new Contato(nome, telefone, email);
            arvore.inserirContato(novoContato);

            JOptionPane.showMessageDialog(null, "Contato Adicionado com Sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IllegalArgumentException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public Contato buscarPorNome(String nome) {
        return arvore.buscarPorNome(nome);
    }

    public Contato buscarPorTelefone(String telefone) {
        return arvore.buscarPorTelefone(telefone);
    }

    public Contato buscarPorEmail(String email) {
        return arvore.buscarPorEmail(email);
    }

    public String exibirContatosEmOrdem() {
        StringBuilder sb = new StringBuilder();

        if (arvore.getRaiz() == null) {
            sb.append("Nenhum contato cadastrado.");
        } else {
            arvore.exibirEmOrdem(arvore.getRaiz(), sb);
        }

        return sb.toString();
    }

}
