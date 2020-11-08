package pl.kl.carworkshopapp.controller;

import pl.kl.carworkshopapp.database.EntityDao;
import pl.kl.carworkshopapp.model.Mechanic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/mechanics", name = "List mechanics")
public class MechanicListServlet extends HttpServlet {
    private final EntityDao<Mechanic> mechanicEntityDao = new EntityDao<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Mechanic> mechanicList = mechanicEntityDao.findAll(Mechanic.class);

        request.setAttribute("mechanics", mechanicList);
        request.getRequestDispatcher("/mechanic_list.jsp").forward(request, response);
    }
}
