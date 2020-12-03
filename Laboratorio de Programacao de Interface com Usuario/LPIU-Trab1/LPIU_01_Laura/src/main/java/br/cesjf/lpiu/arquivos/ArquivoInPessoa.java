/**
 * @author Laura
 */

package br.cesjf.lpiu.arquivos;

import br.cesjf.lpiu.modelo.Pessoa;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArquivoInPessoa {
    private FileInputStream fin = null;
    private ObjectInputStream objIn = null;

    public void abrir() throws FileNotFoundException, IOException {
        fin = new FileInputStream("Informacoes_Pessoas.txt");
        objIn = new ObjectInputStream(fin);
    }

    public void fechar() {
        try {
            objIn.close();
            fin.close();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pessoa getpessoa() throws IOException, ClassNotFoundException {
        Pessoa pess = null;

        try {
            pess = (Pessoa) objIn.readObject();
        } catch (EOFException ex) {
            pess = null;
        }
        return pess;
    }

    public List getTodasPessoas() {
        List<Pessoa> listapessoa = new ArrayList<Pessoa>();

        try {
            this.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoInPessoa.class.getName()).log(Level.SEVERE, null, ex);            
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean continua = true;
        Pessoa pess = null;
        while (continua) {
            try {
                pess = (Pessoa) objIn.readObject();
                listapessoa.add(pess);
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoInPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fechar();
        return listapessoa;
    }
}

