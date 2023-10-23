package io.github.lucianodacunha.appservlet.controller.action;

import io.github.lucianodacunha.appservlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Command{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(login, password);

        if (user.getPassword().equals("1234")) {
            HttpSession session = req.getSession();
            session.setAttribute("userLogin", user);
            return "forward:menu.jsp";
        }
        HttpSession session = req.getSession();
        session.setAttribute("loginError", true);
        return "redirect:controller?action=FormLogin";
    }
}
