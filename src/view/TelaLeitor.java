package view;

import javax.swing.*;
import java.util.List;

import dao.LeitorDAO;
import model.Leitor;

public class TelaLeitor extends JFrame {

    public TelaLeitor() {

        setTitle("Cadastro de Leitores");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("Cadastro de Leitores");
        titulo.setBounds(170, 10, 200, 25);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(30, 50, 80, 25);

        JTextField txtId = new JTextField();
        txtId.setBounds(100, 50, 300, 25);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 90, 80, 25);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 90, 300, 25);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 130, 80, 25);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(100, 130, 300, 25);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(30, 180, 100, 30);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(140, 180, 120, 30);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(270, 180, 100, 30);

        JButton btnListar = new JButton("Listar");
        btnListar.setBounds(380, 180, 90, 30);

        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(30, 230, 440, 160);

        add(titulo);

        add(lblId);
        add(txtId);

        add(lblNome);
        add(txtNome);

        add(lblEmail);
        add(txtEmail);

        add(btnSalvar);
        add(btnAtualizar);
        add(btnExcluir);
        add(btnListar);

        add(scroll);

        // ================= SALVAR =================
        btnSalvar.addActionListener(e -> {

            try {

                Leitor l = new Leitor();
                l.SetNome(txtNome.getText());
                l.SetEmail(txtEmail.getText());

                new LeitorDAO().inserir(l);

                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        });

        // ================= LISTAR =================
        btnListar.addActionListener(e -> {

            try {

                LeitorDAO dao = new LeitorDAO();
                List<Leitor> lista = dao.listar();

                area.setText("");

                for (Leitor l : lista) {
                    area.append(
                            "ID: " + l.GetId() +
                            " | Nome: " + l.GetNome() +
                            " | Email: " + l.GetEmail() + "\n"
                    );
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        });

        // ================= ATUALIZAR =================
        btnAtualizar.addActionListener(e -> {

            try {

                Leitor l = new Leitor();

                l.SetId(Integer.parseInt(txtId.getText()));
                l.SetNome(txtNome.getText());
                l.SetEmail(txtEmail.getText());

                new LeitorDAO().atualizar(l);

                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        });

        // ================= EXCLUSÃO =================
        btnExcluir.addActionListener(e -> {

            try {

                int id = Integer.parseInt(txtId.getText());

                new LeitorDAO().deletar(id);

                JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}