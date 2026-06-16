package view;

import javax.swing.*;
import java.util.List;

import dao.EmprestimoDAO;
import model.Emprestimo;
import model.Leitor;
import model.Copia;

public class TelaEmprestimo extends JFrame {

    public TelaEmprestimo() {

        setTitle("Gerenciar Empréstimos");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("EMPRÉSTIMOS");
        titulo.setBounds(220, 10, 200, 25);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(30, 50, 80, 25);

        JTextField txtId = new JTextField();
        txtId.setBounds(130, 50, 250, 25);

        JLabel lblLeitor = new JLabel("ID Leitor:");
        lblLeitor.setBounds(30, 90, 80, 25);

        JTextField txtLeitor = new JTextField();
        txtLeitor.setBounds(130, 90, 250, 25);

        JLabel lblCopia = new JLabel("ID Cópia:");
        lblCopia.setBounds(30, 130, 80, 25);

        JTextField txtCopia = new JTextField();
        txtCopia.setBounds(130, 130, 250, 25);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(30, 180, 100, 30);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(140, 180, 110, 30);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(260, 180, 100, 30);

        JButton btnListar = new JButton("Listar");
        btnListar.setBounds(370, 180, 100, 30);

        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(30, 230, 520, 140);

        add(titulo);

        add(lblId);
        add(txtId);

        add(lblLeitor);
        add(txtLeitor);

        add(lblCopia);
        add(txtCopia);

        add(btnSalvar);
        add(btnAtualizar);
        add(btnExcluir);
        add(btnListar);

        add(scroll);

        // CREATE
        btnSalvar.addActionListener(e -> {

            try {

                Leitor leitor = new Leitor();
                leitor.SetId(Integer.parseInt(txtLeitor.getText()));

                Copia copia = new Copia();
                copia.SetId(Integer.parseInt(txtCopia.getText()));

                Emprestimo emp = new Emprestimo();
                emp.SetLeitor(leitor);
                emp.SetCopia(copia);

                new EmprestimoDAO().inserir(emp);

                JOptionPane.showMessageDialog(
                        null,
                        "Empréstimo cadastrado com sucesso!"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage()
                );
            }
        });

        // READ
        btnListar.addActionListener(e -> {

            try {

                area.setText("");

                List<Emprestimo> lista =
                        new EmprestimoDAO().listar();

                for (Emprestimo emp : lista) {

                    area.append(
                            "ID: " + emp.GetId()
                            + " | Leitor: "
                            + emp.GetLeitor().GetId()
                            + " | Cópia: "
                            + emp.GetCopia().GetId()
                            + "\n"
                    );
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage()
                );
            }
        });

        // UPDATE
        btnAtualizar.addActionListener(e -> {

            try {

                Leitor leitor = new Leitor();
                leitor.SetId(
                        Integer.parseInt(
                                txtLeitor.getText()
                        )
                );

                Copia copia = new Copia();
                copia.SetId(
                        Integer.parseInt(
                                txtCopia.getText()
                        )
                );

                Emprestimo emp = new Emprestimo();

                emp.SetId(
                        Integer.parseInt(
                                txtId.getText()
                        )
                );

                emp.SetLeitor(leitor);
                emp.SetCopia(copia);

                new EmprestimoDAO()
                        .atualizar(emp);

                JOptionPane.showMessageDialog(
                        null,
                        "Empréstimo atualizado!"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage()
                );
            }
        });

        // DELETE
        btnExcluir.addActionListener(e -> {

            try {

                int id =
                        Integer.parseInt(
                                txtId.getText()
                        );

                new EmprestimoDAO()
                        .deletar(id);

                JOptionPane.showMessageDialog(
                        null,
                        "Empréstimo excluído!"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage()
                );
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
