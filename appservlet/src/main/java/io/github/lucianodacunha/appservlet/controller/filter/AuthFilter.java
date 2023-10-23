package io.github.lucianodacunha.appservlet.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/controller")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("AuthFilter");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String action = req.getParameter("action");

        HttpSession session = req.getSession();
        boolean userLogin = (session.getAttribute("userLogin") == null);
        boolean isActionProtected = !(action.equals("Login") || action.equals("LoginForm"));

        if (userLogin && isActionProtected){
            resp.sendRedirect("controller?action=LoginForm");
            return;
        }

        filterChain.doFilter(req, resp);

    }
}
