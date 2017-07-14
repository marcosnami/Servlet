package com.alura.servlet.web;

import com.alura.servlet.model.Usuario;
import com.alura.servlet.utils.Cookies;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by MarcosNami on 7/8/2017.
 */
@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String usuario = getUsuario(request);

        System.out.println("Usuario " + usuario + " acessando a URI " + request.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }

    private String getUsuario(HttpServletRequest req) {

        String usuario = "<deslogado>";
        HttpSession session = req.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        //Cookie[] cookies = req.getCookies();
        //Cookie cookie = new Cookies(cookies).getUsuarioLogado();

        if (usuarioLogado != null) {
            usuario = usuarioLogado.getEmail();
        }

        return usuario;
    }
}
