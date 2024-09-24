package com.hospital.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.hospital.dao.PatientDAO;
import com.hospital.model.Patient;

public class PatientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String doctorId = request.getParameter("doctorId");
            String drugs = request.getParameter("prescribedDrugs");

            Patient patient = new Patient(name, Integer.parseInt(doctorId), drugs);
            PatientDAO dao = new PatientDAO();
            dao.addPatient(patient);
        }
        
        response.sendRedirect("jsp/patient.jsp");
    }
}
