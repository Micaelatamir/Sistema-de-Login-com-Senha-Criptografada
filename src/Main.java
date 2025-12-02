package main;
import model.Usuario;
import dao.UsuarioDao;
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
        );
        dao.UsuarioDAO usuarioDAO = new dao.UsuarioDAO(conexao);

    int opcao = 0;
    while(opcao!=3){
    System.out.println("=======MENU=======");
    System.out.println("1- Cadastrar Usuario");
    System.out.println("2- Fazer Login");
    System.out.println("3- Sair");
    opcao = sc.nextInt();

    switch(opcao){
        case 1:
    System.out.println("Nome:");
    String nome = sc.next();
    System.out.println("Email:");
    String email = sc.next();
    System.out.println("Senha:");
    String senha = sc.next();

    Usuario novo = new Usuario(nome,email,senha);
    UsuarioDao.salvar(novo);
    System.out.println("Usuario cadastrado com sucesso!");
    break;

    case 2:
        System.out.println(" login:");
        String login = sc.next();
        System.out.println(" Senha:");
        String senha = sc.next();
        String senhaLogin = sc.next();
        usuariosLogado = UsuarioDao.login(emaillogin, senhaLogin);
        if (usuariosLogado == null) {
            System.out.println("Email ou senha incorretos!");
            break;
        }

        System.out.println("Login realizado com sucesso!");
        break;


    }

    }

    }


}
}
