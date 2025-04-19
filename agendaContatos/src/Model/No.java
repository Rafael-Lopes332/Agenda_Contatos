package Model;

public class No {

    Contato contato;
    No esquerdo;
    No direito;

    public No(Contato contato){
        this.contato = contato;
        this.esquerdo = null;
        this.direito = null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(contato);
        return s.toString();
    }

}
