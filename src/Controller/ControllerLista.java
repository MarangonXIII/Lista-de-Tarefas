package Controller;

import DAO.ListaDAO;
import Model.Lista;
import javax.swing.*;
import java.util.List;

public class ControllerLista {

    public void addLista(String titulo, String descricao, String status, java.util.Date data_criacao) {
        Lista lista = new Lista();
        lista.setTitulo(titulo);
        lista.setDescricao(descricao);
        lista.setStatus(status);
        if (data_criacao != null) {
            lista.setData_criacao(new java.sql.Date(data_criacao.getTime()));
        }

        ListaDAO listaDAO = new ListaDAO();
        boolean sucesso = listaDAO.addLista(lista);
        
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar tarefa.");
        }
    }

    public void mostrarLista() {
        ListaDAO listaDAO = new ListaDAO();
        List<Lista> listas = listaDAO.mostrarLista();
        if (listas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa adicionada.");
            return;
        }

        String[] colunas = {"ID", "Título", "Descrição", "Status", "Data de Criação"};
        Object[][] dados = new Object[listas.size()][5];

        for (int i = 0; i < listas.size(); i++) {
            Lista lista = listas.get(i);
            dados[i][0] = lista.getId();
            dados[i][1] = lista.getTitulo();
            dados[i][2] = lista.getDescricao();
            dados[i][3] = lista.getStatus();
            dados[i][4] = lista.getData_criacao();
        }
        JTable tabelaLista = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabelaLista);
        scrollPane.setPreferredSize(new java.awt.Dimension(600, 300));
        JOptionPane.showMessageDialog(null, scrollPane, "Tarefas Adicionadas", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public Lista procurarListaPorID(int id) throws Exception {
        ListaDAO listaDAO = new ListaDAO();
        return listaDAO.buscarListaPorID(id);
    }
    
    private final ListaDAO listaDAO = new ListaDAO();
    public void atualizarLista(int id, String titulo, String descricao, String status, java.util.Date data_criacao) throws Exception {
        if (titulo.isEmpty() || descricao.isEmpty() || status.isEmpty() || data_criacao == null) {
            throw new Exception("Todos os campos devem ser preenchidos corretamente.");
        }
        Lista lista = new Lista();
        lista.setId(id);
        lista.setTitulo(titulo);
        lista.setDescricao(descricao);
        lista.setStatus(status);
        lista.setData_criacao(new java.sql.Date(data_criacao.getTime()));
        listaDAO.atualizarLista(lista);
    }
    
    public void excluirLista(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido. Por favor, insira um ID válido.");
        }
        listaDAO.excluirLista(id);
    }
}