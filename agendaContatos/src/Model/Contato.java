package Model;

public class Contato {
    
    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.nome = telefone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.nome = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome);
        sb.append("\n");
        sb.append("Telefone: ").append(telefone);
        sb.append("\n");
        sb.append("Email: ").append(email);
        sb.append("\n");
        sb.append("------------------------------------");
        sb.append("\n");
        return sb.toString();
    }
    


}
