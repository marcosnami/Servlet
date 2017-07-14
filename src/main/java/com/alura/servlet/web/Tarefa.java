package com.alura.servlet.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by MarcosNami on 7/11/2017.
 */
public interface Tarefa {
    String executa(HttpServletRequest request, HttpServletResponse response);
}
