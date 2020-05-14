/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controller;

import br.com.DAO.UsuarioDAO;
import br.com.Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Willian
 */
@WebServlet(name = "CadastrarUsuarioCTR", urlPatterns = {"/CadastrarUsuarioCTR"})
public class CadastrarUsuarioCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mensagem = "";
        //recebendo informações da página web  
        String nomeUsuario = request.getParameter("nomeUsuario");
        String emailUsuario = request.getParameter("emailUsuario");
        String senhaUsuario = request.getParameter("senhaUsuario");

        //alimentando a model com as informações
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setEmailUsuario(emailUsuario);
        usuario.setSenhaUsuario(senhaUsuario);

        try {
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.cadastrar(usuario)) {
                mensagem = "Usuário cadastrado com sucesso!!";
            } else {
                mensagem = "Erro ao cadastrar Usuário";
            }
            //enviando a variável para a página web
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("cadastrar_usuario.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Problemas "
    + "ao cadastrar Usuário"+e.getMessage()); 
            e.printStackTrace();
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
