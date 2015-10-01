package model;

public class BeanUsuario {

    public BeanUsuario() {
    }

    public BeanUsuario(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;                      
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }   
    
    public String getFirstNome(String nome){
        int i = nome.indexOf(" "); /* Busca na string, a posição do ' ' espaço, e retorna o indice dele */ 
        return nome.substring(0,i); /* Aqui é separada a String do primeiro caractere até o primeiro espaço*/
    }

    private String nome;    
    private String email;  
    private String senha;
}
