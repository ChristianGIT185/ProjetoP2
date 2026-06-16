package view;

import javax.swing.*;
import java.util.List;

import dao.ReservaDAO;
import model.reserva;
import model.Leitor;
import model.Obra;

public class TelaReserva extends JFrame {

    public TelaReserva() {

        setTitle("Gerenciar Reservas");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("RESERVAS");
        titulo.setBounds(220, 10, 200, 25);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(30, 50, 80, 25);

        JTextField txtId = new JTextField();
        txtId.setBounds(130, 50, 250, 25);

        JLabel lblLeitor = new JLabel("ID Leitor:");
        lblLeitor.setBounds(30, 90, 80, 25);

        JTextField txtLeitor = new JTextField();
        txtLeitor.setBounds(130, 90, 250, 25);

        JLabel lblObra = new JLabel("ID Obra:");
        lblObra.setBounds(30, 130, 80, 25);

        JTextField txtObra = new JTextField();
        txtObra.setBounds(130, 130, 250, 25);

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
        scroll.setBounds(30, 240, 520, 140);

        add(titulo);

        add(lblId);
        add(txtId);

        add(lblLeitor);
        add(txtLeitor);

        add(lblObra);
        add(txtObra);

        add(btnSalvar);
        add(btnAtualizar);
        add(btnExcluir);
        add(btnListar);

        add(scroll);

        // CREATE
        btnSalvar.addActionListener(e -> {

            try {

                Leitor leitor = new Leitor();
                leitor.SetId(
                        Integer.parseInt(
                                txtLeitor.getText()
                        )
                );

                Obra obra = new Obra();
                obra.SetId(
                        Integer.parseInt(
                                txtObra.getText()
                        )
                );

                reserva reserva = new reserva();

                reserva.SetLeitor(leitor);
                reserva.SetObra(obra);

                new ReservaDAO().inserir(reserva);

                JOptionPane.showMessageDialog(
                        null,
                        "Reserva cadastrada com sucesso!"
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

                List<reserva> lista =
                        new ReservaDAO().listar();

                for (reserva r : lista) {

                    area.append(
                            "ID: " + r.GetId()
                            + " | Leitor: "
                            + r.GetLeitor().GetId()
                            + " | Obra: "
                            + r.GetObra().GetId()
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

                Obra obra = new Obra();
                obra.SetId(
                        Integer.parseInt(
                                txtObra.getText()
                        )
                );

                reserva reserva = new reserva();

                reserva.SetId(
                        Integer.parseInt(
                                txtId.getText()
                        )
                );

                reserva.SetLeitor(leitor);
                reserva.SetObra(obra);

                new ReservaDAO().atualizar(reserva);

                JOptionPane.showMessageDialog(
                        null,
                        "Reserva atualizada!"
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

                new ReservaDAO().deletar(id);

                JOptionPane.showMessageDialog(
                        null,
                        "Reserva excluída!"
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