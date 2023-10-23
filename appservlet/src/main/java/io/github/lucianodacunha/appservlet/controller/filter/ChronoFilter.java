package io.github.lucianodacunha.appservlet.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/controller")
public class ChronoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse resp,
                         FilterChain chain) throws
            IOException, ServletException {

        System.out.println("ChronoFilter");

        long inicio = System.currentTimeMillis();

        chain.doFilter(req, resp);


        long fim = System.currentTimeMillis();

        System.out.println("tempo gasto para a ação " +
                req.getParameter("action") + ": " + (fim - inicio));
    }
}
