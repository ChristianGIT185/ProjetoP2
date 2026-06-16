package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

import model.reserva;
import model.Leitor;
import model.Obra;




public class ReservaDAO {

    public void inserir(reserva r) {
        String sql = "INSERT INTO reserva (leitor_id, obra_id) VALUES (?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, r.GetLeitor().GetId());
            stmt.setInt(2, r.GetObra().GetId());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir reserva: " + e.getMessage());
        }
    }

    public List<reserva> listar() {
        List<reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reserva";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                reserva r = new reserva();
                r.SetId(rs.getInt("id"));

                Leitor l = new Leitor();
                l.SetId(rs.getInt("leitor_id"));
                r.SetLeitor(l);

                Obra o = new Obra();
                o.SetId(rs.getInt("obra_id"));
                r.SetObra(o);

                lista.add(r);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar reservas: " + e.getMessage());
        }

        return lista;
    }


    public void atualizar(reserva r) {

    String sql = "UPDATE reserva SET leitor_id=?, obra_id=? WHERE id=?";

    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, r.GetLeitor().GetId());
        stmt.setInt(2, r.GetObra().GetId());
        stmt.setInt(3, r.GetId());

        stmt.executeUpdate();

    } catch (Exception e) {

        throw new RuntimeException(
            "Erro ao atualizar reserva: " + e.getMessage()
        );

    }
}


    public void deletar(int id) {
        String sql = "DELETE FROM reserva WHERE id=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar reserva: " + e.getMessage());
        }
    }
}









