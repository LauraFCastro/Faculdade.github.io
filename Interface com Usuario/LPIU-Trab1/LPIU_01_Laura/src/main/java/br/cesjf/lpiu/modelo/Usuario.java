/**
 * @author laura
 */

package br.cesjf.lpiu.modelo;

public class Usuario {
    
    private String usuario;
    private String senha;

    public Usuario() {
        this.usuario = "admin";
        this.senha = "1234567";
    }

    public boolean validarLogin(String login) {

        if (login.trim().length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarSenha(String vsenha) {
        if (vsenha.length() > 6 && vsenha.length() < 12) {
            return true;
        } else {
            return false;
        }
    }

    public boolean autenticar(String login, String senhaLogin) {
        if (login.equalsIgnoreCase(this.usuario) && senhaLogin.equalsIgnoreCase(this.senha)) {
            return true;
        } else {
            return false;
        }
    }
    
}
