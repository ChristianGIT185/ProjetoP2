package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

import model.Copia;
import model.Obra;



public class CopiaDAO {

    public void inserir(Copia c) {
        String sql = "INSERT INTO copia (obra_id, disponivel) VALUES (?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getObra().GetId());
            stmt.setBoolean(2, c.isDisponivel());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir cópia: " + e.getMessage());
        }
    }

    public List<Copia> listar() {
        List<Copia> lista = new ArrayList<>();
        String sql = "SELECT * FROM copia";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Copia c = new Copia();
                c.SetId(rs.getInt("id"));
                c.SetDisponivel(rs.getBoolean("disponivel"));

                // obra simplificada (só id)
                Obra o = new Obra();
                o.SetId(rs.getInt("obra_id"));
                c.SetObra(o);

                lista.add(c);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar cópias: " + e.getMessage());
        }

        return lista;
    }

    public void atualizar(Copia c) {
        String sql = "UPDATE copia SET obra_id=?, disponivel=? WHERE id=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getObra().GetId());
            stmt.setBoolean(2, c.isDisponivel());
            stmt.setInt(3, c.GetId());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar cópia: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM copia WHERE id=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar cópia: " + e.getMessage());
        }
    }
}



