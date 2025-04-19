package Model;

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

    public void exibirEmOrdem(No noAtual) {
        if (noAtual != null) {
            exibirEmOrdem(noAtual.esquerdo);
            System.out.println(noAtual.contato);
            exibirEmOrdem(noAtual.direito);
        }

    }

    public void exibirPreOrdem(No noAtual) {
        if (noAtual != null) {
            System.out.println(noAtual.contato);
            exibirEmOrdem(noAtual.esquerdo);
            exibirEmOrdem(noAtual.direito);
        }

    }

    public void exibirPosOrdem(No noAtual) {
        if (noAtual != null) {
            exibirEmOrdem(noAtual.esquerdo);
            exibirEmOrdem(noAtual.direito);
            System.out.println(noAtual.contato);
        }

    }

}
