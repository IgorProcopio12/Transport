/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Abastecimento;
import model.Bomba;
import model.Carro;
import model.Combustivel;
import model.Funcionario;
import model.Garagem;
import model.Tanque;

/**
 *
 * @author Igor
 */
public class VisualizarAbastecimentoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
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
            request.setAttribute("abastecimentos", Abastecimento.obterAbastecimentos());
            request.setAttribute("funcionarios", Funcionario.obterFuncionarios());
            request.setAttribute("garagens", Garagem.obterGaragens());
            request.setAttribute("tanques", Tanque.obterTanques());
            request.setAttribute("bombas", Bomba.obterBombas());
            request.setAttribute("carros", Carro.obterCarros());
            request.setAttribute("combustiveis", Combustivel.obterCombustiveis());

            if (!operacao.equals("Incluir")) {
                int idAbastecimento = Integer.parseInt(request.getParameter("idAbastecimento"));
                Abastecimento abastecimento = Abastecimento.obterAbastecimento(idAbastecimento);
                request.setAttribute("abastecimento", abastecimento);
            }
            RequestDispatcher view = request.getRequestDispatcher("/visualizarAbastecimento.jsp");
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
            throws ServletException {
        String operacao = request.getParameter("operacao");
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String quantidade = request.getParameter("quantidade");
        int idFuncionario = Integer.parseInt(request.getParameter("funcionario"));
        int idGaragem = Integer.parseInt(request.getParameter("garagem"));
        int idTanque = Integer.parseInt(request.getParameter("tanque"));
        int idBomba = Integer.parseInt(request.getParameter("bomba"));
        int idCarro = Integer.parseInt(request.getParameter("carro"));
        int idCombustivel = Integer.parseInt(request.getParameter("combustivel"));

        try {
            Funcionario funcionario = null;
            if (idFuncionario != 0) {
                funcionario = Funcionario.obterFuncionario(idFuncionario);
            }
            Garagem garagem = null;
            if (idGaragem != 0) {
                garagem = Garagem.obterGaragem(idGaragem);
            }
            Tanque tanque = null;
            if (idTanque != 0) {
                tanque = Tanque.obterTanque(idTanque);
            }
            Bomba bomba = null;
            if (idBomba != 0) {
                bomba = Bomba.obterBomba(idBomba);
            }
            Carro carro = null;
            if (idCarro != 0) {
                carro = Carro.obterCarro(idCarro);
            }
            Combustivel combustivel = null;
            if (idCombustivel != 0) {
                combustivel = Combustivel.obterCombustivel(idCombustivel);
            }
            Abastecimento abastecimento = new Abastecimento(codigo, quantidade, funcionario, garagem, tanque, bomba, carro, combustivel);
            if (operacao.equals("Visualizar")) {
                abastecimento.visualizar();

            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAbastecimentoController");
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
