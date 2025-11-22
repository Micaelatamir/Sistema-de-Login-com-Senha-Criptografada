import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;




public class Main {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try{
        Connection conexao = DriverManager.getConnection(
         "jdbc:postgresql://localhost:5432/sistema_de_login_com_senha_criptografada",
         "postgres",
         "977310607"
        )
    }

}
}
