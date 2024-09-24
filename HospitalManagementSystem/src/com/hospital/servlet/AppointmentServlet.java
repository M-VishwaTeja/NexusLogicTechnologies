package com.hospital.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.hospital.dao.AppointmentDAO;
import com.hospital.model.Appointment;

public class AppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String patientId = request.getParameter("patientId");
            String doctorId = request.getParameter("doctorId");
            String date = request.getParameter("appointmentDate");
            String time = request.getParameter("appointmentTime");
            String status = request.getParameter("status");

            Appointment appointment = new Appointment(Integer.parseInt(patientId), Integer.parseInt(doctorId), date, time, status);
            AppointmentDAO dao = new AppointmentDAO();
            dao.addAppointment(appointment);
        }
        
        response.sendRedirect("jsp/appointment.jsp");
    }
}
