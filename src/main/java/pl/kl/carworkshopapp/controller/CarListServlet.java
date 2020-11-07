package pl.kl.carworkshopapp.controller;

import pl.kl.carworkshopapp.database.EntityDao;
import pl.kl.carworkshopapp.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/cars", name = "List cars")
public class CarListServlet extends HttpServlet {
    private final EntityDao<Car> carEntityDao = new EntityDao<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> carList = carEntityDao.findAll(Car.class);

        request.setAttribute("cars", carList);
        request.getRequestDispatcher("/car_list.jsp").forward(request, response);
    }
}
