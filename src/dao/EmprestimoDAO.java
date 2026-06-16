package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

import model.Emprestimo;
import model.Leitor;
import model.Copia;



public class EmprestimoDAO {

    public void inserir(Emprestimo e) {
        String sql = "INSERT INTO emprestimo (leitor_id, copia_id) VALUES (?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, e.GetLeitor().GetId());
            stmt.setInt(2, e.GetCopia().GetId());

            stmt.executeUpdate();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir empréstimo: " + ex.getMessage());
        }
    }

    public List<Emprestimo> listar() {
        List<Emprestimo> lista = new ArrayList<>();
        String sql = "SELECT * FROM emprestimo";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Emprestimo e = new Emprestimo();
                e.SetId(rs.getInt("id"));

                Leitor l = new Leitor();
                l.SetId(rs.getInt("leitor_id"));
                e.SetLeitor(l);

                Copia c = new Copia();
                c.SetId(rs.getInt("copia_id"));
                e.SetCopia(c);

                lista.add(e);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao listar empréstimos: " + ex.getMessage());
        }

        return lista;
    }


    public void atualizar(Emprestimo e) {

    String sql = "UPDATE emprestimo SET leitor_id=?, copia_id=? WHERE id=?";

    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, e.GetLeitor().GetId());
        stmt.setInt(2, e.GetCopia().GetId());
        stmt.setInt(3, e.GetId());

        stmt.executeUpdate();

    } catch (Exception ex) {

        throw new RuntimeException(
                "Erro ao atualizar empréstimo: " + ex.getMessage()
        );

    }
}


    public void deletar(int id) {
        String sql = "DELETE FROM emprestimo WHERE id=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar empréstimo: " + ex.getMessage());
        }
    }
}