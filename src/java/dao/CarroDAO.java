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
import model.Carro;

/**
 *
 * @author Igor-SSD
 */
public class CarroDAO extends DAO {
    private static CarroDAO instancia = new CarroDAO();
    public static CarroDAO getInstancia(){
        return instancia;
    }
    private CarroDAO(){};
    
     public List<Carro> obterCarros() 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    List<Carro> carros = new ArrayList<Carro>();
    Carro carro = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from carro");
        while (rs.next()) {
            carro = instanciarCarro(rs);
            carros.add(carro);
        }
    } finally {
    fecharConexao(conexao, comando);
    }
    return carros;
}
     
     public Carro obterCarro(int idCarro) 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    Carro carro = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from carro where idCarro = " + idCarro);
        rs.first();
           carro = instanciarCarro(rs);
            
    } finally {
    fecharConexao(conexao, comando);
    }
    return carro;
}
     
     
     public void gravarCarro(Carro carro) throws 
            ClassNotFoundException, SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement(
            "insert into carro (idCarro, modelo, chassi, placa, ano,"
                    + "Garagem_idGaragemC) "
                    + "values (?,?,?,?,?,?)");
            comando.setInt(1, carro.getNumero());
            comando.setString(2, carro.getModelo());
            comando.setString(3, carro.getChassi());
            comando.setString(4, carro.getPlaca());
            comando.setString(5, carro.getAno());
            
            if(carro.getGaragem() == null){
                comando.setNull(6, Types.INTEGER);
            } else{
                comando.setInt(6, carro.getGaragem().getCodigo());
            }
            comando.execute();
        }finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public void excluirCarro(Carro carro) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.createStatement();
            stringSQL = "delete from carro where idCarro = " + carro.getNumero();
            comando.execute(stringSQL);
        } finally{
            fecharConexao(conexao, comando);
        }
    }
    
    public void alterarCarro(Carro carro) throws SQLException, ClassNotFoundException {

         Connection conexao = null;
         PreparedStatement comando = null;

         try {
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement("UPDATE carro set modelo=?, chassi=?, placa=?, ano=?, Garagem_idGaragemC=? WHERE idCarro=?"); 
            comando.setString(1, carro.getModelo());
            comando.setString(2, carro.getChassi());
            comando.setString(3, carro.getPlaca());
            comando.setString(4, carro.getAno());
            if(carro.getGaragem() == null){
                comando.setNull(5, Types.INTEGER);
            } else{
                comando.setInt(5, carro.getGaragem().getCodigo());
            }     
            comando.setInt(6, carro.getNumero());
            comando.execute();

            
         } finally {
             fecharConexao(conexao, comando);
         }

     }
     
    private Carro instanciarCarro(ResultSet rs) throws SQLException {
       Carro carro = new Carro(rs.getInt("idCarro"),
           rs.getString("modelo"),
           rs.getString("chassi"),
           rs.getString("placa"),
           rs.getString("ano"),            
           null); 
       carro.setNumeroGaragem(rs.getInt("Garagem_idGaragemC"));
       return carro;
    } 

    
}
