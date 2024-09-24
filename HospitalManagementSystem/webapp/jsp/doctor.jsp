<%@ page import="com.hospital.dao.DoctorDAO, com.hospital.model.Doctor" %>
<%
    DoctorDAO doctorDAO = new DoctorDAO();
    List<Doctor> doctors = doctorDAO.getAllDoctors();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Management</title>
</head>
<body>
    <h1>Manage Doctors</h1>
    <form action="DoctorServlet" method="post">
        <input type="hidden" name="action" value="add">
        <label for="name">Doctor Name:</label>
        <input type="text" id="name" name="name" required>
        <label for="specialization">Specialization:</label>
        <input type="text" id="specialization" name="specialization" required>
        <button type="submit">Add Doctor</button>
    </form>

    <h2>Existing Doctors</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Specialization</th>
            <th>Actions</th>
        </tr>
        <%
            for (Doctor doctor : doctors) {
        %>
        <tr>
            <td><%= doctor.getId() %></td>
            <td><%= doctor.getName() %></td>
            <td><%= doctor.getSpecialization() %></td>
            <td>
                <form action="DoctorServlet" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= doctor.getId() %>">
                    <input type="hidden" name="action" value="delete">
                    <button type="submit">Delete</button>
                </form>
                <form action="DoctorServlet" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= doctor.getId() %>">
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


<!-- <%@ page import="com.hospital.model.Doctor, com.hospital.dao.DoctorDAO" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Management</title>
</head>
<body>
    <h1>Doctor Management</h1>
    <form action="DoctorServlet" method="post">
        <input type="hidden" name="action" value="add">
        Name: <input type="text" name="name"><br>
        Specialization: <input type="text" name="specialization"><br>
        Contact: <input type="text" name="contact"><br>
        <button type="submit">Add Doctor</button>
    </form>

    <h2>Doctors List</h2>
    <%
        DoctorDAO dao = new DoctorDAO();
        for(Doctor doc : dao.getAllDoctors()) {
            out.print("<p>" + doc.getName() + " - " + doc.getSpecialization() + "</p>");
        }
    %>
</body>
</html> -->
