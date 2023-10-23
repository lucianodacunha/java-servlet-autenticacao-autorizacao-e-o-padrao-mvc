package io.github.lucianodacunha.appservlet.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandExecutor {

    private HttpServletRequest req;
    private HttpServletResponse resp;

    public CommandExecutor(HttpServletRequest req, HttpServletResponse resp){
        this.req = req;
        this.resp = resp;
    }

    public String executeCommand(Command command) throws ServletException, IOException {
        return command.execute(this.req, this.resp);
    }
}
