/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tiago
 */
public class Pais {

    private int id;
    private String codigo;
    private String nome;
    private String referencia;

    public Pais(int id, String codigo, String nome, String referencia) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.referencia = referencia;
    }

    public Pais(String codigo, String nome, String referencia) {
        this.codigo = codigo;
        this.nome = nome;
        this.referencia = referencia;
    }

    public Pais() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
