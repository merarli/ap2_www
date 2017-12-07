package pkg20171130;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import .*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author merarli
 */
@WebServlet(urlPatterns = {"/pkg20171130/Kadai09_31"})
public class Kadai09_31 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ex93</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ex93 at " + request.getContextPath() + "</h1>");

            HttpSession session = request.getSession(false);
            if (session == null) {
                out.println("初めてのAccessですね。セッション開始！");
                session = request.getSession(true);
                String str = request.getParameter("year");
                session.setAttribute("id", str);
            } else {
                out.println("すでにセッションは開始しています。");
            }
            out.print("<br>");
            out.println("id:"+request.getParameter("year") + "<br>");

            Date date = new Date();
            SimpleDateFormat d1 = new SimpleDateFormat("yyyy年MM月dd日()HH:MM:mm");
            String q1 = d1.format(date);
            
            out.println("date:"+q1);
            
            out.println("<p><a href=\"Kadai09_32\">Kadai09_32</a></p>");
            out.println("<p><a href=\"Kadai09_33\">Kadai09_33</a></p>");

            out.println("</body>");
            out.println("</html>");
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