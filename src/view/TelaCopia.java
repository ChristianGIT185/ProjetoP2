package view;

import javax.swing.*;
import java.util.List;

import dao.CopiaDAO;
import model.Copia;
import model.Obra;

public class TelaCopia extends JFrame {

    public TelaCopia() {

        setTitle("Cadastro de Cópias");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("CÓPIAS");
        titulo.setBounds(210, 10, 200, 25);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(30, 50, 80, 25);

        JTextField txtId = new JTextField();
        txtId.setBounds(120, 50, 300, 25);

        JLabel lblObra = new JLabel("ID da Obra:");
        lblObra.setBounds(30, 90, 100, 25);

        JTextField txtObra = new JTextField();
        txtObra.setBounds(120, 90, 300, 25);

        JLabel lblDisponivel = new JLabel("Disponível:");
        lblDisponivel.setBounds(30, 130, 100, 25);

        JTextField txtDisponivel = new JTextField();
        txtDisponivel.setBounds(120, 130, 300, 25);

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
        scroll.setBounds(30, 240, 480, 130);

        add(titulo);

        add(lblId);
        add(txtId);

        add(lblObra);
        add(txtObra);

        add(lblDisponivel);
        add(txtDisponivel);

        add(btnSalvar);
        add(btnAtualizar);
        add(btnExcluir);
        add(btnListar);

        add(scroll);

     
        btnSalvar.addActionListener(e -> {

            try {

                Obra obra = new Obra();
                obra.SetId(Integer.parseInt(txtObra.getText()));

                Copia copia = new Copia();
                copia.SetObra(obra);
                copia.SetDisponivel(
                        Boolean.parseBoolean(
                                txtDisponivel.getText()
                        )
                );

                new CopiaDAO().inserir(copia);

                JOptionPane.showMessageDialog(
                        null,
                        "Cópia cadastrada com sucesso!"
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

                List<Copia> lista =
                        new CopiaDAO().listar();

                for (Copia c : lista) {

                    area.append(
                            "ID: " + c.GetId()
                            + " | Obra: "
                            + c.getObra().GetId()
                            + " | Disponível: "
                            + c.isDisponivel()
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

                Obra obra = new Obra();
                obra.SetId(Integer.parseInt(txtObra.getText()));

                Copia copia = new Copia();

                copia.SetId(
                        Integer.parseInt(
                                txtId.getText()
                        )
                );

                copia.SetObra(obra);

                copia.SetDisponivel(
                        Boolean.parseBoolean(
                                txtDisponivel.getText()
                        )
                );

                new CopiaDAO().atualizar(copia);

                JOptionPane.showMessageDialog(
                        null,
                        "Cópia atualizada!"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage()
                );
            }
        });

      
        btnExcluir.addActionListener(e -> {

            try {

                int id =
                        Integer.parseInt(
                                txtId.getText()
                        );

                new CopiaDAO().deletar(id);

                JOptionPane.showMessageDialog(
                        null,
                        "Cópia excluída!"
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



