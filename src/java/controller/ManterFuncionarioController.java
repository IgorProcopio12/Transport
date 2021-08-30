/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;

/**
 *
 * @author Igor-SSD
 */
public class ManterFuncionarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
            if(acao.equals("confirmarOperacao")){
                    confirmarOperacao(request, response);
          }else{
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }
    }
 }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("funcionarios", Funcionario.obterFuncionarios());
            if (!operacao.equals("Incluir")) {
                int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
                Funcionario funcionario = Funcionario.obterFuncionario(idFuncionario);
                request.setAttribute("funcionario", funcionario);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterFuncionario.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
    
     public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException{
        String operacao = request.getParameter("operacao");
        int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String complemento = request.getParameter("complemento");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String telefone = request.getParameter("telefone");
        String telefone2 = request.getParameter("telefone2");
        String email = request.getParameter("email");
        
        try {
            Funcionario funcionario = new Funcionario(idFuncionario, nome, cpf, rg, cidade, estado, bairro, rua,  numero, cep, complemento, telefone, telefone2, email);
            if (operacao.equals("Incluir")){
                funcionario.gravar();
            } else {
                if (operacao.equals("Editar")){
                    funcionario.alterar();
                               
               } else {
                   if (operacao.equals("Excluir")){
                       funcionario.excluir();
                    
                    }
                }
            }
        RequestDispatcher view = request.getRequestDispatcher("PesquisaFuncionarioController");
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
