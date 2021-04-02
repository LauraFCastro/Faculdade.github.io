/**
 * @author Laura
 */

package br.cesjf.lpiu.modelo;

import java.io.Serializable;

public class Pessoa implements Serializable{

    private String cpf;
    private String nome, cnh, cep, endereco, numero, complemento, bairro, cidade, estado;
    private String data;
    
    public Pessoa(String cpf, String nome, String data, String cnh, String cep, 
                  String endereco, String numero, String complemento,
                  String bairro, String cidade, String estado){
        this.cpf = cpf;
        this.nome = nome;
        this.data = data;
        this.cnh = cnh;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    public Pessoa(){
    }
    
    @Override
    public String toString() {
        return "CPF: " + this.cpf + ", Nome: " + this.nome +
               ", Data de Nascimento: " + this.data + ", CNH: " + this.cnh + 
                ", CEP: " + this.cep + "\nEndereço: " + this.endereco + 
                ", Número: " + this.numero + ", Complemento: "
                + this.complemento + ", Bairro: " + this.bairro + ", Cidade: " 
                + this.cidade + ", Estado: " + this.estado + "\n \n";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public Object[] getpessoa() {
        Object pessoa[] = {cpf, nome, data, cnh, cep, endereco, numero, 
                           complemento, bairro, cidade, estado};
        return pessoa;
    }
    
    public Object[] getpessoaID(){
        Object pessoaID[] = {cpf, nome};
        return pessoaID;
    }
    
}
