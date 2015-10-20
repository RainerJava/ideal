/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.ClienteDAO;
import java.sql.SQLException;
import java.util.Collection;
import model.Cliente;

/**
 *
 * @author Jorge
 */
public class ClienteService {
    
    ClienteDAO clienteDAO = new ClienteDAO();
    
    public void addCliente(Cliente cliente) throws RuntimeException, SQLException{
        clienteDAO.inserirCliente(cliente);
    }
    
    public Collection<Cliente> getClienteById(int id){
        return clienteDAO.getClienteById(id);
    }
    
    public Collection<Cliente> getClienteByCode(String code){
        return clienteDAO.getClienteByCodigo(code);
    }
    
    public boolean updateCliente(Cliente cliente){
        return clienteDAO.updateCliente(cliente);
    }
    
    public Collection<Cliente> getAllClientes(){
        return clienteDAO.getAllClientes();
    }
    
}
