<%@ page import="com.hospital.dao.AppointmentDAO, com.hospital.model.Appointment" %>
<%
    AppointmentDAO appointmentDAO = new AppointmentDAO();
    List<Appointment> appointments = appointmentDAO.getAllAppointments();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Appointment Management</title>
</head>
<body>
    <h1>Manage Appointments</h1>
    <form action="AppointmentServlet" method="post">
        <input type="hidden" name="action" value="add">
        <label for="patientId">Patient ID:</label>
        <input type="number" id="patientId" name="patientId" required>
        <label for="doctorId">Doctor ID:</label>
        <input type="number" id="doctorId" name="doctorId" required>
        <label for="appointmentDate">Date:</label>
        <input type="date" id="appointmentDate" name="appointmentDate" required>
        <label for="appointmentTime">Time:</label>
        <input type="time" id="appointmentTime" name="appointmentTime" required>
        <label for="status">Status:</label>
        <input type="text" id="status" name="status" required>
        <button type="submit">Add Appointment</button>
    </form>

    <h2>Existing Appointments</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Patient ID</th>
            <th>Doctor ID</th>
            <th>Date</th>
            <th>Time</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        <%
            for (Appointment appointment : appointments) {
        %>
        <tr>
            <td><%= appointment.getId() %></td>
            <td><%= appointment.getPatientId() %></td>
            <td><%= appointment.getDoctorId() %></td>
            <td><%= appointment.getAppointmentDate() %></td>
            <td><%= appointment.getAppointmentTime() %></td>
            <td><%= appointment.getStatus() %></td>
            <td>
                <form action="AppointmentServlet" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= appointment.getId() %>">
                    <input type="hidden" name="action" value="delete">
                    <button type="submit">Delete</button>
                </form>
                <form action="AppointmentServlet" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= appointment.getId() %>">
                    <input type="hidden" name="action" value="update">
                    <button type="submit">Update</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
