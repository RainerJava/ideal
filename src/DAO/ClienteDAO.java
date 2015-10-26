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
import java.util.Collection;
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

    private final Logger log = Logger.getLogger(ClienteDAO.class.getName());

    private final String TABELA = "clientes";
    private final String ID = "id";
    private final String CODIGO = "codigo";
    private final String NOME = "nome";
    private final String FONE = "telefone";
    private final String ENDEREÇO = "endereco";
    private final String CIDADE = "cidade";
    private final String CEL = "celular";
    private final String EMAIL = "email";
    private final String DATA_NASCIMENTO = "data_nascimento";
    private final String PROMO = "promo";

    private final String SELECT_ALL = String.format("SELECT * FROM %s ", TABELA);

    private final Funcoes funcoes = new Funcoes();
    private Connection conexao;

    public void inserirCliente(Cliente cliente) throws RuntimeException, SQLException {

        StringBuilder campos = new StringBuilder();
        campos.append(CODIGO).append(",");
        campos.append(NOME).append(",");
        campos.append(FONE).append(",");
        campos.append(ENDEREÇO).append(",");
        campos.append(CIDADE).append(",");
        campos.append(CEL).append(",");
        campos.append(EMAIL).append(",");
        campos.append(DATA_NASCIMENTO).append(",");
        campos.append(PROMO);

        String sql = String.format("INSERT INTO %s ( %s ) VALUES (?,?,?,?,?,?,?,?,?)", TABELA, campos.toString());
        conectar();
        if (conexao != null) {
            try {
                java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
                if (stmt.getConnection() != null) {
                    java.sql.Date dataSql = null;

                    stmt.setString(1, cliente.getCodigo());
                    stmt.setString(2, cliente.getNome()); 
                    stmt.setString(3, cliente.getTelefone());
                    stmt.setString(4, cliente.getEndereco());
                    stmt.setString(5, cliente.getCidade());
                    stmt.setString(6, cliente.getCelular());
                    stmt.setString(7, cliente.getEmail());
                    stmt.setDate(8, funcoes.convertFromJAVADateToSQLDate(cliente.getData_nascimento()));
                    stmt.setInt(9, cliente.getPromo());
                }

                boolean ret = stmt.execute(); //executa comando     
                if (!ret) {
                }
                stmt.close();
                
                JOptionPane.showMessageDialog(null, "Cliente inserido!", "Sucesso", WIDTH);

            } catch (SQLException u) {
                JOptionPane.showMessageDialog(null, "Sem conexão com internet.", "Atenção!", WIDTH);
            }
        }
    }

    public boolean updateCliente(Cliente cliente) {
        conectar();
        if (conexao != null) {
            java.sql.PreparedStatement stmt;
            try {
                StringBuilder query = new StringBuilder();
                query.append(String.format("UPDATE %s SET ", TABELA));
                query.append(String.format(" %s = ?,", NOME));
                query.append(String.format(" %s = ?,", FONE));
                query.append(String.format(" %s = ?,", ENDEREÇO));
                query.append(String.format(" %s = ?,", CIDADE));
                query.append(String.format(" %s = ?,", CEL));
                query.append(String.format(" %s = ? ", EMAIL));
                query.append(String.format(" %s = ?,", DATA_NASCIMENTO));
                query.append(String.format(" %s = ?,", PROMO));
                query.append(String.format(" WHERE %s = ?", CODIGO));
                stmt = conexao.prepareStatement(query.toString());
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getTelefone());
                stmt.setString(3, cliente.getEndereco());
                stmt.setString(4, cliente.getCidade());
                stmt.setString(5, cliente.getCelular());
                stmt.setString(6, cliente.getEmail());
                stmt.setDate(7, funcoes.convertFromJAVADateToSQLDate(cliente.getData_nascimento()));
                stmt.setInt(8, cliente.getPromo());
                stmt.setString(9, cliente.getCodigo());
                ResultSet rs = stmt.executeQuery(query.toString());
                return rs.first();
            } catch (SQLException ex) {
                log.log(Level.SEVERE, null, ex);
            }
        } else {
            return false;
        }
        return false;
    }

    public Collection<Cliente> getClienteByCodigo(String codigo) {
        conectar();
        if (conexao != null) {
            java.sql.PreparedStatement stmt;
            try {
                StringBuilder query = new StringBuilder();
                query.append(String.format("SELECT * FROM %s ", TABELA));
                query.append(String.format(" WHERE %s = '%s' ", CODIGO, codigo));
                stmt = conexao.prepareStatement(query.toString());
                //stmt.setString(1, codigo);
                log.info(query.toString());
                ResultSet rs = stmt.executeQuery(query.toString());
                return resultSetToCollection(rs);
            } catch (SQLException ex) {
                log.log(Level.SEVERE, null, ex);
            }
        } else {
            return null;
        }
        return null;
    }

    public Collection<Cliente> getClienteById(Integer id) {
        conectar();
        if (conexao != null) {
            java.sql.PreparedStatement stmt;
            try {
                StringBuilder query = new StringBuilder();
                query.append(SELECT_ALL).append(String.format(" WHERE %s = %s", ID, id));
                stmt = conexao.prepareStatement(query.toString());
                ResultSet rs = stmt.executeQuery(query.toString());
                return resultSetToCollection(rs);
            } catch (SQLException ex) {
                log.log(Level.SEVERE, null, ex);            }
        } else {
            return null;
        }
        return null;
    }

    public Collection<Cliente> getAllClientes() {
        conectar();
        if (conexao != null) {
            java.sql.PreparedStatement stmt;
            try {
                stmt = conexao.prepareStatement(SELECT_ALL);
                ResultSet rs = stmt.executeQuery(SELECT_ALL);
                return resultSetToCollection(rs);
            } catch (SQLException ex) {
                log.log(Level.SEVERE, null, ex);
            }
        } else {
            return null;
        }
        return null;
    }

    private void conectar() {
        try {
            conexao = Conexao.Conectar();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Sem conexão com internet.", "Atenção!", WIDTH);
        }
    }

    private Collection<Cliente> resultSetToCollection(ResultSet rs) {
        Collection<Cliente> clientes = new ArrayList<>();
        try {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(ID));
                cliente.setCodigo(rs.getString(CODIGO).trim());
                cliente.setNome(rs.getString(NOME).trim());
                cliente.setEndereco(rs.getString(ENDEREÇO));
                cliente.setCidade(rs.getString(CIDADE));
                cliente.setData_nascimento(rs.getDate(DATA_NASCIMENTO));
                cliente.setTelefone(rs.getString(FONE).trim());
                cliente.setCelular(rs.getString(CEL).trim());
                cliente.setEmail(rs.getString(EMAIL).trim());
                cliente.setPromo(rs.getInt(PROMO));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, null, e.getMessage());
        }
        return clientes;
    }
}
