package Controller;

import Model.ArvoreBinaria;
import Model.Contato;

public class ValidarContato {

    public static boolean telefoneValido(String telefone) {
        return telefone.matches("^\\(\\d{2}\\)\\s?9\\d{4}-\\d{4}$");
    }

    public static boolean emailValido(String email) {
        return email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$");
    }

    // Para adicionar
    public static boolean contatoExiste(String telefone, String email, ArvoreBinaria arvore) {
        Contato contatoTelefone = arvore.buscarPorTelefone(telefone);
        Contato contatoEmail = arvore.buscarPorEmail(email);

        return contatoTelefone != null || contatoEmail != null;
    }

    // Para editar
    public static boolean contatoExiste(String telefone, String email, ArvoreBinaria arvore, Contato contatoAtual) {
        Contato contatoTelefone = arvore.buscarPorTelefone(telefone);
        Contato contatoEmail = arvore.buscarPorEmail(email);

        if (contatoTelefone != null && !contatoTelefone.equals(contatoAtual)) {
            return true;
        }

        if (contatoEmail != null && !contatoEmail.equals(contatoAtual)) {
            return true;
        }

        return false;
    }

}
