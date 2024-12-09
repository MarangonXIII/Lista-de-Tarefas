package Conexao;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexaoLista {
    public Connection conectaBD(){
        Connection con = null;
        try{
            String url = "jdbc:mysql://localhost:3306/listadetarefas?user=root&password=";
            con = DriverManager.getConnection(url);
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "ConexaoLista" + erro.getMessage());
        }
        return con;
    }
}
