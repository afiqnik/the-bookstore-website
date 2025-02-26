# The Bookstore Website

Welcome to **The Bookstore Website!** 🚀

This repository contains the source code for an e-commerce platform where users can browse books, add them to their cart, and place orders. 

This project was developed as part of the **CCSD Capstone Project** by a team of three members using **Java Spring Boot**, **JPA**, **Hibernate**, **Thymeleaf**, **HTML**, **Spring Boot Security**, **CSS**, **Bootstrap**, and **JavaScript**.

## Features

### User Authentication
- **Register, Log In, Log Out**: Secure authentication using Spring Security.
- **Password Encryption**: Secure hashing with bcrypt.
- **Session Management**: Ensures data protection.
- **Error Handling**: User-friendly error messages.
- **Input Validation**: Ensures data integrity.

### Cart Functionality
- **Add to Cart**: Users can add books to their cart.
- **Update Quantities**: Modify item quantities.
- **Remove Items**: Delete items from the cart.

### Order Processing
- **Checkout Process**: Users can review their cart and place an orders.
- **Order Review**: Confirm cart items before purchase.

### Database Connection
- **Efficient Connectivity**: Secure and optimized MySQL database connection.
- **CRUD Operations**: Create, Read, Update, Delete operations.
- **Error Handling**: Handles database failures gracefully.
- **Optimization**: Uses connection pooling and prepared statements.

### UI/UX
- **Design**: Clean and intuitive interface.
- **Responsiveness**: Works on all screen sizes.
- **Usability**: Simple and user-friendly.

## Additional Features
- **Product Categories and Filters**: Improved browsing experience.
- **Optimized Performance**: Fast and efficient loading times.

## Installation & Setup

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/afiqnik/The_Bookstore_Website.git
   cd The_Bookstore_Website
   ```

2. **Set Up the Database**:
   - **Install MySQL**

     If you don’t have MySQL installed, download it from [here](https://dev.mysql.com/downloads/installer/).

   - **Create the Database**

     ```sql
     CREATE DATABASE bookstore_db;
     ```

   - **Create the Product Table**

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

   - **Populate Sample Data (Optional)**

     ```sql
     INSERT INTO product (title, author, publisher, published_date, description, isbn, page_count, print_type, categories, average_rating, ratings_count, language, thumbnail_url, small_thumbnail_url, list_price, retail_price, bestseller, new_arrival)
     VALUES ('Sample Book', 'John Doe', 'Sample Publisher', '2024-01-01', 'A sample book for testing.', '1234567890123', 350, 'Hardcover', 'Fiction', 4.5, 10, 'en', 'http://example.com/thumbnail.jpg', 'http://example.com/small_thumbnail.jpg', 19.99, 17.99, true, true);
     ```

3. **Configure Database in Spring Boot**:

     Edit `src/main/resources/application-local.properties`:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/bookstore_db
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     spring.jpa.hibernate.ddl-auto=update
     ```

     Replace `your_db_username` and `your_db_password` with your actual credentials.

4.. **Run the Application**:

   ```bash
   ./mvnw spring-boot:run
   ```

5. **Access the Application**:

   Open your browser and go to [http://localhost:8080](http://localhost:8080)

## Authors

- [@anasfurdaus](https://github.com/anasfurdaus) - [LinkedIn](https://www.linkedin.com/in/anas-firdaus-azhari/)
- [@Itskelan](https://github.com/Itskelan) - [LinkedIn](https://www.linkedin.com/in/ahmad-khairan-b0b458262/)
- [@afiqnik](https://github.com/afiqnik) - [LinkedIn](https://www.linkedin.com/in/nik-afiq-nik-haripin/)

## Contributing

We welcome contributions! 🎉 Fork the repository, make changes, and submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](https://choosealicense.com/licenses/mit/) file for details.

## Feedback

For issues or suggestions, please open an issue in the GitHub repository.

Thank you for visiting **The Bookstore Website**! 📚
