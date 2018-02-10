package com.sablin.j2ee.service;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalcServlet", urlPatterns = {"/calculator"})
public class CalcServlet extends HttpServlet {

    @Inject
    CalculatorBean calc;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String p_v1 = request.getParameter("v1");
        String p_v2 = request.getParameter("v2");
        String p_operator = request.getParameter("operator");

        if (p_v1 == null || p_v2 == null || p_operator == null) {
            System.out.println("Go to calc");
            request.setAttribute("operations", calc.getListOperations());
            getServletContext().getRequestDispatcher("/mycalc.jsp").forward(request, response);
        } else {

            double v1 = Double.parseDouble(p_v1);
            double v2 = Double.parseDouble(p_v2);

            double answer = calc.calculate(v1, v2, p_operator);

            calc.saveToLog(p_v1, p_v2, p_operator, String.valueOf(answer) );


            request.setAttribute("res", answer);
            request.setAttribute("last_v1", p_v1);
            request.setAttribute("last_v2", p_v2);
            request.setAttribute("last_operator", p_operator);
            request.setAttribute("operations", calc.getListOperations());
            getServletContext().getRequestDispatcher("/mycalc.jsp").forward(request, response);

        }
   }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
