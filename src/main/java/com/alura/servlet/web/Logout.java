package com.alura.servlet.web;

import com.alura.servlet.utils.Cookies;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by MarcosNami on 7/8/2017.
 */
@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet implements Tarefa {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Acessando o method doPost");
        HttpSession session = req.getSession();
        //session.invalidate();
        session.removeAttribute("usuarioLogado");


        /*Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();

        if (cookie != null) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }*/

        //PrintWriter writer = resp.getWriter();
        //writer.println("<html><body>Logout efetuado</body></html>");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/logout.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Acessando o method executa");
        HttpSession session = request.getSession();
        session.removeAttribute("usuarioLogado");
        return "/WEB-INF/pages/logout.jsp";
    }
}
