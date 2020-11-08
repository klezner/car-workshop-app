package pl.kl.carworkshopapp.controller;

import pl.kl.carworkshopapp.database.EntityDao;
import pl.kl.carworkshopapp.model.Car;
import pl.kl.carworkshopapp.model.EngineType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/car/edit", name = "Edit car")
public class CarEditServlet extends HttpServlet {
    private final EntityDao<Car> carEntityDao = new EntityDao<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EngineType[] engineTypes = EngineType.values();

        String carIdString = request.getParameter("id");

        if (carIdString == null) {
            response.sendRedirect(request.getContextPath() + "/cars");
            return;
        }

        long carId = Long.parseLong(carIdString);

        Optional<Car> carOptional = carEntityDao.findById(carId, Car.class);

        if (carOptional.isPresent()) {
            Car car = carOptional.get();

            request.setAttribute("availableEngineTypes", engineTypes);
            request.setAttribute("modifiedCar", car);
            request.getRequestDispatcher("/car_form.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/cars");
        }
    }
}
