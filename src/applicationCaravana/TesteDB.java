package applicationCaravana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TesteDB {
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Classe carregada...");
            Connection con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/filmes",
                    "root", "alunofatec");
            System.out.println("Conectado com o banco de dados");
            String sql = "INSERT INTO filmes (id, titulo, lancamento, tempo) ";
            sql+= " VALUES (4, 'Dr. Estanho - No multiverso da loucura', '2022-05-01', 150)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Registro inserido com sucesso");
            sql = "SELECT * FROM filmes";
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println( "Filmes: " + rs.getString("titulo") +
                        " lan?ado em " + rs.getDate("lancamento") );
            }
            System.out.println("Registro lidos com sucesso");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}