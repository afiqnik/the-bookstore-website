# The Bookstore Website

Welcome to 'The Bookstore' Website project! 🚀

This repository contains the source code for an e-commerce platform where users can browse books, add them to their cart, and place orders.

This project was developed as part of the CCSD Capstone Project by a team of three members using Java Spring Boot, JPA, Hibernate, Thymeleaf, HTML, Spring Boot Security, CSS, Bootstrap, and a little bit of JavaScript.

## Features

The main objective of this project is to build an e-commerce platform with the following features:

### User Authentication

- **Register, Log In, Log Out**: Secure user authentication using Spring Security.
- **Password Encryption**: Passwords are encrypted using bcrypt.
- **Session Management**: Secure session management to ensure user data protection.
- **Error Handling**: Clear and user-friendly error messages for login failures.
- **Input Validation**: Validation for login credentials to ensure data integrity.

### Cart Functionality

- **Add to Cart**: Users can add products to their cart.
- **Update Quantities**: Users can update the quantity of products in their cart.
- **Remove Items**: Users can remove items from their cart.

### Order Processing

- **Checkout Process**: Users can review their cart and place an order.
- **Order Review**: Before placing an order, users can review their cart items.

### Database Connection

- **Efficient Connectivity**: Secure and efficient connections to the database.
- **CRUD Operations**: Proper handling of Create, Read, Update, and Delete operations.
- **Error Handling**: Graceful handling of database connection failures.
- **Optimization**: Use of connection pooling and prepared statements to enhance performance.

### UI/UX

- **Design**: Consistent and intuitive user interface.
- **Responsiveness**: Compatible with different devices and screen sizes.
- **Usability**: Easy navigation and user-friendly layout.

### Application Performance

- **Speed**: Efficient loading times and responsiveness to user actions.

## Additional Features

- **Product Categories and Filters**: Implementation of product categories and filters to enhance user experience.

## Usage

To set up this project locally:

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/afiqnik/The_Bookstore_Website.git
   cd The_Bookstore_Website
   ```

2. **Set Up the Database**:

   - Ensure you have a MySQL database running. If you don't have MySQL installed, you can download and install it from the [MySQL website](https://dev.mysql.com/downloads/installer/).

   - **Create the Database**:

     Log into your MySQL server and create a new database:

     ```sql
     CREATE DATABASE bookstore_db;
     ```

   - **Create the Product Table**:

     Run the `productTable.sql` script to create the necessary table. You can find this script in the repository. To execute the script, use the following command in your MySQL client or any MySQL GUI tool:

     ```sql
     USE bookstore_db;

     CREATE TABLE product (
         id INT AUTO_INCREMENT PRIMARY KEY,
         title VARCHAR(255) NOT NULL,
         author VARCHAR(255) NOT NULL,
         publisher VARCHAR(255),
         published_date DATE,
         description TEXT,
         isbn VARCHAR(13),
         page_count INT,
         print_type VARCHAR(50),
         categories VARCHAR(255),
         average_rating DECIMAL(3,2),
         ratings_count INT,
         language VARCHAR(10),
         thumbnail_url VARCHAR(255),
         small_thumbnail_url VARCHAR(255),
         list_price DECIMAL(10,2),
         retail_price DECIMAL(10,2),
         bestseller BOOLEAN,
         new_arrival BOOLEAN
     );
     ```

   - **Populate the Table (Optional)**:

     If you have any initial data to populate the table, insert it now. Here is an example of inserting a new product:

     ```sql
     INSERT INTO product (title, author, publisher, published_date, description, isbn, page_count, print_type, categories, average_rating, ratings_count, language, thumbnail_url, small_thumbnail_url, list_price, retail_price, bestseller, new_arrival)
     VALUES ('Sample Book', 'John Doe', 'Sample Publisher', '2024-01-01', 'A sample book for testing.', '1234567890123', 350, 'Hardcover', 'Fiction', 4.5, 10, 'en', 'http://example.com/thumbnail.jpg', 'http://example.com/small_thumbnail.jpg', 19.99, 17.99, true, true);
     ```

   - **Update the application.properties file**:

     Update the `application.properties` file located in `src/main/resources` with your database credentials. Here is an example configuration:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/bookstore_db
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     spring.jpa.hibernate.ddl-auto=update
     ```

     Replace `your_db_username` and `your_db_password` with your actual MySQL credentials.

3. **Run the Application**:

   Use the following command to run the Spring Boot application:

   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the Application**:

   Open your browser and go to [http://localhost:8080](http://localhost:8080). You should see the application running.

## Authors

- [@anasfurdaus](https://github.com/anasfurdaus) - [LinkedIn](https://www.linkedin.com/in/anas-firdaus-azhari/)
- [@Itskelan](https://github.com/Itskelan) - [LinkedIn](https://www.linkedin.com/in/ahmad-khairan-b0b458262/)
- [@afiqnik](https://github.com/afiqnik) - [LinkedIn](https://www.linkedin.com/in/nik-muhammad-afiq/)

## Contributing

We welcome contributions to this project. Please fork the repository and submit pull requests for any enhancements or bug fixes.

Feel free to contribute, enhance, or customize this project.

## License

This project is licensed under the MIT License - see the [LICENSE](https://choosealicense.com/licenses/mit/) file for details.

## Feedback

For any queries or issues, please open an issue in the GitHub repository.

Thank you for visiting the Bookstore Website project!
