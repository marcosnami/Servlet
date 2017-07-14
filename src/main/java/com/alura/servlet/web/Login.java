package com.alura.servlet.web;

import com.alura.servlet.dao.UsuarioDAO;
import com.alura.servlet.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by MarcosNami on 7/8/2017.
 */
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet implements Tarefa {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

        if (usuario == null) {
            writer.println("<html><body>Usuário ou senha inválida</body></html>");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("usuarioLogado", usuario);
            //Cookie cookie = new Cookie("usuario.logado", email);
            //cookie.setMaxAge(60 * 10);
            //resp.addCookie(cookie);
            writer.println("<html><body>Usuário logado: " + email
                    + "</body></html>");
        }

    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

        String page = "WEB-INF/index.jsp";
        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", usuario);
            request.setAttribute("usuario", usuario);
            //Cookie cookie = new Cookie("usuario.logado", email);
            //cookie.setMaxAge(60 * 10);
            //resp.addCookie(cookie);
            page = "WEB-INF/pages/login.jsp";
        }
        return page;
    }
}
