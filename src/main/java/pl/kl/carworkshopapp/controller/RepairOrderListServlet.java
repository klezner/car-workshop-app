package pl.kl.carworkshopapp.controller;

import pl.kl.carworkshopapp.database.EntityDao;
import pl.kl.carworkshopapp.model.RepairOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/orders", name = "List repair orders")
public class RepairOrderListServlet extends HttpServlet {
    private final EntityDao<RepairOrder> repairOrderEntityDao = new EntityDao<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RepairOrder> repairOrderList = repairOrderEntityDao.findAll(RepairOrder.class);

        request.setAttribute("orders", repairOrderList);
        request.getRequestDispatcher("/repairorder_list.jsp").forward(request, response);
    }
}
