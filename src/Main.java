package main;

import model.Usuario;
import dao.UsuarioDAO;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection conexao = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/sistema_de_login_com_senha_criptografada",
                    "postgres",
                    "977310607"
            );

            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

            int opcao = 0;

            while (opcao != 3) {
                System.out.println("\n======= MENU =======");
                System.out.println("1 - Cadastrar Usuário");
                System.out.println("2 - Fazer Login");
                System.out.println("3 - Sair");
                System.out.print("Escolha: ");

                opcao = sc.nextInt();
                sc.nextLine(); // LIMPA ENTER

                switch (opcao) {

                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        System.out.print("Senha: ");
                        String senha = sc.nextLine();

                        // Criar usuário
                        Usuario novo = new Usuario();
                        novo.setNome(nome);
                        novo.setEmail(email);
                        novo.setSenhaNormal(senha);

                        usuarioDAO.salvar(novo);

                        System.out.println("Usuário cadastrado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Email: ");
                        String emailLogin = sc.nextLine();

                        System.out.print("Senha: ");
                        String senhaLogin = sc.nextLine();

                        Usuario usuarioLogado = usuarioDAO.Login(emailLogin, senhaLogin);

                        if (usuarioLogado == null) {
                            System.out.println("Email ou senha incorretos!");
                        } else {
                            System.out.println("Login realizado com sucesso! Bem-vindo, " + usuarioLogado.getNome());
                        }
                        break;

                    case 3:
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
