# AAD-Assignment-Pos-System-Backend

The POS System Backend is an API that supports the frontend operations of a Point of Sale system. This backend service manages customer, order, and inventory data, providing essential functionalities.

## Table of Contents

- [Features](#Features)
- [Technologies](#Technologies)
- [installation](#installation)
- [API Documentation]
- [License](#license)


## Features
- Manage customer and items records
- Monitoring orders and track inventory
- Update item quantities
- Apply discounts and calculate totals

##  Technologies
 - Backend Framework: Java EE
 - Database: MySQL
 - Build Tool: Maven
 - Application Server: Apache Tomcat 10
 - JDK: OpenJDK 17
 - Communication: AJAX

## installation
 
### Prerequisites

- Java 17 (OpenJDK 17)
- Maven
- MySQL
- Apache Tomcat 10

### Steps

1. **Clone the repository**

git clone https://github.com/duranginethmini/AAD-Assignment-POS-BackEnd.git


2. **Configure the database**

- create a MYSQL database
- Update the .xml file with your credentials.

3. **Build the project**

mvn clean install

4. **Deploy to Tomcat**

- Ensure Tomcat is installed and running.
- Copy the generated WAR file from the `target` directory to the Tomcat `webapps` directory.
- Restart Tomcat.

## API Documentation

For detailed API documentation, please refer to the project’s Swagger UI available.
- [Customer API documentation](https://documenter.getpostman.com/view/35948713/2sA3s1psjK)
- [Item API documentation](https://documenter.getpostman.com/view/35948713/2sA3s1psok)
- [Order API documentation](https://documenter.getpostman.com/view/35948713/2sA3s3FqDj)


## API Endpoints

Here is a brief overview of the available API endpoints:

### 1. Customer

Customers Endpoints:

- POST /customer: Create a new customer record. Needs a JSON object with customer information. Returns the newly created customer object.

- GET /customer/{custId}: Fetches the details of a specific customer using their ID. Returns the customer object.

- PUT /customer/{custId}: Updates the information of an existing customer by ID.  Returns the modified customer object.

- DELETE /customer/{custId}:Removes a customer from the database by their ID.

### 2.Item
Item Endpoints:

- GET /item:
  Retrieve all items or a specific item by its code.

- POST /item:
  Create a new item record.

- PUT /item/{itemCode}:
  Modify an existing item by its ID.

- DELETE /item/{itemCode}:
  Remove an item from the database by its ID.

### 3.Order
Orders Endpoints:

- GET /orders:Fetch all orders. Returns a JSON array containing order objects.

- POST /orders: Place a new order.Returns the newly created order object.

## Project Repository

You can find the frontend development project on GitHub [POS-System-Frontend](https://github.com/duranginethmini/AAD-Assignment-Pos-System-Frontend.git).


## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.


<div align="center">
    <p>This project is licensed under the <a href="LICENSE">MIT License</a></p>
    <p>© 2024 All Rights Reserved, Designed By <a href="https://github.com/duranginethmini">DurangiNethmini</a></p>
</div>


