package com.alura.servlet.web;

import com.alura.servlet.dao.EmpresaDAO;
import com.alura.servlet.model.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * Created by MarcosNami on 7/8/2017.
 */
@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet implements Tarefa {

    public BuscaEmpresa() {
        System.out.println("Construindo uma servlet do tipo Busca Empresa");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Acessando o method doGet");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("Resultado da busca:<br/>");
        String filtro = req.getParameter("filtro");
        Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
        //req.setAttribute("empresas", empresas);
        //RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/buscaEmpresa.jsp");
        //dispatcher.forward(req, resp);

        writer.println("<ul>");
        for (Empresa empresa : empresas) {
            writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
        }
        writer.println("</ul>");
        writer.println("</body>");
        writer.println("</html>");

    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Acessando o method executa");
        String filtro = request.getParameter("filtro");
        Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
        request.setAttribute("empresas", empresas);
        return "/WEB-INF/pages/buscaEmpresa.jsp";
    }
}
