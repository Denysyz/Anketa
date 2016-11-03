package dinis.demidenko;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dende on 23.10.2016.
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Work w = new Work();
        DataBase d = new DataBase();
        String[] ar = null;
        File file = new File("C:\\Users\\dende\\Desktop\\text.txt");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        pw.print(d.printRes(d.uploadBD("SELECT * FROM date")));
        //pw.print(w.saveInAraay(file, ar));
        System.out.println(w.saveInAraay(file, ar));
    }
}
