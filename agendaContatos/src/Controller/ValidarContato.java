package Controller;

import Model.ArvoreBinaria;
import Model.Contato;

public class ValidarContato {

    public boolean telefoneValido(String telefone) {
        return telefone.matches("^\\(\\d{2}\\)\\s?9\\d{4}-\\d{4}$");
    }

    public boolean emailValido(String email) {
        return email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$");
    }

    public boolean contatoExiste(String telefone, String email, ArvoreBinaria arvore) {
        Contato contatoTelefone = arvore.buscarPorTelefone(telefone);
        Contato contatoEmail = arvore.buscarPorEmail(email);

        return contatoTelefone != null || contatoEmail != null;
    }
}
