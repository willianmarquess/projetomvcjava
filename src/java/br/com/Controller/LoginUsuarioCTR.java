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
@WebServlet(name = "LoginUsuarioCTR", urlPatterns = {"/LoginUsuarioCTR"})
public class LoginUsuarioCTR extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String emailUsuario = request.getParameter("emailUsuario");
        String senhaUsuario = request.getParameter("senhaUsuario");
        Usuario usuario = new Usuario();
        String mensagem = "";
        usuario.setEmailUsuario(emailUsuario);
        usuario.setSenhaUsuario(senhaUsuario);
        try {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuarioLogado = dao.logar(usuario);
            if (usuarioLogado != null) {
                request.getSession().setAttribute("usuario", usuarioLogado);
                request.getSession().setMaxInactiveInterval(60);
                request.setAttribute("usuario", usuarioLogado);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                mensagem = "E-mail ou senha incorretos";
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("Problemas ao logar usuário!! Erro: " + e.getMessage());
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
