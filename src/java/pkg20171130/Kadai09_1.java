/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20171130;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author merarli
 */
@WebServlet(name = "Kadai09_1", urlPatterns = {"/pkg20171130/Kadai09_1"})
public class Kadai09_1 extends HttpServlet {

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
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
            out.println("<title>基本情報の表示</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>基本情報の表示" + request.getContextPath() + "</h1>");

            request.setCharacterEncoding("UTF-8");
//          文字化け対策

//            out.println("year:" + request.getParameter("raji1") + "<br>");
//            out.println("month:" + request.getParameter("month") + "<br>");
//            out.println("day:" + request.getParameter("day") + "<br>");
//          疲れる書き方
            String result[] = {"te", "raji1"};
            out.println("<table class=\"type04\">");
            for (String tmp : result) {
                out.println("<tr><th>" + tmp + "</th><th>" + request.getParameter(tmp) + "</th></tr>");
            }

            for (int i = 1; i < 7; i++) {
                String getStr = request.getParameter("check" + i);
                if (getStr != null) {
                    out.print("<tr><th>" + "興味" + "</th><th>" +  getStr + "</th></tr>");
                }
            }
            out.println("</table>");
//          配列で自動書き出し
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
