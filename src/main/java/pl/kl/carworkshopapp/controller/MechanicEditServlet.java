package pl.kl.carworkshopapp.controller;

import pl.kl.carworkshopapp.database.EntityDao;
import pl.kl.carworkshopapp.model.EmploymentLevel;
import pl.kl.carworkshopapp.model.Mechanic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns ="/mechanic/edit", name = "Edit mechanic")
public class MechanicEditServlet extends HttpServlet {
    private final EntityDao<Mechanic> mechanicEntityDao = new EntityDao<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmploymentLevel[] employmentLevels = EmploymentLevel.values();

        String mechanicIdString = request.getParameter("id");

        if (mechanicIdString == null) {
            response.sendRedirect(request.getContextPath() + "/mechanics");
            return;
        }

        long mechanicId = Long.parseLong(mechanicIdString);

        Optional<Mechanic> mechanicOptional = mechanicEntityDao.findById(mechanicId, Mechanic.class);

        if (mechanicOptional.isPresent()) {
            Mechanic mechanic = mechanicOptional.get();

            request.setAttribute("availableEmploymentLevels", employmentLevels);
            request.setAttribute("modifiedMechanic", mechanic);
            request.getRequestDispatcher("/mechanic_form.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/mechanics");
        }
    }
}
