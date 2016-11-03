package dinis.demidenko;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataBase d = new DataBase();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        pw.print(d.printRes(d.uploadBD("SELECT * FROM date")));
    }
}
