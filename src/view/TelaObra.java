package view;

import javax.swing.*;
import java.util.List;

import dao.ObraDAO;
import model.Obra;

public class TelaObra extends JFrame {

    public TelaObra() {

        setTitle("Cadastro de Obras");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("OBRAS");
        titulo.setBounds(220, 10, 150, 25);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(30, 50, 80, 25);

        JTextField txtId = new JTextField();
        txtId.setBounds(120, 50, 300, 25);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(30, 90, 80, 25);

        JTextField txtTitulo = new JTextField();
        txtTitulo.setBounds(120, 90, 300, 25);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(30, 130, 80, 25);

        JTextField txtAutor = new JTextField();
        txtAutor.setBounds(120, 130, 300, 25);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(30, 190, 100, 30);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(140, 190, 110, 30);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(260, 190, 100, 30);

        JButton btnListar = new JButton("Listar");
        btnListar.setBounds(370, 190, 100, 30);

        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(30, 240, 480, 140);

        add(titulo);

        add(lblId);
        add(txtId);

        add(lblTitulo);
        add(txtTitulo);

        add(lblAutor);
        add(txtAutor);

        add(btnSalvar);
        add(btnAtualizar);
        add(btnExcluir);
        add(btnListar);

        add(scroll);

  
        btnSalvar.addActionListener(e -> {

            try {

                Obra o = new Obra();

                o.SetTitulo(txtTitulo.getText());
                o.SetAutor(txtAutor.getText());

                new ObraDAO().inserir(o);

                JOptionPane.showMessageDialog(
                        null,
                        "Obra cadastrada com sucesso!"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage()
                );
            }
        });

        
        btnListar.addActionListener(e -> {

            try {

                area.setText("");

                List<Obra> lista =
                        new ObraDAO().listar();

                for (Obra o : lista) {

                    area.append(
                            "ID: " + o.GetId()
                            + " | Título: "
                            + o.GetTitulo()
                            + " | Autor: "
                            + o.GetAutor()
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

        
        btnAtualizar.addActionListener(e -> {

            try {

                Obra o = new Obra();

                o.SetId(
                        Integer.parseInt(
                                txtId.getText()
                        )
                );

                o.SetTitulo(txtTitulo.getText());
                o.SetAutor(txtAutor.getText());

                new ObraDAO().atualizar(o);

                JOptionPane.showMessageDialog(
                        null,
                        "Obra atualizada!"
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

                new ObraDAO().deletar(id);

                JOptionPane.showMessageDialog(
                        null,
                        "Obra excluída!"
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