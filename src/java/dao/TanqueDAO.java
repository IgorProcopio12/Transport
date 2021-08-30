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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Tanque;

/**
 *
 * @author Igor-SSD
 */
public class TanqueDAO extends DAO {
    private static TanqueDAO instancia = new TanqueDAO();
    public static TanqueDAO getInstancia(){
        return instancia;
    }
    private TanqueDAO(){};
    
    public void gravarTanque(Tanque tanque) throws 
            ClassNotFoundException, SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement(
            "insert into tanque (idTanque, descricao, capacidade,"
                    + "Combustivel_idCombustivel, Garagem_idGaragemT) "
                    + "values (?,?,?,?,?)");
            comando.setInt(1, tanque.getCodigo());
            comando.setString(2, tanque.getDescricao());
            comando.setString(3, tanque.getCapacidade());
            if(tanque.getCombustivel() == null){
                comando.setNull(4, Types.INTEGER);
            } else{
                comando.setInt(4, tanque.getCombustivel().getCodigo());
            }
            if(tanque.getGaragem() == null){
                comando.setNull(5, Types.INTEGER);
            } else{
                comando.setInt(5, tanque.getGaragem().getCodigo());
            }
            comando.execute();
        }finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public void excluirTanque(Tanque tanque) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.createStatement();
            stringSQL = "delete from tanque where idTanque =?" + tanque.getCodigo();
            comando.execute(stringSQL);
            
        } finally{
            fecharConexao(conexao, comando);
        }
    }
    
    public void alterarTanque(Tanque tanque) throws SQLException, ClassNotFoundException {

         Connection conexao = null;
         PreparedStatement comando = null;

         try {
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement("UPDATE tanque set descricao=?, capacidade=?, Combustivel_idCombustivel=?, Garagem_idGaragemT=? WHERE idTanque=?"); 
            comando.setString(1, tanque.getDescricao());
            comando.setString(2, tanque.getCapacidade());
            if(tanque.getCombustivel() == null){
                comando.setNull(3, Types.INTEGER);
            } else{
                comando.setInt(3, tanque.getCombustivel().getCodigo());
            }
            if(tanque.getGaragem() == null){
                comando.setNull(4, Types.INTEGER);
            } else{
                comando.setInt(4, tanque.getGaragem().getCodigo());
            }      
            comando.setInt(5, tanque.getCodigo());
            comando.execute();

            
         } finally {
             fecharConexao(conexao, comando);
         }

     }
    
    
    public List<Tanque> obterTanques() 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    List<Tanque> tanques = new ArrayList<Tanque>();
    Tanque tanque = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from tanque");
        while (rs.next()) {
            tanque = instanciarTanque(rs);
            tanques.add(tanque);
        }
    } finally {
    fecharConexao(conexao, comando);
    }
    return tanques;
}

    public Tanque obterTanque(int idTanque) 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    Tanque tanque = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from tanque where idTanque = " + idTanque);
        rs.first();
            tanque = instanciarTanque(rs);
            
    } finally {
    fecharConexao(conexao, comando);
    }
    return tanque;
  }  
    
    private Tanque instanciarTanque(ResultSet rs) throws SQLException {
       Tanque tanque = new Tanque(rs.getInt("idTanque"),
           rs.getString("descricao"),
           rs.getString("capacidade"),   
           null, 
           null); 
       tanque.setCodigoCombustivel(rs.getInt("Combustivel_idCombustivel"));
       tanque.setNumeroGaragem(rs.getInt("Garagem_idGaragemT"));
       
       return tanque;
    } 
    
}
