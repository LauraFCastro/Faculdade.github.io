/**
 * @author Laura
 */
package dominio;

public class Professor {
    private int codigo;
    private String nome;
    private String email;
    private String titulacao;
    private String genero;
    private String cidade;

    public Professor(){}
    
    public Professor(int codigo, String nome, String email, String titulacao, String genero, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.titulacao = titulacao;
        this.genero = genero;
        this.cidade = cidade;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getSexo() {
        return genero;
    }

    public void setSexo(String genero) {
        this.genero = genero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    
    
}
