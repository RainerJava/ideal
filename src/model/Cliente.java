/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class Cliente {

    private int id;
    private String codigo;
    private String nome;
    private int tipo_pessoa;
    private String rg;
    private String cpf;
    private String inscricao_estadual;
    private String cnpj;
    private Date data_nascimento;
    private String telefone;
    private String celular;
    private String email;
    private boolean ativo;

    private Endereco endereco;

    public Cliente(int id, String codigo, String nome, int tipo_pessoa, String rg, String cpf, String inscricao_estadual, String cnpj, Date data_nascimento, String telefone, String celular, String email, boolean ativo, Endereco enderecos) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.tipo_pessoa = tipo_pessoa;
        this.rg = rg;
        this.cpf = cpf;
        this.inscricao_estadual = inscricao_estadual;
        this.cnpj = cnpj;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.endereco = enderecos;
        this.ativo = ativo;
    }

    public Cliente(String codigo, String nome, int tipo_pessoa, String rg, String cpf, String inscricao_estadual, String cnpj, Date data_nascimento, String telefone, String celular, String email, boolean ativo, Endereco enderecos) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo_pessoa = tipo_pessoa;
        this.rg = rg;
        this.cpf = cpf;
        this.inscricao_estadual = inscricao_estadual;
        this.cnpj = cnpj;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.endereco = enderecos;
        this.ativo = ativo;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEnderecos() {
        return endereco;
    }

    public void setEnderecos(Endereco enderecos) {
        this.endereco = enderecos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(int tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
