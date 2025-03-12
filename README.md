
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

2. **Install Docker Desktop** (instead of MySQL)

   Since this project now uses Docker Compose, install Docker Desktop from [here](https://www.docker.com/products/docker-desktop/) and ensure it is running.

3. **Start the Database with Docker Compose**:

   The database credentials are already configured in the docker-compose.yml file, so there is no need to modify them.

     ```bash
     docker compose up -d
     ```

   This will start the MySQL database inside a container.

4. **Configure the Application**:

   The application is configured to connect to the local MySQL   database started by Docker. No additional configuration is needed, but if you want to manually update the properties, they can be found in `src/main/resources/application-local.properties`.

5. **Run the Application**:

   ```bash
   ./mvnw spring-boot:run
   ```

6. **Access the Application**:

   Open your browser and go to [http://localhost:8080](http://localhost:8080)
## Deployment

The application is deployed using Railway for the backend and AlwaysData for the database.

## Authors

- [@anasfurdaus](https://github.com/anasfurdaus) - [LinkedIn](https://www.linkedin.com/in/anas-firdaus-azhari/)
- [@Itskelan](https://github.com/Itskelan) - [LinkedIn](https://www.linkedin.com/in/ahmad-khairan-b0b458262/)
- [@afiqnik](https://github.com/afiqnik) - [LinkedIn](https://www.linkedin.com/in/nik-muhammad-afiq/)
## Contributing

We welcome contributions! 🎉 Fork the repository, make changes, and submit a pull request.

[@hendisantika](https://github.com/hendisantika) – Added Flyway for database migration, Testcontainers, GitHub Actions, and Spring Docker Compose support (PR #9).

## License

This project is licensed under the MIT License - see the [LICENSE](https://choosealicense.com/licenses/mit/) file for details.


## Feedback

For any queries or issues, please open an issue in the GitHub repository.

Thank you for visiting the Bookstore Website project!
