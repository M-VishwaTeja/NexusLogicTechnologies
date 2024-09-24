<%@ page import="com.hospital.dao.PharmacyDAO, com.hospital.model.Pharmacy" %>
<%
    PharmacyDAO pharmacyDAO = new PharmacyDAO();
    List<Pharmacy> drugs = pharmacyDAO.getAllDrugs();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pharmacy Management</title>
</head>
<body>
    <h1>Manage Pharmacy</h1>
    <form action="PharmacyServlet" method="post">
        <input type="hidden" name="action" value="add">
        <label for="name">Drug Name:</label>
        <input type="text" id="name" name="name" required>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" required>
        <button type="submit">Add Drug</button>
    </form>

    <h2>Pharmacy Inventory</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Actions</th>
        </tr>
        <%
            for (Pharmacy drug : drugs) {
        %>
        <tr>
            <td><%= drug.getId() %></td>
            <td><%= drug.getName() %></td>
            <td><%= drug.getQuantity() %></td>
            <td>
                <form action="PharmacyServlet" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= drug.getId() %>">
                    <input type="hidden" name="action" value="delete">
                    <button type="submit">Delete</button>
                </form>
                <form action="PharmacyServlet" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= drug.getId() %>">
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
