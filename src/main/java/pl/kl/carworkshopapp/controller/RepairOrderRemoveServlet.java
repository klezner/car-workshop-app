package pl.kl.carworkshopapp.controller;

import pl.kl.carworkshopapp.database.EntityDao;
import pl.kl.carworkshopapp.model.RepairOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/order/remove", name = "Remove order")
public class RepairOrderRemoveServlet extends HttpServlet {
    private final EntityDao<RepairOrder> repairOrderEntityDao = new EntityDao<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String repairOrderIdString = request.getParameter("id");

        long repairOrderId = Long.parseLong(repairOrderIdString);

        Long carId = null;

        Optional<RepairOrder> repairOrderOptional = repairOrderEntityDao.findById(repairOrderId, RepairOrder.class);

        if (repairOrderOptional.isPresent()) {
            RepairOrder repairOrder = repairOrderOptional.get();

            carId = repairOrder.getCar().getId();

            repairOrderEntityDao.delete(repairOrder);
        }

        if (carId != null) {
            response.sendRedirect(request.getContextPath() + "/car/details?id=" + carId);
        } else {
            response.sendRedirect(request.getContextPath() + "/cars");
        }
    }
}
