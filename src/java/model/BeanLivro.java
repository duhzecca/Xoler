/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class BeanLivro {
    
    public BeanLivro(){        
    }
    
    public BeanLivro(String nome, String autor, String tag, String capa, String conteudoLivro, int visitas, String editora){
        this.nome = nome;
        this.autor = autor;
        this.tag = tag;
        this.capa = capa;
        this.conteudoLivro = conteudoLivro;
        this.visitas = visitas;
        this.editora = editora;
    }

    public BeanLivro(String nome, String autor, String tag, String capa, String conteudoLivro, int visitas, String editora, String descricao) {
        this.nome = nome;
        this.autor = autor;
        this.tag = tag;
        this.capa = capa;
        this.conteudoLivro = conteudoLivro;
        this.visitas = visitas;
        this.editora = editora;
        this.descricao = descricao;
    }

    public BeanLivro(String nome, String autor, String tag, String capa, String conteudoLivro, int visitas, String editora, String descricao, int cod) {
        this.nome = nome;
        this.autor = autor;
        this.tag = tag;
        this.capa = capa;
        this.conteudoLivro = conteudoLivro;
        this.visitas = visitas;
        this.editora = editora;
        this.descricao = descricao;
        this.cod = cod;
    }
    
    
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getAutor(){
        return autor;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }    

    public String getTag(){
        return tag;
    }
    
    public void setTag(String tag){
        this.tag = tag;
    }    
    
    public String getCapa(){
        return capa;
    }
    
    public void setCapa(String capa){
        this.capa = capa;
    }    
    
    public String getConteudoLivro(){
        return conteudoLivro;
    }
    
    public void setConteudoLivro(String conteudoLivro){
        this.conteudoLivro = conteudoLivro;
    }
    
    public int getVisitas(){
        return visitas;
    }
    
    public void setVisitas(int visitas){
        this.visitas = visitas;
    }
    
    public String getEditora(){
        return editora;
    }
    
    public void setEditora(String editora){
        this.editora = editora;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    
    String nome;
    String autor;
    String tag;
    String capa;
    String conteudoLivro;
    int visitas;
    String editora;
    String descricao;
    int cod;



}
