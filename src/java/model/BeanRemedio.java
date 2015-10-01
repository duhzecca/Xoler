/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Eduardo Zecca
 */
public class BeanRemedio {
    
    public BeanRemedio(){        
    }

    public BeanRemedio(int id_remedio, String nome, String descricao, String validade, float preco, String foto, int um_id) {
        this.id_remedio = id_remedio;
        this.nome = nome;
        this.descricao = descricao;
        this.validade = validade;
        this.preco = preco;
        this.foto = foto;
        this.um_id = um_id;
    }

    public BeanRemedio(String nome, String descricao, String validade, float preco, String foto, int um_id) {
        this.nome = nome;
        this.descricao = descricao;
        this.validade = validade;
        this.preco = preco;
        this.foto = foto;
        this.um_id = um_id;
    }

    public int getId_remedio() {
        return id_remedio;
    }

    public void setId_remedio(int id_remedio) {
        this.id_remedio = id_remedio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getUm_id() {
        return um_id;
    }

    public void setUm_id(int um_id) {
        this.um_id = um_id;
    }        
    
    int id_remedio;
    String nome;
    String descricao;
    String validade;
    float preco;
    String foto;
    int um_id;
}
