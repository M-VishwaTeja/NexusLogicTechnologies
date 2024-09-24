package com.hospital.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.hospital.model.Doctor;
import com.hospital.dao.DoctorDAO;

public class DoctorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String specialization = request.getParameter("specialization");
            String contact = request.getParameter("contact");

            Doctor doctor = new Doctor(name, specialization, contact);
            DoctorDAO dao = new DoctorDAO();
            dao.addDoctor(doctor);
        }
        
        response.sendRedirect("jsp/doctor.jsp");
    }
}
