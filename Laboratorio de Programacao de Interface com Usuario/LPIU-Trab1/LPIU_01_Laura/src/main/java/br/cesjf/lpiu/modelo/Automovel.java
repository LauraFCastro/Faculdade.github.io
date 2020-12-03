/**
 * @author laura
 */

package br.cesjf.lpiu.modelo;

//import java.util.Date;

import java.io.Serializable;

public class Automovel implements Serializable{
    private String placa, modelo;
    private String data;
    private String motorizacao;
    private double valorBasico;
    private String categoria;

    public Automovel(String placa, String modelo, String data, String motorizacao, double valorBasico, String categoria) {
        this.placa = placa;
        this.modelo = modelo;
        this.data = data;
        this.motorizacao = motorizacao;
        this.valorBasico = valorBasico;
        this.categoria = categoria;
    }

    public Automovel() {
    }

    public double calcularImposto(double valorBasico, double aliquota){
    
        return valorBasico*(aliquota/100);
    }
    
    public double calcularValorTotal(Double valorBasico, Double imposto){
        return valorBasico + imposto;
    }
    
    @Override
    public String toString() {
        return "Automovel{" + "Placa: " + this.placa + ", Modelo: " + this.modelo +
               ", Data de Fabricação: " + this.data + ", Motorizacao: " + this.motorizacao +
               ", Categoria: " + this.categoria + "\n \n" + '}';
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDataDeFabricacao() {
        return data;
    }

    public void setDataDeFabricacao(String data) {
        this.data = data;
    }

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorização) {
        this.motorizacao = motorização;
    }

    public double getValorBasico() {
        return valorBasico;
    }

    public void setValorBasico(double valorBasico) {
        this.valorBasico = valorBasico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public Object[] getcarro() {
        Object carro[] = {placa, modelo, data, motorizacao, valorBasico, categoria};
        return carro;
    }

}
