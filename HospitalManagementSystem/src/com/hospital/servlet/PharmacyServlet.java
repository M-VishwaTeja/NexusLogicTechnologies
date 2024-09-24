package com.hospital.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.hospital.dao.PharmacyDAO;
import com.hospital.model.Pharmacy;

public class PharmacyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String drugName = request.getParameter("drugName");
            String quantity = request.getParameter("quantity");

            Pharmacy pharmacy = new Pharmacy(drugName, Integer.parseInt(quantity));
            PharmacyDAO dao = new PharmacyDAO();
            dao.addDrug(pharmacy);
        }
        
        response.sendRedirect("jsp/pharmacy.jsp");
    }
}
