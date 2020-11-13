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
import java.util.Set;

@WebServlet(urlPatterns = "/order/mechanic/form", name = "Add mechanic for repair order")
public class RepairOrderMechanicFormServlet extends HttpServlet {
    private final EntityDao<RepairOrder> repairOrderEntityDao = new EntityDao<>();
    private final EntityDao<Mechanic> mechanicEntityDao = new EntityDao<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String repairOrderIdString = request.getParameter("repairOrderId");
        Long repairOrderId = null;

        if (repairOrderIdString != null && !repairOrderIdString.isEmpty()) {
            repairOrderId = Long.parseLong(repairOrderIdString);
        }

        long carId = Long.parseLong(request.getParameter("carId"));

        String mechanicIdString = request.getParameter("mechanicId");

        if (mechanicIdString == null) {
            response.sendRedirect(request.getContextPath() + "/car/details?id=" + carId);
            return;
        }

        long mechanicId = Long.parseLong(mechanicIdString);

        Optional<RepairOrder> repairOrderOptional = repairOrderEntityDao.findById(repairOrderId, RepairOrder.class);

        Optional<Mechanic> mechanicOptional = mechanicEntityDao.findById(mechanicId, Mechanic.class);

        if (repairOrderOptional.isPresent() && mechanicOptional.isPresent()) {
            Mechanic mechanic = mechanicOptional.get();

            RepairOrder repairOrder = repairOrderOptional.get();

            repairOrder.addMechanic(mechanic);

            repairOrderEntityDao.saveOrUpdate(repairOrder);

            response.sendRedirect(request.getContextPath() + "/orders");
        }
    }
}
