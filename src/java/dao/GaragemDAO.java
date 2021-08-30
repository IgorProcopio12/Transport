/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;        
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Garagem;


/**
 *
 * @author Igor-SSD
 */
public class GaragemDAO extends DAO {
    private static GaragemDAO instancia = new GaragemDAO();
    public static GaragemDAO getInstancia(){
        return instancia;
    }
    private GaragemDAO(){};
    
    public void gravarGaragem(Garagem garagem) throws 
            ClassNotFoundException, SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement(
            "insert into garagem (idGaragem, descricao, cep,"
                    + "estado, cidade, rua, bairro, numero, complemento, telefone) "
                    + "values (?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, garagem.getCodigo());
            comando.setString(2, garagem.getDescricao());
            comando.setString(3, garagem.getCep());
            comando.setString(4, garagem.getEstado());
            comando.setString(5, garagem.getRua());
            comando.setString(6, garagem.getBairro());
            comando.setString(7, garagem.getCidade());
            comando.setString(8, garagem.getNumero());   
            comando.setString(9, garagem.getComplemento());
            comando.setString(10, garagem.getTelefone());  
            comando.execute();
        }finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public void excluirGaragem(Garagem garagem) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.createStatement();
            stringSQL = "delete from garagem where idGaragem = " + garagem.getCodigo();
            comando.execute(stringSQL);
        } finally{
            fecharConexao(conexao, comando);
        }
    }
    
    public void alterarGaragem(Garagem garagem) throws SQLException, ClassNotFoundException {

         Connection conexao = null;
         PreparedStatement comando = null;

         try {
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement("UPDATE garagem set descricao=?, cep=?, estado=?, rua=?, bairro=?,"
                    + "cidade=?, numero=?, complemento=?, telefone=? WHERE idGaragem=?");
            comando.setString(1, garagem.getDescricao());
            comando.setString(2, garagem.getCep());
            comando.setString(3, garagem.getEstado());
            comando.setString(4, garagem.getRua());
            comando.setString(5, garagem.getBairro());
            comando.setString(6, garagem.getCidade());
            comando.setString(7, garagem.getNumero());
            comando.setString(8, garagem.getComplemento());
            comando.setString(9, garagem.getTelefone());
            comando.setInt(10, garagem.getCodigo());
            comando.execute();

            
         } finally {
             fecharConexao(conexao, comando);
         }

     }
    

    public List<Garagem> obterGaragens() 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    List<Garagem> garagens = new ArrayList<Garagem>();
    Garagem garagem = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from garagem");
        while (rs.next()) {
            garagem = instanciarGaragem(rs);
            garagens.add(garagem);
        }
    } finally {
    fecharConexao(conexao, comando);
    }
    return garagens;
}

    public Garagem obterGaragem(int idGaragem) 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    Garagem garagem = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from garagem where idGaragem = " + idGaragem);
        rs.first();
            garagem = instanciarGaragem(rs);
            
    } finally {
    fecharConexao(conexao, comando);
    }
    return garagem;
}
    
    private Garagem instanciarGaragem(ResultSet rs) throws SQLException {
       Garagem garagem = new Garagem(rs.getInt("idGaragem"),
           rs.getString("descricao"),
           rs.getString("cep"),
           rs.getString("estado"),
           rs.getString("rua"),
           rs.getString("bairro"),
           rs.getString("cidade"),
           rs.getString("numero"),
           rs.getString("complemento"),
           rs.getString("telefone")); 
       return garagem;
    } 
    
}

