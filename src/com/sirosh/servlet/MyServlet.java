package com.sirosh.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Illya on 19.01.17.
 */
public class MyServlet extends HttpServlet {

    public MyServlet(){



    }


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        enterForm(resp);


    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException{

        if (UserDB.getInstance().isCorrect(req.getParameter("login"),req.getParameter("pass"))){

            accessAllowedForm(resp);

        }else{

            accessDeniedForm(resp);

        }

    }



    private void enterForm(HttpServletResponse resp)throws IOException {


        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        try {

            out.println("<html>");

            out.println("<head>");

            out.println("<title>Перший сервлет</title>");

            out.println("</head>");

            out.println("<body>");

            out.println("<form action='/MyServlet' method='post'>");

            out.println("Login:<input type='text' name='login'><br>");
            out.println("Password:<input type='password' name='pass'><br>");
            out.println("<input type='submit' value='Enter'>");
            out.println("</form>");

            out.println("</body>");

            out.println("</html>");



        } finally {

            out.close();

        }

    }


    private void accessAllowedForm(HttpServletResponse resp)throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        try {

            out.println("<html>");

            out.println("<head>");

            out.println("<title>Перший сервлет</title>");

            out.println("</head>");

            out.println("<body>");

            out.println("<h1>Доступ дозволено</h1>");

            out.println("</body>");

            out.println("</html>");



        } finally {

            out.close();

        }


    }

    private void accessDeniedForm(HttpServletResponse resp)throws IOException {

       // resp.sendError(403);

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        try {

            out.println("<html>");

            out.println("<head>");

            out.println("<title>Перший сервлет</title>");

            out.println("</head>");

            out.println("<body>");

            out.println("<h1> Error 403. Доступ заборонено</h1>");
            out.println("<form action='/MyServlet' method='get'>");

            out.println("<input type='submit' value='Enter'>");
            out.println("</form>");

            out.println("</body>");

            out.println("</html>");



        } finally {

            out.close();

        }


    }
}
