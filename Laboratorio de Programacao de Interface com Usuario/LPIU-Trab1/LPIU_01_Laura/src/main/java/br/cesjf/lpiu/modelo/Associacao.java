/**
 * @author Laura
 */

package br.cesjf.lpiu.modelo;

import java.io.Serializable;

public class Associacao implements Serializable{

    private String cpf, placa, nome, modelo;

    public Associacao (String nome, String cpf, String placa, String modelo){
        this.nome = nome;
        this.cpf = cpf;
        this.placa = placa;
        this.modelo = modelo;
    }

    public Associacao() {
    }
    
    public Object[] getAssociacao() {
        Object associacao[] = {nome, cpf, placa, modelo};
        return associacao;
    }
    
    @Override
    public String toString() {
        return "Associação {" + "Nome: " + this.nome + ", CPF: " + this.cpf + "Placa: " + this.placa + "Modelo: " + this.modelo + "\n }";
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}