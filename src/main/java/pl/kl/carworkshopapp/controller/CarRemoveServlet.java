package pl.kl.carworkshopapp.controller;

import pl.kl.carworkshopapp.database.EntityDao;
import pl.kl.carworkshopapp.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/car/remove", name = "Remove car")
public class CarRemoveServlet extends HttpServlet {
    EntityDao<Car> carEntityDao = new EntityDao<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carIdString = request.getParameter("id");

        if (carIdString == null) {
            response.sendRedirect(request.getContextPath() + "/cars");
            return;
        }

        long carId = Long.parseLong(carIdString);

        Optional<Car> carOptional = carEntityDao.findById(carId, Car.class);

        if (carOptional.isPresent()) {
            Car car = carOptional.get();

            carEntityDao.delete(car);
        }
        response.sendRedirect(request.getContextPath() + "/cars");
    }
}
