/**
 * @author laura
 */

package br.cesjf.lpiu.arquivos;

import br.cesjf.lpiu.modelo.Associacao;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArquivoOutAssociacao {
    private FileOutputStream fout = null;
    private ObjectOutputStream objOut = null;
    private List<Associacao> lista = new ArrayList<Associacao>();
    
    public void abrir() throws FileNotFoundException, IOException { //throws, trata exceção para cada coisa que possa acontecer
        preparar();
        fout = new FileOutputStream("Informacoes_Associacao.txt");
        objOut = new ObjectOutputStream(fout);
        for (int i = 0; i < lista.size(); i++) {
            objOut.writeObject(lista.get(i));
        }
    }
    
    private void preparar() {
        ArquivoInAssociacao arqin = new ArquivoInAssociacao();
        try {
            arqin.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoOutAssociacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoOutAssociacao.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean continua = true;
        Associacao asso = null;
        while (continua) {
            try {
                asso = arqin.getAssociacao();
                if (asso != null) {
                    lista.add(asso);
                } else {
                    continua = false;
                }
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                Logger.getLogger(ArquivoOutAssociacao.class.getName()).log(Level.SEVERE, null, ex);
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoOutAssociacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        arqin.fechar();
    }
    
    public void fechar() throws IOException {
        objOut.close();
        fout.close();
    }
    
    public void Adicionar(Associacao asso) throws IOException {
        objOut.writeObject(asso);//grava o objeto todo
    }

    public void recadastrar_todos(ArrayList<Associacao> lista2) throws IOException {
        fout = new FileOutputStream("Informacoes_Associacao.txt");
        objOut = new ObjectOutputStream(fout);

        for (int i = 0; i < lista2.size(); i++) {
            objOut.writeObject(lista2.get(i));
        }

    }
    
}
