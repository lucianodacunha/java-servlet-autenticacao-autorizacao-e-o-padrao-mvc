package io.github.lucianodacunha.appservlet.controller.action;

import io.github.lucianodacunha.appservlet.dao.Database;
import io.github.lucianodacunha.appservlet.model.Machine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListMachines implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Database db = new Database();
        List<Machine> machines = db.list();

        req.setAttribute("machines", machines);
        return "forward:listmachines.jsp";
    }
}
