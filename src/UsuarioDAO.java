package dao;

import model Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class UsuarioDAO {
    Connection conexao;
    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }
    public void salvar(model.Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha_hash) VALUES (?, ?. ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha_hash());
        stmt.executeUpdate();
        stmt.close();

    }

    public Usuario login(String email, String senha_hash) {
        String sql = "SELECT * FROM usuarios WHERE email = ? and senha_hash = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, getNome());
        stmt.setString(2, getSenha);
    }



    public void BuscarEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";

    }

    public void listar() {
        String sql = "SELECT * FROM usuarios";
    }

}
