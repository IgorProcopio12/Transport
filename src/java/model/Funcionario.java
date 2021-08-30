/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.List;



/**
 *
 * @author Igor-SSD
 */
public class Funcionario {

    private int idFuncionario;
    private String nome;
    private String cpf;
    private String rg;
    private String cidade;
    private String estado;
    private String bairro;
    private String rua;
    private String numero;
    private String cep;
    private String complemento;
    private String telefone;
    private String telefone2;
    private String email;

    public Funcionario(int idFuncionario, String nome, String cpf, String rg, String cidade, String estado, String bairro, String rua, String numero, String cep, String complemento, String telefone, String telefone2, String email) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.telefone = telefone;
        this.telefone2 = telefone2;
        this.email = email;
    }

    

   public static Funcionario obterFuncionario(int idFuncionario) throws 
            ClassNotFoundException, SQLException {
        return FuncionarioDAO.getInstancia().obterFuncionario(idFuncionario);
    }
    
    
    public static List<Funcionario> obterFuncionarios()
            throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.getInstancia().obterFuncionarios();
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public void gravar() throws SQLException, ClassNotFoundException{
        FuncionarioDAO.getInstancia().gravarFuncionario(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
        FuncionarioDAO.getInstancia().alterarFuncionario(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
        FuncionarioDAO.getInstancia().excluirFuncionario(this);
    }

    
    
}
