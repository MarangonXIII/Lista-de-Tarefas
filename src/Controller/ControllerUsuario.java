package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import View.jfrTelaPrincipal;
import javax.swing.JFrame;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControllerUsuario {
    public void autenticarUsuario(String login, String senha, JFrame fechajanela) {
        try{
            Usuario objusuario = new Usuario();
            objusuario.setLogin(login);
            objusuario.setSenha(senha);

            UsuarioDAO objusuariodao = new UsuarioDAO();
            ResultSet rsusuariodao = objusuariodao.autenticacaoUsuario(objusuario);

            if(rsusuariodao.next()){
                jfrTelaPrincipal objjfrtelaprincipal = new jfrTelaPrincipal();
                objjfrtelaprincipal.setVisible(true);
                fechajanela.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválidos");
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "jfrLogin: " + erro);
        }
    }
}
