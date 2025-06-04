package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bo.BOFactory;
import org.example.bo.custom.CustomerBO;
import org.example.dto.CustomerDto;
import org.example.entity.Customer;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBo(BOFactory.getBoType.CUSTOMER);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<CustomerDto> allDetails = customerBO.getAllDetails();

        //SEND TO THE CLIENT
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), allDetails);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        CustomerDto customer = mapper.readValue(req.getInputStream(), CustomerDto.class);

        boolean b = customerBO.saveCustomer(customer);
        resp.getWriter().print(b);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
