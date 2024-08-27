Project - 2: Inventory Management System with JDBC

Project Overview:

The goal is to create a functional Inventory Management System that allows users to manage products, track inventory levels, and perform basic CRUD (Create, Read, Update, Delete) operations using a MySQL database. This project will help reinforce your understanding of JDBC concepts and database interactions in a real-world scenario.

Project Details:

Inventory Management System Requirements:

1. Product Management:

 - Create: Add new products to the inventory.
  - Update: Allow modification of product details such as price, and quantity of a product when sold or update it when new stock arrives.
 - Delete: Remove products from the inventory.

2. Inventory Tracking:

  - Display details of all products in the inventory.
  - Display the details of a specific product.

3. Database Connectivity:

  - Use JDBC to connect to a MySQL database.
  - Design the database schema to store product information.

4. User Interface (Optional):

  - While the primary focus is on backend development, you have the option to create a simple User Interface using either a Command-Line Interface (CLI) or a web application using JSP and Servlets for users to interact with the application.

Compile :

javac -cp lib/mysql-connector-java-8.2.0.jar src/*.java -d bin

After compiling all the class files will be created in bin folder.

Run : 

java -cp "bin:lib/mysql-connector-java-8.2.0.jar" Main
