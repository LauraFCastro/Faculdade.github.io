/**
 * @author Laura
 */

package br.cesjf.lpiu.arquivos;

import br.cesjf.lpiu.modelo.Automovel;
import br.cesjf.lpiu.modelo.Pessoa;
import br.cesjf.lpiu.modelo.Associacao;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.text.ParseException;

public class CreatedFile {

    /**
     * @param args 
     * @throws 
     */
    public static void main(String[] args) throws ParseException {
            //CARROS
             try {
                    FileOutputStream fout = new FileOutputStream("Informacoes_Carros.txt");
                    ObjectOutputStream objOut = new ObjectOutputStream(fout);
        
                    Automovel auto = new Automovel();
                    auto.setCategoria("Carga");
                    auto.setMotorizacao("1.0");
                    auto.setValorBasico(10000);
                    auto.setDataDeFabricacao("1996");
                    auto.setModelo("Uno");
                    auto.setPlaca("ABC-1234");
                    
                    objOut.writeObject(auto);
                   
                    objOut.close();
             } catch (IOException e) {
                    e.printStackTrace();
             }
             
             //PESSOAS
             try {
                    FileOutputStream fout = new FileOutputStream("Informacoes_Pessoas.txt");
                    ObjectOutputStream objOut = new ObjectOutputStream(fout);
        
                    Pessoa pess = new Pessoa();
                    pess.setEstado("Alagoas");
                    pess.setCidade("JFCity A");
                    pess.setComplemento("apertamento");
                    pess.setNumero("34a");
                    pess.setBairro("Algum bairro somewhere");
                    pess.setEndereco("Rua Qualquer de teste");
                    pess.setCep("36363636");
                    pess.setCnh("numeros0293993");
                    pess.setData("16/06/1996");
                    
                    pess.setNome("Nome Qualquer");
                    pess.setCpf("12345678901");
                    
                    objOut.writeObject(pess);
                   
                    objOut.close();
             } catch (IOException e) {
                    e.printStackTrace();
             }
             
             //ASSOCIACOES
             try {
                 FileOutputStream fout = new FileOutputStream("Informacoes_Associacao.txt");
                 ObjectOutputStream objOut = new ObjectOutputStream(fout);
     
                 Associacao asso = new Associacao();
                 asso.setCpf("34509876867");
                 asso.setModelo("Fiesta Arriba");
                 asso.setNome("Joazinho Pedro Nélio");
                 asso.setPlaca("BRL0666");
                 
                 objOut.writeObject(asso);
                
                 objOut.close();
          } catch (IOException e) {
                 e.printStackTrace();
          }
  
       }

}
