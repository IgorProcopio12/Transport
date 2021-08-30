/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AbastecimentoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Igor-SSD
 */
public class Abastecimento {

    private int codigo;
    private String quantidade;
    private int matriculaFuncionario;
    private int numeroGaragem;
    private int codigoTanque;
    private int codigoBomba;
    private int numeroCarro;
    private int codigoCombustivel;
    private Funcionario funcionario;
    private Garagem garagem;
    private Tanque tanque;
    private Bomba bomba;
    private Carro carro;
    private Combustivel combustivel;

    public Abastecimento(int codigo, String quantidade, Funcionario funcionario, Garagem garagem, Tanque tanque, Bomba bomba, Carro carro, Combustivel combustivel) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.funcionario = funcionario;
        this.garagem = garagem;
        this.tanque = tanque;
        this.bomba = bomba;
        this.carro = carro;
        this.combustivel = combustivel;
    }

    public static List<Abastecimento> obterAbastecimentos()
            throws ClassNotFoundException, SQLException {
        return AbastecimentoDAO.getInstancia().obterAbastecimentos();
    }

    public static Abastecimento obterAbastecimento(int idAbastecimento) throws
            ClassNotFoundException, SQLException {
        return AbastecimentoDAO.getInstancia().obterAbastecimento(idAbastecimento);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Funcionario getFuncionario() throws ClassNotFoundException, SQLException {
        if ((this.matriculaFuncionario != 0) && (this.funcionario == null)) {
            this.funcionario = Funcionario.obterFuncionario(this.matriculaFuncionario);
        }
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Garagem getGaragem() throws ClassNotFoundException, SQLException {
        if ((this.numeroGaragem != 0) && (this.garagem == null)) {
            this.garagem = Garagem.obterGaragem(this.numeroGaragem);
        }
        return this.garagem;
    }

    public void setGaragem(Garagem garagem) {
        this.garagem = garagem;
    }

    public Tanque getTanque() throws ClassNotFoundException, SQLException {
        if ((this.codigoTanque != 0) && (this.tanque == null)) {
            this.tanque = Tanque.obterTanque(this.codigoTanque);
        }
        return this.tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }

    public Bomba getBomba() throws ClassNotFoundException, SQLException {
        if ((this.codigoBomba != 0) && (this.bomba == null)) {
            this.bomba = Bomba.obterBomba(this.codigoBomba);
        }
        return this.bomba;
    }

    public void setBomba(Bomba bomba) {
        this.bomba = bomba;
    }

    public Carro getCarro() throws ClassNotFoundException, SQLException {
        if ((this.numeroCarro != 0) && (this.carro == null)) {
            this.carro = Carro.obterCarro(this.numeroCarro);
        }
        return this.carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Combustivel getCombustivel() throws ClassNotFoundException, SQLException {
        if ((this.codigoCombustivel != 0) && (this.combustivel == null)) {
            this.combustivel = Combustivel.obterCombustivel(this.codigoCombustivel);
        }
        return this.combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public int getMatriculaFuncionario() {
        return matriculaFuncionario;
    }

    public void setMatriculaFuncionario(int matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
    }

    public int getNumeroGaragem() {
        return numeroGaragem;
    }

    public void setNumeroGaragem(int numeroGaragem) {
        this.numeroGaragem = numeroGaragem;
    }

    public int getCodigoTanque() {
        return codigoTanque;
    }

    public void setCodigoTanque(int codigoTanque) {
        this.codigoTanque = codigoTanque;
    }

    public int getCodigoBomba() {
        return codigoBomba;
    }

    public void setCodigoBomba(int codigoBomba) {
        this.codigoBomba = codigoBomba;
    }

    public int getNumeroCarro() {
        return numeroCarro;
    }

    public void setNumeroCarro(int numeroCarro) {
        this.numeroCarro = numeroCarro;
    }

    public int getCodigoCombustivel() {
        return codigoCombustivel;
    }

    public void setCodigoCombustivel(int codigoCombustivel) {
        this.codigoCombustivel = codigoCombustivel;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        AbastecimentoDAO.getInstancia().gravarAbastecimento(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AbastecimentoDAO.getInstancia().alterarAbastecimento(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AbastecimentoDAO.getInstancia().excluirAbastecimento(this);
    }

    public void visualizar() throws SQLException, ClassNotFoundException {
        AbastecimentoDAO.getInstancia().excluirAbastecimento(this);
    }
}
