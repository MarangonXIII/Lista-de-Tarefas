package DAO;

import Conexao.ConexaoLista;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection con;
    
    public ResultSet autenticacaoUsuario(Usuario objusuario){
        con = new ConexaoLista().conectaBD();
        
        try{
            String sql = "SELECT * FROM Usuario WHERE login=? AND senha=?"; //login=teksystem & senha=todolist
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, objusuario.getLogin());
            pstm.setString(2, objusuario.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }
}
