package io.github.lucianodacunha.appservlet.controller.action;

import io.github.lucianodacunha.appservlet.dao.Database;
import io.github.lucianodacunha.appservlet.model.Machine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateMachine implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String type = req.getParameter("type");
        String model = req.getParameter("model");
        Integer year = Integer.valueOf(req.getParameter("year"));

        Machine machine = new Machine(type, model, year);
        Database db = new Database();
        db.add(machine);

        return "redirect:controller?action=ListMachines";
    }
}
