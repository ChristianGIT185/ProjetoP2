package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao{
    private static final String URL = "jdbc:mysql://localhost:3306/Biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "ADS@Banco2026";

    public static Connection getConexao(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch(Exception e){
            throw new RuntimeException("Erro ao conectar:" + e.getMessage());

        }
    }


}



