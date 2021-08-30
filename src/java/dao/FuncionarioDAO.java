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
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;


/**
 *
 * @author Igor-SSD
 */
public class FuncionarioDAO extends DAO {
    private static FuncionarioDAO instancia = new FuncionarioDAO();
    public static FuncionarioDAO getInstancia(){
        return instancia;
    }
    private FuncionarioDAO(){};
    
    public void gravarFuncionario(Funcionario funcionario) throws 
            ClassNotFoundException, SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement(
            "insert into funcionario (idFuncionario, nome, cpf, rg, cidade,"
                    + "estado, bairro, rua, numero, cep, complemento, telefone,"
                    + "telefone2, email) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, funcionario.getIdFuncionario());
            comando.setString(2, funcionario.getNome());
            comando.setString(3, funcionario.getCpf());
            comando.setString(4, funcionario.getRg());
            comando.setString(5, funcionario.getCidade());
            comando.setString(6, funcionario.getEstado());
            comando.setString(7, funcionario.getBairro());
            comando.setString(8, funcionario.getRua());
            comando.setString(9, funcionario.getNumero());
            comando.setString(10, funcionario.getCep());
            comando.setString(11, funcionario.getComplemento());
            comando.setString(12, funcionario.getTelefone());
            comando.setString(13, funcionario.getTelefone2());
            comando.setString(14, funcionario.getEmail());  
            comando.execute();
        }finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public void excluirFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getInstance().getConnection();
            comando = conexao.createStatement();
            stringSQL = "delete from funcionario where idFuncionario = " + funcionario.getIdFuncionario();
            comando.execute(stringSQL);
        } finally{
            fecharConexao(conexao, comando);
        }
    }
    
    public void alterarFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException {

         Connection conexao = null;
         PreparedStatement comando = null;

         try {
            conexao = BD.getInstance().getConnection();
            comando = conexao.prepareStatement("UPDATE funcionario set nome=?, cpf=?, rg=?, cidade=?, estado=?, bairro=?, rua=?, numero=?, cep=?, "
                    + "complemento=?, telefone=?, telefone2=?, email=? WHERE idFuncionario=?");
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCpf());
            comando.setString(3, funcionario.getRg());
            comando.setString(4, funcionario.getCidade());
            comando.setString(5, funcionario.getEstado());
            comando.setString(6, funcionario.getBairro());
            comando.setString(7, funcionario.getRua());
            comando.setString(8, funcionario.getNumero());
            comando.setString(9, funcionario.getCep());
            comando.setString(10, funcionario.getComplemento());
            comando.setString(11, funcionario.getTelefone());
            comando.setString(12, funcionario.getTelefone2());
            comando.setString(13, funcionario.getEmail()); 
            comando.setInt(14, funcionario.getIdFuncionario());
            comando.execute();

            
         } finally {
             fecharConexao(conexao, comando);
         }

     }
    
    
    
    public List<Funcionario> obterFuncionarios() 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    Funcionario funcionario = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from funcionario");
        while (rs.next()) {
            funcionario = instanciarFuncionario(rs);
            funcionarios.add(funcionario);
        }
    } finally {
    fecharConexao(conexao, comando);
    }
    return funcionarios;
}

    public Funcionario obterFuncionario(int idFuncionario) 
            throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    Funcionario funcionario = null;
    try {
    conexao = BD.getInstance().getConnection();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from funcionario where idFuncionario = " + idFuncionario);
        rs.first();
            funcionario = instanciarFuncionario(rs);
            
    } finally {
    fecharConexao(conexao, comando);
    }
    return funcionario;
 }    
    private Funcionario instanciarFuncionario(ResultSet rs) throws SQLException {
       Funcionario funcionario = new Funcionario(rs.getInt("idFuncionario"),
           rs.getString("nome"),
           rs.getString("cpf"),
           rs.getString("rg"), 
           rs.getString("cidade"),
           rs.getString("estado"),
           rs.getString("bairro"),
           rs.getString("rua"),
           rs.getString("numero"),
           rs.getString("cep"),
           rs.getString("complemento"),
           rs.getString("telefone"),
           rs.getString("telefone2"),
           rs.getString("email")); 
       return funcionario;
    }



}
        
