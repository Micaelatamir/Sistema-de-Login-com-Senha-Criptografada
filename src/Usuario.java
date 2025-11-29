package  model;

import java.time.LocalDate;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senhaNormal;
    private String senha_hash;
    private LocalDate data_cadastro;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenhaNormal() {
        return senhaNormal;
    }
    public void setSenhaNormal(String senhaNormal) {
        this.senhaNormal = senhaNormal;
    }
    public String getSenha_hash() {
        return senha_hash;
    }
    public void setSenha_hash(String senha_hash) {
        this.senha_hash = senha_hash;
    }
    public LocalDate getData_cadastro() {
        return data_cadastro;
    }
    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

}
