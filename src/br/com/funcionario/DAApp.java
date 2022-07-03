/**
 * @author Daniel Dantas
 * @see https://github.com/lobinhodev?tab=repositories
 */

package br.com.funcionario;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import br.com.funcionario.controller.FuncionarioDAO;
import br.com.funcionario.model.Funcionario;
 

public class DAApp implements ActionListener {
    // Declara componentes
    private JLabel ltitulo;
    private JLabel lid;
    private JLabel lpnome;
    private JLabel lsnome;
    private JLabel lcargo;
    private JLabel lsalario;
    private JLabel lpesquisa;
 
    private JTextField tid;
    private JTextField tpnome;
    private JTextField tsnome;
    private JTextField tcargo;
    private JTextField tsalario;
    private JTextField tpesquisa;
 
    private JButton botao;
    private JButton alterar;
    private JButton inserir;
    private JButton deletar;
    private JButton novo;
 
    private Border borda;
 
    private JFrame menssagem;
 
    public Container criaPainel() {
        // cria painel
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        // Cria titulo
        ltitulo = new JLabel("Database - Fields -Sem conex�o");
 
        painel.add(ltitulo);
        painel.add(Box.createVerticalStrut(60));
 
        // Cria painel de usuario
        JPanel painelDados = new JPanel(new GridLayout(0, 2, 10, 10));
 
        // Cria componentes
        lid = new JLabel("C�digo:");
        lpnome = new JLabel("Primeiro Nome:");
        lsnome = new JLabel("Sobrenome:");
        lcargo = new JLabel("Cargo:");
        lsalario = new JLabel("Sal�rio:");
 
        tid = new JTextField();
        tpnome = new JTextField();
        tsnome = new JTextField();
        tcargo = new JTextField();
        tsalario = new JTextField();
 
        tid.setPreferredSize(new Dimension(150, 20));
 
        // Adiciona componentes no painel
        painelDados.add(Box.createVerticalStrut(10));
        painelDados.add(Box.createVerticalStrut(10));
        painelDados.add(lid);
        painelDados.add(tid);
        painelDados.add(lpnome);
        painelDados.add(tpnome);
        painelDados.add(lsnome);
        painelDados.add(tsnome);
        painelDados.add(lcargo);
        painelDados.add(tcargo);
        painelDados.add(lsalario);
        painelDados.add(tsalario);
        painelDados.add(Box.createVerticalStrut(10));
        painelDados.add(Box.createVerticalStrut(10));
 
        // Cria painel de pesquisa
        JPanel painelPesquisa = new JPanel(new GridLayout(0, 3, 10, 10));
        borda = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        painelPesquisa.setBorder(borda);
 
        // Cria pesquisas
        lpesquisa = new JLabel("Pesquisa c�digo:");
        tpesquisa = new JTextField();
        botao = new JButton("Pesquisar");
        botao.addActionListener(this);
 
        // Define foco do cursor no campo de pesquisa
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                tpesquisa.requestFocus();
            }
        });
 
        // Adiciona compoentes ao painel de pesquisa
        painelPesquisa.add(lpesquisa);
        painelPesquisa.add(tpesquisa);
        painelPesquisa.add(botao);
 
        // Cria painel de pesquisa
        JPanel painelAcao = new JPanel(new GridLayout(0, 4, 10, 10));
        borda = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        painelAcao.setBorder(borda);
 
        // Cria bot�es de manipula��o de banco
        novo = new JButton("Novo");
        inserir = new JButton("Inserir");
        alterar = new JButton("Alterar");
        deletar = new JButton("Apagar");
 
        // Cria ouvintes de eventos
        novo.addActionListener(this);
        inserir.addActionListener(this);
        alterar.addActionListener(this);
        deletar.addActionListener(this);
 
        // Insere componentes em um painel
        painelAcao.add(novo);
        painelAcao.add(inserir);
        painelAcao.add(alterar);
        painelAcao.add(deletar);
 
        // Adiciona paineis
        painel.add(painelPesquisa);
        painel.add(painelDados);
        painel.add(painelAcao);
 
        return painel;
    }
 
    // Clique do bot�o de pesquisa
    
    public void actionPerformed(ActionEvent arg0) {
 
        // Verifica pesquisa
        if (arg0.getSource() == botao) {
 
            // Cria funcionario
            Funcionario funcionario = new Funcionario();
 
            // Busca funcionario
            funcionario = new FuncionarioDAO().buscaFuncionario(tpesquisa
                    .getText());
 
            // verifica resultado
            long resultado = funcionario.getId();
 
            // Alimenta dados na GUI
            if (resultado != 0) {
                tid.setText(String.valueOf(funcionario.getId()));
                tpnome.setText(funcionario.getNome());
                tsnome.setText(funcionario.getSobrenome());
                tcargo.setText(funcionario.getCargo());
                tsalario.setText(String.valueOf(funcionario.getSalario()));
            } else {
 
                JOptionPane.showMessageDialog(menssagem,
                        "Funcionario n�o encontrado!");
 
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        tpesquisa.requestFocus();
                        tpesquisa.selectAll();
                    }
                });
            }
        }
 
        // Bot�o Novo
        if (arg0.getSource() == novo) {
 
            // Limpa GUI
            tid.setText(null);
            tpnome.setText(null);
            tsnome.setText(null);
            tcargo.setText(null);
            tsalario.setText(null);
 
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    tid.requestFocus();
                }
            });
 
        }
 
        // Insere dados
        if (arg0.getSource() == inserir) {
 
            // Cria funcionario usando o construtor Overload
            Funcionario funcionario = new Funcionario(Integer.parseInt(tid
                    .getText()), tpnome.getText(), tsnome.getText(),
                    tcargo.getText(), Double.parseDouble(tsalario.getText()));
 
            // Cria objeto DAO
            FuncionarioDAO inserir = new FuncionarioDAO();
 
            // Insere funcionario
            boolean resultado = inserir.insereFuncionario(funcionario);
 
            // Exibe resultado
            if (resultado) {
                JOptionPane.showMessageDialog(menssagem,
                        "Dados inseridos com sucesso!");
            } else {
                JOptionPane.showMessageDialog(menssagem,
                        "Erro ao inserir Dados!");
            }
 
        }
 
        // Altera dados
        if (arg0.getSource() == alterar) {
 
            // Cria funcionario usando o construtor overload
            Funcionario funcionario = new Funcionario(Integer.parseInt(tid
                    .getText()), tpnome.getText(), tsnome.getText(),
                    tcargo.getText(), Double.parseDouble(tsalario.getText()));
 
            // Cria objeto DAO
            FuncionarioDAO alterar = new FuncionarioDAO();
 
            // Altera funcionario
            boolean resultado = alterar.updateFuncionario(funcionario);
 
            if (resultado) {
                JOptionPane.showMessageDialog(menssagem,
                        "Dados alterados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(menssagem,
                        "Erro ao alterar Dados!");
            }
 
        }
 
        // Deleta dados
        if (arg0.getSource() == deletar) {
 
            // Cria funcionario utilizando o construtor overload
            Funcionario funcionario = new Funcionario(Integer.parseInt(tid
                    .getText()), tpnome.getText(), tsnome.getText(),
                    tcargo.getText(), Double.parseDouble(tsalario.getText()));
 
            // Cria objeto DAO
            FuncionarioDAO apagar = new FuncionarioDAO();
 
            // Deleta funcionario
            boolean resultado = apagar.deletaFuncionario(funcionario);
 
            // Exibe resultado
            if (resultado) {
                JOptionPane.showMessageDialog(menssagem,
                        "Dados apagados com sucesso!");
 
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        tpesquisa.requestFocus();
                        tpesquisa.selectAll();
                    }
                });
 
                novo.doClick();
            } else {
 
                JOptionPane.showMessageDialog(menssagem,
                        "Erro ao apagar Dados!");
 
            }
        }
 
    }
 
    public static void criaGUI() {
        // Cria formulario
        JFrame formulario = new JFrame("Desenvolvimento Aberto");
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // cria painel de conteudo
        DAApp app = new DAApp();
 
        formulario.setContentPane(app.criaPainel());
 
        // Exibe o formulario
        formulario.setSize(400, 450);
        formulario.setVisible(true);
 
    }
 
    public static void main(String[] args) {
 
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
 
            @Override
            public void run() {
 
                // Mostra GUI
                criaGUI();
 
            }
        });
 
    }
 
}
