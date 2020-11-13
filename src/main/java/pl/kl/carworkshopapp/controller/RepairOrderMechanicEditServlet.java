package pl.kl.carworkshopapp.controller;

import pl.kl.carworkshopapp.database.EntityDao;
import pl.kl.carworkshopapp.model.Mechanic;
import pl.kl.carworkshopapp.model.RepairOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/order/mechanic/edit", name = "Select mechanic to add for repair order")
public class RepairOrderMechanicEditServlet extends HttpServlet {
    private final EntityDao<RepairOrder> repairOrderEntityDao = new EntityDao<>();
    private final EntityDao<Mechanic> mechanicEntityDao = new EntityDao<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String repairOrderIdString = request.getParameter("id");

        if (repairOrderIdString == null) {
            response.sendRedirect(request.getContextPath() + "/cars");
            return;
        }

        long repairOrderId = Long.parseLong(repairOrderIdString);

        Optional<RepairOrder> repairOrderOptional = repairOrderEntityDao.findById(repairOrderId, RepairOrder.class);

        if (repairOrderOptional.isPresent()) {
            RepairOrder repairOrder = repairOrderOptional.get();

            List<Mechanic> mechanics = mechanicEntityDao.findAll(Mechanic.class);

            request.setAttribute("availableMechanics", mechanics);
            request.setAttribute("repairOrderToDisplay", repairOrder);
            request.getRequestDispatcher("/repairorder_details_form.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/cars");
        }
    }
}
