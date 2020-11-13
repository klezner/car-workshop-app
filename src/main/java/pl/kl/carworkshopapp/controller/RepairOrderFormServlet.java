package pl.kl.carworkshopapp.controller;

import pl.kl.carworkshopapp.database.EntityDao;
import pl.kl.carworkshopapp.model.Car;
import pl.kl.carworkshopapp.model.Mechanic;
import pl.kl.carworkshopapp.model.RepairOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@WebServlet(urlPatterns = "/order/form", name = "Add repair order")
public class RepairOrderFormServlet extends HttpServlet {
    private final EntityDao<Car> carEntityDao = new EntityDao<>();
    private final EntityDao<RepairOrder> repairOrderEntityDao = new EntityDao<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carIdString = request.getParameter("carId");

        if (carIdString == null) {
            response.sendRedirect(request.getContextPath() + "/cars");
            return;
        }

        long carId = Long.parseLong(carIdString);

        Optional<Car> carOptional = carEntityDao.findById(carId, Car.class);

        if (carOptional.isPresent()) {
            request.setAttribute("carId", carId);
            request.getRequestDispatcher("/repairorder_form.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/cars");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String modifiedRepairOrderIdString = request.getParameter("modifiedRepairOrderId");
        Long modifiedRepairOrderId = null;

        if (modifiedRepairOrderIdString != null && !modifiedRepairOrderIdString.isEmpty()) {
            modifiedRepairOrderId = Long.parseLong(modifiedRepairOrderIdString);
        }

        long carId = Long.parseLong(request.getParameter("carId"));

        Optional<Car> carOptional = carEntityDao.findById(carId, Car.class);

        if (carOptional.isPresent()) {
            Car car = carOptional.get();

            RepairOrder repairOrder = new RepairOrder();
            repairOrder.setOrderContents(request.getParameter("order_contents"));
            repairOrder.setOrderClosed(request.getParameter("order_closed") != null);

            if (modifiedRepairOrderId != null) {
                repairOrder.setId(modifiedRepairOrderId);
                repairOrder.setCreationDate(LocalDateTime.parse(request.getParameter("modifiedRepairOrderCreationDate")));

                if (("on").equals(request.getParameter("order_closed"))) {
                    repairOrder.setClosingDate(LocalDateTime.now());
                } else {
                    repairOrder.setClosingDate(null);
                }

                Optional<RepairOrder> modifiedRepairOrderOptional = repairOrderEntityDao.findById(modifiedRepairOrderId, RepairOrder.class);

                if (modifiedRepairOrderOptional.isPresent()) {
                    repairOrder.setMechanicSet(modifiedRepairOrderOptional.get().getMechanicSet());
                } else {
                    repairOrder.setMechanicSet(null);
                }
            }
            repairOrder.setCar(car);

            repairOrderEntityDao.saveOrUpdate(repairOrder);
        }
        response.sendRedirect(request.getContextPath() + "/car/details?id=" + carId);
    }
}
