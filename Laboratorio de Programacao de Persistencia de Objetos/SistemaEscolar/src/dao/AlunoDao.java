/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConectionFactory;
import dominio.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class AlunoDao {
     private Connection conecta;  

      public AlunoDao() {
        this.conecta = new ConectionFactory().conecta();
    }
    
    public void cadastrarAluno(Aluno obj){
       
       try {
           String cmdsql = "insert into aluno(nome, email, telefone,celular, observacao) values (?,?,?,?,?)";
           PreparedStatement stmt = conecta.prepareStatement(cmdsql);
           stmt.setString(1, obj.getNome());
           stmt.setString(2, obj.getEmail());
           stmt.setString(3, obj.getTelefone());
           stmt.setString(4, obj.getCelular());
           stmt.setString(5, obj.getObs());
           stmt.execute();           
           stmt.close();
       } catch (SQLException erro) {
           throw new RuntimeException(erro);  
       }
    }
    
    public List<Aluno>listarAlunos(){
           try {
               List<Aluno> lista =new ArrayList<Aluno>();
               String SQL="select * from aluno";
               PreparedStatement stmt=conecta.prepareStatement(SQL);
               ResultSet rs=stmt.executeQuery();
             while(rs.next()){
                 Aluno a=new Aluno();
                   a.setId(rs.getInt("id"));
                   a.setNome(rs.getString("nome"));
                   a.setEmail(rs.getString("email"));
                   a.setTelefone(rs.getString("telefone"));
                   a.setCelular(rs.getString("celular"));
                   a.setObs(rs.getString("observacao"));
                   lista.add(a);
             }    
               return lista;
               
           } catch (SQLException e) {
               e.printStackTrace();
           }
         return null;
 
       }
  
   public void excluirAluno(Aluno obj){
        try {
        String sql="delete from aluno where id=?";
        PreparedStatement stmt= conecta.prepareStatement(sql);
        stmt.setInt(1, obj.getId());
        stmt.execute();
        stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void alterarAluno(Aluno obj){
        try {
            String sql=" update aluno set nome=?, email=?, telefone=?,"
            + "celular=?, observacao=? where id=?";
            PreparedStatement stmt = conecta.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getCelular());
            stmt.setString(5, obj.getObs());
            stmt.setInt(5, obj.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}