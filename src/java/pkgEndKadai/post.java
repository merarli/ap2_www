/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgEndKadai;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author merarli
 */
@WebServlet(name = "post", urlPatterns = {"/pkgEndKadai/post"})
public class post extends HttpServlet {

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
            out.println("<title>Servlet Ex103</title>");
            out.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 class=\"top\">出会いMerarli</h1>");
            out.println("<div class=\"div-main\">");
            out.println("<div class=\"div-in\">");
            
//            out.println("<h3>Servlet Ex103 at " + request.getContextPath() + "</h3>");
            
            

//            Class.forNameの記述
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //データベースへの接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deaiDB", "kadaiyou", "Kadaiyou1!");
            stmt = con.createStatement();
            request.setCharacterEncoding("UTF-8");

            String username = request.getParameter("username");
            String sex = request.getParameter("sex");
            String age = request.getParameter("age");
            String appeal = request.getParameter("appeal");

            //レコードの追加
            String sql1 = "INSERT INTO postlist VALUES(DEFAULT,?,?,?,?,?)";
            ps = con.prepareStatement(sql1);

            ps.setString(1, username);
            ps.setString(2, sex);
            ps.setInt(3, Integer.parseInt(age));
            ps.setString(4, appeal);

            //投稿の日付
            GregorianCalendar cal = new GregorianCalendar();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
            String datestr = format.format(cal.getTime());
            java.sql.Date d3 = Date.valueOf(datestr);

            ps.setDate(5, d3);

            int count = ps.executeUpdate();

            String sql2 = "select * from postlist";
            ps = con.prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();

            //データベースから値を取得して出力
            while (rs.next()) {
                out.println("<div class=\"post\">");
                out.println("<b>"+rs.getString("username")+"</b>");
                out.println("<span class=\"gray\">投稿ID:" + rs.getInt("postid"));
                out.println(rs.getString("date") + "<br></span>");
                out.println("<span class=\"gray\">性別:" + rs.getString("sex"));
                out.println("年齢:" + rs.getInt("age") + "</span><br>");
                out.println(rs.getString("appeal") + "<br>");
                out.println("<a href=\"#\" class=\"square_btn\">返信する♥</a>");
                out.println("</div>");
            }

            //ResultSetのclose
            rs.close();

            out.println("</div>");
            out.println("<div class=\"div-in-35\">");
            out.println("<div id=\"google_center_div\"><div id=\"google_image_div\" style=\"height: 280px; width: 336px; overflow:hidden; position:relative\"><input type=\"hidden\" id=\"csi\" value=\"1\"><a id=\"aw0\" target=\"_top\" href=\"//www.googleadservices.com/pagead/aclk?sa=L&amp;ai=C6TJoak1XWrHQK8Po2ASen4LICc-nj85Pt_btvMQGjLj4y9oJEAEgrtyWJWCJk9SErBSgAb-atuQDyAECqQIDCF49wTVDPqgDAcgDyQSqBKcBT9D75Aq7-ZA0rwjjQp4g-4Tn2tqcPbuRDodut_3v-dKD3f6BlZ-L3k8rQnX5wR2Yt6tTIVofAcr8razdHITVOcv3H-pAO-uBfkqJ_2qEztr2n2W-0GtoM-x6fNgXK_gt37LkI1ksPRNKSlRp-iWU-tP3lca2eLQ_5qjlHX2OESp52siTDjxWpU-uL9Il0ikFQqJI5nz-9kURr2G2sgh2zRY6hVH7kdSgBgKAB6nlyRuoB6a-G9gHAdIIBwiAARABGAKxCZbvsEafAZf_gAoB2BMC&amp;num=1&amp;cid=CAASEuRov0mbkFCS973zS_sU1bRpVg&amp;sig=AOD64_0f_oqurO6YKJeOal1DBdCd-OHMzA&amp;client=ca-pub-5403370376223466&amp;adurl=https://mynavi-creator.jp/feature/0007\" data-original-click-url=\"https://www.googleadservices.com/pagead/aclk?sa=L&amp;ai=C6TJoak1XWrHQK8Po2ASen4LICc-nj85Pt_btvMQGjLj4y9oJEAEgrtyWJWCJk9SErBSgAb-atuQDyAECqQIDCF49wTVDPqgDAcgDyQSqBKcBT9D75Aq7-ZA0rwjjQp4g-4Tn2tqcPbuRDodut_3v-dKD3f6BlZ-L3k8rQnX5wR2Yt6tTIVofAcr8razdHITVOcv3H-pAO-uBfkqJ_2qEztr2n2W-0GtoM-x6fNgXK_gt37LkI1ksPRNKSlRp-iWU-tP3lca2eLQ_5qjlHX2OESp52siTDjxWpU-uL9Il0ikFQqJI5nz-9kURr2G2sgh2zRY6hVH7kdSgBgKAB6nlyRuoB6a-G9gHAdIIBwiAARABGAKxCZbvsEafAZf_gAoB2BMC&amp;num=1&amp;cid=CAASEuRov0mbkFCS973zS_sU1bRpVg&amp;sig=AOD64_0f_oqurO6YKJeOal1DBdCd-OHMzA&amp;client=ca-pub-5403370376223466&amp;adurl=https://mynavi-creator.jp/feature/0007\"><div data-a7n=\"\"><img src=\"https://tpc.googlesyndication.com/daca_images/simgad/15464130668852596428\" border=\"0\" width=\"336\" alt=\"\" class=\"img_ad\"></div></a><style>div,ul,li{margin:0;padding:0;}.abgc{display:block;height:15px;overflow:hidden;position:absolute;right:17px;top:1px;text-rendering:geometricPrecision;width:15px;z-index:9020;}.abgb{display:block;height:15px;width:15px;}.abgc,.abgcp,.cbb {opacity: 0;}.jar .abgc,.jar .abgcp,.jar .cbb {opacity: 1;}.jaa .abgc,.jaa .abgcp,.jaa .cbb {display: none;}.abgc{cursor:pointer;}.cbb{cursor:pointer;height:15px;width:15px;z-index:9020;}.cbb svg {position: absolute;top: 0;right: 0;height: 15px;width: 15px;}.cbb .cbbbg {fill-opacity:1.0;fill:#ffffff;stroke:none;}.cbb .cbbcross {stroke: #00aecd;stroke-width: 1.25;}.cbb:hover{cursor:pointer;}.cbb:hover .cbbbg {fill: #58585a;}.cbb:hover .cbbcross {stroke: #ffffff;}.abgb{position:absolute;right:0px;top:0px;}.cbb{position:absolute;right:1px;top:1px;}.abgc img{display:block;}.abgc svg{display:block;}.abgs{display:none;height:100%;}.abgl{text-decoration:none;}.abgi{fill-opacity:1.0;fill:#00aecd;stroke:none;}.abgbg{fill-opacity:1.0;fill:#ffffff;stroke:none;}.abgtxt{fill:black;font-family:'Arial';font-size:100px;overflow:visible;stroke:none;}.abgac{position:fixed;left:0px;top:0px;z-index:9100;display:none;width:100%;height:100%;background-color:#FAFAFA;}</style><div id=\"abgc\" class=\"abgc\" dir=\"ltr\" aria-hidden=\"true\"><div id=\"abgb\" class=\"abgb\"><svg width=\"100%\" height=\"100%\"><rect class=\"abgbg\" width=\"100%\" height=\"100%\"></rect><svg class=\"abgi\" x=\"0px\"><path d=\"M7.5,1.5a6,6,0,1,0,0,12a6,6,0,1,0,0,-12m0,1a5,5,0,1,1,0,10a5,5,0,1,1,0,-10ZM6.625,11l1.75,0l0,-4.5l-1.75,0ZM7.5,3.75a1,1,0,1,0,0,2a1,1,0,1,0,0,-2Z\"></path></svg></svg></div><div id=\"abgs\" class=\"abgs\"><a id=\"abgl\" class=\"abgl\" href=\"https://www.google.com/url?ct=abg&amp;q=https://www.google.com/adsense/support/bin/request.py%3Fcontact%3Dabg_afc%26url%3Dhttps://www.javadrive.jp/servlet/database/index10.html%26gl%3DJP%26hl%3Dja%26client%3Dca-pub-5403370376223466%26ai0%3DC6TJoak1XWrHQK8Po2ASen4LICc-nj85Pt_btvMQGjLj4y9oJEAEgrtyWJWCJk9SErBSgAb-atuQDyAECqQIDCF49wTVDPqgDAcgDyQSqBKcBT9D75Aq7-ZA0rwjjQp4g-4Tn2tqcPbuRDodut_3v-dKD3f6BlZ-L3k8rQnX5wR2Yt6tTIVofAcr8razdHITVOcv3H-pAO-uBfkqJ_2qEztr2n2W-0GtoM-x6fNgXK_gt37LkI1ksPRNKSlRp-iWU-tP3lca2eLQ_5qjlHX2OESp52siTDjxWpU-uL9Il0ikFQqJI5nz-9kURr2G2sgh2zRY6hVH7kdSgBgKAB6nlyRuoB6a-G9gHAdIIBwiAARABGAKxCZbvsEafAZf_gAoB2BMC&amp;usg=AFQjCNH1YLq9Tpn4-nx5vVI6KMpBSr15uQ\" target=\"_blank\"><svg width=\"100%\" height=\"100%\"><path class=\"abgbg\" d=\"M0,0L96,0L96,15L4,15s-4,0,-4,-4z\"></path><svg class=\"abgtxt\" x=\"5px\" y=\"11px\" width=\"34px\"><text>Ads by</text></svg><svg class=\"abgtxt\" x=\"41px\" y=\"11px\" width=\"38px\"><text>Google</text></svg><svg class=\"abgi\" x=\"81px\"><path d=\"M7.5,1.5a6,6,0,1,0,0,12a6,6,0,1,0,0,-12m0,1a5,5,0,1,1,0,10a5,5,0,1,1,0,-10ZM6.625,11l1.75,0l0,-4.5l-1.75,0ZM7.5,3.75a1,1,0,1,0,0,2a1,1,0,1,0,0,-2Z\"></path></svg></svg></a></div></div><div id=\"cbb\" class=\"cbb\" aria-hidden=\"true\"><svg><path class=\"cbbbg\" d=\"M0,0l15,0l0,15l-15,0Z\"></path><path class=\"cbbcross\" d=\"M3.25,3.25l8.5,8.5M11.75,3.25l-8.5,8.5\"></path></svg></div><div id=\"mute_panel\" aria-hidden=\"true\"></div><div id=\"abgac\" class=\"abgac\" aria-hidden=\"true\"></div><script>var abgp={hw:15,sw:96,hh:15,sh:15,himg:'https://tpc.googlesyndication.com'+'/pagead/images/abg/icon.png',simg:'https://tpc.googlesyndication.com'+'/pagead/images/abg/en.png',alt:'Ads by Google',t:'Ads by',tw:34,t2:'Google',t2w:38,tbo:0,att:'adsbygoogle',ff:'',halign:'right',fe:false,iba:false,lttp:true,uic:true,uit:true,ci:'',icd:{\"creatives\":[],\"height\":280,\"width\":336,\"attribution\":{\"user_feedback_data\":{\"mute_icon_url\":\"https://googleads.g.doubleclick.net/pagead/images/mtad/x_blue.png\",\"pub_feedback_icon_url\":\"https://googleads.g.doubleclick.net/pagead/images/mtad/x_blue.png\",\"conversion_url\":\"https://googleads.g.doubleclick.net/pagead/conversion/?ai=C6TJoak1XWrHQK8Po2ASen4LICc-nj85Pt_btvMQGjLj4y9oJEAEgrtyWJWCJk9SErBSgAb-atuQDyAECqQIDCF49wTVDPqgDAcgDyQSqBKcBT9D75Aq7-ZA0rwjjQp4g-4Tn2tqcPbuRDodut_3v-dKD3f6BlZ-L3k8rQnX5wR2Yt6tTIVofAcr8razdHITVOcv3H-pAO-uBfkqJ_2qEztr2n2W-0GtoM-x6fNgXK_gt37LkI1ksPRNKSlRp-iWU-tP3lca2eLQ_5qjlHX2OESp52siTDjxWpU-uL9Il0ikFQqJI5nz-9kURr2G2sgh2zRY6hVH7kdSgBgKAB6nlyRuoB6a-G9gHAdIIBwiAARABGAKxCZbvsEafAZf_gAoB2BMC\\u0026sigh=fUbD56lYCJo\\u0026cid=CAASEuRov0mbkFCS973zS_sU1bRpVg\",\"close_button_token\":\"tze9Ze_DJq0It_btvMQGEPfi9OcDGPHZxxwiEW15bmF2aS1jcmVhdG9yLmpwQhdjYS1wdWItNTQwMzM3MDM3NjIyMzQ2NkgFWAJwAagBAQ\",\"interaction_conversion\":{\"label\":\"user_feedback_menu_interaction\",\"label_instance\":\"\",\"include_close_button_token\":false},\"survey_header\":\"この広告のどういった点が問題でしたか？\",\"back_icon_url\":\"https://googleads.g.doubleclick.net/pagead/images/mtad/back_blue.png\",\"mute_confirmation_header\":\"ご意見をお寄せいただきありがとうございます。\",\"mute_confirmation_text\":\"今後のユーザー エクスペリエンス向上のため、この広告を確認いたします。\",\"pub_feedback_confirmation_header\":\"ご意見をお寄せいただきありがとうございます。\",\"pub_feedback_confirmation_text\":\"お送りいただいたフィードバックは、このサイトの広告の確認に利用させていただきます。\",\"encoded_cookie\":\"CAASEuRov0mbkFCS973zS_sU1bRpVg\",\"close_message\":\"{\\\"msg_type\\\":\\\"ablate-me\\\",\\\"key_value\\\":[{\\\"key\\\":\\\"collapse-after-close\\\",\\\"value\\\":\\\"animate\\\"},{\\\"key\\\":\\\"secs-to-countdown\\\",\\\"value\\\":\\\"1\\\"},{\\\"key\\\":\\\"countdown\\\",\\\"value\\\":\\\"3\\\"},{\\\"key\\\":\\\"message-tick\\\",\\\"value\\\":\\\"1\\\"}],\\\"googMsgType\\\":\\\"sth\\\"}\",\"closing_countdown_text\":\"広告が閉じるまで: %1$d 秒\",\"attribution_text\":\"Ads by Google\",\"attribution_icon_url\":\"https://googleads.g.doubleclick.net/pagead/images/mtad/abg_blue.png\",\"attribution_destination_url\":\"https://www.google.com/url?ct=abg\\u0026q=https://www.google.com/adsense/support/bin/request.py%3Fcontact%3Dabg_afc%26url%3Dhttps://www.javadrive.jp/servlet/database/index10.html%26gl%3DJP%26hl%3Dja%26client%3Dca-pub-5403370376223466%26ai0%3DC6TJoak1XWrHQK8Po2ASen4LICc-nj85Pt_btvMQGjLj4y9oJEAEgrtyWJWCJk9SErBSgAb-atuQDyAECqQIDCF49wTVDPqgDAcgDyQSqBKcBT9D75Aq7-ZA0rwjjQp4g-4Tn2tqcPbuRDodut_3v-dKD3f6BlZ-L3k8rQnX5wR2Yt6tTIVofAcr8razdHITVOcv3H-pAO-uBfkqJ_2qEztr2n2W-0GtoM-x6fNgXK_gt37LkI1ksPRNKSlRp-iWU-tP3lca2eLQ_5qjlHX2OESp52siTDjxWpU-uL9Il0ikFQqJI5nz-9kURr2G2sgh2zRY6hVH7kdSgBgKAB6nlyRuoB6a-G9gHAdIIBwiAARABGAKxCZbvsEafAZf_gAoB2BMC\\u0026usg=AFQjCNH1YLq9Tpn4-nx5vVI6KMpBSr15uQ\",\"ad_feedback_icon_url\":\"https://googleads.g.doubleclick.net/pagead/images/mtad/x_blue.png\",\"is_rtl_language\":false,\"feedback_options\":[{\"text\":\"この広告の表示を停止\",\"conversion\":{\"label\":\"user_feedback_menu_option\",\"label_instance\":\"1\",\"include_close_button_token\":true},\"survey\":{\"header\":\"この広告のどういった点が問題でしたか？\",\"options\":[{\"text\":\"この広告を何回も見た\",\"conversion\":{\"label\":\"mute_survey_option\",\"label_instance\":\"2\",\"include_close_button_token\":true}},{\"text\":\"この広告に興味がない\",\"conversion\":{\"label\":\"mute_survey_option\",\"label_instance\":\"12\",\"include_close_button_token\":true}},{\"text\":\"既に購入済み\",\"conversion\":{\"label\":\"mute_survey_option\",\"label_instance\":\"11\",\"include_close_button_token\":true}},{\"text\":\"広告でコンテンツが隠れる\",\"conversion\":{\"label\":\"mute_survey_option\",\"label_instance\":\"3\",\"include_close_button_token\":true}}]},\"undo_conversion\":{\"label\":\"user_feedback_undo\",\"label_instance\":\"1\",\"include_close_button_token\":true}}],\"mute_panel_data\":{\"adchoices_icon_url\":\"https://googleads.g.doubleclick.net/pagead/images/adchoices/iconx2-000000.png\",\"adchoices_button_text\":\"AdChoices\",\"closed_message_text\":\"広告は %1$s により終了しました\",\"enable_lightbox\":false,\"google_logo_url\":\"https://www.gstatic.com/images/branding/googlelogo/2x/googlelogo_dark_color_84x28dp.png\",\"report_ad_button_text\":\"この広告の表示を停止\",\"confirmation_text\":\"今後その広告を表示しないようにします\",\"ads_by_google_icon_url\":\"https://googleads.g.doubleclick.net/pagead/images/abg/iconx2-000000.png\",\"ads_by_google_button_text\":\"Ads by Google\",\"protocol_gstatic_host\":\"https://www.gstatic.com\",\"jake_mta_context\":\"\",\"overlay_message_text\":\"Ads by %1$s\"}}},\"flags\":[{\"name\":\"jake_ui_extension\",\"value\":\"jake_default_ui\"}]},opi:false,ti:false,mob:false,il:false,eaca:false,ejar:true,eda:false};</script><script src=\"https://tpc.googlesyndication.com/pagead/js/r20180108/r20110914/abg.js\"></script></div></div>");
            out.println("<img src=\"https://tpc.googlesyndication.com/simgad/12600582998939899040\" border=\"0\" width=\"300\" alt=\"\" class=\"img_ad\">");
            out.println("<img src=\"https://tpc.googlesyndication.com/daca_images/simgad/9286483250525490702\" border=\"0\" width=\"300\" alt=\"\" class=\"img_ad\">");
            out.println("</div>");
            out.println("</div>");
            
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            //サーブレット内での例外をアプリケーションのエラーとして表示
            throw new ServletException(e);
        } finally {
            //例外が発生する・しないにかかわらず確実にデータベースから切断
            if (ps != null) {
                try {
                    ps.close();
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
