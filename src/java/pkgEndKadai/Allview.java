/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgEndKadai;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author C0116289
 */
@WebServlet(urlPatterns = {"/pkgEndKadai/Allview"})
public class Allview extends HttpServlet {

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

        //コネクションとステートメントの宣言
        Connection con = null;
        Statement stmt = null;
        PreparedStatement ps = null;

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Kadai10_3</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Servlet Kadai10_3 at " + request.getContextPath() + "</h3>");

            //Class.forNameの記述
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //データベースへの接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deaiDB", "kadaiyou", "Kadaiyou1!");
            stmt = con.createStatement();

//            SQL文の発行
            String username = request.getParameter("username");
            String sex = request.getParameter("sex");
            String age = request.getParameter("age");
            String appeal = request.getParameter("appeal");
            
            String sql = "INSERT INTO postlist VALUES(?,?,?,?,?,?)";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, "DEFAULT");
            ps.setString(2, username);
            ps.setString(3, sex);
            ps.setInt(4, Integer.parseInt(age));
            ps.setString(5, appeal);
            
            //投稿の日付
            GregorianCalendar cal = new GregorianCalendar();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String datestr = format.format(cal.getTime());
            
            ps.setString(6,datestr);

            
            int count = ps.executeUpdate();

            String sql2 = "select * from postlist";
            ps = con.prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();

            //データベースから値を取得して出力
            while (rs.next()) {
                out.println("postid=" + rs.getInt("postid") + "<br>");
                out.println("username=" + rs.getString("username") + "<br>");
                out.println("sex=" + rs.getString("sex") + "<br>");
                out.println("age=" + rs.getInt("age") + "<br>");
                out.println("appeal=" + rs.getString("appeal") + "<br>");
                out.println("date=" + rs.getString("date") + "<br>");
                out.println("<hr><br>");
            }

            //ResultSetのclose
            rs.close();

            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            //サーブレット内での例外をアプリケーションのエラーとして表示
            throw new ServletException(e);
        } finally {
            //例外が発生する・しないにかかわらず確実にデータベースから切断
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
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
