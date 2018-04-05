package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public final class Hello
        extends HttpServlet {
    public Hello() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>test mysql connect</title>");
        writer.println("</head>");
        writer.println("<body bgcolor=white>");

        writer.println("<table border=\"0\">");
        writer.println("<tr>");
        writer.println("<td>");
        writer.println("</td>");
        writer.println("<td>");
        writer.println("<h1>db test</h1>");
        writer.println("list some data");
        writer.println("<a href=\"index.html\">back</a>");
        writer.println("</td>");
        writer.println("</tr>");
        writer.println("</table>");


        this.dbtest(writer);

        writer.println("</body>");
        writer.println("</html>");
    }


    public void dbtest(PrintWriter writer) {
        String url = "jdbc:mysql://192.168.1.115/test";
        String name = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "888888";

        String sql = "select * from users";

        Connection conn = null;
        PreparedStatement pst = null;

        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement(sql);
            ResultSet ret = pst.executeQuery();
            while (ret.next()) {
                String uid = ret.getString(1);
                String ufname = ret.getString(2);
//                System.out.println(uid + "\t" + ufname + "\t" );
                writer.println(ufname + "<br>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

