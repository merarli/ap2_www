/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20171213;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author merarli
 */
@WebServlet(name = "Ex11_2", urlPatterns = {"/pkg20171213/Ex11_2"})
public class Ex11_2 extends HttpServlet {

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

            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Ex11_1</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Ex11_1 at " + request.getContextPath() + "</h1>");

            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            //コネクションとステートメントの宣言
            Connection con = null;
            Statement stmt = null;

            try (PrintWriter out = response.getWriter()) {
                //Class.forNameの記述
                Class.forName("org.apache.derby.jdbc.ClientDriver");

                //データベースへの接続
                String driverUrl = "jdbc:derby://localhost:1527/meibo";
                con = DriverManager.getConnection(driverUrl, "db", "db");
                stmt = con.createStatement();

                String sql = "select * from T_STUDENT_A";
                ResultSet rs = stmt.executeQuery(sql);

                //Student型のArrayListを作成
                List<Student> slist = new ArrayList<>();

                //データベースから値を取得して出力
                while (rs.next()) {
                    //1つのレコードの情報を格納するインスタンスstdを作成
                    Student std = new Student();

                    //stdにレコードの値をセット
                    std.setSID(rs.getInt("STUDENT_ID"));
                    std.setName(rs.getString("FULLNAME"));
                    std.setGakubu(rs.getInt("GAKUBU_ID"));
                    std.setGrade(rs.getInt("GRADE"));

                    //リストにstdを追加
                    slist.add(std);
                }

                //ResultSetのclose
                rs.close();

                //リストの内容を順番に出力
                for (Student s : slist) {
                    out.println("STUDENT_ID=" + s.getSID() + "<br>");
                    out.println("FULLNAME=" + s.getName() + "<br>");
                    out.println("GAKUBU_ID=" + s.getGakubu() + "<br>");
                    out.println("GRADE=" + s.getGrade() + "<br>");
                    //同様にFULLNAME, GAKUBU_ID, GRADEを出力
                }

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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
