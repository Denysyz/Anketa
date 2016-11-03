package dinis.demidenko;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    String result = "";
    String resultNull = "";
    int k;
    int t = 0;
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        DataBase d = new DataBase();
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String surname = request.getParameter("surname");
        String radio = request.getParameter("radio");
        String[] check = request.getParameterValues("check[]");
        String film = request.getParameter("film");
        String[] music = request.getParameterValues("music[]");
        String coment = request.getParameter("coment");
        String resultSave = "";
        String[] arrName = {name, surname};
        String[] arrEvaluation  = {radio};
        String[] arrFreeTime = check;
        String[] arrFilm = {film};
        String[] arrMusic = music;
        String[] arrComent = {coment};
        String[][] arrResul = {arrName, arrEvaluation, arrFreeTime, arrFilm, arrMusic, arrComent};
        k = 0;                                             // якщо к = 0 то всі поля заповнені
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //блок генерує html коли не всі данні
        if(name.equals("") | surname.equals("")){
            resultNull =  "<!DOCTYPE html><html><head><link href=\"styles.css\" type=\"text/css\""
                    + " rel=\"stylesheet\"><meta charset = \"UTF-8\"><title>Результат</title></head>"
                    + "<body><p id=\"resNull\" class=\"res\">Введено не всі данні</p><div id=\"ssilkaRes\"><a"
                    + " href=\"index.html\"><p id=\"ssi\">Назад</p></a></div>";
            k = 1;
        }else{
            resultSave = resultSave + arrResul[0][1] + " " + arrResul[0][0] + ", вік - " + age + ", У вільний час: ";
            if( arrResul[2] == null){
                resultSave = resultSave + "інформація відсутня";
            }else{
                for (int i = 0; i < arrResul[2].length; i++) {
                    resultSave = resultSave + arrResul[2][i];
                    if(i < arrResul[2].length - 1){
                        resultSave = resultSave + " ";
                    }
                }
            }
            resultSave = resultSave + ", Улюблені фільми - " + arrResul[3][0] + ", Улюблена музика: ";
            if( arrResul[4] == null){
                resultSave = resultSave + "інформація відсутня";
            }else{
                for (int i = 0; i < arrResul[4].length; i++) {
                    resultSave = resultSave + arrResul[4][i];
                    if(i < arrResul[4].length - 1){
                        resultSave = resultSave + " ";
                    }
                }
            }
            resultSave = resultSave + ", Коментар: " + arrResul[5][0] + ".";
        }
        if( k == 0){
            d.addBD("insert into date values('" + resultSave + "');"); //дописуєм у базу
        }
        //блок генерує html при повному заповненні
        if( age.equals("")){
            age = "інформація відсутня";
        }
        result = "<!DOCTYPE html><html><head><link href=\"styles.css\" type=\"text/css\""
                + " rel=\"stylesheet\"><meta charset = \"UTF-8\"><title>Результат</title></head>"
                + "<body><div id=\"resMain\"><p class=\"res\">" + surname + " " +  name + "</p><p class=\"res\">"
                + "Вік - " + age + "</p><div class=\"res\"><p>У вільний час:</p>";
        if( check == null){
            result = result + "<p>Інформація відсутня</p></div>";
        }else{
            for (String string : check) {
                result = result + "<p>" + string + "</p>";
            }
            result = result + "</div>";
        }
        result = result + "<div class=\"res\"><p>Улюблені фільми:</p><p>" + film + "</p></div><div class=\"res\">"
                + "<p>Улюблена музика</p>";
        if( music == null){
            result = result + "<p>Інформація відсутня</p></div>";
        }else{
            for (String string : music) {
                result = result + "<p>" + string + "</p>";
            }
            result = result + "</div>";
        }
        result = result + "<div class=\"res\"><p>Коментар:</p><p id=\"comentRes\">" + coment + "</p></div>"
                + "<div id=\"ssilkaRes\"><a"
                + " href=\"index.html\"><p id=\"ssi\">Назад</p></a></div>";
        if(k == 1){
            pw.println(resultNull);
            System.out.println(resultNull);
        }else{
            pw.println(result);
            System.out.println(resultSave);
        }
    }
}
