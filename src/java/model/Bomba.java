/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dao.BombaDAO;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Igor-SSD
 */
public class Bomba {
    private int codigo;
    private String descricao;
    private Tanque tanque;
    private int codigoTanque;

    public Bomba(int codigo, String descricao, Tanque tanque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tanque = tanque;
       
        
    }

    
    public static Bomba obterBomba(int idBomba) throws 
            ClassNotFoundException, SQLException {
        return BombaDAO.getInstancia().obterBomba(idBomba);
    }
    
public static List<Bomba> obterBombas()
            throws ClassNotFoundException, SQLException {
        return BombaDAO.getInstancia().obterBombas();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Tanque getTanque() throws ClassNotFoundException, SQLException {
        if ((this.codigoTanque !=0)&&(this.tanque == null)){
            this.tanque = Tanque.obterTanque(this.codigoTanque);
        }
        return this.tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }


    public int getCodigoTanque() {
        return codigoTanque;
    }

    public void setCodigoTanque(int codigoTanque) {
        this.codigoTanque = codigoTanque;
    }
    
    
    public void gravar() throws SQLException, ClassNotFoundException{
       BombaDAO.getInstancia().gravarBomba(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
        BombaDAO.getInstancia().alterarBomba(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
        BombaDAO.getInstancia().excluirBomba(this);
    }

   
}
