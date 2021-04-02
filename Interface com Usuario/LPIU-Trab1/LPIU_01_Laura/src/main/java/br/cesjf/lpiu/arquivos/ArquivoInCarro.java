/**
 * @author Laura
 */

package br.cesjf.lpiu.arquivos;

import br.cesjf.lpiu.modelo.Automovel;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArquivoInCarro {    
    private FileInputStream fin = null;
    private ObjectInputStream objIn = null;

    public void abrir() throws FileNotFoundException, IOException {
        fin = new FileInputStream("Informacoes_Carros.txt");
        objIn = new ObjectInputStream(fin);
    }

    public void fechar() {
        try {
            objIn.close();
            fin.close();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Automovel getcarro() throws IOException, ClassNotFoundException {
        Automovel auto = null;

        try {
            auto = (Automovel) objIn.readObject();
        } catch (EOFException ex) {
            auto = null;
        }
        return auto;
    }

    public List getTodosCarros() {
        List<Automovel> listacarro = new ArrayList<Automovel>();

        try {
            this.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoInCarro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInCarro.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean continua = true;
        Automovel auto = null;
        while (continua) {
            try {
                auto = (Automovel) objIn.readObject();
                listacarro.add(auto);
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoInCarro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fechar();
        return listacarro;
    }
}
