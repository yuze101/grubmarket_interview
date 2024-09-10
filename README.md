# Employee Management System - Interview Project

## Starting The Database

To start the database you can run the following command:

```docker compose up```

This will start your database and initialize it with the schema.

## Task 1

Build a simple REST API for managing employees. The system will allow for basic CRUD (Create, Read, Update, Delete) operations on employees and should include features like:

- RESTful API endpoints
- Dependency Injection and Spring Beans
- Data persistence using a relational database (e.g., H2)
- JPA for database interactions
- Basic validation
- Exception handling
- Unit and Integration tests

### Requirements:

#### Employee Entity

- Employee ID (auto-generated)
- First Name
- Last Name
- Email
- Department
- Salary

#### Endpoints:

- POST /employees: Create a new employee.
- GET /employees: Retrieve a list of all employees.
- GET /employees/{id}: Retrieve details of a specific employee by ID.
- PUT /employees/{id}: Update an employee’s details.
- DELETE /employees/{id}: Delete an employee by ID.

#### Data Validation:

- Validate input data, e.g., non-null values for firstName, lastName, and email.
- Salary must be greater than zero.

#### Exception Handling:

- Return appropriate HTTP status codes for success and error scenarios.
- Handle cases where employees are `not found (404)` or `invalid input is provided (400)`.
- Unit & Integration Testing:


#### Bonus:

- Add search functionality to search for employees by name or department.
- Implement pagination for the `GET` /employees endpoint.

## Task 2

Extend the Employee Management System to include the ability for the employee to have multiple addresses.

### Functionality:

- CRUD operations to manage employee addresses.
- Handle one-to-many relationships between employees and addresses.
- The address entity should include fields like:
  - Address ID (auto-generated)
  - Street
  - City
  - State
  - Zip Code
  - Country

#### Data Validation:

- Validate input data, e.g., non-null values for street, city, state, zipcode and country.
- Make sure to have `created at` and `updated at` fields that track when a record was created and updated.
  
### Requirements:
- Delete all addresses associated with an employee when the employee is deleted.
- Implement a endpoint to retrieve all addresses for a specific employee.
