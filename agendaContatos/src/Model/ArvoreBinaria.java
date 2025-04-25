package Model;

import java.util.List;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void inserirContato(Contato contato) {
        if (raiz == null) {
            raiz = new No(contato);
        } else {
            inserirContatoRecursivo(raiz, contato);
        }
    }

    private void inserirContatoRecursivo(No noAtual, Contato contato) {
        if (contato.getNome().compareToIgnoreCase(noAtual.contato.getNome()) < 0) {
            if (noAtual.esquerdo == null) {
                noAtual.esquerdo = new No(contato);
            } else {
                inserirContatoRecursivo(noAtual.esquerdo, contato);
            }
        } else {
            if (noAtual.direito == null) {
                noAtual.direito = new No(contato);
            } else {
                inserirContatoRecursivo(noAtual.direito, contato);
            }
        }

    }

    public Contato buscarPorNome(String nome) {
        if (raiz == null) {
            return null;
        } else {
            return buscarPorNomeRecursivo(raiz, nome);
        }
    }

    private Contato buscarPorNomeRecursivo(No noAtual, String nome) {
        if (noAtual == null) {
            return null;
        }

        int comparacao = nome.compareToIgnoreCase(noAtual.contato.getNome());

        if (comparacao < 0) {
            return buscarPorNomeRecursivo(noAtual.esquerdo, nome);
        }

        if (comparacao > 0) {
            return buscarPorNomeRecursivo(noAtual.direito, nome);
        }

        return noAtual.contato;
    }

    public Contato buscarPorTelefone(String telefone) {
        if (raiz == null) {
            return null;
        } else {
            return buscarPorTelefoneRecursivo(raiz, telefone);
        }
    }

    private Contato buscarPorTelefoneRecursivo(No noAtual, String telefone) {
        if (noAtual == null) {
            return null;
        }

        if (noAtual.contato.getTelefone().equals(telefone)) {
            return noAtual.contato;
        }

        Contato encotradoNaEsquerda = buscarPorTelefoneRecursivo(noAtual.esquerdo, telefone);
        if (encotradoNaEsquerda != null) {
            return encotradoNaEsquerda;
        }

        return buscarPorTelefoneRecursivo(noAtual.direito, telefone);
    }

    public Contato buscarPorEmail(String email) {
        if (raiz == null) {
            return null;
        } else {
            return buscarPorEmailRecursivo(raiz, email);
        }
    }

    private Contato buscarPorEmailRecursivo(No noAtual, String email){
        if (noAtual == null) {
            return null;
        }

        if (noAtual.contato.getEmail().equals(email)) {
            return noAtual.contato;
        }

        Contato encontradoEsquerda = buscarPorEmailRecursivo(noAtual.esquerdo, email);
        if (encontradoEsquerda != null) {
            return encontradoEsquerda;
        }

        return buscarPorEmailRecursivo(noAtual.direito, email);
    }

    public void exibirEmOrdem(No noAtual, List<Contato> lista) {
        if (noAtual != null) {
            exibirEmOrdem(noAtual.esquerdo, lista);
            lista.add(noAtual.contato);
            exibirEmOrdem(noAtual.direito, lista);
        }

    }

    public void exibirPreOrdem(No noAtual, List<Contato> lista) {
        if (noAtual != null) {
            lista.add(noAtual.contato);
            exibirEmOrdem(noAtual.esquerdo, lista);
            exibirEmOrdem(noAtual.direito, lista);
        }

    }

    public void exibirPosOrdem(No noAtual, List<Contato> lista) {
        if (noAtual != null) {
            exibirEmOrdem(noAtual.esquerdo, lista);
            exibirEmOrdem(noAtual.direito, lista);
            lista.add(noAtual.contato);
        }

    }

}
