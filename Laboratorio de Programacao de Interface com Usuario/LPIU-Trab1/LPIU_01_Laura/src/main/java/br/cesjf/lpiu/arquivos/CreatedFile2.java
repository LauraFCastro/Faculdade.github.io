/**
 * @author Laura
 */

package br.cesjf.lpiu.arquivos;

import br.cesjf.lpiu.modelo.Associacao;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.text.ParseException;

public class CreatedFile2 {

    /**
     * @param args 
     * @throws 
     */
    public static void main(String[] args) throws ParseException {
             //inicializar Associações
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
