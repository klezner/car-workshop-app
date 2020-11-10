package pl.kl.carworkshopapp.controller;

import pl.kl.carworkshopapp.database.EntityDao;
import pl.kl.carworkshopapp.model.Car;
import pl.kl.carworkshopapp.model.RepairOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

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
        long carId = Long.parseLong(request.getParameter("carId"));

        Optional<Car> carOptional = carEntityDao.findById(carId, Car.class);

        if (carOptional.isPresent()) {
            Car car = carOptional.get();

            RepairOrder repairOrder = new RepairOrder();
            repairOrder.setOrderContents(request.getParameter("order_contents"));
            repairOrder.setOrderClosed(request.getParameter("order_closed") != null);
            repairOrder.setCar(car);

            repairOrderEntityDao.saveOrUpdate(repairOrder);
        }
        response.sendRedirect(request.getContextPath() + "/car/details?id=" + carId);
    }
}
