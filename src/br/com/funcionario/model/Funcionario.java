package br.com.funcionario.model;

public class Funcionario {
    // Declara atributos
    private long Id;
    private String nome;
    private String sobrenome;
    private String cargo;
    private double salario;
 
    // M�todo construtor padr�o do JavaBean
    public Funcionario() {
 
    }
 
    // M�todo construtor Overload
    /**
     * 
     * @param id
     * @param nome
     * @param sobrenome
     * @param cargo
     * @param salario
     */
    public Funcionario(long id, String nome, String sobrenome, String cargo,
            double salario) {
        this.Id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cargo = cargo;
        this.salario = salario;
    }
 
    // Declara m�todos Getters e Setters
    public long getId() {
        return Id;
    }
 
    public void setId(long id) {
        Id = id;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String getSobrenome() {
        return sobrenome;
    }
 
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
 
    public String getCargo() {
        return cargo;
    }
 
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
 
    public double getSalario() {
        return salario;
    }
 
    public void setSalario(double salario) {
        this.salario = salario;
    }
}
