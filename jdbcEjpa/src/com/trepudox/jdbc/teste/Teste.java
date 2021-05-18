import java.sql.DriverManager;

public class Teste {
    public static void main(String[] args) {
        Connection connection = DriverManager.getConnection(url, user, password);
    }
}
