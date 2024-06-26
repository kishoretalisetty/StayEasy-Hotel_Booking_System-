# StayEasy-Hotel_Booking_System-

# Hotel Booking System

The Hotel Booking System is a Spring Boot application that provides APIs for managing hotel bookings. It includes functionality for user registration, authentication, hotel management, and booking rooms.

## Features

- **User Management**: Allows users to register with their email addresses and passwords. Supports user authentication using JWT tokens.
- **Hotel Management**: Enables the addition, deletion, and updating of hotel details such as name, location, description, and number of rooms.
- **Room Booking**: Users can book hotel rooms by specifying check-in and check-out dates.
- **Authorization and Access Control**: Different endpoints are secured with role-based access control. Users with roles such as ADMIN, MANAGER, and CUSTOMER have access to specific endpoints based on their roles.

## Authentication and Authorization

### Overview

Authentication and authorization are crucial aspects of the Hotel Booking System. They ensure that users can securely access the system's features while maintaining proper permissions and data security.

### Authentication

Authentication in the Hotel Booking System is handled using JSON Web Tokens (JWT). When a user registers or logs in, the system generates a JWT token containing the user's identity information. This token is then included in subsequent requests to authenticate the user.

To authenticate a user and generate a JWT token, use the following endpoint:

- **POST /authenticate**: Authenticate a user and generate a JWT token.

The JWT token must be included in the request headers of protected endpoints for successful authentication.

### Authorization

Authorization in the Hotel Booking System is role-based, meaning certain actions or endpoints are restricted based on the user's role. The available roles include:

- **Customer**: Regular users who can book rooms and view available hotels.
- **Manager/Admin**: Users with additional permissions, such as creating, updating, or deleting hotels.

Authorization rules are enforced using Spring Security annotations. These annotations specify which roles are allowed to access specific endpoints.


## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (JSON Web Tokens)
- Hibernate
- PostgreSQL (or your preferred database)
- Maven

## Getting Started

1. **Clone the repository**:   
- git clone https://github.com/your-username/hotel-booking-system.git

2. **Set up the database**:

- Configure your database settings in `src/main/resources/application.properties`.
- Ensure that PostgreSQL (or your preferred database) is installed and running.

3. **Run the application**:

- cd hotel-booking-system
- mvn spring-boot:run

4. **Access the APIs**:
- Use tools like Postman or curl to interact with the APIs.
- The base URL for accessing the APIs is http://localhost:8080.

### API Endpoints

**User Management**:

- `POST /register/user`: Register a new user.
- `POST /authenticate`: Authenticate user and generate JWT token.

**Hotel Management**:

- `POST /create/hotel`: Add a new hotel.
- `PUT /update/hotel`: Update hotel details.
- `DELETE /delete/hotel/{hotelId}`: Delete a hotel by ID.

**Room Booking**:

- `POST /book/room`: Book a room.
- `PUT /vaccate/room`: Vacate a booked room.

**Access Control**:

- `GET /getAllAvailableHotels`: Get a list of all available hotels.
- `GET /getAllBookedRooms`: Get a list of all booked rooms (for managers).

### Security

- JWT tokens are used for authentication and authorization.
- Role-based access control is implemented using Spring Security annotations.

### Contributing

Contributions are welcome! Feel free to submit bug reports, feature requests, or pull requests.

### License

This project is licensed under the MIT License.

