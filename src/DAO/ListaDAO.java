package DAO;

import Conexao.ConexaoLista;
import Model.Lista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ListaDAO {
    private Connection con;

    public ListaDAO() {
        this.con = new ConexaoLista().conectaBD();
    }

    public boolean addLista(Lista lista) {
        String status = lista.getStatus().toLowerCase();
        if (!status.equals("pendente") && !status.equals("em progresso") && !status.equals("concluída")) {
            JOptionPane.showMessageDialog(null, "O campo 'status' deve ser 'pendente', 'em progresso' ou 'concluída'.", "Status Inválido", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String sql = "INSERT INTO Lista (titulo, descricao, status, data_criacao) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, lista.getTitulo());
            stmt.setString(2, lista.getDescricao());
            stmt.setString(3, lista.getStatus());
            stmt.setDate(4, new java.sql.Date(lista.getData_criacao().getTime()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar tarefa: " + e.getMessage());
            return false;
        }
    }

    public List<Lista> mostrarLista() {
        List<Lista> listas = new ArrayList<>();
        String sql = "SELECT * FROM Lista";

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Lista lista = new Lista();
                lista.setId(rs.getInt("id"));
                lista.setTitulo(rs.getString("titulo"));
                lista.setDescricao(rs.getString("descricao"));
                lista.setStatus(rs.getString("status"));
                lista.setData_criacao(rs.getDate("data_criacao"));
                listas.add(lista);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao mostrar a lista de tarefas: " + e.getMessage());
        }
        return listas;
    }
    
    public Lista buscarListaPorID(int id) throws Exception {
        Connection con = new ConexaoLista().conectaBD();
        String sql = "SELECT * FROM Lista WHERE id = ?";
        Lista lista = null;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                lista = new Lista();
                lista.setId(rs.getInt("id"));
                lista.setTitulo(rs.getString("titulo"));
                lista.setDescricao(rs.getString("descricao"));
                lista.setStatus(rs.getString("status"));
                lista.setData_criacao(rs.getDate("data_criacao"));
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar a tarefa por ID: " + e.getMessage());
        }
        return lista;
    }
    
    public void atualizarLista(Lista lista) throws SQLException {
        String status = lista.getStatus().toLowerCase();
        if (!status.equals("pendente") && !status.equals("em progresso") && !status.equals("concluída")) {
            JOptionPane.showMessageDialog(null, "O campo 'status' deve ser 'pendente', 'em progresso' ou 'concluída'.", "Status Inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection con = new ConexaoLista().conectaBD();
        String verificarSql = "SELECT COUNT(*) AS total FROM Lista WHERE id = ?";
        String atualizarSql = "UPDATE Lista SET titulo = ?, descricao = ?, status = ?, data_criacao = ? WHERE id = ?";

        try (PreparedStatement verificarStmt = con.prepareStatement(verificarSql)) {
            verificarStmt.setInt(1, lista.getId());
            ResultSet rs = verificarStmt.executeQuery();
            if (rs.next() && rs.getInt("total") == 0) {
                throw new SQLException("Tarefa com ID " + lista.getId() + " não encontrada. Por favor, insira um ID válido.");
            }
        }

        try (PreparedStatement atualizarStmt = con.prepareStatement(atualizarSql)) {
            atualizarStmt.setString(1, lista.getTitulo());
            atualizarStmt.setString(2, lista.getDescricao());
            atualizarStmt.setString(3, lista.getStatus());
            atualizarStmt.setDate(4, new java.sql.Date(lista.getData_criacao().getTime()));
            atualizarStmt.setInt(5, lista.getId());
            atualizarStmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar a tarefa: " + e.getMessage());
        }
    }

    public Lista excluirLista(int id) throws SQLException {
        Connection con = new ConexaoLista().conectaBD();
        String sql = "DELETE FROM Lista WHERE id = ?";
        Lista lista = null;
        
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Nenhuma tarefa encontrada com o ID especificado.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao excluir o tarefa: " + e.getMessage());
        }
        return lista;
    }
}