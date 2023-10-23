package io.github.lucianodacunha.appservlet.controller.action;

import io.github.lucianodacunha.appservlet.dao.Database;
import io.github.lucianodacunha.appservlet.model.Machine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteMachine implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Database db = new Database();
        Machine machine = db.findById(id);
        db.remove(machine);

        return "redirect:controller?action=ListMachines";
    }
}
