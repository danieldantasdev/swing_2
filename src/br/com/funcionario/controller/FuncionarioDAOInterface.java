package br.com.funcionario.controller;

import br.com.funcionario.model.Funcionario;

public interface FuncionarioDAOInterface { 
    // Cria interface
    // A interface propricia os retornos corretos de cada opera��o.
 
    public Funcionario buscaFuncionario(String id);
 
    public boolean insereFuncionario(Funcionario funcionario);
 
    public boolean updateFuncionario(Funcionario funcionario);
 
    public boolean deletaFuncionario(Funcionario funcionario);
 
    // TODO: Insira outros metodos que voc� deseje que sejam obrigatorios.
}
