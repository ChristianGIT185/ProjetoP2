package view;

import javax.swing.*;
import java.util.List;

import dao.FuncionarioDAO;
import model.Funcionario;

public class TelaFuncionario extends JFrame {

    public TelaFuncionario() {

        setTitle("Cadastro de Funcionários");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("FUNCIONÁRIOS");
        titulo.setBounds(180, 10, 200, 25);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(30, 50, 80, 25);

        JTextField txtId = new JTextField();
        txtId.setBounds(120, 50, 300, 25);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 90, 80, 25);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(120, 90, 300, 25);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 130, 80, 25);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(120, 130, 300, 25);

        JLabel lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(30, 170, 80, 25);

        JTextField txtCargo = new JTextField();
        txtCargo.setBounds(120, 170, 300, 25);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(30, 220, 100, 30);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(140, 220, 110, 30);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(260, 220, 100, 30);

        JButton btnListar = new JButton("Listar");
        btnListar.setBounds(370, 220, 100, 30);

        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(30, 270, 480, 120);

        add(titulo);

        add(lblId);
        add(txtId);

        add(lblNome);
        add(txtNome);

        add(lblEmail);
        add(txtEmail);

        add(lblCargo);
        add(txtCargo);

        add(btnSalvar);
        add(btnAtualizar);
        add(btnExcluir);
        add(btnListar);

        add(scroll);

        // CREATE
        btnSalvar.addActionListener(e -> {

            Funcionario f = new Funcionario();

            f.SetNome(txtNome.getText());
            f.SetEmail(txtEmail.getText());
            f.SetCargo(txtCargo.getText());

            new FuncionarioDAO().inserir(f);

            JOptionPane.showMessageDialog(null,
                    "Funcionário cadastrado com sucesso!");
        });

        // READ
        btnListar.addActionListener(e -> {

            area.setText("");

            List<Funcionario> lista =
                    new FuncionarioDAO().listar();

            for (Funcionario f : lista) {

                area.append(
                        "ID: " + f.GetId()
                        + " | Nome: " + f.GetNome()
                        + " | Email: " + f.GetEmail()
                        + " | Cargo: " + f.GetCargo()
                        + "\n"
                );
            }
        });

        // UPDATE
        btnAtualizar.addActionListener(e -> {

            Funcionario f = new Funcionario();

            f.SetId(Integer.parseInt(txtId.getText()));
            f.SetNome(txtNome.getText());
            f.SetEmail(txtEmail.getText());
            f.SetCargo(txtCargo.getText());

            new FuncionarioDAO().atualizar(f);

            JOptionPane.showMessageDialog(null,
                    "Funcionário atualizado!");
        });

        // DELETE
        btnExcluir.addActionListener(e -> {

            int id =
                    Integer.parseInt(txtId.getText());

            new FuncionarioDAO().deletar(id);

            JOptionPane.showMessageDialog(null,
                    "Funcionário excluído!");
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}