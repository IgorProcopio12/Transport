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
import model.Bomba;

/**
 *
 * @author Igor-SSD
 */
public class BombaDAO extends DAO {
    private static BombaDAO instancia = new BombaDAO();
    public static BombaDAO getInstancia(){
        return instancia;
    }
    private BombaDAO(){};
    
    public List<Bomba> obterBombas() 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    List<Bomba> bombas = new ArrayList<Bomba>();
    Bomba bomba = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from bomba");
        while (rs.next()) {
            bomba = instanciarBomba(rs);
            bombas.add(bomba);
        }
    } finally {
    fecharConexao(conexao, comando);
    }
    return bombas;
}

    public Bomba obterBomba(int idBomba) 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    Bomba bomba = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from bomba where idBomba = " + idBomba);
        rs.first();
            bomba = instanciarBomba(rs);
            
    } finally {
    fecharConexao(conexao, comando);
    }
  return bomba;
  
}
    
    public void gravarBomba(Bomba bomba) throws 
            ClassNotFoundException, SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement(
            "insert into bomba (idBomba, descricao,"
                    + "Tanque_idTanqueB) "
                    + "values (?,?,?)");
            comando.setInt(1, bomba.getCodigo());
            comando.setString(2, bomba.getDescricao());
            if(bomba.getTanque() == null){
                comando.setNull(3, Types.INTEGER);
            } else{
                comando.setInt(3, bomba.getTanque().getCodigo());
            }
            comando.execute();
        }finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public void excluirBomba(Bomba bomba) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.createStatement();
            stringSQL = "delete from bomba where idBomba = " + bomba.getCodigo();
            comando.execute(stringSQL);
        } finally{
            fecharConexao(conexao, comando);
        }
    }
    
    public void alterarBomba(Bomba bomba) throws SQLException, ClassNotFoundException {

         Connection conexao = null;
         PreparedStatement comando = null;

         try {
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement("UPDATE bomba set descricao=?, Tanque_idTanqueB=? WHERE idBomba=?"); 
            comando.setString(1, bomba.getDescricao());
            if(bomba.getTanque() == null){
                comando.setNull(2, Types.INTEGER);
            } else{
                comando.setInt(2, bomba.getTanque().getCodigo());
            }
            comando.setInt(3, bomba.getCodigo());
            comando.execute();

            
         } finally {
             fecharConexao(conexao, comando);
         }

     }

    private Bomba instanciarBomba(ResultSet rs) throws SQLException {
       Bomba bomba = new Bomba(rs.getInt("idBomba"),
           rs.getString("descricao"),
           null ); 
        bomba.setCodigoTanque(rs.getInt("Tanque_idTanqueB"));
       return bomba;
    } 
    
}
