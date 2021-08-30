/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import dao.GaragemDAO;
import java.sql.SQLException;
import java.util.List;



/**
 *
 * @author Igor-SSD
 */
public class Garagem {
    public int codigo;
    public String descricao;
    private String cep;
    private String estado;
    private String rua;
    private String bairro;
    private String cidade;
    private String numero;
    private String complemento;
    private String telefone;

    public Garagem(int codigo, String descricao, String cep, String estado, String rua, String bairro, String cidade, String numero, String complemento, String telefone) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.cep = cep;
        this.estado = estado;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.complemento = complemento;
        this.telefone = telefone;
    }

   
    
    public static Garagem obterGaragem(int idGaragem) throws 
            ClassNotFoundException, SQLException {
        return GaragemDAO.getInstancia().obterGaragem(idGaragem);
    }
    
    public static List<Garagem> obterGaragens()
            throws ClassNotFoundException, SQLException {
        return GaragemDAO.getInstancia().obterGaragens();
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    

    

public void gravar() throws SQLException, ClassNotFoundException{
        GaragemDAO.getInstancia().gravarGaragem(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
        GaragemDAO.getInstancia().alterarGaragem(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
        GaragemDAO.getInstancia().excluirGaragem(this);
    }

    
}
