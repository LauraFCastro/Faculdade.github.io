/**
 * @author Laura
 */

package br.cesjf.lpiu.arquivos;

import br.cesjf.lpiu.modelo.Associacao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArquivoInAssociacao {    
    private FileInputStream fin = null;
    private ObjectInputStream objIn = null;

    public void abrir() throws FileNotFoundException, IOException {
        fin = new FileInputStream("Informacoes_Associacao.txt");
        objIn = new ObjectInputStream(fin);
    }

    public void fechar() {
        try {
            objIn.close();
            fin.close();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInAssociacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Associacao getAssociacao() throws IOException, ClassNotFoundException {
        Associacao asso = null;

        try {
            asso = (Associacao) objIn.readObject();
        } catch (EOFException ex) {
            asso = null;
        }
        return asso;
    }

    public List getTodasAssociacoes() {
        List<Associacao> listaAssociacoes = new ArrayList<Associacao>();

        try {
            this.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoInAssociacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInAssociacao.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean continua = true;
        Associacao asso = null;
        while (continua) {
            try {
                asso = (Associacao) objIn.readObject();
                listaAssociacoes.add(asso);
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoInAssociacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fechar();
        return listaAssociacoes;
    }
}
