package crm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    public Conexao() {
    } //Possibilita instancias
    public static Connection con = null;

    public static Connection Conectar() {
        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://ideal10.mysql.uhserver.com:3306/ideal10", "tiagoadmin", "@sharkweb10");
            System.out.println("Conectado.");
            return con;
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
