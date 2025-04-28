package Controller;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

import Model.ArvoreBinaria;
import Model.Contato;

public class ContatoControle {

    private ArvoreBinaria arvore;

    public ContatoControle() {
        this.arvore = new ArvoreBinaria();
    }

    public boolean adicionarContato(String nome, String telefone, String email) {

        if (nome.trim().isEmpty() || telefone.trim().isEmpty() || email.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preeenchidos!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!ValidarContato.telefoneValido(telefone)) {
            JOptionPane.showMessageDialog(null, "Telefone inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!ValidarContato.emailValido(email)) {
            JOptionPane.showMessageDialog(null, "Email inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (ValidarContato.contatoExiste(telefone, email, arvore)) {
            JOptionPane.showMessageDialog(null, "Contato já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Contato novoContato = new Contato(nome, telefone, email);
        arvore.inserirContato(novoContato);

        JOptionPane.showMessageDialog(null, "Contato Adicionado com Sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);

        return true;
    }

    public boolean editarContato(String nome, String novoTelefone, String novoEmail) {
        Contato contatoEncontrado = arvore.buscarPorNome(nome);

        if (contatoEncontrado != null) {

            if (!ValidarContato.telefoneValido(novoTelefone)) {

                JOptionPane.showMessageDialog(null, "Telefone inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (!ValidarContato.emailValido(novoEmail)) {
                JOptionPane.showMessageDialog(null, "Email inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (ValidarContato.contatoExiste(novoTelefone, novoEmail, arvore, contatoEncontrado)) {
                JOptionPane.showMessageDialog(null, "Contato já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            contatoEncontrado.setTelefone(novoTelefone);
            contatoEncontrado.setEmail(novoEmail);

                    return true;
        } else {
            JOptionPane.showMessageDialog(null, "Contato não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);

            return false;
        }
    }

    public boolean removerContato(String nome) {
        Contato Cont = buscarPorNome(nome);
        if (Cont == null) {
            JOptionPane.showMessageDialog(null, "Contato: " + Cont + " não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        arvore.removerContato(nome);
        JOptionPane.showMessageDialog(null,"Contato: " + Cont + " removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        return true;
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

    public List<Contato> buscarTodosContatos() {
        List<Contato> contatos = new ArrayList<>();

        arvore.exibirEmOrdem(arvore.getRaiz(), contatos);

        return contatos;
    }

    public List<Contato> exibirContatosEmOrdem() {
        List<Contato> contatos = new ArrayList<>();

        if (arvore.getRaiz() == null) {
            return contatos;
        } else {
            arvore.exibirEmOrdem(arvore.getRaiz(), contatos);
        }

        return contatos;
    }

    public List<Contato> exibirContatosPreOrdem() {
        List<Contato> contatos = new ArrayList<>();

        if (arvore.getRaiz() == null) {
            return contatos;
        } else {
            arvore.exibirPreOrdem(arvore.getRaiz(), contatos);
        }

        return contatos;
    }

    public List<Contato> exibirContatosPosOrdem() {
        List<Contato> contatos = new ArrayList<>();

        if (arvore.getRaiz() == null) {
            return contatos;
        } else {
            arvore.exibirPosOrdem(arvore.getRaiz(), contatos);
        }

        return contatos;
    }

}
