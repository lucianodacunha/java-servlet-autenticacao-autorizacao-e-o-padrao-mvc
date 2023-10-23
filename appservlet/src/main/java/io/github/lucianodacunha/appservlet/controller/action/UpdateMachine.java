package io.github.lucianodacunha.appservlet.controller.action;

import io.github.lucianodacunha.appservlet.dao.Database;
import io.github.lucianodacunha.appservlet.model.Machine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateMachine implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getMethod().equalsIgnoreCase("POST")) {
            Long id = Long.valueOf(req.getParameter("id"));
            String type = req.getParameter("type");
            String model = req.getParameter("model");
            Integer year = Integer.valueOf(req.getParameter("year"));

            Database db = new Database();
            Machine machine = db.findById(id);
            machine.setType(type);
            machine.setModel(model);
            machine.setYear(year);

            return "redirect:controller?action=ListMachines";
        }

        Long id = Long.valueOf(req.getParameter("id"));
        Database db = new Database();
        Machine machine = db.findById(id);
        req.setAttribute("machine", machine);
        return "forward:form.jsp";

    }
}
