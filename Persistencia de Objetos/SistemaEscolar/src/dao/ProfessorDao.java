/**
 * @author Laura
 */

package dao;

import conexao.ConectionFactory;
import dominio.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDao {
    private Connection conecta;
    
    public ProfessorDao(){
        this.conecta = new ConectionFactory().conecta();
    }
    
    public void cadastrarProfessor(Professor obj){
       
       try {
           String cmdsql = "insert into professor(nome, email, titulacao, genero, cidade) values (?,?,?,?,?)";
           PreparedStatement stmt = conecta.prepareStatement(cmdsql);
           stmt.setString(1, obj.getNome());
           stmt.setString(2, obj.getEmail());
           stmt.setString(3, obj.getTitulacao());
           stmt.setString(4, obj.getSexo());
           stmt.setString(5, obj.getCidade());
           stmt.execute();           
           stmt.close();
       } catch (SQLException erro) {
           throw new RuntimeException(erro);  
       }
    }
    
    public List<Professor>listarProfessores(){
           try {
               List<Professor> lista = new ArrayList<Professor>();
               String SQL="select * from professor";
               PreparedStatement stmt = conecta.prepareStatement(SQL);
               ResultSet rs = stmt.executeQuery();
             while(rs.next()){
                 Professor p = new Professor();
                   p.setCodigo(rs.getInt("codigo"));
                   p.setNome(rs.getString("nome"));
                   p.setEmail(rs.getString("email"));
                   p.setTitulacao(rs.getString("titulacao"));
                   p.setSexo(rs.getString("genero"));
                   p.setCidade(rs.getString("cidade"));
                   lista.add(p);
             }    
               return lista;
               
           } catch (SQLException e) {
               e.printStackTrace();
           }
         return null;
 
       }
  
   public void excluirProfessor(Professor obj){
       try {
            String sql="delete from professor where codigo=?";
            PreparedStatement stmt= conecta.prepareStatement(sql);
            stmt.setInt(1, obj.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }
    
    public void alterarProfessor (Professor obj){
        try {
            String sql = "update professor set nome=?, email=?, titulacao=?, genero=?, cidade=? where codigo=?";
            PreparedStatement stmt = conecta.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getTitulacao());
            stmt.setString(4, obj.getSexo());
            stmt.setString(5, obj.getCidade());
            stmt.setInt(6, obj.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public Professor buscarProfessor (Professor obj){
        Professor p = new Professor();
        try {
            String SQL="SELECT * FROM `professor` WHERE `codigo` = ?";
            PreparedStatement stmt = conecta.prepareStatement(SQL);
            stmt.setInt(1, obj.getCodigo());
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                p.setTitulacao(rs.getString("titulacao"));
                p.setSexo(rs.getString("genero"));
                p.setCidade(rs.getString("cidade"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
