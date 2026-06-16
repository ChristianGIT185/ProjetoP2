package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Leitor;
import util.Conexao;
import java.util.ArrayList;
import java.util.List;


//Primeiro método a ser implementado nesta classe: Inserção

public class LeitorDAO {
    private int id;
    private String nome;
    private String email;

    public void inserir(Leitor leitor){
        String sql = "INSERT INTO leitor(nome, email) VALUES(?, ?)";

        try(Connection conn = Conexao.getConexao();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, leitor.GetNome());
            stmt.setString(2, leitor.GetEmail());

            stmt.executeUpdate();
            System.out.println("Leitor cadastrado com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //Implementação do controle SELECT para listar leitores cadastrados

    public List<Leitor> listar(){
        String sql = "SELECT * FROM leitor";
        List<Leitor> lista = new ArrayList<>();

        try(Connection conn = Conexao.getConexao();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {
            while(rs.next()){
                Leitor l = new Leitor();
                l.SetId(rs.getInt("Id"));
                l.SetNome(rs.getString("Nome"));
                l.SetEmail(rs.getString("Email"));

                lista.add(l);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    
    }

    public void atualizar(Leitor leitor){
        String sql = "UPDATE leitor SET nome = ?, email = ? WHERE id = ?";

        try(Connection conn = Conexao.getConexao();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, leitor.GetNome());
            stmt.setString(2, leitor.GetEmail());
            stmt.setInt(3, leitor.GetId());
            
            stmt.executeUpdate();


        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void deletar(int id){
        String sql = "DELETE FROM leitor WHERE id = ?";

        try(Connection conn = Conexao.getConexao();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch(Exception e){
            e.printStackTrace();
        }


    }














}

