package com.alura.servlet.utils;

import javax.servlet.http.Cookie;

/**
 * Created by MarcosNami on 7/8/2017.
 */
public class Cookies {

    private Cookie[] cookies;

    public Cookies(Cookie[] cookies) {
        this.cookies = cookies;
    }

    public Cookie getUsuarioLogado() {

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usuario.logado")) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
