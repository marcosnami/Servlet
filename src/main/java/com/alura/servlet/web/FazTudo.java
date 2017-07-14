package com.alura.servlet.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MarcosNami on 7/11/2017.
 */
@WebServlet(urlPatterns = "/fazTudo")
public class FazTudo extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tarefa = req.getParameter("tarefa");

        if (tarefa != null) {
            tarefa = "com.alura.servlet.web." + tarefa;
            try {
                Class<?> tipo = Class.forName(tarefa);
                Tarefa instance = (Tarefa) tipo.newInstance();
                String page = instance.executa(req, resp);
                RequestDispatcher dispatcher = req.getRequestDispatcher(page);
                dispatcher.forward(req, resp);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                throw new ServletException(e);
            }
        } else {
            throw new IllegalArgumentException("Voce esqueceu de passar a tarefa");
        }
    }
}
