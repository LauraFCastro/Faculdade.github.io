/**
 * @author Laura
 */

package br.cesjf.lpiu.interfaces;


import br.cesjf.lpiu.modelo.Automovel;
import br.cesjf.lpiu.arquivos.ArquivoInCarro;
import br.cesjf.lpiu.modelo.Pessoa;
import br.cesjf.lpiu.arquivos.ArquivoInPessoa;
import br.cesjf.lpiu.modelo.Associacao;
import br.cesjf.lpiu.arquivos.ArquivoInAssociacao;
import br.cesjf.lpiu.arquivos.ArquivoOutAssociacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFormattedTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Associacoes extends javax.swing.JFrame {

    private ArquivoInCarro arqinC = new ArquivoInCarro();
    private ArquivoInPessoa arqinP = new ArquivoInPessoa();
    private ArquivoOutAssociacao arqout = new ArquivoOutAssociacao();
    private ArquivoInAssociacao arqin = new ArquivoInAssociacao();
    int linha;
    
    /**
     * Creates new form Associacao
     */
    
    public Associacoes() {
    	setMaximumSize(new Dimension(1080, 720));
    	setSize(new Dimension(440, 312));
    	setMinimumSize(new Dimension(440, 312));
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Associacoes.class.getResource("/br/cesjf/lpiu/icons/logo2.png")));
        initComponents();
        asso = new Associacao();
        try {
            arqout.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Associacoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Associacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Associacao asso = null;
    
    public void limpar(){
        txtPlaca.setText("");
        txtCpf.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setMinimumSize(new Dimension(400, 200));
        jScrollPane1.setPreferredSize(new Dimension(400, 200));
        tblAssociacao = new javax.swing.JTable();
        tblAssociacao.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		btnDesassociar.setEnabled(true);
        		linha = tblAssociacao.getSelectedRow();
        		txtCpf.setText(tblAssociacao.getValueAt(linha, 1).toString());
        		txtPlaca.setText(tblAssociacao.getValueAt(linha, 2).toString());
        	}
        });
        lblCPF = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        txtCpf = new JFormattedTextField();
        
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        
        txtPlaca = new JFormattedTextField();
        
        try {
            txtPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        
        btnAssociar = new javax.swing.JButton();
        btnAssociar.setIcon(new ImageIcon(Associacoes.class.getResource("/br/cesjf/lpiu/icons/link.png")));
        btnLimpar = new javax.swing.JButton();
        btnLimpar.setIcon(new ImageIcon(Associacoes.class.getResource("/br/cesjf/lpiu/icons/limpar.png")));
        btnLimpar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		limpar();
        	}
        });
        btnDesassociar = new javax.swing.JButton();
        btnDesassociar.setEnabled(false);
        btnDesassociar.setIcon(new ImageIcon(Associacoes.class.getResource("/br/cesjf/lpiu/icons/UNlink.png")));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Associação de Veículos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblAssociacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Placa", "Modelo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAssociacao);

        lblCPF.setText("CPF:");

        lblPlaca.setText("Placa:");

        txtCpf.setMinimumSize(new java.awt.Dimension(15, 25));
        txtCpf.setPreferredSize(new java.awt.Dimension(15, 25));

        txtPlaca.setMinimumSize(new java.awt.Dimension(15, 25));
        txtPlaca.setPreferredSize(new java.awt.Dimension(15, 25));

        btnAssociar.setText("Associar");
        btnAssociar.setMaximumSize(new java.awt.Dimension(100, 35));
        btnAssociar.setMinimumSize(new java.awt.Dimension(100, 35));
        btnAssociar.setPreferredSize(new java.awt.Dimension(100, 35));
        btnAssociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssociarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.setMaximumSize(new java.awt.Dimension(100, 35));
        btnLimpar.setMinimumSize(new java.awt.Dimension(100, 35));
        btnLimpar.setPreferredSize(new java.awt.Dimension(100, 35));

        btnDesassociar.setText("Desassociar");
        btnDesassociar.setMaximumSize(new Dimension(110, 35));
        btnDesassociar.setMinimumSize(new Dimension(110, 35));
        btnDesassociar.setPreferredSize(new Dimension(120, 35));
        btnDesassociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesassociarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(lblPlaca)
        						.addPreferredGap(ComponentPlacement.UNRELATED)
        						.addComponent(txtPlaca, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(lblCPF)
        						.addGap(18)
        						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btnDesassociar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        					.addGap(34)
        					.addComponent(btnAssociar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(27)
        					.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(17)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCPF)
        				.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPlaca)
        				.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(30)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnDesassociar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btnAssociar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssociarActionPerformed
        
        ArrayList<Automovel> listautos = new ArrayList<>();
        ArrayList<Pessoa> listaPs = new ArrayList<>();
        listautos = (ArrayList<Automovel>) arqinC.getTodosCarros();
        listaPs = (ArrayList<Pessoa>) arqinP.getTodasPessoas();
        
        String placaDigitada = txtPlaca.getText();
        String cpfDigitado = txtCpf.getText();
        String nome = null;
        String modelo = null;
        
        for (int i=0; i < listautos.size(); i++){
        	if(placaDigitada.equals(listautos.get(i).getPlaca())){
        		modelo = listautos.get(i).getModelo();
        	}
        }
        
        for (int n=0; n < listaPs.size(); n++){
        	if(cpfDigitado.equals(listaPs.get(n).getCpf())){
        		nome = listaPs.get(n).getNome();
        	}
        }
        
        if (modelo == null || nome == null){
        	if(modelo == null){
        		JOptionPane.showMessageDialog(null, "Veículo não encontrado!");
        	}else{
        		JOptionPane.showMessageDialog(null, "Pessoa não encontrada!");
        	}
        	
        }else{
        	asso.setPlaca(txtPlaca.getText());
    		asso.setModelo(modelo);
            asso.setCpf(txtCpf.getText());
    		asso.setNome(nome);
    		
    		try {
                arqout.Adicionar(asso);
                JOptionPane.showMessageDialog(null, "Associação Inserida com Sucesso!");
            } catch (IOException ex) {
                Logger.getLogger(Associacoes.class.getName()).log(Level.SEVERE, null, ex);
            }
    		
    		limpar();
            
            int cont = 1;

            List<Associacao> listAssociacao = new ArrayList<Associacao>();

            listAssociacao = arqin.getTodasAssociacoes();
            DefaultTableModel modelocarro = (DefaultTableModel) tblAssociacao.getModel();

            for (int a = tblAssociacao.getRowCount() - 1; a >= 0; --a) {
                modelocarro.removeRow(a);
            }

            for (int b = 0; b < listAssociacao.size(); b++) {
                modelocarro.addRow(listAssociacao.get(b).getAssociacao());
                cont++;
            }
    		
        }
    }//GEN-LAST:event_btnAssociarActionPerformed

    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    	int n = 1;

        List<Associacao> listaAssociacao = new ArrayList<Associacao>();

        listaAssociacao = arqin.getTodasAssociacoes();
        DefaultTableModel modeloPessoa = (DefaultTableModel) tblAssociacao.getModel();

        for (int i = tblAssociacao.getRowCount() - 1; i >= 0; --i) {
            modeloPessoa.removeRow(i);
        }

        for (int i = 0; i < listaAssociacao.size(); i++) {
            modeloPessoa.addRow(listaAssociacao.get(i).getAssociacao());
            n++;
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Principal princ = new Principal();
        princ.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnDesassociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesassociarActionPerformed

    	DefaultTableModel modelo = (DefaultTableModel) tblAssociacao.getModel();
        List<Associacao> list = new ArrayList<Associacao>();
        ArrayList<Associacao> nova_list = new ArrayList<Associacao>();
        
        linha = tblAssociacao.getSelectedRow();
        Object valor = modelo.getValueAt(linha, 1);
        list = arqin.getTodasAssociacoes();
        
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i).getCpf().equals(valor))) {
                nova_list.add(list.get(i));
            }
        }
        try {
            arqout.recadastrar_todos(nova_list);
        } catch (IOException ex) {
            Logger.getLogger(Associacoes.class.getName()).log(Level.SEVERE, null, ex);
        }

        modelo.removeRow(linha);
        JOptionPane.showMessageDialog(null, "Associação apagada com sucesso");
        
        btnDesassociar.setEnabled(false);
    
    }//GEN-LAST:event_btnDesassociarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Associacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Associacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Associacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Associacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Associacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssociar;
    private javax.swing.JButton btnDesassociar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JTable tblAssociacao;
    private JFormattedTextField txtCpf;
    private JFormattedTextField txtPlaca;
}