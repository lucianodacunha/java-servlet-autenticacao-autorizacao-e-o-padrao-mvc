package io.github.lucianodacunha.appservlet.controller.filter;

import io.github.lucianodacunha.appservlet.controller.action.Command;
import io.github.lucianodacunha.appservlet.controller.action.CommandExecutor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/controller")
public class ControllerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        CommandExecutor commandExecutor = new CommandExecutor(req, resp);

        String action = req.getParameter("action");

        String fqnPrefix = "io.github.lucianodacunha.appservlet.controller.action.";
        String claz =  fqnPrefix + action;
        String result = "";

        try {
            Class<?> className = Class.forName(claz);
            result = commandExecutor.executeCommand((Command) className.newInstance());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        String[] typeAddress = result.split(":");
        if (typeAddress[0].equalsIgnoreCase("forward")){
            String jspPath = "WEB-INF/view/";
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher(jspPath + typeAddress[1]);
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(typeAddress[1]);
        }
    }
}
