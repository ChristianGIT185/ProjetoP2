package view;

import javax.swing.*;

public class TelaMenu extends JFrame {

    private JButton btnLeitores = new JButton("Gerenciar Leitores");
    private JButton btnObras = new JButton("Gerenciar Obras");
    private JButton btnEmprestimos = new JButton("Realizar Empréstimo");
    private JButton btnReservas = new JButton("Gerenciar Reservas");
    private JButton btnFuncionarios = new JButton("Funcionários");
    private JButton btnCopias = new JButton("Gerenciar Cópias");

    public TelaMenu() {

        setTitle("Sistema de Biblioteca");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("Seja Bem-vindo ao Sistema de Biblioteca");
        titulo.setBounds(100, 20, 300, 25);

        btnLeitores.setBounds(100, 60, 220, 30);
        btnObras.setBounds(100, 100, 220, 30);
        btnEmprestimos.setBounds(100, 140, 220, 30);
        btnReservas.setBounds(100, 180, 220, 30);
        btnFuncionarios.setBounds(100, 220, 220, 30);
        btnCopias.setBounds(100, 260, 220, 30);

        add(titulo);
        add(btnLeitores);
        add(btnObras);
        add(btnEmprestimos);
        add(btnReservas);
        add(btnFuncionarios);
        add(btnCopias);


        btnLeitores.addActionListener(e -> new TelaLeitor().setVisible(true));

        btnObras.addActionListener(e -> new TelaObra().setVisible(true));

        btnEmprestimos.addActionListener(e -> new TelaEmprestimo().setVisible(true));

        btnReservas.addActionListener(e -> new TelaReserva().setVisible(true));

        btnFuncionarios.addActionListener(e -> new TelaFuncionario().setVisible(true));

        btnCopias.addActionListener(e -> new TelaCopia().setVisible(true));

        setVisible(true);
    }
}
