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
import model.Abastecimento;

/**
 *
 * @author Igor-SSD
 */
public class AbastecimentoDAO extends DAO {
    private static AbastecimentoDAO instancia = new AbastecimentoDAO();
    public static AbastecimentoDAO getInstancia(){
        return instancia;
    }
    private AbastecimentoDAO(){};
    
     public List<Abastecimento> obterAbastecimentos() 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    List<Abastecimento> abastecimentos = new ArrayList<Abastecimento>();
    Abastecimento abastecimento = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from abastecimento");
        while (rs.next()) {
            abastecimento = instanciarAbastecimento(rs);
            abastecimentos.add(abastecimento);
        }
    } finally {
    fecharConexao(conexao, comando);
    }
    return abastecimentos;
}

     
      public void gravarAbastecimento(Abastecimento abastecimento) throws 
            ClassNotFoundException, SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement(
            "insert into abastecimento (idAbastecimento, quantidade, Funcionario_idFuncionarioA, Garagem_idGaragemA, Tanque_idTanqueA, Bomba_idBombaA"
                    + "Carro_idCarroA, Combustivel_idCombustivel) "
                    + "values (?,?,?,?,?,?,?,?)");
            comando.setInt(1, abastecimento.getCodigo());
            comando.setString(2, abastecimento.getQuantidade());
            if(abastecimento.getFuncionario() == null){
                comando.setNull(3, Types.INTEGER);
            } else{
                comando.setInt(3, abastecimento.getFuncionario().getIdFuncionario());
            }
            if(abastecimento.getGaragem() == null){
                comando.setNull(4, Types.INTEGER);
            } else{
                comando.setInt(4, abastecimento.getGaragem().getCodigo());
            }
            if(abastecimento.getTanque() == null){
                comando.setNull(5, Types.INTEGER);
            } else{
                comando.setInt(5, abastecimento.getTanque().getCodigo());
            }
            if(abastecimento.getBomba() == null){
                comando.setNull(6, Types.INTEGER);
            } else{
                comando.setInt(6, abastecimento.getBomba().getCodigo());
            }
            if(abastecimento.getCarro() == null){
                comando.setNull(7, Types.INTEGER);
            } else{
                comando.setInt(7, abastecimento.getCarro().getNumero());
            }
            if(abastecimento.getCombustivel() == null){
                comando.setNull(8, Types.INTEGER);
            } else{
                comando.setInt(8, abastecimento.getCombustivel().getCodigo());
            }
            comando.execute();
        }finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public void excluirAbastecimento(Abastecimento abastecimento) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.createStatement();
            stringSQL = "delete from abastecimento where idAbastecimento = " + abastecimento.getCodigo();
            comando.execute(stringSQL);
        } finally{
            fecharConexao(conexao, comando);
        }
    }
    
    public void alterarAbastecimento(Abastecimento abastecimento) throws SQLException, ClassNotFoundException {

         Connection conexao = null;
         PreparedStatement comando = null;

         try {
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement("UPDATE abastecimento set quantidade=?, Funcioanrio_idFuncionarioA=?, Garagem_idGaragemA=?, Tanque_idTanqueA=?,"
                    + " Bomba_idBombaA=?, Carro_idCarroA=?, Combustivel_idCombustivel=? WHERE idAbastecimento=?"); 
            comando.setString(1, abastecimento.getQuantidade());
            if(abastecimento.getFuncionario() == null){
                comando.setNull(2, Types.INTEGER);
            } else{
                comando.setInt(2, abastecimento.getFuncionario().getIdFuncionario());
            } 
             if(abastecimento.getGaragem() == null){
                comando.setNull(3, Types.INTEGER);
            } else{
                 comando.setInt(3, abastecimento.getGaragem().getCodigo());
             } 
              if(abastecimento.getTanque() == null){
                comando.setNull(4, Types.INTEGER);
            } else{
                  comando.setInt(4, abastecimento.getTanque().getCodigo());
              } 
               if(abastecimento.getBomba() == null){
                comando.setNull(5, Types.INTEGER);
            } else{
                   comando.setInt(5, abastecimento.getBomba().getCodigo());
               } 
                if(abastecimento.getCarro() == null){
                comando.setNull(6, Types.INTEGER);
            } else{
                    comando.setInt(6, abastecimento.getCarro().getNumero());
                } 
            if(abastecimento.getCombustivel() == null){
                comando.setNull(7, Types.INTEGER);
            } else{
                comando.setInt(7, abastecimento.getCombustivel().getCodigo());
            }
            comando.setInt(8, abastecimento.getCodigo());
            comando.execute();

            
         } finally {
             fecharConexao(conexao, comando);
         }

     }
     
     
      public Abastecimento obterAbastecimento(int idAbastecimento) 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    Abastecimento abastecimento = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from abastecimento where idabastecimento = " + idAbastecimento);
        rs.first();
           abastecimento = instanciarAbastecimento(rs);
            
    } finally {
    fecharConexao(conexao, comando);
    }
    return abastecimento;
}
     
    private Abastecimento instanciarAbastecimento(ResultSet rs) throws SQLException {
       Abastecimento abastecimento = new Abastecimento(rs.getInt("idAbastecimento"),
               rs.getString("quantidade"),
               null,
               null,
               null,
               null,
               null,
               null); 
       abastecimento.setMatriculaFuncionario(rs.getInt("Funcionario_idFuncionarioA"));
       abastecimento.setNumeroGaragem(rs.getInt("Garagem_idGaragemA"));
       abastecimento.setCodigoTanque(rs.getInt("Tanque_idTanqueA"));
       abastecimento.setCodigoBomba(rs.getInt("Bomba_idBombaA"));
       abastecimento.setNumeroCarro(rs.getInt("Carro_idCarroA"));
       abastecimento.setCodigoCombustivel(rs.getInt("Combustivel_idCombustivel")); 
       return abastecimento;
    } 
}
