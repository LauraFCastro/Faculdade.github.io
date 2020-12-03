/**
 * @author Laura
 */

package br.cesjf.lpiu.arquivos;

import br.cesjf.lpiu.modelo.Pessoa;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ArquivoOutPessoa {
    private FileOutputStream fout = null;
    private ObjectOutputStream objOut = null;
    private List<Pessoa> lista = new ArrayList<Pessoa>();
    
    public void abrir() throws FileNotFoundException, IOException { //throws, trata exceção para cada coisa que possa acontecer
        preparar();
        fout = new FileOutputStream("Informacoes_Pessoas.txt");
        objOut = new ObjectOutputStream(fout);
        for (int i = 0; i < lista.size(); i++) {
            objOut.writeObject(lista.get(i));
        }
    }
    
    private void preparar() {
        ArquivoInPessoa arqin = new ArquivoInPessoa();
        try {
            arqin.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoOutPessoa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro em ArquivoOutPessoa\nArquivo não encontrado!", null, JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoOutPessoa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro em ArquivoOutPessoa \nErro no Método preparar() - Abrir o arquivo", null, JOptionPane.WARNING_MESSAGE);
        }

        boolean continua = true;
        Pessoa pess = null;
        while (continua) {
            try {
                pess = arqin.getpessoa();
                if (pess != null) {
                    lista.add(pess);
                } else {
                    continua = false;
                }
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                Logger.getLogger(ArquivoOutPessoa.class.getName()).log(Level.SEVERE, null, ex);
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoOutPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        arqin.fechar();
    }
    
    public void fechar() throws IOException {
        objOut.close();
        fout.close();
    }
    
    public void Adicionar(Pessoa pess) throws IOException {
        objOut.writeObject(pess);//grava o objeto todo
    }

    public void recadastrar_todos(ArrayList<Pessoa> lista2) throws IOException {
        fout = new FileOutputStream("Informacoes_Pessoas.txt");
        objOut = new ObjectOutputStream(fout);

        for (int i = 0; i < lista2.size(); i++) {
            objOut.writeObject(lista2.get(i));
        }

    }
    
}

