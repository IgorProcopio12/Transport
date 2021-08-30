/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Combustivel;

/**
 *
 * @author Igor-SSD
 */
public class CombustivelDAO extends DAO {
    private static CombustivelDAO instancia = new CombustivelDAO();
    public static CombustivelDAO getInstancia(){
        return instancia;
    }
    private CombustivelDAO(){};
    
    
    public void gravar(Combustivel combustivel) throws 
            ClassNotFoundException, SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement(
            "insert into combustivel (idCombustivel, descricao) "
                    + "values (?,?)");
            comando.setInt(1, combustivel.getCodigo());
            comando.setString(2, combustivel.getDescricao()); 
            comando.execute();
        }finally {
            fecharConexao(conexao, comando);
        }
    }

    public void excluir (Combustivel combustivel) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;    
        
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement("DELETE from combustivel WHERE idCombustivel =?");
            comando.setInt(1, combustivel.getCodigo());
            comando.execute();
        } finally{
            fecharConexao(conexao, comando);
        }
    }
    
    public void alterar(Combustivel combustivel) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement("UPDATE combustivel set descricao=? WHERE idCombustivel=?");
            comando.setString(1, combustivel.getDescricao());
            comando.setInt(2, combustivel.getCodigo());       
            comando.execute();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException{
        String operacao = request.getParameter("operacao");
        int idCombustivel = Integer.parseInt(request.getParameter("codigo"));
        String descricao = request.getParameter("descricao");
        
        
        try {
            Combustivel combustivel = new Combustivel(idCombustivel, descricao);
            if (operacao.equals("Incluir")){
                combustivel.gravar();
            } else {
                if (operacao.equals("Editar")){
                    combustivel.alterar();
                               
               } else {
                    if (operacao.equals("Excluir")){
                        combustivel.excluir();
                    
                   }
                }
            }
        
        RequestDispatcher view = request.getRequestDispatcher("PesquisaCombustivelController");
            view.forward(request, response);
        } catch (IOException e) {
               throw new ServletException(e);
           } catch (SQLException e) {
               throw new ServletException(e);
           } catch (ClassNotFoundException e) {
               throw new ServletException(e);
           } catch (ServletException e) {
               throw e;
           }
    
    }
     public List<Combustivel> obterCombustiveis() 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    List<Combustivel> Combustiveis = new ArrayList<Combustivel>();
    Combustivel combustivel = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from combustivel");
        while (rs.next()) {
            combustivel = instanciarCombustivel(rs);
            Combustiveis.add(combustivel);
        }
    } finally {
    fecharConexao(conexao, comando);
    }
    return Combustiveis;
}

     
     public Combustivel obterCombustivel(int idCombustivel) 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    Combustivel combustivel = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from combustivel where idCombustivel = " + idCombustivel);
        rs.first();
           combustivel = instanciarCombustivel(rs);
            
    } finally {
    fecharConexao(conexao, comando);
    }
    return combustivel;
}
     
    private Combustivel instanciarCombustivel(ResultSet rs) throws SQLException {
       Combustivel combustivel = new Combustivel(rs.getInt("idCombustivel"),
           rs.getString("descricao")); 
       return combustivel;
    } 
}
