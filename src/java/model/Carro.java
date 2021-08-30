/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import dao.CarroDAO;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Igor-SSD
 */
public class Carro {
    private int numero;
    private String modelo;
    private String chassi;
    private String placa;
    private String ano;
    private Garagem garagem;
    private int numeroGaragem;

    public Carro(int numero, String modelo, String chassi, String placa, String ano, Garagem garagem) {
        this.numero = numero;
        this.modelo = modelo;
        this.chassi = chassi;
        this.placa = placa;
        this.ano = ano;
        this.garagem = garagem;
    }
    
    
    public static Carro obterCarro(int idCarro) throws 
            ClassNotFoundException, SQLException {
        return CarroDAO.getInstancia().obterCarro(idCarro);
    }
    
    public static List<Carro> obterCarros()
            throws ClassNotFoundException, SQLException {
        return CarroDAO.getInstancia().obterCarros();
    } 

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
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

    public int getNumeroGaragem() {
        return numeroGaragem;
    }

    public void setNumeroGaragem(int numeroGaragem) {
        this.numeroGaragem = numeroGaragem;
    }


   
    public void gravar() throws SQLException, ClassNotFoundException{
       CarroDAO.getInstancia().gravarCarro(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
       CarroDAO.getInstancia().alterarCarro(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
        CarroDAO.getInstancia().excluirCarro(this);
    }

    
}
