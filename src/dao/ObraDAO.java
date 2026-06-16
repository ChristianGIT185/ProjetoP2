package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

import model.Obra;


public class ObraDAO {

    public void inserir(Obra o) {
        String sql = "INSERT INTO obra (titulo, autor) VALUES (?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, o.GetTitulo());
            stmt.setString(2, o.GetAutor());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir obra: " + e.getMessage());
        }
    }

    public List<Obra> listar() {
        List<Obra> lista = new ArrayList<>();
        String sql = "SELECT * FROM obra";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Obra o = new Obra();
                o.SetId(rs.getInt("id"));
                o.SetTitulo(rs.getString("titulo"));
                o.SetAutor(rs.getString("autor"));

                lista.add(o);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar obras: " + e.getMessage());
        }

        return lista;
    }

    public void atualizar(Obra o) {
        String sql = "UPDATE obra SET titulo=?, autor=? WHERE id=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, o.GetTitulo());
            stmt.setString(2, o.GetAutor());
            stmt.setInt(3, o.GetId());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar obra: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM obra WHERE id=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar obra: " + e.getMessage());
        }
    }
}













