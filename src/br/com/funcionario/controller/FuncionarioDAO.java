package br.com.funcionario.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.funcionario.model.Funcionario;
import br.com.funcionario.repository.Conexao;
 
public class FuncionarioDAO implements FuncionarioDAOInterface {
 
    // Cria componentes
    private Connection conn = null;
    private Statement query;
    private String sql;
 
    public FuncionarioDAO() {
 
        // Como o exemplo n�o possui uma tela de login
        // utilizamos uma adapta��o no construtor da classe
        // voc� pode utilizar um login para que o factory da conex�o
        // use a string de conex�o completa.
 
        try {
 
            this.conn = Conexao
                    .getConexao(1, "root", "010394");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    @Override
    public Funcionario buscaFuncionario(String id) {
 
        // Cria novo objeto
        Funcionario funcionario = new Funcionario();
 
        // Define SQL
        sql = "SELECT * FROM funcionario WHERE id_funcionario = " + id;
 
        try {
 
            // Associa conex�o e executa SQL
            query = conn.createStatement();
            ResultSet rs = query.executeQuery(sql);
 
            // Recupera dados do set
            while (rs.next()) {
                funcionario.setId(rs.getInt("ID_FUNCIONARIO"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setSobrenome(rs.getString("SOBRENOME"));
                funcionario.setCargo(rs.getString("CARGO"));
                funcionario.setSalario(rs.getDouble("SALARIO"));
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        // Retorna objeto
        return funcionario;
    }
 
    @Override
    public boolean insereFuncionario(Funcionario funcionario) {
 
        // Define SQL
        sql = "INSERT INTO funcionario VALUES (?, ?, ?, ?, ?)";
 
        try {
 
            // Prepara SQL e alimenta parametros
            PreparedStatement query = conn.prepareStatement(sql);
            query.setLong(1, funcionario.getId());
            query.setString(2, funcionario.getNome());
            query.setString(3, funcionario.getSobrenome());
            query.setString(4, funcionario.getCargo());
            query.setDouble(5, funcionario.getSalario());
 
            // Executa SQL
            query.execute();
            query.close();
            return true;
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        return false;
    }
 
    @Override
    public boolean updateFuncionario(Funcionario funcionario) {
 
        // Define SQL
        sql = "UPDATE funcionario SET id_funcionario = ?, nome = ?, sobrenome = ?,"
                + " cargo = ?, salario = ? WHERE id_funcionario = ?";
 
        try {
 
            // Prepara SQL e alimenta parametros
            PreparedStatement query = conn.prepareStatement(sql);
            query.setLong(1, funcionario.getId());
            query.setString(2, funcionario.getNome());
            query.setString(3, funcionario.getSobrenome());
            query.setString(4, funcionario.getCargo());
            query.setDouble(5, funcionario.getSalario());
            query.setLong(6, funcionario.getId());
 
            // Executa SQL
            query.execute();
            query.close();
            return true;
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        return false;
    }
 
    @Override
    public boolean deletaFuncionario(Funcionario funcionario) {
 
        // Define SQL
        sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
 
        // Prepara SQL e alimenta parametros
        PreparedStatement query;
        try {
            // Executa SQL
            query = conn.prepareStatement(sql);
            query.setLong(1, funcionario.getId());
            query.execute();
            query.close();
 
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        return false;
 
    }
 
}