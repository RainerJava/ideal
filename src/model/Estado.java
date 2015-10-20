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
public class Estado {
    
    private int id;
    private String codigo;
    private String uf;
    private String referencia;
    private int id_pais;

    public Estado(int id, String codigo, String uf, String referencia, int id_pais) {
        this.id = id;
        this.codigo = codigo;
        this.uf = uf;
        this.referencia = referencia;
        this.id_pais = id_pais;
    }

    public Estado(String codigo, String uf, String referencia, int id_pais) {
        this.codigo = codigo;
        this.uf = uf;
        this.referencia = referencia;
        this.id_pais = id_pais;
    }

    public Estado() {
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }
   
   
}
