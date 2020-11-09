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
import java.time.LocalDate;

@WebServlet(urlPatterns = "/mechanic/form", name = "Add mechanic")
public class MechanicFormServlet extends HttpServlet {
    private final EntityDao<Mechanic> mechanicEntityDao = new EntityDao<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmploymentLevel[] employmentLevels = EmploymentLevel.values();
        request.setAttribute("availableEmploymentLevels", employmentLevels);
        request.getRequestDispatcher("/mechanic_form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String modifiedMechanicIdString = request.getParameter("modifiedMechanicId");
        Long modifiedMechanicId = null;

        if (modifiedMechanicIdString != null && !modifiedMechanicIdString.isEmpty()) {
            modifiedMechanicId = Long.parseLong(modifiedMechanicIdString);
        }

        Mechanic mechanic = new Mechanic();
        mechanic.setId(modifiedMechanicId);
        mechanic.setFirstName(request.getParameter("first_name"));
        mechanic.setLastName(request.getParameter("last_name"));
        mechanic.setBirthDate(LocalDate.parse(request.getParameter("birth_date")));
        mechanic.setEmploymentLevel(EmploymentLevel.valueOf(request.getParameter("employment_level")));
        mechanic.setSalary(Integer.parseInt(request.getParameter("salary")));

        mechanicEntityDao.saveOrUpdate(mechanic);

        response.sendRedirect(request.getContextPath() + "/mechanics");
    }
}
