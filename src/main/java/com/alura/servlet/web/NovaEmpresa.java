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

/**
 * Created by MarcosNami on 7/8/2017.
 */
@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa extends HttpServlet implements Tarefa {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Acessando o method doPost");
        String nome = req.getParameter("nome");
        Empresa empresa = new Empresa(nome);
        new EmpresaDAO().adiciona(empresa);
        //System.out.println(empresa);
        req.setAttribute("empresa", empresa);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/pages/novaEmpresa.jsp");
        requestDispatcher.forward(req, resp);

        //Get Request
        //GET /gerenciador/novaEmpresa?nome=Facebook HTTP/1.1
        //Host: localhost:8080

        //Post Request
        //POST /gerenciador/novaEmpresa HTTP/1.1
        //Host: localhost:8080
        //nome=Facebook

    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Acessando o method executa");
        String nome = request.getParameter("nome");
        Empresa empresa = new Empresa(nome);
        new EmpresaDAO().adiciona(empresa);
        request.setAttribute("empresa", empresa);
        return "WEB-INF/pages/novaEmpresa.jsp";
    }
}
