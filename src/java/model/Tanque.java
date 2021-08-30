/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dao.TanqueDAO;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Igor-SSD
 */
public class Tanque {
    private int codigo;
    private String descricao;
    private String capacidade;
    private Combustivel combustivel;
    private Garagem garagem;
    private int numeroGaragem;
    private int codigoCombustivel;

    public Tanque(int codigo, String descricao, String capacidade, Combustivel combustivel, Garagem garagem) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.combustivel = combustivel;
        this.garagem = garagem;
    }


    
    public static Tanque obterTanque(int idTanque) throws 
            ClassNotFoundException, SQLException {
        return TanqueDAO.getInstancia().obterTanque(idTanque);
    }
    
    
    public static List<Tanque> obterTanques()
            throws ClassNotFoundException, SQLException {
        return TanqueDAO.getInstancia().obterTanques();
    }
    
    public Garagem getGaragem()throws ClassNotFoundException, SQLException {
    if ((this.numeroGaragem !=0) && (this.garagem == null)){
        this.garagem = Garagem.obterGaragem(this.numeroGaragem);
    }    
        return this.garagem;
  }

    public void setGaragem(Garagem garagem) {
        this.garagem = garagem;
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

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public Combustivel getCombustivel() throws ClassNotFoundException, SQLException {
    if ((this.codigoCombustivel !=0) && (this.combustivel == null)){
        this.combustivel = Combustivel.obterCombustivel(this.codigoCombustivel);
    }    
        return this.combustivel;
  }



    public int getNumeroGaragem() {
        return numeroGaragem;
    }

    public void setNumeroGaragem(int numeroGaragem) {
        this.numeroGaragem = numeroGaragem;
    }

    public int getCodigoCombustivel() {
        return codigoCombustivel;
    }

    public void setCodigoCombustivel(int codigoCombustivel) {
        this.codigoCombustivel = codigoCombustivel;
    }

    
    public void gravar() throws SQLException, ClassNotFoundException{
       TanqueDAO.getInstancia().gravarTanque(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
        TanqueDAO.getInstancia().alterarTanque(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
        TanqueDAO.getInstancia().excluirTanque(this);
    }

    
}
