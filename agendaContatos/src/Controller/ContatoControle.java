package Controller;

import javax.swing.JOptionPane;

import Model.ArvoreBinaria;
import Model.Contato;
import View.InterfaceUsuario;
import Controller.ValidarContato;

public class ContatoControle {

    private ArvoreBinaria arvore;

    public ContatoControle() {
        this.arvore = new ArvoreBinaria();
    }

    public void adicionarContato(String nome, String telefone, String email) {
        try {
            
            if (nome.trim().isEmpty() || telefone.trim().isEmpty() || email.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preeenchidos!");
                return;
            } 
    
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

    public String exibirContatosPreOrdem() {
        StringBuilder sb =  new StringBuilder();

        if (arvore.getRaiz() == null) {
            sb.append("Nenhum contato cadastrado.");
        } else {
            arvore.exibirPreOrdem(arvore.getRaiz(), sb);
        }

        return sb.toString();
    }

    public String exibirContatosPosOrdem() {
        StringBuilder sb =  new StringBuilder();

        if (arvore.getRaiz() == null) {
            sb.append("Nenhum contato cadastrado.");
        } else {
            arvore.exibirPosOrdem(arvore.getRaiz(), sb);
        }

        return sb.toString();
    }


}
