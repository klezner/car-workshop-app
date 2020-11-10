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

@WebServlet(urlPatterns = "/order/edit", name = "Edit repair order")
public class RepairOrderEditServlet extends HttpServlet {
    private final EntityDao<RepairOrder> repairOrderEntityDao = new EntityDao<>();

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

            request.setAttribute("carId", repairOrder.getCar().getId());
            request.setAttribute("modifiedRepairOrder", repairOrder);
            request.getRequestDispatcher("/repairorder_form.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/cars");
        }
    }
}
