package io.github.lucianodacunha.appservlet.controller.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import io.github.lucianodacunha.appservlet.dao.Database;
import io.github.lucianodacunha.appservlet.model.Machine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/listmachines")
public class ListMachinesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accept = req.getHeader("Accept");
        List<Machine> machines = new Database().list();

        if (accept.equals("json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(machines);

            resp.setContentType("application/json");
            resp.getWriter().println(json);
        } else {
            XStream xstream = new XStream();
            String xml = xstream.toXML(machines);

            resp.setContentType("application/xml");
            resp.getWriter().print(xml);
        }
    }
}
