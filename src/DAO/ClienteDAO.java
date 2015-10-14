/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import crm.Conexao;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import util.Funcoes;

/**
 *
 * @author Tiago
 */
public class ClienteDAO {

    Funcoes funcoes = new Funcoes();

    public ClienteDAO() {
    }

    public void Inserir(Cliente cliente) {

        String sql = "INSERT INTO cliente(codigo,"
                + " nome, "
                + "tipo_pessoa, "
                + "rg, "
                + "cpf, "
                + "inscricao_estadual, "
                + "cnpj, "
                + "data_nascimento, "
                + "telefone, "
                + "celular, "
                + "email, "
                + "ativo, "
                + "id_endereco) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Conexao conex = new Conexao();
        Connection conexaoRet = conex.Conectar();
        if (conexaoRet != null) {
            try {
                java.sql.PreparedStatement stmt = conexaoRet.prepareStatement(sql);
                if (stmt.getConnection() != null) {

                    java.sql.Date dataSql = null;

                    if (cliente.getData_nascimento() != null) {
                        java.util.Date dataUtil = cliente.getData_nascimento();
                        dataSql = new java.sql.Date(dataUtil.getTime());
                    }

                    stmt.setString(1, cliente.getCodigo());
                    stmt.setString(2, cliente.getNome());
                    stmt.setInt(3, cliente.getTipo_pessoa());
                    stmt.setString(4, cliente.getRg());
                    stmt.setString(5, cliente.getCpf());
                    stmt.setString(6, cliente.getInscricao_estadual());
                    stmt.setString(7, cliente.getCnpj());
                    stmt.setDate(8, dataSql);
                    stmt.setString(9, cliente.getTelefone());
                    stmt.setString(10, cliente.getCelular());
                    stmt.setString(11, cliente.getEmail());
                    stmt.setBoolean(12, cliente.getAtivo());
                    stmt.setInt(13, 0);
                }

                boolean ret = stmt.execute(); //executa comando     
                if (!ret) {
                }
                stmt.close();

            } catch (SQLException u) {
                throw new RuntimeException(u);
            }
        } else {
            //SEM CONEXÃO
            JOptionPane.showMessageDialog(null, "Sem conexão com internet.", "Atenção!", WIDTH);
        }

    }

    public ArrayList<Cliente> Buscar() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Conexao conex = new Conexao();
        Connection conexaoRet = conex.Conectar();
        if (conexaoRet != null) {
            String query = "SELECT * FROM cliente";
            java.sql.PreparedStatement stmt;
            try {
                stmt = conexaoRet.prepareStatement(query);
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String codigo = rs.getString("codigo").trim();
                    String nome = rs.getString("nome").trim();
                    int tipo_pessoa = rs.getInt("tipo_pessoa");
                    String rg = rs.getString("rg").trim();
                    String cpf = rs.getString("cpf").trim();
                    String inscricao_estadual = rs.getString("inscricao_estadual").trim();
                    String cnpj = rs.getString("cnpj").trim();
                    String telefone = rs.getString("telefone");
                    String celular = rs.getString("celular");
                    String email = rs.getString("email");
                    boolean ativo = rs.getBoolean("ativo");
                    int id_endereco = rs.getInt("id_endereco");

                    Cliente cliente = new Cliente(id,codigo, nome, tipo_pessoa, rg, cpf, inscricao_estadual, cnpj, null, telefone, celular, email, ativo, null);
                    clientes.add(cliente);
                }
                return clientes;
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return null;
        }
        return null;
    }
}
