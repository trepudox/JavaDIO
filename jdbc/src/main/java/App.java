import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dio_teste";

        try (Connection connection = DriverManager.getConnection(url, "root", "root")) {
            System.out.println("Conectou");
        } catch(SQLException e) {
            System.out.println(e.getStackTrace());
        }


    //    System.out.println("Hello World!");
    }
}
