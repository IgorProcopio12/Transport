/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dao.CombustivelDAO;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Igor-SSD
 */
public class Combustivel {
    private int codigo;
    private String descricao;

    public Combustivel(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Combustivel obterCombustivel(int idCombustivel) throws 
            ClassNotFoundException, SQLException {
        return CombustivelDAO.getInstancia().obterCombustivel(idCombustivel);
    }
    
   public static List<Combustivel> obterCombustiveis()
            throws ClassNotFoundException, SQLException {
        return CombustivelDAO.getInstancia().obterCombustiveis();
    } 

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
  
    public void gravar() throws SQLException, ClassNotFoundException{
        CombustivelDAO.getInstancia().gravar(this);
    }
  
   public void alterar() throws SQLException, ClassNotFoundException{
        CombustivelDAO.getInstancia().alterar(this);
    }
   
   public void excluir() throws SQLException, ClassNotFoundException{
        CombustivelDAO.getInstancia().excluir(this);
    }
    
}
