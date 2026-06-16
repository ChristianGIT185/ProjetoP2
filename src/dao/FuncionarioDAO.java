package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import util.Conexao;


public class FuncionarioDAO {

    public void inserir(Funcionario f) {
        String sql = "INSERT INTO funcionario (nome, email, cargo) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.GetNome());
            stmt.setString(2, f.GetEmail());
            stmt.setString(3, f.GetCargo());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir funcionário: " + e.getMessage());
        }
    }

    public List<Funcionario> listar() {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.SetId(rs.getInt("id"));
                f.SetNome(rs.getString("nome"));
                f.SetEmail(rs.getString("email"));
                f.SetCargo(rs.getString("cargo"));

                lista.add(f);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar funcionários: " + e.getMessage());
        }

        return lista;
    }

    public void atualizar(Funcionario f) {
        String sql = "UPDATE funcionario SET nome=?, email=?, cargo=? WHERE id=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.GetNome());
            stmt.setString(2, f.GetEmail());
            stmt.setString(3, f.GetCargo());
            stmt.setInt(4, f.GetId());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM funcionario WHERE id=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar funcionário: " + e.getMessage());
        }
    }
}






