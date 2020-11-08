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

@WebServlet(urlPatterns = "/car/form", name = "Add car")
public class CarFormServlet extends HttpServlet {
    private final EntityDao<Car> carEntityDao = new EntityDao<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EngineType[] engineTypes = EngineType.values();
        request.setAttribute("availableEngineTypes", engineTypes);
        request.getRequestDispatcher("/car_form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Car car = new Car();
        car.setName(request.getParameter("name"));
        car.setRegistrationNumber(request.getParameter("registration_number"));
        car.setEngineType(EngineType.valueOf(request.getParameter("engine_type")));
        car.setEngineCapacity(Double.parseDouble(request.getParameter("engine_capacity")));
        car.setMileage(Integer.parseInt(request.getParameter("mileage")));
        car.setVinNumber(request.getParameter("vin_number"));

        carEntityDao.saveOrUpdate(car);

        response.sendRedirect(request.getContextPath() + "/cars");
    }
}
