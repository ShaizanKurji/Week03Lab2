/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 715060
 */
public class CalculatorServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorMsg = "";
        String firstInput = request.getParameter("first");
        String secondInput = request.getParameter("second");

        if (firstInput.equals("") || secondInput.equals("")) {
            errorMsg = "Please fill in all boxes";
            request.setAttribute("errorMsg", errorMsg);
            getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
            return;
        }

        try {
            int result = 0;
            int first = Integer.parseInt(request.getParameter("first"));
            int second = Integer.parseInt(request.getParameter("second"));
            char operationType = request.getParameter("operation").charAt(0);

            switch (operationType) {
                case '+':
                    result = first + second;
                    break;
                case '-':
                    result = first - second;
                    break;
                case '*':
                    result = first * second;
                    break;
                case '%':
                    result = first % second;
                    break;
            }

            request.setAttribute("first", first);
            request.setAttribute("second", second);
            request.setAttribute("result", result);
            getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);

        } catch (NumberFormatException nfe) {
            errorMsg = "Please input only numbers";
            request.setAttribute("errorMsg", errorMsg);
            getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
        }

    }
}
