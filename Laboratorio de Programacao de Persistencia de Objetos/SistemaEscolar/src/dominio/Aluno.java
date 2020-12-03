/**
 * @author Laura
 */
package dominio;

public class Aluno {
        private int id;
	private String nome;
	private String email;
	private String telefone;
	private String celular;
	private String obs;

    public Aluno() {
    }

    public Aluno(int id, String nome, String email, String telefone, String celular, String obs) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.obs = obs;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String observacao) {
        this.obs = observacao;
    }

   
}
