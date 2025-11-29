package dao;

import model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.security.MessageDigest;

public class UsuarioDAO {
    Connection conexao;

    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // SALVAR USUÁRIO
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha_hash) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());

            // GERAR HASH ANTES DE SALVAR
            String hash = gerarHash(usuario.getSenhaNormal());
            stmt.setString(3, hash);

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // GERAR HASH
    public static String gerarHash(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(senha.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // LOGIN
    public Usuario Login(String email, String senhaDigitada) {
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha_hash = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            // GERAR HASH DA SENHA DIGITADA
            String hashGerado = gerarHash(senhaDigitada);

            stmt.setString(1, email);
            stmt.setString(2, hashGerado);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                // não retornar senha
                return u;
            }

            return null; // login incorreto
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
