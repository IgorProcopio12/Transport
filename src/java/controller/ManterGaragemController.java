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
import model.Garagem;

/**
 *
 * @author Igor-SSD
 */
public class ManterGaragemController extends HttpServlet {

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
            request.setAttribute("garagens", Garagem.obterGaragens());
            if (!operacao.equals("Incluir")) {
                int idGaragem = Integer.parseInt(request.getParameter("idGaragem"));
                Garagem garagem = Garagem.obterGaragem(idGaragem);
                request.setAttribute("garagem", garagem);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterGaragem.jsp");
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
        int idGaragem = Integer.parseInt(request.getParameter("codigo")); 
        String descricao = request.getParameter("descricao");
        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String complemento = request.getParameter("complemento");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String telefone = request.getParameter("telefone");
        
        try {
            Garagem garagem = new Garagem(idGaragem, descricao, cep, estado, rua, bairro, cidade, numero, complemento, telefone);
            if (operacao.equals("Incluir")){
                garagem.gravar();
            } else {
                if (operacao.equals("Editar")){
                    garagem.alterar();
                               
               } else {
                   if (operacao.equals("Excluir")){
                       garagem.excluir();
                    
                    }
                }
            }
        RequestDispatcher view = request.getRequestDispatcher("PesquisaGaragemController");
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
