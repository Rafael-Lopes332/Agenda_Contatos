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

     new InterfaceUsuario(controle, arvore);
  }
}
