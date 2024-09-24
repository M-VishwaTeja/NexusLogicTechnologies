<%@ page import="com.hospital.dao.PatientDAO, com.hospital.model.Patient" %>
<%
    PatientDAO patientDAO = new PatientDAO();
    List<Patient> patients = patientDAO.getAllPatients();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Management</title>
</head>
<body>
    <h1>Manage Patients</h1>
    <form action="PatientServlet" method="post">
        <input type="hidden" name="action" value="add">
        <label for="name">Patient Name:</label>
        <input type="text" id="name" name="name" required>
        <label for="doctorId">Doctor ID:</label>
        <input type="number" id="doctorId" name="doctorId" required>
        <label for="prescribedDrugs">Prescribed Drugs:</label>
        <input type="text" id="prescribedDrugs" name="prescribedDrugs" required>
        <button type="submit">Add Patient</button>
    </form>

    <h2>Existing Patients</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Doctor ID</th>
            <th>Prescribed Drugs</th>
            <th>Actions</th>
        </tr>
        <%
            for (Patient patient : patients) {
        %>
        <tr>
            <td><%= patient.getId() %></td>
            <td><%= patient.getName() %></td>
            <td><%= patient.getDoctorId() %></td>
            <td><%= patient.getPrescribedDrugs() %></td>
            <td>
                <form action="PatientServlet" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= patient.getId() %>">
                    <input type="hidden" name="action" value="delete">
                    <button type="submit">Delete</button>
                </form>
                <form action="PatientServlet" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= patient.getId() %>">
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
