import java.util.ArrayList;
import java.util.List;

import Controller.ContatoControle;
import Model.ArvoreBinaria;
import Model.Contato;
import View.InterfaceUsuario;

public class Main {
  public static void main(String[] args) {

    ArvoreBinaria arvore = new ArvoreBinaria();
    ContatoControle controle = new ContatoControle();

    /*List<Contato> contatos = new ArrayList<>();

      //  arvore.exibirPreOrdem(arvore.getRaiz());
        
        new InterfaceUsuario(controle, arvore);
    arvore.inserirContato(new Contato("Rafael", "(63) 12345-6789", "teste@email.com"));
    arvore.inserirContato(new Contato("Pedro", "(63) 98765-4321", "teste2@email.com"));
    arvore.inserirContato(new Contato("Sabrina", "(63) 11111-2222", "teste3@email.com"));

    arvore.exibirPreOrdem(arvore.getRaiz(), contatos);

    for (Contato c : contatos) {
      System.out.println(c.getNome() + " | " + c.getTelefone() + " | " + c.getEmail());
    }*/

     new InterfaceUsuario(controle, arvore);

    // System.out.println(arvore.buscarPorNome("Rafael"));

  }
}
